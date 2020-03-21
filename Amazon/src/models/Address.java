package models;

import java.io.Serializable;
import java.util.Scanner;

public class Address implements Serializable {
    private String _street;
    private String _housenumber;
    private String _zipcode;
    private String _city;
    private String _state;
    private int _addressID;

    public String get_street() {
        return _street;
    }
    public void set_street(String street) {
        this._street = street;
    }

    public String get_housenumber() {
        return _housenumber;
    }
    public void set_housenumber(String housenumber) {
            this._housenumber = housenumber;
    }

    public String get_zipcode() {
        return _zipcode;
    }
    public void set_zipcode(String zipcode) {
            this._zipcode = zipcode;
    }

    public String get_city() {
        return _city;
    }
    public void set_city(String city) {
        this._city = city;
    }

    public String get_state() {
        return _state;
    }
    public void set_state(String state) {
        this._state = state;
    }

    public int get_addressID() {
        return _addressID;
    }
    public void set_addressID(int idAddress) {
        this._addressID = idAddress;
    }

    private transient static Scanner reader = new Scanner(System.in);

    public static Address create_address(int addressSize){
        String street, housenumber, zipcode, city, state;

        System.out.print("Street: ");
        street = reader.next();

        while(street.length() < 2){
            System.out.println("Street is too short!\n");
            System.out.print("Street: ");
            street = reader.next();
        }

        System.out.print("Housenumber: ");
        housenumber = reader.next();

        System.out.print("Zipcode: ");
        zipcode = reader.next();

        while(zipcode.length() < 4 || zipcode.length() > 5){
            System.out.println("Zipcode is wrong length!\n");
            System.out.print("Zipcode: ");
            zipcode = reader.next();
        }

        System.out.print("City: ");
        city = reader.next();

        while(city.length() < 2){
            System.out.println("City is too short!\n");
            System.out.print("City: ");
            city = reader.next();
        }

        System.out.print("State: ");
        state = reader.next();

        while(state.length() < 2){
            System.out.println("State is too short!\n");
            System.out.print("State: ");
            state = reader.next();
        }

        return new Address(street, housenumber, zipcode, city, state, addressSize);
    }

    public Address (){
        this("","","","","",0);
    }
    public Address(String street, String housenumber, String zipcode, String city, String state, int idAddress) {
        this.set_street(street);
        this.set_housenumber(housenumber);
        this.set_zipcode(zipcode);
        this.set_city(city);
        this.set_state(state);
        this.set_addressID(idAddress);
    }

    @Override
    public String toString(){
        return "Address number: " + this.get_addressID() + "\n" +
                this.get_street() + " " + this.get_housenumber() + "\n" +
                this.get_zipcode() + " " + this.get_city() + "\n" +
                this.get_state() + "\n";
    }

}
