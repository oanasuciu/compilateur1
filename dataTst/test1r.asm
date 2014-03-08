extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
STARTUPCODE

; ouvrePrinc 14
mov bp,sp
sub sp,14

; iconst 10
push word ptr 10

; iconst 10
push word ptr 10

; iconst 2
push word ptr 2

; idiv
pop bx
pop ax
cwd
idiv bx
push ax

; iadd
pop bx
pop ax
add ax,bx
push ax

; iconst 5
push word ptr 5

; idiv
pop bx
pop ax
cwd
idiv bx
push ax

; istore -2
pop ax
mov word ptr [bp-2],ax

; iload -2
push word ptr [bp-2]

; iconst 3
push word ptr 3

; iload -2
push word ptr [bp-2]

; imul
pop bx
pop ax
imul bx
push ax

; iadd
pop bx
pop ax
add ax,bx
push ax

; iconst 10
push word ptr 10

; isub
pop bx
pop ax
sub ax,bx
push ax

; istore -4
pop ax
mov word ptr [bp-4],ax

; iconst -1
push word ptr -1

; iconst -1
push word ptr -1

; ior
pop bx
pop ax
or ax,bx
push ax

; istore -12
pop ax
mov word ptr [bp-12],ax

; iload -2
push word ptr [bp-2]

; iload -4
push word ptr [bp-4]

; iconst 4
push word ptr 4

; iadd
pop bx
pop ax
add ax,bx
push ax

; iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0

; istore -14
pop ax
mov word ptr [bp-14],ax

; queue
nop
EXITCODE
END debut
