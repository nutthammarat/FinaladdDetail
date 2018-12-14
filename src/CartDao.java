/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WATCHARAPOL PLOYJAN
 */

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import java.util.*;
public class CartDao {
    static MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds249503.mlab.com:49503/finalproject");
    static MongoClient client = new MongoClient(uri);
    static MongoDatabase db = client.getDatabase(uri.getDatabase());
    static MongoCollection<Document> col = db.getCollection("cart");
    
    static public boolean addCart(User user,Product product,int num){
        Product thisProduct = getProductCart(user, product);
        if(thisProduct == null){
            col.insertOne(new Document("username",user.getUsername()).append("pId", product.getId()).append("num", num));
            return true;
        }else
            return false;
    }
    
    static public ArrayList<Product> getAllProductCart(User user,Product product){
        ArrayList<Product> products = new ArrayList<>();
        Document findUser = new Document("username",user.getUsername());
        MongoCursor<Document> cursor = col.find(findUser).iterator();
        while(cursor.hasNext()){
            Document doc = cursor.next();
            Product thisProduct = ProductDao.getProduct(doc.get("pId").toString());
            products.add(thisProduct);
        }
        return products;
    }
    
        static public Product getProductCart(User user,Product product){
        Product thisProduct = null;
        Document findProduct = new Document("username",user.getUsername()).append("pId", product.getId());
        MongoCursor<Document> cursor = col.find(findProduct).iterator();
        if(cursor.hasNext()){
            Document doc = cursor.next();
            thisProduct = ProductDao.getProduct(doc.get("pId").toString());
        }
        return thisProduct;
    }
        public static void main(String args[]){
            User user = UserService.getUser("user2");
            Product product = ProductService.getProduct("S02");
            addCart(user, product, 1);
           
            
        }
        static public ArrayList<Cart> getAllProductss() {
        MongoCursor<Document> cursor = col.find().iterator();
        ArrayList<Cart> carts = new ArrayList<>();
        while (cursor.hasNext()) {
            Document cart = cursor.next();
           carts.add(new Cart(cart.get("username").toString(),cart.get("pId").toString(),cart.get("num").toString()));
        }
        return carts;
    }
         public static ArrayList<Cart> showAllCart() {
        return CartDao.getAllProductss();
    }
}
