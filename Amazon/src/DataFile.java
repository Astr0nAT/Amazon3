import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import models.*;

public class DataFile implements Data{

    final static String usersFilename = "users.bin";
    final static String itemsFilename = "items.bin";
    final static File usersFile = new File("./" + usersFilename);
    final static File itemsFile = new File("./" + itemsFilename);

    public static void createFile(String filename) throws IOException{
            Files.createFile(Paths.get(filename));

            // besser wäre hier, dass die Exception an den Aufrufer weitergeleitet wird
            // und nicht in dieser Methode behandelt wird
            // Lösung: kein Exceptionhandling +
            //      public static void createFile(String filename) throws IOException{ ...
            //  würde für alle Methoden in dieser Klasse gelten
    }
    @Override
    public void saveUsers(ArrayList<User> users){
        try(FileOutputStream fos = new FileOutputStream("users.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(users);
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
    }
    @Override
    public void loadUsers(UserManager um){
        if(usersFile.exists()){
            try(FileInputStream fis = new FileInputStream("users.bin");
                ObjectInputStream ois = new ObjectInputStream(fis)){
                um.set_users((ArrayList<User>)ois.readObject());
                System.out.println("Loaded users from file");
            }
            catch(ClassNotFoundException e){
                System.out.println("Class not found.");
            }
            catch(IOException e){
                System.out.println("IO-Exception");
            }
        }
        else{
            um.set_users(um.createExampleUsers());
            System.out.println("File \"users\".bin does not exist. Creating example users from source code.");
            createUsersFile(um.get_users());
            System.out.println("Created file with users to load (\"users.bin\").");
        }
    }

    @Override
    public void saveShoppingcart(ArrayList<ItemCart> cartItems, UserManager um){
        try(FileOutputStream fos = new FileOutputStream("sc" + um.get_currentUser() + ".bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(cartItems);
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
    }
    @Override
    public void loadShoppingcart(ShoppingCart sc, UserManager um){
        int currentUser = um.get_currentUser();
        String filename = "sc" + currentUser + ".bin";
        File scFile = new File("./" + filename);
        if(scFile.exists()){
            try(FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis)){
                sc.set_items((ArrayList<ItemCart>)ois.readObject());
                System.out.println("Loaded shopping cart from file");
            }
            catch(ClassNotFoundException e){
                System.out.println("Class not found.");
            }
            catch(IOException e){
                System.out.println("IO-Exception");
            }
        }
        else{
            try{
                createFile(filename);
                System.out.println("Shopping cart file not found. New file created.");
            }
            catch(IOException e){
                System.out.println("IOException");
            }
        }
    }

    @Override
    public void saveItems(ArrayList<Item> items){
        try(FileOutputStream fos = new FileOutputStream("items.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(items);
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
    }
    @Override
    public void loadItems(Catalog catalog){
        if(itemsFile.exists()){
            try(FileInputStream fis = new FileInputStream("items.bin");
                ObjectInputStream ois = new ObjectInputStream(fis)){
                catalog.set_items((ArrayList<Item>)ois.readObject());
                System.out.println("Loaded items from file");
            }
            catch(ClassNotFoundException e){
                System.out.println("Class not found.");
            }
            catch(IOException e){
                System.out.println("IO-Exception");
            }
        }
        else{
            catalog.set_items(catalog.createExampleItems());
            System.out.println("File \"items\".bin does not exist. Creating example items from source code.");
            createItemsFile(catalog.get_items());
            System.out.println("Created file with items to load (\"items.bin\").");
        }
    }

    private void createUsersFile(ArrayList<User> users){
        try{
            createFile("users.bin");
        }
        catch(IOException e){
            System.out.println("IOException");
        }
        saveUsers(users);
    }

    private void createItemsFile(ArrayList<Item> items){
        try{
            createFile("items.bin");
        }
        catch(IOException e){
            System.out.println("IOException");
        }

        saveItems(items);
    }

}

