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

    public static void createFile(String filename){
        try{
            Files.createFile(Paths.get(filename));
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
    }
    public static void deleteFile(String filename) {
        try{
            Files.delete(Paths.get(filename));
            System.out.println("File deleted!");
        }
        catch(IOException e){
            System.out.println("File does not exist.");
        }
    }

    public static void saveUsers(String filename, ArrayList<User> users){
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(users);
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
    }
    @Override
    public void loadUsers(String filename, UserManager um){
        if(usersFile.exists()){
            try(FileInputStream fis = new FileInputStream(filename);
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

    public static void saveItems(String filename, ArrayList<Item> items){
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(items);
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
    }
    @Override
    public void loadItems(String filename, Catalog catalog){
        if(itemsFile.exists()){
            try(FileInputStream fis = new FileInputStream(filename);
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

    public static void createUsersFile(ArrayList<User> users){
        createFile("users.bin");
        saveUsers("users.bin", users);
    }

    public static void overwriteUsersFile(ArrayList<User> users){
        deleteFile("users.bin");
        createUsersFile(users);
    }

    private static void createItemsFile(ArrayList<Item> items){
        createFile("items.bin");
        saveItems("items.bin", items);
    }

    public static void overwriteItemsFile(ArrayList<User> items){
        deleteFile("items.bin");
        createUsersFile(items);
    }

}
