import models.Catalog;
import models.UserManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataDB implements Data{

    // @Override
    public boolean checkIfUserDataAvailable(UserManager um){
        try{
            Class.forName("com.mysql.jdbc.Driver");
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
    public void loadUsers(String filename, UserManager um) {

    }

    @Override
    public void loadItems(String filename, Catalog catalog) {

    }
}
