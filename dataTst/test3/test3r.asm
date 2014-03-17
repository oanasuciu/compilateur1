extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
STARTUPCODE

; ouvrePrinc 2
mov bp,sp
sub sp,2

; ecrireChaine "x="
.DATA
mess0 DB " x= $ "
.CODE
lea dx,mess0
push dx
call ecrch

; iconst 2
push word ptr 2

; ecrireEnt
call ecrent

; aLaLigne
call ligsuiv

; ecrireChaine "y="
.DATA
mess1 DB " y= $ "
.CODE
lea dx,mess1
push dx
call ecrch

; iconst 3
push word ptr 3

; ecrireEnt
call ecrent

; aLaLigne
call ligsuiv

; ecrireChaine " somme= "
.DATA
mess2 DB " somme= $ "
.CODE
lea dx,mess2
push dx
call ecrch

; iconst 2
push word ptr 2

; iconst 3
push word ptr 3

; iadd
pop bx
pop ax
add ax,bx
push ax

; istore -2
pop ax
mov word ptr [bp-2],ax

; ecrireEnt
call ecrent

; aLaLigne
call ligsuiv

; queue
nop
EXITCODE
END debut
