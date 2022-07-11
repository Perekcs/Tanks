package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {
    JPanel panel = new JPanel();
    JButton button1;
    JButton button2;
    JButton button3;
    String level;


    public Menu(){
        //panel.setLayout();
        panel.setBackground(Color.DARK_GRAY);
        button1 = new JButton(" Level 1");
        button1.setLocation(320, 50);
        button1.setSize(100,50);
        button1.addActionListener(this);

        button2 = new JButton(" Level 2");
        button2.setLocation(320, 150);
        button2.setSize(100,50);
        button2.addActionListener(this);

        button3 = new JButton(" Level 3");
        button3.setLocation(320, 250);
        button3.setSize(100,50);
        button3.addActionListener(this);


        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            level = "test_level_map_3";
        }
        if(e.getSource() == button1){
            level = "test_level_map_4";
        }
        if(e.getSource() == button1){
            level = "test_level_map_5";
        }
    }
}
