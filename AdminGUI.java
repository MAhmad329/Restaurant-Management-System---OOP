import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;
public class AdminGUI extends JFrame{

    public AdminGUI(){
        JFrame frame = new JFrame();
        JPanel p1 = new JPanel(null);
        add(p1,BorderLayout.CENTER);

        JPanel p2 = new JPanel(null);
        p2.setBounds(0,5,550,40);
        p2.setBackground(Color.black);

        JLabel l1 = new JLabel("ADMIN LOGIN PAGE");
        l1.setBounds(170, 5, 200, 30);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Serif",Font.BOLD,20));
        p2.add(l1);
        

        JLabel l2 = new JLabel("ID:");
        l2.setBounds(220, 150, 50, 20);
        l2.setOpaque(true);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Serif",Font.BOLD,12));
        p1.add(l2);
        

        JTextField tf1 = new JTextField(5);
        tf1.setBounds(250, 150, 50, 20);
        p1.add(tf1);
        

        JLabel l3 = new JLabel("Pin:");
        l3.setBounds(220, 180, 50, 20);
        l3.setOpaque(true);
        l3.setForeground(Color.black);
        l3.setFont(new Font("Serif",Font.BOLD,12));
        p1.add(l3);

        JTextField tf2 = new JTextField(10);
        tf2.setBounds(250, 180, 50, 20);
        p1.add(tf2);
        

        JButton b1 = new JButton("Login");
        b1.setBounds(190, 210, 70, 20);
        b1.addActionListener(e->{try {
            if(tf1.getText().equalsIgnoreCase("44") && tf2.getText().equals("123")){
                RestaurantGUI g = new RestaurantGUI();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Credentials");
                AdminGUI g = new AdminGUI();
            }
            
        } catch (IOException e1) {
            e1.printStackTrace();
        }frame.dispose();});
        p1.add(b1);

        JButton b2 = new JButton("Exit");
        b2.setBounds(270, 210, 70, 20);
        b2.addActionListener(e->System.exit(0));
        p1.add(b2);

        
        ImageIcon image=new ImageIcon("D:\\Visual Studio\\Java\\SemesterProject\\i.jpg");
        JLabel l4=new JLabel(image);
        l4.setBounds(0, 0, 550, 500);
        l4.add(p2);
        p1.add(l4);
        

        
        
       
        
        
        
        
        

        frame.add(p1);
        frame.setTitle("ADMIN PAGE");
        frame.setSize(550, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}