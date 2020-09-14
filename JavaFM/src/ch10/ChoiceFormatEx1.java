package ch10;

import java.text.ChoiceFormat;

public class ChoiceFormatEx1 {
    public static void main(String[] args) {
        double[] limits = {60,70,80,90};
        String[] grade = {"D","C","B","A"};

        int[] scores = {100,95,88,70,52,60,70};

        ChoiceFormat form = new ChoiceFormat(limits, grade);

        for(int i=0; i<scores.length; i++)
            System.out.println(scores[i]+":"+form.format(scores[i]));
    }
}
