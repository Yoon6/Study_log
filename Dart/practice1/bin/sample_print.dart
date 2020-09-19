main(){
  print('a single quoted string');
  print("a single quoted string"); // 작은 따음표와 큰 따음표는 차이 없음

  print("cat "+"dog"); // 문자열을 합쳐서 출력

  print(''' triple quoted String
  are for multiple line'''
  ); // 여러줄로 쓸 때는 ''' ''' 로 감싸준다.

  var PI = 3.14;
  print('PI is $PI');
  print('tau is ${2*PI}');

}