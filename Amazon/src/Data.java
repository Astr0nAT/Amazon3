import models.Catalog;
import models.User;
import models.UserManager;
import models.Item;

import java.util.ArrayList;

public interface Data {

    void saveUsers(ArrayList<User> users);
    void loadUsers(UserManager um);
    void loadItems(Catalog catalog);
    void saveItems(ArrayList<Item> item);

    boolean checkIfUserDataAvailable();

}
