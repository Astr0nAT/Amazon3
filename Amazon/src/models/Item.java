package models;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private String _itemNumber;
    private double _price;
    private Category _category;
    private String _name;
    private String _brand;
    private double _weight;

    public String get_itemNumber() {
        return _itemNumber;
    }
    public void set_itemNumber(String itemNumber) {
        this._itemNumber = itemNumber;
    }

    public double get_price() {
        return _price;
    }
    public void set_price(double _price) {
       if(_price >= 0) this._price = _price;
    }

    public Category get_category() {
        return _category;
    }
    public void set_category(Category category) {
        this._category = category;
    }

    public String get_name() {
        return _name;
    }
    public void set_name(String name) {
        this._name = name;
    }

    public String get_brand() {
        return _brand;
    }
    public void set_brand(String brand) {
        this._brand = brand;
    }

    public double get_weight() {
        return _weight;
    }
    public void set_weight(double weight) {
        if(weight > 0) this._weight = weight;
    }

    public Item(){
        this("", 0.0, Category.notSpecified, "", "", 0.0);
    }

    public Item(String itemNumber, double price, Category category, String name, String brand, double weight){
        this.set_itemNumber(itemNumber);
        this.set_price(price);
        this.set_category(category);
        this.set_name(name);
        this.set_brand(brand);
        this.set_weight(weight);
    }

    @Override
    public String toString(){
        return "Itemnumber: " + this.get_itemNumber() + "\n" +
                "Category: " + this.get_category() + "\n" +
                "Brand: " + this.get_brand() + "\n" +
                "Name: " + this.get_name() + "\n" +
                "Price: " + this.get_price() + "€\n" +
                "Weight: " + this.get_weight() + " kg\n";
    }

}
