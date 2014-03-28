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
	cmp ax,0
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
	push word ptr [bp+6]
	push word ptr [bp+4]
	
	pop bx
	pop ax
	cmp ax,bx
	jle $+6
	push -1
	jmp $+4
	push 0
	
	pop ax
	cmp ax,0
	
	push word ptr [bp+6]

	pop ax
	mov [bp+8],ax
	jmp FSI2
	
SINON2:
	push word ptr [bp+4]
	pop ax
	mov [bp+8],ax
	
FSI2:
	leave
	ret 4
	
sup:
	enter 0,0
	push word ptr [bp+6]
	push word ptr [bp+4]
	
	pop bx
	pop ax
	cmp ax,bx
	jle $+6
	push -1
	jmp $+4
	push 0
	
	pop ax
	mov [bp+8],ax
	leave 
	ret 4
	
debut:
	STARTUPCODE
	
main:
	enter 8,0
	push word ptr 5
	pop ax
	mov word ptr [bp-2],ax
	push word ptr 5
	pop ax
	mov word ptr [bp-4],ax	
	
	lea dx,[bp-4]
	push dx
	call lirent
	call ligsuiv
	
	sub sp,2
	push word ptr [bp-2]	
	push word ptr 5
	call min
	call max
	push word ptr 2
	pop bx
	pop ax
	add ax,bx
	push ax
	pop ax
	mov word ptr [bp-6],ax
	
	sub sp,2
	push word ptr 1
	sub sp,2
	push word ptr [bp-2]
	push word ptr [bp-4]
	push word ptr 5
	
	pop bx
	pop ax
	sub ax,bx
	push ax
	
	call max
	pop bx
	pop ax
	add ax,bx
	push ax
	pop ax
	
	sub sp,2
	push word ptr [bp-2]
	push word ptr 2
	pop bx
	pop ax
	imul bx
	push ax
	push word ptr [bp-4]
	
	call min
	call sup
	pop ax
	mov word ptr [bp-8],ax
	call ligsuiv
	
	push word ptr [bp-6]
	call ecrent
	call ligsuiv
	push word ptr [bp-8]
	call ecrbool
	
	nop
	EXITCODE
	end