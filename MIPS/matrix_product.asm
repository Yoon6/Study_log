.data
   	Matrix_A:  .word 1,2,3,4,5
        	   .word 1,2,3,4,5
       	           .word 1,2,3,4,5
       	           .word 1,2,3,4,5
       	           .word 1,2,3,4,5			#A행렬 선언
   	Matrix_x:  .word 1
   		   .word 2
   		   .word 3
   		   .word 4
   		   .word 5 				#x행렬 선언	
  	endLine : .asciiz "\n"
       spacebar : .asciiz " "
       
.text
   	main:			
   		run:
     	 	li $t2, 0   		# $t2 = mul_Matrix에서 사용할 변수 초기화
      		li $s0, 0		# $s0 = 결과행렬의 한 항 초기화
      		div $t0,$t1,5		# $t0 = 뒤에서 출력할 x행렬의 인덱스 초기화 t0=t1/3
      		mul_Matrix:
         		lw $s1, Matrix_A($t1)     	# $s1 A행렬 저장
         		lw $s2, Matrix_x($t2)		# $s2 x행렬 저장
         		mul $s1, $s1, $s2 		
        		add $s0, $s0, $s1  		#s0 = A[][1]*x[1]  행렬 곱 저장
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
         		syscall				# A행렬 출력
        		li $v0,4
        		la $a0, spacebar
        		syscall				# 열 구분
        		add $t3, $t3, 4
        		blt $t3, $t4, print_Matrix
         		syscall				#print_Matrix_x:	
         		
         		li $v0,1
     			lw $a0, Matrix_x($t0)		# x행렬 출력
      			syscall
      			li $v0,4
      			la $a0,spacebar
      			syscall				# 열 구분
      			
      			syscall
      			li $v0,1				#print_Result:
      			move $a0, $s0
     			syscall				# 결과행렬 출력 위에 matrit_mul에서 계산
     			
      			li $v0, 4
      			la $a0, endLine
     			syscall				# 행 구분
     			blt $t1, 100, run        # while( $t1 < 9*INT_SIZE )
     			
   		li $v0, 10
   		syscall				# END
