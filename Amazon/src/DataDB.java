import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataDB implements Data{

    // This code is completely useless as it is. TODO implement full database support. Postponing for now.

    @Override
    public boolean checkIfUserDataAvailable(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon", "root", "root");
            System.out.println("Database connection successful!");
            return true;
        }
        catch(Exception e){
            Logger.getLogger(DataDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

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
