# 5*5��� 5*1���� �� 
.data
   	A:  .word 1,2,3,4,5
   	    .word 1,2,3,4,5
       	    .word 1,2,3,4,5
       	    .word 1,2,3,4,5
       	    .word 1,2,3,4,5			#A��� ����
   	x:  .word 1
   	    .word 2
     	    .word 3
   	    .word 4
    	    .word 5 				#x��� ����	
	newLine : .asciiz "\n"	                      #���� ���� 
	space : .asciiz " "                           #���� ����
       
.text
   	main:			
   		init:
     	 	li $t2, 0   		# ����� �ε��� �ʱ�ȭ 
      		li $s0, 0		# �������� �� �� �ʱ�ȭ
      		div $t0,$t1,5		# ����� ������ 5*1����� �ε��� ���� 
      		product:
         		lw $s1, A($t1)     	# $s1�� A��� ����
         		lw $s2, x($t2)		# $s2�� x��� ����
         		mul $s1, $s1, $s2 		
        		add $s0, $s0, $s1  		# A�� �� ��� x�� ���� ������ �� ( ��� ��)
         		add $t1, $t1, 4			#  ���� ����� �ε�����
         		add $t2, $t2, 4    		
         		blt $t2, 20, product		# (int size=4) 5�� �ݺ� 
         	add $t4,$t3,20
         	print:
         		li $v0,1
         		lw $a0,A($t3)
         		syscall				# A��� ���
        		li $v0,4
        		la $a0, space
        		syscall				# ���� 
        		add $t3, $t3, 4
        		blt $t3, $t4, print		# t3<20 ���� �ݺ�
         		syscall				# 	
         		li $v0,1
     			lw $a0, x($t0)			# x���� ���
      			syscall
      			li $v0,4
      			la $a0,space
      			syscall				# �� ����
      			syscall
      			li $v0,1			
      			move $a0, $s0
     			syscall				
      			li $v0, 4
      			la $a0, endLine
     			syscall				# �� ����
     			blt $t1, 100, init        	# 4*25(int������*���(5*5))
     			
   		li $v0, 10
   		syscall				# END
