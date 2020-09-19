bool isEven(int x){
  if(x%2==0) {
    return true;
  }
  else {
    return false;
  }
}

List<int> getEvenNumbers(Iterable<int> numbers){ // 리스트 값이라고 보면됨
  var evenNumbers = <int>[]; // list 생성

  for(var i in numbers){ // 자바의 향상된 for문과 비슷
    if(isEven(i)) evenNumbers.add(i); // 짝수면 list에 추가
  }

  return evenNumbers; // 리스트를 반환
}

main(){
  var numbers = List.generate(10, (i) => i); // 축약
  print(getEvenNumbers(numbers));
}