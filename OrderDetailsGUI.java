import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
public class OrderDetailsGUI extends JFrame {
    
    public OrderDetailsGUI() throws IOException{
        JPanel p = new JPanel(null);
        p.setBackground(Color.white);
        add(p,BorderLayout.CENTER);
        
        FileHandling f = new FileHandling();
        
        ArrayList<PlaceOrder> orderarray = f.readObjectOrder();
        
        String temp = "";
        for (int i = 0; i < orderarray.size(); i++) {
            temp += orderarray.get(i).toString();
        }
        
        JTextPane tp = new JTextPane();
        tp.setBounds(20, 20, 500 , 400);
        tp.setText(temp);
        tp.setEditable(false);

        JButton b1 = new JButton("Exit");
        b1.setBounds(20, 500, 100, 30);
        b1.addActionListener(e->{
            this.dispose();
        });

        p.add(tp);
        p.add(b1);
        this.add(p);
        this.setTitle("Order Details");
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }
}
