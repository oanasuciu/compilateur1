	; entete
	extrn lirent:proc, ecrent:proc
	extrn ercbool:proc
	extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE

max:
	enter 6,0
	
	push word ptr [bp+6]
	
	pop ax
	mov word ptr [bp-6],ax
	
	push word ptr [bp-6]
	
	push word ptr [bp+4]
	
	pop bx
	pop ax
	cmp ax,bx
	jle $+6
	push -1
	jmp $+4
	push 0
	
	pop ax
	camp ax,0
	je SINON1
	
	push word ptr [bp-6]
	
	pop ax
	mov [bp+8],ax
	
	jmp FSI1
	
SINON1:
	push word ptr [bp+4]
	
	pop ax
	mov [bp+8],ax
	
FSI1:
	leave
	ret 4
	
min:
	enter 0,0