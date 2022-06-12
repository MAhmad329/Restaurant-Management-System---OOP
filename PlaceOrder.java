import java.io.Serializable;
import java.util.ArrayList;

public class PlaceOrder implements Serializable{
   
    private String menuName;
    private String customerName;
    private String service;
    private float totalCost;
    private int quantity;

    public PlaceOrder(){
        menuName = null;
        customerName = null;
        service = null;
        totalCost = 0.0f;
        quantity = 0 ;
        
    }

    public PlaceOrder(String f,String cN,String sT,float tC , int q){
        menuName= f;
        customerName = cN;
        service = sT;
        totalCost = tC;
        quantity = q;

    }
    
    public void setMenuName(String n){
        this.menuName=n;
    }
    public void setCustomerName(String m){
        this.customerName = m ;
    }
    public void setService(String s){
        this.service = s ;
    }
    public void setQuantity(int q){
        this.quantity = q ;
    }
    public void setTotalCost(float tc){
        this.totalCost = tc ;
    }
    public int getQuantity(){
        return quantity;
    }
    
    public String toString(){
        return("******Receipt******\n"+
                "Customer Name:\t"+ this.customerName+"\n"+
                "Menu Name:\t"+this.menuName+"\n"+
                "Quantity:\t"+this.quantity+"\n"+
                "Total Cost:\t"+this.totalCost+"\n"+
                "Service Type:\t"+this.service+"\n");
    }


    public float calCost(String men , int quan ,ArrayList<MenuItems> menuArray ){
        float cost = 0.0f;
        for(int i=0 ; i<menuArray.size() ; i++){
            MenuItems r = menuArray.get(i);
            if(r.getMenuName().contains(men)){
                float p = r.getMenuPrice();
                cost = quan*p;
            
            }
        }
    
    return cost;
    }





  
}

