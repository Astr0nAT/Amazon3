import models.Catalog;
import models.UserManager;

public interface Data {

    void loadUsers(String filename, UserManager um);
    void loadItems(String filename, Catalog catalog);
}
