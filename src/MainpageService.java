
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class MainpageService {

    public static ArrayList<Product> showAllProduct() {
        return ProductDao.getAllProducts();
    }

    public static Product getProduct(String pId) {
        return ProductDao.getProduct(pId);
    }

    static void getInfo() {
        ArrayList<Product> product = MainpageService.showAllProduct();
        int i = 0;
        for (Product e : product) {
            Product product1 = MainpageService.getProduct(e.getId());
            if (i == 0) {
                MainPage.x10.setText(product1.getName().toUpperCase());
                ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\chelsea-shirt.png");
                MainPage.x1.setIcon(icon);
            } else if (i == 1) {
                MainPage.x11.setText(product1.getName().toUpperCase());
                ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\sweatershirt.png");
                MainPage.x2.setIcon(icon);
            } else if (i == 2) {
                MainPage.x12.setText(product1.getName().toUpperCase());
                ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\pajamas.png");
                MainPage.x3.setIcon(icon);
            } else if (i == 3) {
                MainPage.x13.setText(product1.getName().toUpperCase());
                ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\hawaii-shirt.png");
                MainPage.x4.setIcon(icon);
            } else if (i == 4) {
                MainPage.x14.setText(product1.getName().toUpperCase());
                ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\supernova.png");
                MainPage.x5.setIcon(icon);
            } else if (i == 5) {
                MainPage.x15.setText(product1.getName().toUpperCase());
                ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\adidas_zne.png");
                MainPage.x6.setIcon(icon);
                break;
            }
            //MainPage.x1.setText(""+product1.getImage());
            i++;
        }

    }

//    public static void showCart() {
//        Random ran = new Random();
//        int a = ran.nextInt(2);
//        if (a == 0) {
//            JOptionPane.showMessageDialog(null, "ไม่มีสินค้าอยู่ในตะกร้า !", "Warning Message !", a);
//        } else {
//            CartPage cart = new CartPage();
//            cart.setVisible(true);
//        }
//    }

    abstract public  void showProfile() ;
    abstract public  void addtoCart();
}
