#------------------------------------#
# Authored by: Bharath Karumudi     #
# Purpose Quicksort in MIPS         #
#------------------------------------#

.data # Defines variable section of an assembly routine.
array: .space 100 # Define a variable named array as a word (integer) array.
# After your program has run, the integers in this array
# should be sorted.
space: .asciiz " "
newLine: .asciiz "\n"
value: .asciiz "value : "

.text # Defines the start of the code section for the program .
.globl main

	main:
		
		addi $s6, $zero, 0		# counter( 배열 사이즈 )
		addi $s7, $zero, 0		# index용 
		
		input:
			li $v0,4
			la $a0,value
			syscall
		
			li $v0, 5
			syscall
			
			
			
			addi $a1, $v0, 0
			jal saveInput
			
			la $t0, array # Moves the address of array into register $t0.
			addi $a0, $t0, 0 # Set  1 to the array.
			addi $a1, $zero, 0 # Set argument 2 to (low = 0)
			subi $t1, $s6, 1
			add $a2, $zero, $t1 # Set argument 3 to (high = 7, last index in array)
			jal quicksort # Call quick sort
		
			jal print
			
			j input
			
		li $v0, 10 # Terminate program run and
		syscall # Exit
	
	saveInput:
		sw $a1, array($s7)
		addi $s7, $s7, 4		# index += 4
		addi $s6, $s6, 1		# count++
		
		
		jr $ra
		
	print:
		addi $t0, $zero, 0 			# int i
		
	
		while_print:
			beq $t0, $s7, exit_print 	# 인덱스와 스택의 개수가 같으면 탈출 
			
			li $v0, 1
			lw $a0, array($t0)
			syscall 			# 배열 출력
			
			addi $t0, $t0, 4 		# 인덱스값 갱신 
			
			li $v0, 4
			la $a0, space
			syscall				# 컴마 출력 
			
			j while_print
		exit_print:
		li $v0, 4
		la $a0, newLine
		syscall				# 컴마 출력 
		
		jr $ra	
	

	swap:				#swap method

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
	


partition: 			#partition method

	addi $sp, $sp, -16	#Make room for 5

	sw $a0, 0($sp)		#store a0
	sw $a1, 4($sp)		#store a1
	sw $a2, 8($sp)		#store a2
	sw $ra, 12($sp)		#store return address
	
	move $s1, $a1		#s1 = low
	move $s2, $a2		#s2 = high

	sll $t1, $s2, 2		# t1 = 4*high
	add $t1, $a0, $t1	# t1 = arr + 4*high
	lw $s5, 0($t1)		# t2 = arr[high] //pivot

	addi $t3, $s1, -1	#t3, i=low -1
	move $t4, $s1		#t4, j=low
	addi $t5, $s2, -1	#t5 = high - 1

	forloop: 
		#slt $t6, $t5, $t4	#t6=1 if j>high-1, t6=0 if j<=high-1
		#bne $t6, $zero, endfor	#if t6=1 then branch to endfor
		
		bgt $t4, $t5, endfor


		sll $t1, $t4, 2		#t1 = j*4
		add $t1, $t1, $a0	#t1 = arr + 4j
		lw $t7, 0($t1)		#t7 = arr[j]

		#slt $t8, $t2, $t7	#t8 = 1 if pivot < arr[j], 0 if arr[j]<=pivot
		#bne $t8, $zero, endfif	#if t8=1 then branch to endfif
		
		bgt $t7, $s5, endfif
		
		addi $t3, $t3, 1	#i=i+1

		move $a1, $t3		#a1 = i
		move $a2, $t4		#a2 = j
		jal swap		#swap(arr, i, j)
		
		#addi $t4, $t4, 1	#j++
		#j forloop

	  	endfif:
		addi $t4, $t4, 1	#j++
		j forloop		#junp back to forloop

	endfor:
		addi $a1, $t3, 1		#a1 = i+1
		move $a2, $s2			#a2 = high
		jal swap			#swap(arr, i + 1, high);
		
		add $v0, $zero, $a1		#v0 = i+1 return (i + 1);

		lw $ra, 12($sp)			#return address
		addi $sp, $sp, 16		#restore the stack
		jr $ra				#junp back to the caller
	
	quicksort:				#quicksort method
	
	
		addi $sp, $sp, -16		# Make room for 4

		sw $a0, 0($sp)			# a0
		sw $a1, 4($sp)			# low
		sw $a2, 8($sp)			# high
		sw $ra, 12($sp)			# return address
	
		move $t0, $a2			#saving high in t0
	
		slt $t1, $a1, $t0		# t1=1 if low < high, else 0
		beq $t1, $zero, endif		# if low >= high, endif	(return)

		jal partition			# call partition 
		move $s0, $v0			# pivot, s0= v0 partition의 리턴값

		lw $a1, 4($sp)			#a1 = low
		addi $a2, $s0, -1		#a2 = pi -1
		jal quicksort			#call quicksort
	
		addi $a1, $s0, 1		#a1 = pi + 1
		lw $a2, 8($sp)			#a2 = high
		jal quicksort			#call quicksort

	 endif:

 		lw $a0, 0($sp)			#restore a0
 		lw $a1, 4($sp)			#restore a1
 		lw $a2, 8($sp)			#restore a2
 		lw $ra, 12($sp)			#restore return address
 		addi $sp, $sp, 16		#restore the stack
 		jr $ra				#return to caller
