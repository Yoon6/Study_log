package ch7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerEx7 {
    public static void main(String[] args) {
        Button b = new Button("start");
        b.addActionListener(new EventHandler());
    }
}
class EventHandler implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("ActionEvent occurred!!");
    }
}
