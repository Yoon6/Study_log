.data
	array: .space 40
	top: .word 0
	
	comma: .asciiz ", "
	brace1: .asciiz "[ "
	brace2: .asciiz " ]"
	newLine: .asciiz "\n"
.text
	main:
		addi $s1, $zero, 0 	# $s1 == 인덱스
		lw $s0, top 		# $s0 == top 포인터 
		
			
		addi $a1, $zero, 3 	# 3을 인자로 전달		
		jal push 		# 푸쉬 
		jal print		# 출력
		
		addi $a1, $zero, 4 	# 4을 인자로 전달		
		jal push 		# 푸쉬 
		jal print		# 출력
		
		addi $a1, $zero, 7 	# 7을 인자로 전달		
		jal push 		# 푸쉬 
		jal print		# 출력
		
		addi $a1, $zero, 30 	# 30을 인자로 전달		
		jal push 		# 푸쉬 
		jal print		# 출력
		
		addi $a1, $zero, 23 	# 23을 인자로 전달		
		jal push 		# 푸쉬 
		jal print		# 출력
		
		jal pop			# 스택 최상위 요소 삭제 
		jal print		# 출력
		
		jal pop			# 스택 최상위 요소 삭제
		jal print		# 출력 
		
		addi $a1, $zero, 10 	# 10을 인자로 전달		
		jal push 		# 푸쉬 
		jal print		# 출력
		
		jal pop			# 스택 최상위 요소 삭제
		jal print		# 출력 
		
		jal pop			# 스택 최상위 요소 삭제
		jal print		# 출력 
		
		jal pop			# 스택 최상위 요소 삭제
		jal print		# 출력 
		
		jal pop			# 스택 최상위 요소 삭제
		jal print		# 출력 
		
		jal pop			# 스택 최상위 요소 삭제
		jal print		# 출력 
		
		li $v0, 10
		syscall			# 메인 끝 
		
	push: 
		bgt $s0, 9, exit_push 	# 10개를 넘으면 push제한 
		
		sw $a1, array($s1)	# 배열에 저장 
		addi $s0, $s0, 1	# top 포인터값 증가 
		addi $s1, $s1, 4	# 인덱스값 + 4(int size)
		
		exit_push:
		jr $ra			# 리턴 
	pop:
	
		blt $s0, 1, exit_pop	# 스택 요소가 없으면 pop 제한 
		
		subi $s1, $s1, 4	# 인덱스값 - 4
		addi $t0, $zero, 0	
		sw $t0, array($s1)	# 원래 값을 0으로 바꿈 
		subi $s0, $s0, 1	# top 포인터값 감소 
		
		exit_pop:
		jr $ra			# 리턴 
	
	print:
		
		li $v0, 4
		la $a0, brace1
		syscall				# 괄호 열기
		
		addi $t1, $zero, 0		# 출력에 사용할 인덱스 초기화

		mul $t2, $s0, 4			# 반복 횟수 지정
		while:
			beq $t1, $t2, exit 	# 인덱스와 스택의 개수가 같으면 탈출 
			
			li $v0, 1
			lw $a0, array($t1)
			syscall 		# 배열 출력
			
			addi $t1, $t1, 4 	# 인덱스값 갱신 
			
			li $v0, 4
			la $a0, comma
			syscall			# 컴마 출력 
			
			j while
		exit:
		
		li $v0, 4
		la $a0, brace2
		syscall			# 괄호 닫기
			
		li $v0, 4
		la $a0, newLine
		syscall			# 줄바꿈 
		
		jr $ra			# 리턴

			
			
			
