package DS;

import java.util.Scanner;

public class quicksort {
    private static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    private static void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr, start, end);
        if(start<part2 - 1){
            quickSort(arr, start, part2-1);
        }
        if(part2<end){
            quickSort(arr, part2, end);
        }
    }
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2];
        while(start<=end){
            while(arr[start]>pivot) start++;
            while(arr[end]<pivot) end--;
            if(start<=end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }
    private static void swap(int[] arr, int start, int end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    private static void printArray(int[] arr){
        for(int data : arr){
            System.out.print(data+", ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr=new int[10];
        int count=0;

        Scanner sc = new Scanner(System.in);
        for(int i=0; i<10; i++){
            System.out.print("value :");
            int input = sc.nextInt();
            arr[i]=input;
            count++;

            quickSort(arr, 0, count);
            printArray(arr);

        }

        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }
}
