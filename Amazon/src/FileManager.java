import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import models.*;

public class FileManager extends DataManager{
    @Override
    public char get_type(){
        return 'f';
    }

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
    public static ArrayList<User> loadUsers(String filename){
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            return (ArrayList<User>)ois.readObject();
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found.");
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
        return null;
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
    public static ArrayList<Item> loadItems(String filename){
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            return (ArrayList<Item>)ois.readObject();
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found.");
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
        return null;
    }

}
