package example6_7;

import java.util.Arrays;

public class Ex6_23 {
    static int max(int[] arr){
        if(arr==null||arr.length==0)
            return -999999;
        int maximum = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length-i-1; j++){
                if(arr[i]>=arr[j])
                    maximum=arr[i];
                else
                    maximum=arr[j];

            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        int[] data = {3,2,9,4,7};
        System.out.println(Arrays.toString(data));
        System.out.println("최대값:"+max(data));
        System.out.println("최대값:"+max(null));
        System.out.println("최대값:"+max(new int[]{}));
    }
}
