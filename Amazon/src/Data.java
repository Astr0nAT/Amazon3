import models.Catalog;
import models.UserManager;

public interface Data {

    void loadUsers(UserManager um);
    void loadItems(Catalog catalog);
}
