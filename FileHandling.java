import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    public void writeStreamHeader() throws IOException {
        return;
    }
}

public class FileHandling implements Serializable{
    File f = new File("MenuItems.dat");
    File f1 = new File("OrderDetails.dat");
    public void writeObjectMenu(MenuItems m){
        
        try {
            
           
            
            if (f.length()<1){
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f,true));
                out.writeObject(m);
                
            
            
            JOptionPane.showMessageDialog(null, "Menu Item Added");
            out.close();
            } 
            else{
                MyObjectOutputStream out = new MyObjectOutputStream(new FileOutputStream(f,true));
                out.writeObject(m);
                
            
            
            JOptionPane.showMessageDialog(null, "Menu Item Added");
            out.close();
            }
               
    }
        catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.toString());
        }
    }

    public ArrayList<MenuItems> readObjectMenu() throws IOException{
         ArrayList<MenuItems> list2 = new ArrayList<>();
         try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
                
                while (true) {
                    MenuItems mt = (MenuItems)in.readObject();
                    list2.add(mt);

                    
                    }
                
                
                
                
                } 
            
            catch (EOFException e) {
                System.out.println("End Of File");
            }
            catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
          } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
          } 
          return list2;
    }
    public void deleteObject(int c) throws IOException{
        ArrayList<MenuItems> delArray = new ArrayList<>();
        
        try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("MenuItems.dat"));
                
                while (true) {
                    MenuItems mt = (MenuItems)in.readObject();
                    delArray.add(mt);
                    
                }               
                
                } 
            
            catch (EOFException e) {
                System.out.println("End Of File");
            }
            catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
          } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
          }
        
        
        for(int i = 0 ; i<delArray.size();i++){
            MenuItems r = delArray.get(i);
            if(r.getMenuId()==c){
                delArray.remove(r);
                
            
            }
            
            try{
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("MenuItems.dat"));
                for (int j=0 ; j<delArray.size() ; j++){
                    out.writeObject(delArray.get(j));
                }
                
                
                
                
            }
            catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.toString());
        }
            
            
            
            
            
        }
                
    }
    
    public void writeObjectOrder(PlaceOrder p){
        
        try {
            
            if(f1.length()<1){
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f1,true));
                                  
            out.writeObject(p);
                
            
            
            JOptionPane.showMessageDialog(null, p.toString() );
            out.close(); 
            }
            else{
                MyObjectOutputStream out = new MyObjectOutputStream(new FileOutputStream(f1,true));
                                  
            out.writeObject(p);
 
            JOptionPane.showMessageDialog(null, p.toString() );
            out.close(); 
            }
              
    }
        catch (Exception e) {
            System.out.println("Exception");
            System.out.println(e.toString());
        }
    }
    
      
    
      public ArrayList<PlaceOrder> readObjectOrder() throws IOException{
        ArrayList<PlaceOrder> list3 = new ArrayList<>();
        try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1));
                
                while (true) {
                    PlaceOrder po = (PlaceOrder)in.readObject();
                    list3.add(po);
                    
                    }
            
                } 
            
            catch (EOFException e) {
                System.out.println("End Of File");
            }
            catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
          } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
          } 
          return list3;
    }
    
    
    
    
}