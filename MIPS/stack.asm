.data
	array: .space 40
	top: .word 0
	
	comma: .asciiz ", "
	brace1: .asciiz "[ "
	brace2: .asciiz " ]"
	newLine: .asciiz "\n"
.text
	main:
		addi $s1, $zero, 0 	# $s1 == �ε���
		lw $s0, top 		# $s0 == top ������ 
		
			
		addi $a1, $zero, 3 	# 3�� ���ڷ� ����		
		jal push 		# Ǫ�� 
		jal print		# ���
		
		addi $a1, $zero, 4 	# 4�� ���ڷ� ����		
		jal push 		# Ǫ�� 
		jal print		# ���
		
		addi $a1, $zero, 7 	# 7�� ���ڷ� ����		
		jal push 		# Ǫ�� 
		jal print		# ���
		
		addi $a1, $zero, 30 	# 30�� ���ڷ� ����		
		jal push 		# Ǫ�� 
		jal print		# ���
		
		addi $a1, $zero, 23 	# 23�� ���ڷ� ����		
		jal push 		# Ǫ�� 
		jal print		# ���
		
		jal pop			# ���� �ֻ��� ��� ���� 
		jal print		# ���
		
		jal pop			# ���� �ֻ��� ��� ����
		jal print		# ��� 
		
		addi $a1, $zero, 10 	# 10�� ���ڷ� ����		
		jal push 		# Ǫ�� 
		jal print		# ���
		
		jal pop			# ���� �ֻ��� ��� ����
		jal print		# ��� 
		
		jal pop			# ���� �ֻ��� ��� ����
		jal print		# ��� 
		
		jal pop			# ���� �ֻ��� ��� ����
		jal print		# ��� 
		
		jal pop			# ���� �ֻ��� ��� ����
		jal print		# ��� 
		
		jal pop			# ���� �ֻ��� ��� ����
		jal print		# ��� 
		
		li $v0, 10
		syscall			# ���� �� 
		
	push: 
		bgt $s0, 9, exit_push 	# 10���� ������ push���� 
		
		sw $a1, array($s1)	# �迭�� ���� 
		addi $s0, $s0, 1	# top �����Ͱ� ���� 
		addi $s1, $s1, 4	# �ε����� + 4(int size)
		
		exit_push:
		jr $ra			# ���� 
	pop:
	
		blt $s0, 1, exit_pop	# ���� ��Ұ� ������ pop ���� 
		
		subi $s1, $s1, 4	# �ε����� - 4
		addi $t0, $zero, 0	
		sw $t0, array($s1)	# ���� ���� 0���� �ٲ� 
		subi $s0, $s0, 1	# top �����Ͱ� ���� 
		
		exit_pop:
		jr $ra			# ���� 
	
	print:
		
		li $v0, 4
		la $a0, brace1
		syscall				# ��ȣ ����
		
		addi $t1, $zero, 0		# ��¿� ����� �ε��� �ʱ�ȭ

		mul $t2, $s0, 4			# �ݺ� Ƚ�� ����
		while:
			beq $t1, $t2, exit 	# �ε����� ������ ������ ������ Ż�� 
			
			li $v0, 1
			lw $a0, array($t1)
			syscall 		# �迭 ���
			
			addi $t1, $t1, 4 	# �ε����� ���� 
			
			li $v0, 4
			la $a0, comma
			syscall			# �ĸ� ��� 
			
			j while
		exit:
		
		li $v0, 4
		la $a0, brace2
		syscall			# ��ȣ �ݱ�
			
		li $v0, 4
		la $a0, newLine
		syscall			# �ٹٲ� 
		
		jr $ra			# ����

			
			
			
