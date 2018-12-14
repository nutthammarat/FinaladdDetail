public class Product {
    private String id;
    private String picture;
    private String name;
    private int price;
    private String size;
    private String color;
    private String brand;
    private byte image;
    //private int num;

    Product(String id,String name, int price, String size, String color, String brand){
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.brand = brand;
        //this.picture = picture;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String toString(){
        return id + " " + name + " " + price + " " + size + " " + color;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        picture = "www.picz.in.th/images/2018/11/02/3k4D4P.th.jpg";
        this.picture = picture;
    }

    /**
     * @return the image
     */
    public byte getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte image) {
       
        this.image = image;
    }
}
