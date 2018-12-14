
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ProductDetailService {

    static String blue = "น้ำเงิน";
    static String gray = "เทา";
    static String red = "แดง";
    static String brown = "น้ำตาล";
    static String pink = "ชมพู";
    static String black = "ดำ";

    public static void showProductDetail() {
        ProductDetailFrame productdetail = new ProductDetailFrame();
        productdetail.setVisible(true);
    }

    public static Product getProduct(String pId) {
        return ProductDao.getProduct(pId);
    }

    public static String changeEngtoThaiColor(String color) {
        if (color.equals("blue")) {
            return blue;
        } else if (color.equals("gray")) {
            return gray;
        } else if (color.equals("red")) {
            return red;
        } else if (color.equals("brown")) {
            return brown;
        } else if (color.equals("pink")) {
            return pink;
        }
        return black;
    }

    public static void getDetailProduct(String pid) {
        Product product1 = getProduct(pid);
        String setcolor = changeEngtoThaiColor(product1.getColor());
        getSize(product1.getSize());
        getPicture(pid);
        getBand(product1.getBrand());
        getPrice(product1.getPrice());
        ProductDetailFrame.nameproduct.setText(product1.getName().toUpperCase());
        ProductDetailFrame.colortxt.setText(setcolor);

    }

    public static void getBand(String band) {
        ProductDetailFrame.bandtxt.setText(band);

    }

    public static void getSize(String size) {
        ProductDetailFrame.sizetxt.setText(size);

    }

    public static void getPrice(int price) {
        ProductDetailFrame.pricetxt.setText("" + price);

    }

    public static void getPicture(String pid) {
        if (pid.equals("S01")) {
            ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\chelsea-shirt.png");
            ProductDetailFrame.pic1.setIcon(icon);
        } else if (pid.equals("S02")) {
            ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\sweatershirt.png");
            ProductDetailFrame.pic1.setIcon(icon);
        } else if (pid.equals("S03")) {
            ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\pajamas.png");
            ProductDetailFrame.pic1.setIcon(icon);
        } else if (pid.equals("S04")) {
            ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\hawaii-shirt.png");
            ProductDetailFrame.pic1.setIcon(icon);
        } else if (pid.equals("S05")) {
            ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\supernova.png");
            ProductDetailFrame.pic1.setIcon(icon);
        } else if (pid.equals("S06")) {
            ImageIcon icon = new ImageIcon("D:\\FinalProject-master\\src\\org\\me\\myimageapp\\resources\\adidas_zne.png");
            ProductDetailFrame.pic1.setIcon(icon);
        }
    }
    public static void increaseNumofProduct(){
        int index = Integer.parseInt(ProductDetailFrame.numtxt.getText());
        index = index +1;
        ProductDetailFrame.numtxt.setText(""+index);
    }
    public static void decreaseNumofProduct(){
        int index = Integer.parseInt(ProductDetailFrame.numtxt.getText());
        index = index -1;
        if(index > 0){
          ProductDetailFrame.numtxt.setText(""+index);  
        }
        
    }
    public static void showCcomfirmProducttoCart(){
        JOptionPane.showMessageDialog(null, "คุณได้ทำการเพิ่มสินค้าไปยังตะกร้าเรียบร้อยแล้ว_");
        int index = JOptionPane.showConfirmDialog(null, 
                "คุณต้องการไปยังหน้าตะกร้าสินค้าเลยหรือไม่ ??", "Go to Cart or Not?", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        showCartPage(index);
    }
    public static void showCartPage(int index){
        if(index == 0){
            CartPage cartpage = new CartPage();
            cartpage.setVisible(true);
        }
        
    }
    public static String addCartToDB(){
        System.out.println(ProductDetailFrame.nameproduct.getText() + " " +
                ProductDetailFrame.bandtxt.getText()+ " "+
                ProductDetailFrame.colortxt.getText()+ " "+
                 ProductDetailFrame.sizetxt.getText()+ " "+
                 ProductDetailFrame.pricetxt.getText()+ " "+
                 ProductDetailFrame.numtxt.getText()+ " ");
        return "";
    }

}
