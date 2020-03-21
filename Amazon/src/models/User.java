package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private int _userID;
    private String _firstname;
    private String _lastname;
    private Date _birthdate;
    private List<Address> _addresses = new ArrayList<Address>();
    private String _email;
    private Gender _gender;

    private ShoppingCart _shoppingCart;

    public ShoppingCart get_shoppingCart() {
        return _shoppingCart;
    }
    public void set_shoppingCart(ShoppingCart _shoppingCart) {
        this._shoppingCart = _shoppingCart;
    }

    public int get_userID() {
        return _userID;
    }
    public void set_userID(int userNumber) {
        this._userID = userNumber;
    }

    public String get_firstname() {
        return _firstname;
    }
    public void set_firstname(String firstname) {
        this._firstname = firstname;
    }

    public String get_lastname() {
        return _lastname;
    }
    public void set_lastname(String lastname) {
        this._lastname = lastname;
    }


    public Date get_birthdate() {
        return _birthdate;
    }
    public void set_birthdate(Date birthdate) {
        this._birthdate = birthdate;
    }

    public List<Address> get_addresses() {
        return _addresses;
    }

    public String get_email() {
        return _email;
    }
    public void set_email(String email) {
        this._email = email;
    }

    public Gender get_gender() {
        return _gender;
    }
    public void set_gender(Gender gender) {
        this._gender = gender;
    }

    public User() {
        this(0, "", "", 1, 1, 1950, "", Gender.notSpecified);
        this.set_shoppingCart(new ShoppingCart());
    }
    public User(int userNumber, String firstname, String lastname, int day, int month, int year, String email, Gender gender) {
        this.set_userID(userNumber);
        this.set_firstname(firstname);
        this.set_lastname(lastname);
        this.set_birthdate(new Date(day, month, year));
        this.set_email(email);
        this.set_gender(gender);
        this.set_shoppingCart(new ShoppingCart());
    }

    @Override
    public String toString() {
        String s = "User-Nr: " + this.get_userID() + "\n" +
                "Name: " + this.get_firstname() + " " + this.get_lastname() + "\n" +
                "Birthdate: " + this.get_birthdate().toString() + "\n" +
                "Gender: " + this.get_gender() + "\n" +
                "Email: " + this.get_email() + "\n";

        for (Address a : this.get_addresses()) {
            s += "\n" + a.toString();
        }
        return s;
    }

    public String toStringAddressless(){
        return "Name: " + this.get_firstname() + " " + this.get_lastname() + "\n" +
                "Birthdate: " + this.get_birthdate().toString() + "\n" +
                "Gender: " + this.get_gender() + "\n" +
                "Email: " + this.get_email() + "\n";
    }


    public String toStringShort(){
        return "User-Nr: " + this.get_userID() + "\n" +
                "Name: " + this.get_firstname() + " " + this.get_lastname() + "\n";
    }

    public String toAddressString(UserManager um){
        String s = "";
        for(Address a : um.get_users().get(um.get_currentUser()).get_addresses()){
            s += "------------------------\n" + a.toString();
        }

        return s + "------------------------\n";
    }
}
