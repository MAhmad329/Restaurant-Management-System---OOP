import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
public class DeleteItemGUI extends JFrame {
    
    public DeleteItemGUI(){
        JPanel p1 = new JPanel(null);
        add(p1,BorderLayout.CENTER);
        p1.setBackground(Color.white);

        JLabel l1 = new JLabel("ID:");
        l1.setBounds(20, 50,50, 20);
        p1.add(l1);
        

        JTextField tf1 = new JTextField(5);
        tf1.setBounds(60,50,150,20);
        p1.add(tf1);
        
        FileHandling f = new FileHandling();

        JButton b1 = new JButton("Delete");
        b1.setBounds(20, 100, 80, 30);
        b1.addActionListener(e->{
            int id = Integer.parseInt(tf1.getText());
            try {
                f.deleteObject(id);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            this.dispose();
            try {
                RestaurantGUI g = new RestaurantGUI();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
           
        p1.add(b1);
        JButton b2 = new JButton("Exit");
        b2.setBounds(130, 100, 80, 30);
        b2.addActionListener(e->this.dispose());
        p1.add(b2);

       
        
       
        

        this.add(p1);
        this.setTitle("Delete Item");
        this.setSize(250, 200);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}