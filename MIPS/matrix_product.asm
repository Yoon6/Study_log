# 5*5행렬 5*1벡터 곱 
.data
   	A:  .word 1,2,3,4,5
   	    .word 1,2,3,4,5
       	    .word 1,2,3,4,5
       	    .word 1,2,3,4,5
       	    .word 1,2,3,4,5			#A행렬 선언
   	x:  .word 1
   	    .word 2
     	    .word 3
   	    .word 4
    	    .word 5 				#x행렬 선언	
	newLine : .asciiz "\n"	                      #개행 문자 
	space : .asciiz " "                           #공백 문자
       
.text
   	main:			
   		init:
     	 	li $t2, 0   		# 행렬의 인덱스 초기화 
      		li $s0, 0		# 결과행렬의 한 항 초기화
      		div $t0,$t1,5		# 결과를 저장할 5*1행렬의 인덱스 설정 
      		product:
         		lw $s1, A($t1)     	# $s1에 A행렬 저장
         		lw $s2, x($t2)		# $s2에 x행렬 저장
         		mul $s1, $s1, $s2 		
        		add $s0, $s0, $s1  		# A의 각 행과 x의 열의 곱들의 합 ( 행렬 곱)
         		add $t1, $t1, 4			#  다음 요소의 인덱스값
         		add $t2, $t2, 4    		
         		blt $t2, 20, product		# (int size=4) 5번 반복 
         	add $t4,$t3,20
         	print:
         		li $v0,1
         		lw $a0,A($t3)
         		syscall				# A행렬 출력
        		li $v0,4
        		la $a0, space
        		syscall				# 공백 
        		add $t3, $t3, 4
        		blt $t3, $t4, print		# t3<20 동안 반복
         		syscall				# 	
         		li $v0,1
     			lw $a0, x($t0)			# x벡터 출력
      			syscall
      			li $v0,4
      			la $a0,space
      			syscall				# 열 구분
      			syscall
      			li $v0,1			
      			move $a0, $s0
     			syscall				
      			li $v0, 4
      			la $a0, endLine
     			syscall				# 행 구분
     			blt $t1, 100, init        	# 4*25(int사이즈*행렬(5*5))
     			
   		li $v0, 10
   		syscall				# END
