.data
   	Matrix_A:  .word 1,2,3,4,5
        	   .word 1,2,3,4,5
       	           .word 1,2,3,4,5
       	           .word 1,2,3,4,5
       	           .word 1,2,3,4,5			#A��� ����
   	Matrix_x:  .word 1
   		   .word 2
   		   .word 3
   		   .word 4
   		   .word 5 				#x��� ����	
  	endLine : .asciiz "\n"
       spacebar : .asciiz " "
       
.text
   	main:			
   		run:
     	 	li $t2, 0   		# $t2 = mul_Matrix���� ����� ���� �ʱ�ȭ
      		li $s0, 0		# $s0 = �������� �� �� �ʱ�ȭ
      		div $t0,$t1,5		# $t0 = �ڿ��� ����� x����� �ε��� �ʱ�ȭ t0=t1/3
      		mul_Matrix:
         		lw $s1, Matrix_A($t1)     	# $s1 A��� ����
         		lw $s2, Matrix_x($t2)		# $s2 x��� ����
         		mul $s1, $s1, $s2 		
        		add $s0, $s0, $s1  		#s0 = A[][1]*x[1]  ��� �� ����
							#    + A[][2]*x[2] 
							#    + A[][3]*x[3]
							#    + A[][4]*x[4]
							#    + A[][5]*x[5]
         		add $t1, $t1, 4			# $t1 +=INT_SIZE
         		add $t2, $t2, 4    		# $t2 +=INT_SIZE
         		blt $t2, 20, mul_Matrix		# while ( $t2 < 3*INT_SIZE )
         	add $t4,$t3,20
         	print_Matrix:
         		li $v0,1
         		lw $a0,Matrix_A($t3)
         		syscall				# A��� ���
        		li $v0,4
        		la $a0, spacebar
        		syscall				# �� ����
        		add $t3, $t3, 4
        		blt $t3, $t4, print_Matrix
         		syscall				#print_Matrix_x:	
         		
         		li $v0,1
     			lw $a0, Matrix_x($t0)		# x��� ���
      			syscall
      			li $v0,4
      			la $a0,spacebar
      			syscall				# �� ����
      			
      			syscall
      			li $v0,1				#print_Result:
      			move $a0, $s0
     			syscall				# ������ ��� ���� matrit_mul���� ���
     			
      			li $v0, 4
      			la $a0, endLine
     			syscall				# �� ����
     			blt $t1, 100, run        # while( $t1 < 9*INT_SIZE )
     			
   		li $v0, 10
   		syscall				# END
