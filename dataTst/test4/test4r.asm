extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
STARTUPCODE

main: 

; ouvbloc 4
enter 4,0

; ecrireChaine "n="
.DATA
mess0 DB "n=$"
.CODE
lea dx,mess0
push dx
call ecrch

; iconst 1
push word ptr 1

; istore -4
pop ax
mov word ptr [bp-4],ax

; iconst 0
push word ptr 0

; istore -2
pop ax
mov word ptr [bp-2],ax

FAIRE_1:

;iload -4
push word ptr [bp-4]

; iconst 4
push word ptr 4

;iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0

;iffaux FAIT_1
pop ax
cmp ax, 0
je FAIT_1

;iload -2
push word ptr [bp-2]

;iload -4
push word ptr [bp-4]

; iadd
pop bx
pop ax
add ax,bx
push ax

; istore -2
pop ax
mov word ptr [bp-2],ax

;iload -4
push word ptr [bp-4]

; iconst 1
push word ptr 1

; iadd
pop bx
pop ax
add ax,bx
push ax

; istore -4
pop ax
mov word ptr [bp-4],ax

;goto FAIRE_1
jmp FAIRE_1

FAIT_1:

; aLaLigne
call ligsuiv

; ecrireChaine "s="
.DATA
mess1 DB "s=$"
.CODE
lea dx,mess1
push dx
call ecrch

;iload -2
push word ptr [bp-2]

; ecrireEnt
call ecrent

; queue
nop
EXITCODE
END debut

