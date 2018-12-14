import java.util.*;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        ArrayList<Product> product = ProductService.showAllProduct();
        ArrayList<Cart> cart = CartDao.showAllCart();
        for(Cart e : cart){
            System.out.println(e.getUser());
            
        }
        
    
        
}
    
   
}
