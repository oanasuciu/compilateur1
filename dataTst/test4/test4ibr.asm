extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
STARTUPCODE

main:

; ouvreBloc 8
enter 8,0

; iconst 0
push word ptr 0

; istore -4
pop ax
mov word ptr [bp-4],ax

; iconst 0
push word ptr 0

; istore -6
pop ax
mov word ptr [bp-6],ax

; iconst 0
push word ptr 0

; istore -2
pop ax
mov word ptr [bp-2],ax

FAIRE_1:

;iload -4
push word ptr [bp-4]

; iconst 2
push word ptr 2

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
cmp ax,0
je FAIT_1

; iconst 0
push word ptr 0

; istore -6
pop ax
mov word ptr [bp-6],ax

FAIRE_1_1:

;iload -6
push word ptr [bp-6]

; iconst 2
push word ptr 2

;iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0

;iffaux FAIT_1_1
pop ax
cmp ax,0
je FAIT_1_1

;iload -2
push word ptr [bp-2]

; iconst 1
push word ptr 1

; iadd
pop bx
pop ax
add ax,bx
push ax

; istore -2
pop ax
mov word ptr [bp-2],ax

;iload -6
push word ptr [bp-6]

; iconst 1
push word ptr 1

; iadd
pop bx
pop ax
add ax,bx
push ax

; istore -6
pop ax
mov word ptr [bp-6],ax

;goto FAIRE_1_1
jmp FAIRE_1_1

FAIT_1_1:

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

FAIRE_2:

; iconst 0
push word ptr 0

;iffaux FAIT_2
pop ax
cmp ax,0
je FAIT_2

FAIRE_2_1:

; iconst 0
push word ptr 0

;iffaux FAIT_2_1
pop ax
cmp ax,0
je FAIT_2_1

FAIRE_2_1_1:

; iconst 0
push word ptr 0

;iffaux FAIT_2_1_1
pop ax
cmp ax,0
je FAIT_2_1_1

; aLaLigne
call ligsuiv

;goto FAIRE_2_1_1
jmp FAIRE_2_1_1

FAIT_2_1_1:

;goto FAIRE_2_1
jmp FAIRE_2_1

FAIT_2_1:

;goto FAIRE_2
jmp FAIRE_2

FAIT_2:

; queue
nop
EXITCODE
END debut
