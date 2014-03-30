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

; iffaux SINON_1
pop ax
cmp ax,0
je SINON_1

; iconst 2
push word ptr 2

; istore -2
pop ax
mov word ptr [bp-2],ax

; iconst 3
push word ptr 3

; iconst 2
push word ptr 2

; isup
pop bx
pop ax
cmp ax,bx
jle $+6
push -1
jmp $+4
push 0

; iffaux SINON_1_1
pop ax
cmp ax,0
je SINON_1_1

; iconst 3
push word ptr 3

; istore -2
pop ax
mov word ptr [bp-2],ax

; goto FSI_1_1
jmp FSI_1_1

SINON_1_1:

; iconst 2
push word ptr 2

; istore -2
pop ax
mov word ptr [bp-2],ax

FSI_1_1:

; goto FSI_1
jmp FSI_1

SINON_1:

FSI_1:

; iconst -1
push word ptr -1

; iffaux SINON_2
pop ax
cmp ax,0
je SINON_2

; iconst 1
push word ptr 1

; istore -2
pop ax
mov word ptr [bp-2],ax

; iconst 0
push word ptr 0

;iffaux SINON_2_1
pop ax
cmp ax,0
je SINON_2_1

; iconst 0
push word ptr 0

; istore -2
pop ax
mov word ptr [bp-2],ax

; iconst -1
push word ptr -1

;iffaux SINON_2_1_1
pop ax
cmp ax,0
je SINON_2_1_1

; iconst 1
push word ptr 1

; istore -2
pop ax
mov word ptr [bp-2],ax

;goto FSI_2_1_1
jmp FSI_2_1_1

SINON_2_1_1:
FSI_2_1_1:

;goto FSI_2_1
jmp FSI_2_1

SINON_2_1:
FSI_2_1:

;goto FSI_2
jmp FSI_2

SINON_2:
FSI_2:

; queue
nop
EXITCODE
END debut
