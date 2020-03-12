import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.io.*;
import models.*;

public class FileManager {

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
            System.out.println("Datei gelöscht!");
        }
        catch(IOException e){
            System.out.println("Datei existiert nicht!");
        }
    }

    public static void serializeUsers(String filename, ArrayList<User> users){
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(users);
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
    }
    public static ArrayList<User> deserializeUsers(String filename){
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            return (ArrayList<User>)ois.readObject();
        }
        catch(ClassNotFoundException e){
            System.out.println("Klasse nicht gefunden");
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
        return null;
    }

    public static void serializeItems(String filename, ArrayList<Item> items){
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(items);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Item> deserializeItems(String filename){
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            return (ArrayList<Item>)ois.readObject();
        }
        catch(ClassNotFoundException e){
            System.out.println("Klasse nicht gefunden");
        }
        catch(IOException e){
            System.out.println("IO-Exception");
        }
        return null;
    }

}
