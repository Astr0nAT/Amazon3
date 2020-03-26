import models.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    static Data manager = new DataFile();

    public static void main(String[] args) {

        UserManager um = new UserManager();
        Catalog catalog = new Catalog();
        Address shippingAddress;
        String paymentMethod;
        ArrayList<User> users = new ArrayList<User>();

        manager.loadUsers(um);
        manager.loadItems(catalog);

        switchForStartup(showStartupMenu(), um);
        System.out.println(um.printCurrentUser());
        manager.saveUsers("users.bin", users);

        boolean addAnotherItem, dataRight;
        char choice;
        do {
            do {
                switchForMain(showMainMenu(), catalog, um.get_users().get(um.get_currentUser()).get_shoppingCart(), um);
                System.out.println("\n------------------------\nShopping cart: \n" + um.get_users().get(um.get_currentUser()).get_shoppingCart().toString());


                if(um.get_users().get(um.get_currentUser()).get_shoppingCart().get_items().size() > 0){
                    do {
                        System.out.print("Proceed to check out? [y/n]: ");
                        choice = reader.next().toLowerCase().charAt(0);
                        if (choice != 'y' && choice != 'n') {
                            System.out.println("Wrong input!\n");
                        }
                    } while (choice != 'y' && choice != 'n');
                }
                else {
                    choice = 'n';
                }

                addAnotherItem = choice == 'n';

            } while (addAnotherItem);

            shippingAddress = chooseShippingAddress(um);
            paymentMethod = switchForPaymethod(showPaymethodMenu());

            System.out.println();
            System.out.println(um.get_users().get(um.get_currentUser()).toStringAddressless());
            System.out.println(shippingAddress.toString());
            System.out.println(um.get_users().get(um.get_currentUser()).get_shoppingCart().toString());
            System.out.println("Payment method: " + paymentMethod + "\n");
            dataRight = dataRightQuery();
        }while (!dataRight);
        System.out.println("Your order was successful");

        String fullinfo = um.get_users().get(um.get_currentUser()).toStringAddressless() + "\n" +
                shippingAddress.toString() + "\n" +
                um.get_users().get(um.get_currentUser()).get_shoppingCart().toString() + "\n" +
                "Payment method: " + paymentMethod + "\n";

        /*
        // String "fullinfo" wäre der komplette Inhalt der Email mit allen Informationen
        try {
            System.out.println("Trying to send email.\n");
            SendEmail.sendMail(um.get_users().get(um.get_currentUser()).get_email(), fullinfo);
        } catch(MessagingException m){
            System.out.println("Failed to send email");
            System.out.println(m.toString());
        }
        // es wird immer eine fehler mit der exception ausgeworfen, sollte so aber funktionieren
         */
        epicCountdown();
    }

    private static Address chooseShippingAddress(UserManager um) {
        char choice;

        Address shippingAddress = new Address();
        if(um.get_users().get(um.get_currentUser()).get_addresses().size() < 1){

            shippingAddress = Address.create_address(um.get_users().get(um.get_currentUser()).get_addresses().size());

        } else {
            System.out.println("Choose existing address ... c");
            System.out.println("Create new address      ... a");
            System.out.print("Choice: ");

            do{
                choice = reader.next().toLowerCase().charAt(0);
                if(choice != 'c' && choice != 'a'){
                    System.out.println("Wrong input!\n");
                    System.out.print("Choice: ");
                }
            } while (choice != 'c' && choice != 'a');

            switch(choice){
                case 'c':
                    System.out.println(um.get_users().get(um.get_currentUser()).toAddressString(um));
                    int addressID;

                    System.out.print("Choice: ");
                    addressID = reader.nextInt();

                    while(addressID > um.get_users().get(um.get_currentUser()).get_addresses().size() - 1 || addressID < 0){
                        System.out.println("Wrong input!");
                        System.out.print("Choice: ");
                        addressID = reader.nextInt();
                    }

                    shippingAddress = um.get_users().get(um.get_currentUser()).get_addresses().get(addressID);
                    break;
                case 'a':
                    shippingAddress = Address.create_address(um.get_users().get(um.get_currentUser()).get_addresses().size());
                    break;
            }
        }

        return shippingAddress;
    }

    private static final Scanner reader = new Scanner(System.in);

    private static void epicCountdown() {
        System.out.print("Programm wird geschlossen in: ");
        System.out.print("3");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.print(" ... 2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.print(" ... 1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println(" ... bye");
        System.exit(0);
    }

    private static char showStartupMenu(){
        System.out.println("Create new user      ... n");
        System.out.println("Choose existing user ... e");

        System.out.print("Choice: ");

        return reader.next().toLowerCase().charAt(0);
    }

    private static void switchForStartup(char choice, UserManager um){
        while(choice != 'n' && choice != 'e'){
            System.out.println("Wrong input!\n");
            System.out.print("Choice: ");
            choice = reader.next().toLowerCase().charAt(0);
        }

        switch(choice){
            case 'n':
                User user = um.create_user();
                um.add_user(user);
                um.set_currentUser(user.get_userID());
                break;
            case 'e':
                System.out.println("\n" + um.toStringShort());
                um.set_currentUser(UserManager.chooseUser(um));
                System.out.println();
                break;
        }
    }

    private static char showMainMenu(){
        System.out.println("Item menu ... i");
        System.out.println("User menu ... u");
        System.out.print("Choice: ");
        return reader.next().toLowerCase().charAt(0);
    }

    private static void switchForMain(char choice, Catalog catalog, ShoppingCart sc, UserManager um){
        while(choice != 'i' && choice != 'u'){
            System.out.println("Wrong input!\n");
            System.out.print("Choice: ");
            choice = reader.next().toLowerCase().charAt(0);
        }

        switch(choice){
            case 'i':
                System.out.println("\n" + catalog.toString());
                switchForItem(showItemMenu(), sc, catalog);
                break;
            case 'u':
                switchForUser(showUserMenu(), um);
                break;
        }
    }

    private static char showItemMenu(){
        System.out.println("Add new item to shopping cart ... a");
        System.out.println("Filter item catalog           ... f");
        System.out.println("Show shopping cart            ... s");
        System.out.print("Choice: ");
        return reader.next().toLowerCase().charAt(0);
    }

    private static void switchForItem(char choice, ShoppingCart sc, Catalog catalog){
        while(choice != 'a' && choice != 'f' && choice != 's'){
            System.out.println("Wrong input!\n");
            System.out.print("Choice: ");
            choice = reader.next().toLowerCase().charAt(0);
        }

        switch(choice){
            case 'a':
                inputItemNumber(catalog, sc);
            break;
            case 'f':
                switchForFilter(showFilterMenu(), catalog, sc);
                break;
            case 's':
                System.out.println(sc.toString());
                switchForShoppingCart(showShoppingCartMenu(), catalog, sc);
                break;
        }
    }

    private static char showShoppingCartMenu(){
        System.out.println("Add new item to shopping cart  ... a");
        System.out.println("Remove item from shopping cart ... r");
        System.out.print("Choice: ");
        return reader.next().toLowerCase().charAt(0);
    }
    
    private static void switchForShoppingCart(char choice, Catalog catalog, ShoppingCart sc){
        while(choice != 'r' && choice != 'a'){
            System.out.println("Wrong input!\n");
            System.out.print("Choice: ");
            choice = reader.next().toLowerCase().charAt(0);
        }

        switch(choice) {
            case 'r':
                System.out.print("Which item would you like to remove (Itemnumber): ");
                String searchphrase = reader.next().toLowerCase();

                List<ItemCart> sc_clone = new ArrayList<>(sc.get_items());

                for(ItemCart i : sc_clone){
                    if(i.get_item().get_itemNumber().toLowerCase().contains(searchphrase)){
                        sc.get_items().remove(i);
                    }
                }
                break;
            case 'a':
                inputItemNumber(catalog, sc);
                break;
        }
    }

    private static void inputItemNumber(Catalog catalog, ShoppingCart sc){
        boolean inputValid;
        String inputItemnumber;
        do {
            inputValid = false;

            System.out.print("Which item (itemnumber): ");
            inputItemnumber = reader.next().toUpperCase();

            for (Item i : catalog.get_items()) {
                if (i.get_itemNumber().equals(inputItemnumber)) {
                    inputValid = true;
                    break;
                }
            }

            if(!inputValid){
                System.out.println("Invalid itemnumber!\n");
            }

        } while(!inputValid);
        sc.chooseItem(inputItemnumber, catalog);
    }

    private static char showUserMenu(){
        System.out.println("\nChoose current user  ... c");
        System.out.println("Edit user              ... e");
        System.out.println("Add new user           ... a");
        System.out.println("Show all user data     ... s");
        System.out.println("Show current user data ... u");
        System.out.print("Choice: ");
        return reader.next().toLowerCase().charAt(0);
    }

    private static void switchForUser(char choice, UserManager um){
        while(choice != 'c' && choice != 'e' && choice != 'a' && choice != 's' && choice != 'u'){
            System.out.println("Wrong input!\n");
            System.out.print("Choice: ");
            choice = reader.next().toLowerCase().charAt(0);
        }

        switch(choice){
            case 'c':
                System.out.println(um.toStringShort());
                um.set_currentUser(UserManager.chooseUser(um));
                System.out.println(um.printCurrentUser());
                break;
            case 'e':
                System.out.println(um.toStringShort());
                System.out.print("Choose user number: ");
                int choiceUser = reader.nextInt();

                while((choiceUser > um.get_users().size() - 1) || (choiceUser < 0)){
                    System.out.println("Index out of bounds!\n");
                    System.out.print("Choose user number: ");
                    choiceUser = reader.nextInt();
                }

                UserManager.editUser(UserManager.editableFieldMenu(), um.get_users().get(choiceUser));
                break;
            case 'a':
                User user = um.create_user();
                um.add_user(user);
                break;
            case 's':
                System.out.println(um.toString());
                break;
            case 'u':
                UserManager.showOneUser(um);
        }
    }

    private static char showFilterMenu(){
        System.out.println("\nSearch by name  ... s");
        System.out.println("Limit max price ... l");
        System.out.println("Choose category ... c");
        System.out.print("Choice: ");
        return reader.next().toLowerCase().charAt(0);
    }

    private static void switchForFilter(char choice, Catalog catalog, ShoppingCart sc){
        Catalog outputCatalog = new Catalog();
        while(choice != 's' && choice != 'l' && choice != 'c'){
            System.out.println("Wrong input!\n");
            System.out.print("Choice: ");
            choice = reader.next().toLowerCase().charAt(0);
        }
        switch(choice){
            case 's':
                System.out.print("Search for: ");
                String searchPhrase = reader.next().toLowerCase();

                while(searchPhrase.length() < 2){
                    System.out.println("Searchphrase is too short.\n");
                    System.out.print("Search for: ");
                    searchPhrase = reader.next();
                }

                for(Item i : catalog.get_items()){
                    if(i.get_name().toLowerCase().contains(searchPhrase)){
                        outputCatalog.get_items().add(i);
                    }
                }
                System.out.println("\n" + outputCatalog.toString());
                break;
            case 'l':
                System.out.print("Price limit: ");
                double maxPrice = reader.nextDouble();

                while(maxPrice < 4.99){
                    System.out.println("This price wouldn't give any results.\n");
                    System.out.print("Price limit: ");
                    maxPrice = reader.nextDouble();
                }

                for(Item i : catalog.get_items()){
                    if(i.get_price() < maxPrice){
                        outputCatalog.get_items().add(i);
                    }
                }

                System.out.println("\n" + outputCatalog.toString());
                break;
            case 'c':
                switchForCategory(showCategoryMenu(), catalog);
                break;
        }

        inputItemNumber(catalog, sc);
    }

    private static char showCategoryMenu(){
        System.out.println("\nBook ........ b");
        System.out.println("Electronics ... e");
        System.out.println("Video ......... v");
        System.out.print("Choice: ");
        return reader.next().toLowerCase().charAt(0);
    }

    private static void switchForCategory(char choice, Catalog catalog){
        Catalog catalogOutput = new Catalog();

        while(choice != 'b' && choice != 'e' && choice != 'v'){
            System.out.println("Wrong input!\n");
            System.out.print("Choice: ");
            choice = reader.next().toLowerCase().charAt(0);
        }

        switch(choice){
            case 'b':
                for(Item i : catalog.get_items()){
                    if(i.get_category() == Category.Book){
                        catalogOutput.get_items().add(i);
                    }
                }
                break;
            case 'e':
                for(Item i : catalog.get_items()){
                    if(i.get_category() == Category.Electronics){
                        catalogOutput.get_items().add(i);
                    }
                }
                break;
            case 'v':
                for(Item i : catalog.get_items()){
                    if(i.get_category() == Category.Video){
                        catalogOutput.get_items().add(i);
                    }
                }
                break;
        }
        System.out.println("\n" + catalogOutput.toString());
    }

    private static char showPaymethodMenu(){
        System.out.println("Bank account ... b");
        System.out.println("Creditcard ..... c");
        System.out.println("Bill ........... i");
        System.out.print("Choice: ");
        return reader.next().toLowerCase().charAt(0);
    }
    private static String switchForPaymethod(char choice){
        while(choice != 'b' && choice != 'c' && choice != 'i'){
            System.out.println("Wrong input!\n");
            System.out.print("Choice: ");
            choice = reader.next().toLowerCase().charAt(0);
        }
        String a = "";
        switch(choice){
            case 'b':
                a = "Bank account";
                break;
            case 'c':
                a = "Credit card";
                break;
            case 'i':
                a = "Bill";
                break;
        }
        return a;
     }
     private static boolean dataRightQuery (){
        char answer;
        boolean value = true;
        do{
            System.out.println("Is this data right? [y|n]");
            answer = reader.next().toLowerCase().charAt(0);
            if (answer == 'n') {
                value = false;
            } else if (answer != 'y'){
                System.out.println("Invalid input");
                answer = 'f';
            }
        }while (answer == 'f');
         return value;
     }



}
