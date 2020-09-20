class Car{
  int seats; // 의자 수
  String color; // 색상

  Car(/*@required*/ int seats, [String color = 'black']){ // 생성자, []-> 옵션값, 없어도 가능
    // 필수요소에 어노테이션 @required 사용가능
    //Car({int seats, String color = 'black'}){ {}-> 옵션값, 순서를 바꿔도 됨
    this.seats=seats;
    this.color=color;
  }
  // 축약 함수
  //Car(this.seats, this.color = 'black');

  printVars(){
    print('seat : $seats, color : $color');
  }
}
void main(){
  var newCar = Car(4); // new 연산자가 없어도 인스턴스 생성가능
  //var newCar = Car(color:'red', seats:4); // 생성자가 중괄호로 감싸여있으면 순서바꾸기 가능

  newCar.printVars();
}