package generation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import concept.iteration.Iteration;
import utils.Ecriture;
import utils.FilenameUtils;
import yaka.Yaka;

public class YVMasm extends YVM {
	/**
	 * Variable contenant l'indice du prochain message à écrire Utilisé lors de
	 * l'écriture de chaînes (mess0, mess1, etc.)
	 */
	private int numMsg;

	public YVMasm(String nomFichier, boolean interactif) {
		super(nomFichier, interactif);
		this.numMsg = 0;
	}

	public String getExtension() {
		return ".asm";
	}

	public String getCheminAbsolu() {
		File currentDirectory = new File(new File(".").getAbsolutePath());
		try {
			return currentDirectory.getCanonicalPath();
		} catch (IOException e) {
			System.out.println("N'a pas pu trouver le chemin vers le fichier");
			e.printStackTrace();
		}
		return "";
	}

	public void compile() {
		String path;
		if (System.getProperty("os.name").startsWith("Windows")) {
	        path = "C:\\TASM";
	    } else {
	    	path = "/usr/tasm/";
	    }
	    String cheminNormalise = FilenameUtils.separatorsToWindows(nomFichier);
	    System.out.println(FilenameUtils.normalize(this.getCheminAbsolu()));
		String[] commandes = {
				"dosbox",
				"-c",
				"mount C "+path+"",// monte le dossier C:\TASM dans le disque C:
				"-c",
				"mount H " + FilenameUtils.normalize(this.getCheminAbsolu())+"",// monte le dossier contenant le fichier .asm
				"-c",
				"C:\\tasm H:\\" + cheminNormalise + this.getExtension() + " H:\\" + cheminNormalise + ".obj",// on compile le fichier
				"-c",
				"C:\\tlink H:\\" + cheminNormalise + ".obj H:\\biblio.obj, H:\\" + cheminNormalise + ".exe",// on link le fichier
				"-c",
				"H:\\" + cheminNormalise + ".exe"+((!this.interactif) ? ">H:\\" + cheminNormalise + ".out" : ""), // on éxécute le fichier fraichement compilé
				((!this.interactif) ? "-c" : ""),
				((!this.interactif) ? "exit" : ""),
				"-noconsole",
				"-noautoexec"
		};
		try {
			// on lance dosbox et la liste des commandes pour compiler
			Process proc = Runtime.getRuntime().exec(commandes);
			// on attend la fin du processus
			proc.waitFor();
		} catch (IOException e) {
			System.out.println("N'a pas pu compiler");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("N'a pas pu compiler");
			e.printStackTrace();
		}
	}

	/*
	 * Les meta-instructions (entete, queue)
	 */

