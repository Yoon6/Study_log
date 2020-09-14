package ch9;

import java.util.StringJoiner;

public class StringEx6 {
    public static void main(String[] args) {
        int iVal = 100;
        String strVal = String.valueOf(iVal);

        double dVal = 200.0;
        String strVal2 = dVal + "";

        double sum = Integer.parseInt("+"+strVal)+Double.parseDouble(strVal2);
        double sum2 = Integer.valueOf(strVal)+Double.valueOf(strVal2);

        //elements 뒤에 delimiter 삽입
        System.out.println(String.join("",strVal,"+",strVal2,"=")+sum);
        System.out.println(strVal+"+"+strVal2+"="+sum2);

    }
}
