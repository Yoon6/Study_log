	.text

	.globl main



main:			          # $t0 : i , $t1 : temp, $t2 : ans , $t7 : 1(0,1���丮���� ���� ��)

	li $t7,1	          # $t7�� 1����

	li $t2,1	           # $t2�� 1����



	li $v0,5 	          # scanf �غ�
	syscall

	move $t0,$v0	    # $v0���� $t0�� ���� 



	beq $t0,0,return0     # 0�̸� return0����

	

	j return1	          # �װ� �ƴϸ� return1��



return0:		          # 1�϶� ��� ����ϴ°�



	li $v0,1	          # print�غ�

	move $a0,$t7	    # $t7(1)���� $a0�� ����

	syscall

	

return1:

	

	beq $t0,1,return0    # 1�̸� return0����



	                      # �Ʒ� �ڵ�� 2�̻� ���



	mul $t2,$t2,$t0	  # $t2�� $t2*$t0�� �Ѱ��� �ִ´�.



	sub $t0,$t0,1	  # $t0 = $t0 - 1



	beq $t0,1,return2  # ���⼭ $t0�� 1�̵Ǹ� return2��

	j return1



return2:

	

	li $v0,1	         # print�غ�

	move $a0,$t2	  # $t7(1)���� $a0�� ����

	syscall	

