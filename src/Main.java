import java.util.*;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        ArrayList<Product> product = MainpageService.showAllProduct();
        
        for(Product e : product){
            System.out.println(e.getColor());
            
        }
        
    
        
}
   
}
