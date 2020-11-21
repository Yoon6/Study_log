.data
	count: .word 1
	array: .space 100
	value: .asciiz "value : "
	num: .asciiz "num : "
	newLine: .asciiz "\n"
	comma: .asciiz ", "
	str: .asciiz " "
.text
	main:
		li $v0, 4
		la $a0, num
		syscall
		
		li $v0, 5
		syscall
		
		addi $s0, $v0, 0
		
		la $t0, count
		sw $s0, 0($t0)
		la $t0, array
		li $t1, 0
		
	L1:
		beq $t1, $s0, Else 	# 카운트 값과 t1의 0을 비교 
		li $v0, 4
		la $a0, value
		syscall
		li $v0, 5
		syscall
		sw $v0, 0($t0)
		addi $t0, $t0, 4	# 배열의 크기
		addi $t1, $t1, 1	# 반복문 횟수 
		j L1
		
	Else:
		addi $s0, $s0, -1
		li $a0, 0
		add $a1, $zero, $s0
		addi $sp, $sp, -4
		sw $ra, 0($sp)
		jal QuickSort
		lw $ra, 0($sp)
		addi $sp, $sp, 4
		
		la $t1, count
		lw $t1, 0($t1)
		li $t0, 0
		la $t2, array
		
	L2:
		beq $t1, $t0, ProgramExit
		li $v0,1
		lw $t3, 0($t2)
		add $a0, $zero, $t4
		syscall
		addi $t2, $t2, 4
		addi $t0, $t0, 1
		jL2
	
	ProgramExit:
		jr $ra
	
	QuickSort:
		addi $sp, $sp, -16
		sw $ra, 12($sp)
		sw $a2, 8($sp)
		sw $a1, 4($sp)
		sw $a0, 0($sp)
		
		slt $t5, $a0, $a1	# if(left<right)
		beq $t5, $zero, QuickSortElse1
		
		jal Partition
		add $a2, $v0
			
		
		