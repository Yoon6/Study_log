package ch6;

public class ReferenceParamEx3 {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 1, 6, 5, 4};

        System.out.println(arr.length);
        ReferenceParamEx3 referParam = new ReferenceParamEx3();
        referParam.printArr(arr);
        referParam.sortArr(arr);
        referParam.printArr(arr);
        System.out.println("sum= "+referParam.sumArr(arr));
    }

    void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i+",");
        }
        System.out.println();
    }
    int sumArr(int[] arr){
        int sum = 0;

        for (int i=0; i<arr.length-1; i++){
            sum += arr[i];
        }
        return sum;
    }
    void  sortArr(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
