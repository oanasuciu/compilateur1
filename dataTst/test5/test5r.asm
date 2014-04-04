extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
STARTUPCODE

main :

; ouvbloc 2
enter 2,0

; iconst 4
push word ptr 4

; istore -2
pop ax
mov word ptr [bp-2],ax

; iconst 2
push word ptr 2

; iconst 4
push word ptr 4

; isup
pop bx
pop ax
cmp ax,bx
jle $+6
push -1
jmp $+4
push 0

;iffaux SINON_1
pop ax
cmp ax,0
je SINON_1

; iconst 2
push word ptr 2

; istore -2
pop ax
mov word ptr [bp-2],ax

;goto FSI_1
jmp FSI_1

SINON_1:
FSI_1:

;iload -2
push word ptr [bp-2]

; ecrireEnt
call ecrent

; queue
nop
EXITCODE
END debut

