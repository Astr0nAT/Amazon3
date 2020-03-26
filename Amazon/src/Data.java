import models.Catalog;
import models.User;
import models.UserManager;

import java.util.ArrayList;

public interface Data {

    void loadUsers(String filename, UserManager um);
    void loadItems(String filename, Catalog catalog);
    void saveUsers(String filename, ArrayList<User> users);
}
