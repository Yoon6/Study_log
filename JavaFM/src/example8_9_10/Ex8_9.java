package example8_9_10;

public class Ex8_9 {
    public static void main(String[] args) {
        throw new UnsupportedFunctionException("지원하지 않는 기능입니다.",100);
    }
}
class UnsupportedFunctionException extends RuntimeException{
    final private int ERR_CODE;

    UnsupportedFunctionException(){
        this("지원하지 않는 기능입니다.", 100);
    }

    UnsupportedFunctionException(String message, int num){
        super(message);
        this.ERR_CODE=num;
    }

    public int getErrorCode(){
        return ERR_CODE;
    }

    public String getMessage(){
        return "["+getErrorCode()+"]"+super.getMessage();
    }
}