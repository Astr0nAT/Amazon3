import models.*;

import java.util.ArrayList;

public class DataDB implements Data{

    // This code is completely useless as it is. TODO implement full database support. Postponing for now.

    @Override
    public void loadUsers(UserManager um) {}
    @Override
    public void loadItems(Catalog catalog) {

    }

    @Override
    public void loadShoppingcart(ShoppingCart sc, UserManager um) {

    }

    @Override
    public void saveUsers(ArrayList<User> users) {

    }

    @Override
    public void saveItems(ArrayList<Item> items) {

    }

    @Override
    public void saveShoppingcart(ArrayList<ItemCart> cartItems, UserManager um) {

    }

}
