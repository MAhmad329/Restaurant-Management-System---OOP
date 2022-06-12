import java.io.Serializable;
import java.util.Scanner;

public class MenuItems implements Serializable {
    private int menuId;
    private String name;
    private float price ;
    private String type;
    
    
    public MenuItems(){
        menuId = 0 ;
        name = null ;
        price = 0.0f ;
        type = null ;
    }
    public MenuItems(int m , String n ,float p , String t ){
        this.menuId = m ;
        this.name = n ;
        this.price = p;
        this.type = t ;
    }
    public void readData(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Menu Details : ");
        System.out.println("Enter your Menu Type : ");
        type = input.nextLine();
        System.out.println("Enter Menu Name : ");
        name = input.nextLine();
        System.out.println("Enter Menu ID : ");
        menuId = input.nextInt();
        
        System.out.println("Enter Menu Price : ");
        price = input.nextFloat();
        
        
        
    }
    public void setId(int id){
        this.menuId=id;
    }
    public void setName(String s){
        this.name=s;
    }
    public void setPrice(float p){
        this.price = p;
    }
    public void setType(String g){
        this.type = g ;
    }
    public String getMenuName(){
        return name;
    }
    public int getMenuId(){
        return menuId;
    }
    public float getMenuPrice(){
        return price;
    }
    public String display(){
        return("MENU ID\t\tNAME:\t\tPRICE\t\tTYPE:\n"+this.menuId+"\t\t"+this.name+"\t\t"+this.price+"\t\t"+this.type+"\n\n");
    }
    public String toString(){
        return this.name;
    }
    
   
    

  
    
}