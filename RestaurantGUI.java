import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;


public class RestaurantGUI extends JFrame{ 
    ArrayList<MenuItems> menuarray = new ArrayList<>();
    public RestaurantGUI() throws IOException{
        
        JPanel p = new JPanel(null);
    
        p.setBackground(Color.white);
        add(p,BorderLayout.CENTER);
        
        FileHandling f = new FileHandling();
        
        menuarray = f.readObjectMenu();
        
        String temp = "";
        for (int i = 0; i < menuarray.size(); i++) {
            temp += menuarray.get(i).display();
        }

        JLabel l1 = new JLabel("WELCOME TO THE RESTAURANT");
        l1.setBounds(140,10,300,20);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif",Font.BOLD,16));

        JLabel l2 = new JLabel();
        l2.setText("Customer Name");
        l2.setBounds(20, 50,100, 20);

        JTextField tf1 = new JTextField(50);
        tf1.setBounds(150,50,200,20);

        JLabel l3 = new JLabel();
        l3.setText("Service");
        l3.setBounds(20, 100, 100, 20);

        JRadioButton rb1 = new JRadioButton("Dine-In");
        rb1.setBounds(150,100,100,20);
        rb1.setActionCommand("Dine-In");
        JRadioButton rb2 = new JRadioButton("Take-Away");
        rb2.setBounds(250,100,100,20);
        rb2.setActionCommand("Take-Away");
        ButtonGroup bg = new ButtonGroup();
        
        bg.add(rb1);
        bg.add(rb2);

        JLabel l4 = new JLabel();
        l4.setText("Menu");
        l4.setBounds(20, 150, 100, 20);

        JComboBox<MenuItems> cb1 = new JComboBox<MenuItems>();
        cb1.setModel(new DefaultComboBoxModel<MenuItems>(menuarray.toArray(new MenuItems[0])));
        cb1.setBounds(150,150,100,20);
        p.add(cb1);

        JLabel l5 = new JLabel();
        l5.setText("Quantity");
        l5.setBounds(20,200,100,20);

        
        JTextField tf2 = new JTextField();
        tf2.setBounds(150,200,50,20);

        JLabel l6 = new JLabel();
        l6.setText("Total Cost");
        l6.setBounds(20,250,100,20);

        JTextField tf3 = new JTextField();
        tf3.setBounds(150,250,100,20);

        tf3.setEditable(false);
        
        
        PlaceOrder po = new PlaceOrder();
        JButton b1 = new JButton("Confirm");
        b1.setBounds(210,200,80,20);
        b1.setBackground(Color.green);
        b1.addActionListener(e->{
            try{
                int q = Integer.parseInt(tf2.getText());
                String cn = cb1.getSelectedItem().toString();
                String tc = Float.toString(po.calCost(cn,q,menuarray));
                tf3.setText(tc);
            }
            catch(Exception ef){
                System.out.println(ef.toString());
            }
        });

        JButton b2 = new JButton("Orders Details");
        b2.setBounds(80,300,120,30);
        b2.setBackground(Color.yellow);
        b2.addActionListener(e->{try {
            OrderDetailsGUI g = new OrderDetailsGUI();
        } catch (IOException e1) {
            e1.printStackTrace();
        }});

        
        
        JButton b3 = new JButton("Place Order");
        b3.setBounds(220,300,120,30);
        b3.setBackground(Color.yellow);
        b3.addActionListener(e->{
            po.setCustomerName(tf1.getText());
            po.setService(bg.getSelection().getActionCommand());
            po.setMenuName(cb1.getSelectedItem().toString());
            po.setQuantity(Integer.parseInt(tf2.getText()));
            po.setTotalCost(po.calCost(cb1.getSelectedItem().toString(), Integer.parseInt(tf2.getText()), menuarray));
            f.writeObjectOrder(po);
        });
           

        JButton b4 = new JButton("New Order");
        b4.setBounds(360,300,120,30);
        b4.setBackground(Color.yellow);
        b4.addActionListener(e->{tf1.setText(null);tf2.setText(null);tf3.setText(null);bg.clearSelection();});
        
        
        

        JTextPane tp = new JTextPane();
        tp.setText(temp);
        tp.setBounds(20, 20, 200, 300);
        
        tp.setEditable(false);

        JButton b5 = new JButton("Menu");
        b5.setBounds(80,350,120,30);
        b5.setBackground(Color.yellow);
        b5.addActionListener(e->JOptionPane.showMessageDialog(null,tp));


        
        JButton b6 = new JButton("Edit Menu");
        b6.setBounds(220,350,120,30);
        b6.setBackground(Color.yellow);
        b6.addActionListener(e->{EditMenuGUI g = new EditMenuGUI();
            this.dispose();
        });
        JButton b7 = new JButton("Exit");
        b7.setBackground(Color.red);
        b7.setForeground(Color.white);
        b7.setBounds(360,350,120,30);
        b7.addActionListener(e->this.dispose());

        
        
        
        
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(l6);
        p.add(tf1);
        p.add(tf2);
        p.add(tf3);
        p.add(rb1);
        p.add(rb2);
        
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        

        this.add(p);
        this.setTitle("Restaurant Management System");
        this.setSize(550, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    
    
}
