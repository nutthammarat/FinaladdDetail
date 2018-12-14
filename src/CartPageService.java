
import javax.swing.JOptionPane;

public abstract class CartPageService {

    public static void increaseItem() {
        int index = Integer.parseInt(CartPage.index1.getText());
        CartPage.index1.setText("" + (index + 1));
        int y = Integer.parseInt(CartPage.total1.getText());
        CartPage.total1.setText("" + (100 + y));
        getSum();
    }

    public static void increaseItems() {
        int index = Integer.parseInt(CartPage.index2.getText());
        CartPage.index2.setText("" + (index + 1));
        int y = Integer.parseInt(CartPage.total2.getText());
        CartPage.total2.setText("" + (180 + y));
        getSum();
    }

    public static void decreaseItems() {
        int index = Integer.parseInt(CartPage.index1.getText());
        if (index - 1 == 0) {
            int a = JOptionPane.showConfirmDialog(null, "ท่านต้องการลบสินค้าใช่หรือใหม่", "Warnning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (a == 0) {
                System.out.println("ลบสินค้าแล้ว");
                CartPage.index1.setText("" + (0));
                CartPage.total1.setText("0");
               
            } else {
                CartPage.index1.setText("" + 1);
                CartPage.total1.setText("100");
                
            }
            getSum();
        } else {
            CartPage.index1.setText("" + (index - 1));
            int y = Integer.parseInt(CartPage.total1.getText());
            CartPage.total1.setText("" + (y - 100));
            getSum();
        }
    }

    public static void decreaseItem() {
        int index = Integer.parseInt(CartPage.index2.getText());
        if (index - 1 == 0) {
            int a = JOptionPane.showConfirmDialog(null, "ท่านต้องการลบสินค้าใช่หรือใหม่", "Warnning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (a == 0) {
                System.out.println("ลบสินค้าแล้ว");
                CartPage.index2.setText("" + (0));
                CartPage.total2.setText("0");
            } else {
                CartPage.index2.setText("" + 1);
                CartPage.total2.setText("180");
            }
            getSum();
        } else {
            CartPage.index2.setText("" + (index - 1));
            int y = Integer.parseInt(CartPage.total2.getText());
            CartPage.total2.setText("" + (y - 180));
            getSum();
        }

    }

    public static void getSum() {
            int x = Integer.parseInt(CartPage.total1.getText());
            int y = Integer.parseInt(CartPage.total2.getText());
            CartPage.sum.setText(""+(x+y)+" บาท");
    }
    abstract public void showPayment();

}
