import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class EditMenuGUI extends JFrame {
    public EditMenuGUI(){
        
        JPanel p1 = new JPanel(null);
        add(p1,BorderLayout.CENTER);
        p1.setBackground(Color.white);

        JButton b1 = new JButton("Add Item");
        b1.setBounds(20, 20, 150, 50);
        b1.addActionListener(e->{AddItemGUI g = new AddItemGUI();
            this.dispose();
        });
        p1.add(b1);

        JButton b2 = new JButton("Delete Item");
        b2.setBounds(210,20,150,50);
        b2.addActionListener(e->{DeleteItemGUI g = new DeleteItemGUI();
            this.dispose();
        });
        p1.add(b2);


        JButton b3 = new JButton("Exit");
        b3.setBounds(115,90,150, 50);
        b3.addActionListener(e->{this.dispose();
            try {
                RestaurantGUI g = new RestaurantGUI();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        p1.add(b3);



        this.add(p1);
        this.setTitle("Edit Menu");
        this.setSize(400, 200);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
