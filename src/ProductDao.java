import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import org.bson.*;
import java.util.*;
import javax.xml.crypto.Data;
import org.bson.types.ObjectId;
public class ProductDao {
    static MongoClientURI uri = new MongoClientURI("mongodb://admin:password1@ds249503.mlab.com:49503/finalproject");
    static MongoClient client = new MongoClient(uri);
    static MongoDatabase db = client.getDatabase(uri.getDatabase());
    static MongoCollection<Document> col = db.getCollection("product");
    static GridFSBucket gridFSBucket = GridFSBuckets.create(db);
    
    static public ArrayList<Product> getAllProducts() {
        MongoCursor<Document> cursor = col.find().iterator();
        ArrayList<Product> products = new ArrayList<>();
        while (cursor.hasNext()) {
            Document product = cursor.next();
            products.add(new Product(product.get("_id").toString(),product.get("name").toString(),(int)product.get("price")
                    ,product.get("size").toString(),product.get("color").toString(),product.get("brand").toString()));
        }
        return products;
    }

    static public Product getProduct(String pId) {
        Document findProduct = new Document("_id",pId);
        MongoCursor<Document> cursor = col.find(findProduct).iterator();
        Product thisProduct = null;
        if(cursor.hasNext()){
            Document product = cursor.next();
            thisProduct = new Product(product.get("_id").toString(),product.get("name").toString(),(int)product.get("price")
                    ,product.get("size").toString(),product.get("color").toString(),product.get("brand").toString());
        }
        return thisProduct;
    }
     
  public static void main(String[] args) throws Exception {
//        //Load our image
//        byte[] imageBytes = LoadImage("C:/Temp/bear.bmp");
//        //Connect to database
//        MongoDatabase db = client.getDatabase(uri.getDatabase());
//        MongoCollection<Document> col = db.getCollection("product");
//        //Create GridFS object
//        GridFS fs = new GridFS(col);
//        //Save image into database
//        GridFSInputFile in = fs.createFile( imageBytes );
//        in.save();
//
//        //Find saved image
//        GridFSDBFile out = fs.findOne( new BasicDBObject( "_id" , in.getId() ) );
//
//        //Save loaded image from database into new image file
//        FileOutputStream outputImage = new FileOutputStream("C:/Temp/bearCopy.bmp");
//        out.writeTo( outputImage );
//        outputImage.close();
    }
}
