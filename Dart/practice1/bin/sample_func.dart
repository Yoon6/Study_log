// A function declaration
int timesTwo(int x){ // 반환값
  return x*2; // 리턴값
}

// Arrow syntax is shorthand for '{ return expr; }'.
// 위의 함수는 아래 축약 함수와 똑같다.
// int timesTwo(int x) => x*2;

int timesFour(int x) => timesTwo(timesTwo(x));
// int timesFour(int x){
//   return timesTwo(timesTwo(x));
// }

// Functions are object
// function 자체를 객체로 쓸 수 있다.
int runTwice(int x, Function f){ // int와 function을 받아온다.
  for(var i = 0; i<2; i++){
    x=f(x);
  }
  return x;
}

main(){
  int num =16;
  print("4 times two is ${timesTwo(4)}"); // function 사용법
  print("4 times four is ${timesFour(4)}"); // function 사용법
  print("4 times four is $num"); // function 사용법
  print("2 x 2 x 2 is ${runTwice(2, timesTwo)}"); // 파라미터 없이 던져줌 function name만
  // "" 스트링 리터럴 안에 값을 출력할 때는, ${}안에 해야한다.
  // 간단한 변수면 $var 로 해도된다.
}