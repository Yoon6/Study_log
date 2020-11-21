#2단부터 9단까지 반복문을 이용하여 출력
.data
  	newLine : .asciiz "\n"	                      #개행 문자 
        multi : .asciiz " * "
        equal: .asciiz " = "

.text
	main:
		addi $t0, $zero, 2
		addi $t1, $zero, 1
		run:			
			mul $t2, $t0, $t1
			
			li $v0, 1
			add $a0, $zero, $t0
			syscall 
			
			li $v0,4
        		la $a0, multi
        		syscall				# *
			
			li $v0, 1
			add $a0, $zero, $t1
			syscall
			
			li $v0,4
        		la $a0, equal
        		syscall				# =
			
			li $v0, 1
			add $a0, $zero, $t2
			syscall
			
			li $v0,4
        		la $a0, endLine
        		syscall				# \n
			
			addi $t1, $t1, 1
			
			blt $t1, 10, run
		
			li $v0, 4
			la $a0, endLine
			syscall
			
			addi $t0, $t0, 1
			addi $t1, $zero, 1
			
			blt $t0, 10, run