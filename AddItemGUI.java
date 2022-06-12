import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
public class AddItemGUI extends JFrame {
    
    public AddItemGUI(){
        JPanel p1 = new JPanel(null);
        add(p1,BorderLayout.CENTER);
        p1.setBackground(Color.white);
        
        JLabel l1 = new JLabel("ID:");
        l1.setBounds(20, 50,50, 20);
        p1.add(l1);
        JLabel l2 = new JLabel("Name:");
        l2.setBounds(20,100,50,20);
        p1.add(l2);
        JLabel l3 = new JLabel("Price:");
        l3.setBounds(20,150,50,20);
        p1.add(l3);
        JLabel l4 = new JLabel("Type:");
        l4.setBounds(20,200,50,20);
        p1.add(l4);

        JTextField tf1 = new JTextField(5);
        tf1.setBounds(80,50,150,20);
        p1.add(tf1);
        JTextField tf2 = new JTextField(15);
        tf2.setBounds(80,100,150,20);
        p1.add(tf2);
        JTextField tf3 = new JTextField(10);
        tf3.setBounds(80,150,150,20);
        p1.add(tf3);
        JTextField tf4 = new JTextField(15);
        tf4.setBounds(80,200,150,20);
        p1.add(tf4);

        MenuItems M = new MenuItems();
        FileHandling f = new FileHandling();
        

        JButton b1 = new JButton("Save");
        b1.setBounds(20, 250, 100, 30);
        b1.addActionListener(e->{
            M.setId(Integer.parseInt(tf1.getText()));
            M.setName(tf2.getText());
            M.setPrice(Float.parseFloat(tf3.getText()));
            M.setType(tf4.getText());
            f.writeObjectMenu(M);
            
            tf1.setText(null);
            tf2.setText(null);
            tf3.setText(null);
            tf4.setText(null);
            this.dispose();
            
            try {
                RestaurantGUI g = new RestaurantGUI();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        p1.add(b1);

        JButton b2 = new JButton("Exit");
        b2.setBounds(150, 250, 100, 30);
        b2.addActionListener(e->{this.dispose();
            EditMenuGUI g = new EditMenuGUI();
        });
        p1.add(b2);

    
    
        this.add(p1);
        this.setTitle("Add Item");
        this.setSize(300, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
