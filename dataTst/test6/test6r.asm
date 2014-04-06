	; entete
	extrn lirent:proc, ecrent:proc
	extrn ecrbool:proc
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
	je SINON_1
	
	push word ptr [bp-6]
	
	pop ax
	mov [bp+8],ax
	
	jmp FSI_1
	
SINON_1:
	push word ptr [bp+4]
	
	pop ax
	mov [bp+8],ax
	
FSI_1:
	leave
	ret 4
	
min:
	enter 0,0
	push word ptr [bp+6]
	push word ptr [bp+4]
	
	pop bx
	pop ax
	cmp ax,bx
	jge $+6
	push -1
	jmp $+4
	push 0
	
	pop ax
	cmp ax,0

	je SINON_2
	
	push word ptr [bp+6]

	pop ax
	mov [bp+8],ax
	jmp FSI_2
	
SINON_2:
	push word ptr [bp+4]
	pop ax
	mov [bp+8],ax
	
FSI_2:
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
	
	call ligsuiv
	
	sub sp,2
	push word ptr [bp-2]	

	sub sp,2
	push word ptr [bp-4]

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
	END debut