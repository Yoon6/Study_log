package ch9;

class Person{
    long id;

    //equal 메소드 오버라이딩 id비교위해
    public boolean equals(Object object){
        if(object!=null&&object instanceof Person){
            return id == ((Person)object).id;
        }else{
            return false;
        }
    }
    Person(long id){
        this.id = id;
    }
}

public class EqualsEx2 {
    public static void main(String[] args) {
        Person p1 = new Person(8011);
        Person p2 = new Person(8011);
        if(p1==p2)
            System.out.println("같음");
        else
            System.out.println("다름");
        if(p1.equals(p2))
            System.out.println("같음");
        else
            System.out.println("다름");
    }
}