	public void entete() {
		Ecriture.ecrireStringln(ficYVM, "extrn lirent:proc, ecrent:proc");
		Ecriture.ecrireStringln(ficYVM, "extrn ecrbool:proc");
		Ecriture.ecrireStringln(ficYVM, "extrn ecrch:proc, ligsuiv:proc");
		Ecriture.ecrireStringln(ficYVM, ".model SMALL");
		Ecriture.ecrireStringln(ficYVM, ".586");
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, ".CODE");
		Ecriture.ecrireStringln(ficYVM, "debut:");
		Ecriture.ecrireStringln(ficYVM, "STARTUPCODE");
	}

	public void queue() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; queue");
		Ecriture.ecrireStringln(ficYVM, "nop");
		Ecriture.ecrireStringln(ficYVM, "EXITCODE");
		Ecriture.ecrireStringln(ficYVM, "END debut");
		// c'est le dernier élément : on ferme le descripteur du fichier
		Ecriture.fermer(ficYVM);
		// s'il y a eu une erreur de compilation, on efface le fichier :
		// on ne laisse pas l'utilisateur utiliser un tel fichier qui est
		// incomplet sur plusieurs points
		if (Yaka.em.hasErreur()) {
			File f = new File(this.nomFichier + this.getExtension());
			f.delete();
		} else
			this.compile();
	}

	/*
	 * Les instructions pour les fonctions
	 */

	public void ouvrePrinc(int nbVar) {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; ouvrePrinc " + nbVar);
		Ecriture.ecrireStringln(ficYVM, "mov bp,sp");
		Ecriture.ecrireStringln(ficYVM, "sub sp," + nbVar);
	}

	/*
	 * Les instructions d'entrée/sortie
	 */

	public void lireEnt(int offset) {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; lireEnt " + offset);
		Ecriture.ecrireStringln(ficYVM, "lea dx,[bp" + offset + "]");
		Ecriture.ecrireStringln(ficYVM, "push dx");
		Ecriture.ecrireStringln(ficYVM, "call lirent");
	}

	public void ecrireBool() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; ecrireBool");
		Ecriture.ecrireStringln(ficYVM, "call ecrbool");
	}

	public void ecrireChaine(String str) {
		// la chaîne reçue inclut aussi les doubles ou simples quote : on les enlève
		str = str.substring(1,str.length()-1);
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; ecrireChaine " + str + "");
		Ecriture.ecrireStringln(ficYVM, ".DATA");
		Ecriture.ecrireStringln(ficYVM, "mess" + this.numMsg + " DB \"" + str + "$\"");
		Ecriture.ecrireStringln(ficYVM, ".CODE");
		Ecriture.ecrireStringln(ficYVM, "lea dx,mess" + this.numMsg++);
		Ecriture.ecrireStringln(ficYVM, "push dx");
		Ecriture.ecrireStringln(ficYVM, "call ecrch");
	}

	public void ecrireEnt() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; ecrireEnt");
		Ecriture.ecrireStringln(ficYVM, "call ecrent");
	}

	public void aLaLigne() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; aLaLigne");
		Ecriture.ecrireStringln(ficYVM, "call ligsuiv");
	}

	/*
	 * Les instructions pour les affectations et les expressions
	 */

	public void iconst(int val) {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; iconst " + val);
		Ecriture.ecrireStringln(ficYVM, "push word ptr " + val);
	}

	public void iload(int val) {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; iload " + val);
		Ecriture.ecrireStringln(ficYVM, "push word ptr [bp" + val + "]");

	}

	public void istore(int val) {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; istore " + val);
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "mov word ptr [bp" + val + "],ax");
	}

	/*
	 * Les instructions pour les opérations
	 */

	public void iadd() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; iadd");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "add ax,bx");
		Ecriture.ecrireStringln(ficYVM, "push ax");
	}

	public void iand() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; iand");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "and ax,bx");
		Ecriture.ecrireStringln(ficYVM, "push ax");
	}

	public void idiff() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; idiff");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "cmp ax,bx");
		Ecriture.ecrireStringln(ficYVM, "je $+6");
		Ecriture.ecrireStringln(ficYVM, "push -1");
		Ecriture.ecrireStringln(ficYVM, "jmp $+4");
		Ecriture.ecrireStringln(ficYVM, "push 0");
	}

	public void idiv() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; idiv");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "cwd");
		Ecriture.ecrireStringln(ficYVM, "idiv bx");
		Ecriture.ecrireStringln(ficYVM, "push ax");
	}

	public void iegal() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; iegal");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "cmp ax,bx");
		Ecriture.ecrireStringln(ficYVM, "jne $+6");
		Ecriture.ecrireStringln(ficYVM, "push -1");
		Ecriture.ecrireStringln(ficYVM, "jmp $+4");
		Ecriture.ecrireStringln(ficYVM, "push 0");
	}

	public void iinf() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; iinf");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "cmp ax,bx");
		Ecriture.ecrireStringln(ficYVM, "jge $+6");
		Ecriture.ecrireStringln(ficYVM, "push -1");
		Ecriture.ecrireStringln(ficYVM, "jmp $+4");
		Ecriture.ecrireStringln(ficYVM, "push 0");
	}

	public void iinfegal() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; iinfegal");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "cmp ax,bx");
		Ecriture.ecrireStringln(ficYVM, "jg $+6");
		Ecriture.ecrireStringln(ficYVM, "push -1");
		Ecriture.ecrireStringln(ficYVM, "jmp $+4");
		Ecriture.ecrireStringln(ficYVM, "push 0");
	}

	public void ineg() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; ineg");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "mov ax,0");
		Ecriture.ecrireStringln(ficYVM, "sub ax,bx");
		Ecriture.ecrireStringln(ficYVM, "push ax");
	}

	public void imul() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; imul");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "imul bx");
		Ecriture.ecrireStringln(ficYVM, "push ax");
	}

	public void inot() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; inot");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "not bx");
		Ecriture.ecrireStringln(ficYVM, "push bx");
	}

	public void ior() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; ior");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "or ax,bx");
		Ecriture.ecrireStringln(ficYVM, "push ax");
	}

	public void isub() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; isub");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "sub ax,bx");
		Ecriture.ecrireStringln(ficYVM, "push ax");
	}

	public void isup() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; isup");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "cmp ax,bx");
		Ecriture.ecrireStringln(ficYVM, "jle $+6");
		Ecriture.ecrireStringln(ficYVM, "push -1");
		Ecriture.ecrireStringln(ficYVM, "jmp $+4");
		Ecriture.ecrireStringln(ficYVM, "push 0");
	}

	public void isupegal() {
		Ecriture.ecrireStringln(ficYVM, "");
		Ecriture.ecrireStringln(ficYVM, "; isupegal");
		Ecriture.ecrireStringln(ficYVM, "pop bx");
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "cmp ax,bx");
		Ecriture.ecrireStringln(ficYVM, "jl $+6");
		Ecriture.ecrireStringln(ficYVM, "push -1");
		Ecriture.ecrireStringln(ficYVM, "jmp $+4");
		Ecriture.ecrireStringln(ficYVM, "push 0");
	}
	
	public void faire(ArrayList<Integer> numerotationIteration){
		Ecriture.ecrireStringln(ficYVM, "pop ax");
		Ecriture.ecrireStringln(ficYVM, "cmp ax, 0");
		Ecriture.ecrireStringln(ficYVM, "je FAIT"+Iteration.stringNumerotation(numerotationIteration));
	}
	
	public void fait(ArrayList<Integer> numerotationIteration){
		Ecriture.ecrireStringln(ficYVM, "jmp FAIRE"+Iteration.stringNumerotation(numerotationIteration));
		Ecriture.ecrireStringln(ficYVM, "FAIT"+Iteration.stringNumerotation(numerotationIteration)+":\n");
	}
}
