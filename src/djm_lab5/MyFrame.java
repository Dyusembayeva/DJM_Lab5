package djm_lab5;

import javax.swing.*;


public class MyFrame extends JFrame {
    Draw directX = new Draw();
    public MyFrame(){
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(directX);
        this.setVisible(true);
        this.setTitle("Lab5");
        
    }
    
}
