.data
	array: .space 40
	value: .asciiz "value :"
	newLine: .asciiz "\n"
	comma: .asciiz ", "

.text
	.globl main
	main:
		addi $s4, $zero, 0		# counter( 배열 사이즈 )
		addi $s5, $zero, 0		# index용 
		addi $t0, $zero, 0
		
		input:
			li $v0,4
			la $a0,value
			syscall
		
			li $v0, 5
			syscall
			
			addi $a1, $v0, 0
			jal saveInput
			jal print
			
			blt $s4, 2, jup
			mul $t3, $s4, 4
			subi $t4, $t3, 4
			lw $a0, array
			move $a1,$t3 
			move $a2, $t4
			jal swap
			
			jup:
			
			j input
		
		li $v0, 10
		syscall				# main 끝 
	
	
	
	swap:				#swap method 
		# parameter arr, swap1, swap2

		addi $sp, $sp, -12	# Make stack room for three

		sw $a0, 0($sp)		# Store a0
		sw $a1, 4($sp)		# Store a1
		sw $a2, 8($sp)		# store a2
	
		sll $t1, $a1, 2 	#t1 = 4a
		add $t1, $a0, $t1	#t1 = arr + 4a
		lw $s3, 0($t1)		#s3  t = array[a]
	
		sll $t2, $a2, 2		#t2 = 4b
		add $t2, $a0, $t2	#t2 = arr + 4b
		lw $s4, 0($t2)		#s4 = arr[b]	

		sw $s4, 0($t1)		#arr[a] = arr[b]
		sw $s3, 0($t2)		#arr[b] = t 


		addi $sp, $sp, 12	#Restoring the stack size
		jr $ra			#jump back to the caller
	
	
	saveInput:
		
		sw $a1, array($s5)
		addi $s5, $s5, 4		# index += 4
		addi $s4, $s4, 1		# count++
		
		
		jr $ra
	
	print:
		
		
		addi $t0, $zero, 0 			# int i
		mul $t1, $s4, 4				# count*4
	
		while_print:
			beq $t0, $t1, exit_print 	# 인덱스와 스택의 개수가 같으면 탈출 
			
			li $v0, 1
			lw $a0, array($t0)
			syscall 			# 배열 출력
			
			addi $t0, $t0, 4 		# 인덱스값 갱신 
			
			li $v0, 4
			la $a0, comma
			syscall				# 컴마 출력 
			
			j while_print
		exit_print:
		
		
		li $v0, 4
		la $a0, newLine
		syscall
		
		jr $ra
