extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
STARTUPCODE

; ouvrePrinc 10
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

; iconst 10
push word ptr 10

; iconst 2
push word ptr 2

; iadd
pop bx
pop ax
add ax,bx
push ax

; istore -2
pop ax
mov word ptr [bp-2],ax


; queue
nop
EXITCODE
END debut
