package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {

    private transient static Scanner reader = new Scanner(System.in);

    private ArrayList<User> _users = new ArrayList<User>();
    private int _currentUser;

    public int get_currentUser() {
        return _currentUser;
    }
    public void set_currentUser(int currentUser) {
        this._currentUser = currentUser;
    }

    public List<User> get_users(){
        return _users;
    }
    public void set_users(ArrayList<User> users){
        this._users = users;
    }

    public void add_user(User user){
        this.get_users().add(user);
    }
    public void remove_user(int userNumber){
        for(User u : this.get_users()){
            if(u.get_userID() == userNumber){
                this.get_users().remove(u);
            }
        }
    }

    public ArrayList<User> createExampleUsers(){
        ArrayList<User> exampleUsers = new ArrayList<User>();
        User user1 = new User(0, "Philipp", "Schuler", 13, 5, 2003, "schulerp03@gmail.com", Gender.male);
        Address address1 = new Address("Kreuzbichlstraße", "57", "6112", "Wattens", "Austria", 0);
        Address address2 = new Address("Anichstraße", "26-28", "6020", "Innsbruck", "Austria", 1);
        user1.get_addresses().add(address1);
        user1.get_addresses().add(address2);

        User user2 = new User(1, "Anna-Maria", "Tipotsch", 20, 3, 2003, "annamaria@tsn.at", Gender.female);
        Address address3 = new Address("Zillertalstraße", "84b", "1337", "Zillertal", "Austria", 0);
        Address address4 = new Address("Georgenweg", "4a", "6100", "Telfs", "Austria", 1);
        user2.get_addresses().add(address3);
        user2.get_addresses().add(address4);

        exampleUsers.add(user1);
        exampleUsers.add(user2);

        this.set_users(exampleUsers);
        return exampleUsers;
    }

    public static int chooseUser(UserManager um){
        int choiceUser;
        boolean repeat;

        do {
            repeat = false;

            System.out.print("Choose a User by index (User-Nr): ");
            choiceUser = reader.nextInt();

            if((choiceUser > um.get_users().size() - 1) || (choiceUser < 0)){
                System.out.println("Index out of bounds\n");
                repeat = true;
            }

        } while( repeat );

        return choiceUser;

    }

    public static char editableFieldMenu(){
        System.out.println("Editable fields:");
        System.out.println("Firstname ....... f");
        System.out.println("Lastname ........ l(L)");
        System.out.println("Birthday ........ b");
        System.out.println("Email ........... e");
        System.out.println("Gender .......... g\n");
        System.out.print("Choice: ");
        return reader.next().toLowerCase().charAt(0);
    }

    public static void editUser(char choice, User user){
        while(choice != 'f' && choice != 'l' && choice != 'b' && choice != 'e' && choice != 'g'){
            System.out.println("Wrong input!\n");
            System.out.print("Choice: ");
            choice = reader.next().toLowerCase().charAt(0);
        }

        switch(choice){
            case 'f':
                System.out.println("Current firstname: "+ user.get_firstname());
                System.out.print("New firstname: ");
                user.set_firstname(reader.next());
                break;
            case 'l':
                System.out.println("Current lastname: "+ user.get_lastname());
                System.out.print("New lastname: ");
                user.set_lastname(reader.next());
                break;
            case 'b':
                Date birthday = new Date();
                System.out.println("Current Birthday: "+ user.get_birthdate().toString());
                System.out.print("New Birthyear: ");
                birthday.set_year(reader.nextInt());
                System.out.print("New Birthmonth: ");
                birthday.set_month(reader.nextInt());
                System.out.print("New Birthday: ");
                birthday.set_day(reader.nextInt());
                user.set_birthdate(birthday);
                break;
            case 'e':
                System.out.println("Current Email: "+ user.get_email());
                System.out.print("New Email: ");
                user.set_email(reader.next());
                break;
            case 'g':
                char gender;
                System.out.println("Current Gender: "+ user.get_gender());
                System.out.print("New Gender [m (male), f (female) , n (not specified)]: ");
                gender = reader.next().toLowerCase().charAt(0);
                if(gender == 'f'){
                    user.set_gender(Gender.female);
                }
                else if(gender == 'm'){
                    user.set_gender(Gender.male);
                }
                else if(gender == 'n'){
                    user.set_gender(Gender.notSpecified);
                }
                else{
                    System.out.println("Wrong input");
                }
                break;
       }
     }

     public static void showOneUser(UserManager um){
        System.out.println("\n" + um.get_users().get(um.get_currentUser()).toString() + "\n");
     }

    public User create_user(){
        Scanner reader = new Scanner(System.in);
        String firstname, lastname, email;
        Gender gender;
        char genderChar;
        int day, month, year;

        System.out.print("Firstname: ");
        firstname = reader.next();

        while(firstname.length() < 2){
            System.out.println("Firstname is too short!\n");
            System.out.print("Firstname: ");
            firstname = reader.next();
        }

        System.out.print("Lastname: ");
        lastname = reader.next();

        while(lastname.length() < 2){
            System.out.println("Lastname is too short!\n");
            System.out.print("Lastname: ");
            lastname = reader.next();
        }

        System.out.print("Year of birth: ");
        year = reader.nextInt();

        while(year > 2020 || year < 1900){
            System.out.println("Unrealistic year of birth!\n");
            System.out.print("Year of birth: ");
            year = reader.nextInt();
        }

        System.out.print("Month: ");
        month = reader.nextInt();

        while(month < 1 || month > 12){
            System.out.println("Month only possible from 1 to 12!\n");
            System.out.print("Month: ");
            month = reader.nextInt();
        }

        System.out.print("Day: ");
        day = reader.nextInt();

        while(day<1 || day > 31){
            System.out.println("Day only possible from 1 to 31!\n");
            System.out.print("Day: ");
            day = reader.nextInt();
        }

        System.out.print("Email: ");
        email = reader.next();

        while(email.length() < 5){
            System.out.println("Email is too short!\n");
            System.out.print("Email: ");
            email = reader.next();
        }

        System.out.print("Gender (m/f/n): ");
        genderChar = reader.next().charAt(0);

        while(genderChar != 'm' && genderChar != 'f' && genderChar != 'n'){
            System.out.println("Invalid input!\n");
            System.out.print("Gender (m/f/n): ");
            genderChar = reader.next().charAt(0);
        }

        System.out.println();

        if(genderChar == 'm'){
            gender = Gender.male;
        } else if(genderChar == 'f'){
            gender = Gender.female;
        } else {
            gender = Gender.notSpecified;
        }

        return new User(get_users().size(), firstname, lastname, day, month, year, email, gender);
    }

    public UserManager(){
        this(new ArrayList<User>(), 0);
    }

    public UserManager(ArrayList<User> users, int currentUser){
        this._users = users;
        this.set_currentUser(currentUser);
    }

    public String printCurrentUser(){
        return
                "------------------------\n" +
                "Current user: " + this.get_currentUser() + "\n" +
                "------------------------\n";
    }

    @Override
    public String toString(){
        String s = "------------------------\n";

        s += "Current user: " + this.get_currentUser() + "\n------------------------\n";

        for(User u : _users){
            s = s + u.toString();
            s += "------------------------\n";
        }

        return s;
    }

    public String toStringShort(){
        String s = "------------------------\n";

        s += "Current user ID: " + this.get_currentUser() + "\n------------------------\n";

        for(User u : _users){
            s = s + u.toStringShort();
            s += "------------------------\n";
        }

        return s;
    }

}
