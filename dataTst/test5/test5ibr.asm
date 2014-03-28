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

; iconst 2
push word ptr 2

; iconst 3
push word ptr 3

; isup
pop bx
pop ax
cmp ax,bx
jle $+6
push -1
jmp $+4
push 0

;iffaux SINON2
pop ax
cmp ax,0
je SINON2

; iconst 3
push word ptr 3

; istore -2
pop ax
mov word ptr [bp-2],ax

;goto FSI2
jmp FSI2

SINON2:
; iconst 2
push word ptr 2

; istore -2
pop ax
mov word ptr [bp-2],ax
FSI2:

;goto FSI1
jmp FSI1

SINON1:
FSI1:

; iconst -1
push word ptr -1

;iffaux SINON3
pop ax
cmp ax,0
je SINON3

; iconst 0
push word ptr 0

; istore -2
pop ax
mov word ptr [bp-2],ax

; iconst 0
push word ptr 0

;iffaux SINON4
pop ax
cmp ax,0
je SINON4

; iconst 0
push word ptr 0

; istore -2
pop ax
mov word ptr [bp-2],ax

; iconst -1
push word ptr -1

;iffaux SINON5
pop ax
cmp ax,0
je SINON5

; iconst 1
push word ptr 1

; istore -2
pop ax
mov word ptr [bp-2],ax

;goto FSI5
jmp FSI5

SINON5:
FSI5:

;goto FSI4
jmp FSI4

SINON4:
FSI4:

;goto FSI3
jmp FSI3

SINON3:
FSI3:

; queue
nop
EXITCODE
END debut

