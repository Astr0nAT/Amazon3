import models.Catalog;
import models.User;
import models.UserManager;

import java.util.ArrayList;

public interface Data {

<<<<<<< HEAD
    void loadUsers(String filename, UserManager um);
    void loadItems(String filename, Catalog catalog);
    void saveUsers(String filename, ArrayList<User> users);
=======
    void loadUsers(UserManager um);
    void loadItems(Catalog catalog);

    boolean checkIfUserDataAvailable();
>>>>>>> 6803a327dd53c1b13dd9aa0e70a723b4b1defc08
}
