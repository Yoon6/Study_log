package example13_14;

import java.util.*;

public class Ex13_8 {
    Vector words = new Vector();
    String[] data = {"태연","유리","윤아","효연","수영","서현","티파니","써니","제시카"};

    int interval = 2*1000;

    WordGenerator wg = new WordGenerator();

    public static void main(String[] args) {
        Ex13_8 word = new Ex13_8();

        word.wg.start();

        Vector words = word.words;
        while (true){
            System.out.println(words);
            String prompt = ">>";
            System.out.print(prompt);

            Scanner s = new Scanner(System.in);
            String input = s.nextLine().trim();

            int index = words.indexOf(input);

            if(index!=-1){
                words.remove(index);
            }
        }
    }

    class WordGenerator extends Thread{
        @Override
        public void run() {
            while (true){
                int index = (int)(Math.random()*data.length);
                words.add(data[index]);
                try {
                    Thread.sleep(interval);
                }catch (Exception e){}
            }
        }
    }
}
