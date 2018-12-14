
public abstract class UserDAO {
    abstract public UserClass get(String username);
    abstract public UserClass getCart(String username);
    abstract public boolean addItem(UserClass username,Product product);
    abstract public boolean deleteItem(UserClass username,Product product);
    
}
