package ch9;

public class RandomEx4 {
    final static int RECORD_NUM = 10;
    final static String TABLE_NAME = "TEXT_TABLE";
    final static String[] CODE1 = {"010","011","017","018","019"};
    final static String[] CODE2 = {"남자","여자"};
    final static String[] CODE3 = {"10대","20대","30대","40대","50대"};

    public static void main(String[] args) {
        for(int i=0; i<RECORD_NUM; i++){
            System.out.println(" INSERT INTO "+TABLE_NAME+" VALUES ("
                    +" '"+getRandArr(CODE1)+"'"
                    +", '"+getRandArr(CODE2)+"'"
                    +", '"+getRandArr(CODE3)+"'"
                    +", "+getRand(100,200)
                    +");");
        }
    }

    public static String getRandArr(String[] arr){ // arr.length-1개의 배열공간 생성 // 인자 배열크기에서 랜덤으로 뽑기
        return arr[getRand(arr.length-1)];
    }
    public static int getRand(int n){ // 인자가 한개면 0~n까지 랜덤
        return getRand(0, n);
    }
    public static int getRand(int from, int to){ // from에서 to까지 숫자중에 랜덤
        return (int)(Math.random()*(Math.abs(to-from)+1))+Math.min(from, to);
    }
}
