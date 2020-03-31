import models.*;

import java.util.ArrayList;

public interface Data {
    void saveUsers(ArrayList<User> users);
    void saveItems(ArrayList<Item> items);
    void saveShoppingcart(ArrayList<ItemCart> cartItems, UserManager um);

    void loadUsers(UserManager um);
    void loadItems(Catalog catalog);
    void loadShoppingcart(ShoppingCart sc, UserManager um);

}
