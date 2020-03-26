import models.Catalog;
import models.Item;
import models.User;
import models.UserManager;

import java.util.ArrayList;

public interface Data {

    void loadUsers(UserManager um);
    void loadItems(Catalog catalog);
    void saveUsers(ArrayList<User> users);
    void saveItems(ArrayList<Item> items);

    boolean checkIfUserDataAvailable();
}
