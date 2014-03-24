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

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

; iconst 2
push word ptr 2

; istore -2
pop ax
mov word ptr [bp-2],ax

;goto FSI1
jmp FSI1

SINON1:
FSI1:

;iload -2
push word ptr [bp-2]

; ecrireEnt
call ecrent

; queue
nop
EXITCODE
END debut

