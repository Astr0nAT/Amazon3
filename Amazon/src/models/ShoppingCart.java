package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart implements Serializable {
    private ArrayList<ItemCart> _items = new ArrayList<>();

    public ArrayList<ItemCart> get_items() {
        return _items;
    }
    public void set_items(ArrayList<ItemCart> items) {
        this._items = items;
    }

    public double get_totalPrice() {
        double _totalPrice = 0.0;

        for(ItemCart i : _items){
            _totalPrice = _totalPrice + i.get_priceOfAll();
        }

        return _totalPrice;
    }

    public void add_item(Item item, int amount){
        this.get_items().add(new ItemCart(item, amount));
    }

    public void chooseItem(String itemnumber, Catalog catalog){
        boolean addAmountBool = false;
        for(Item i : catalog.get_items()){
            if(i.get_itemNumber().equals(itemnumber)){
                for(ItemCart ic : this.get_items()){
                    if(ic.get_item().get_itemNumber().equals(itemnumber)){
                        System.out.print("You already have " + ic.get_amount() + " item(s) of that type in your " +
                                "shopping cart.\nHow many items would you like to add: ");
                        int addAmount = new Scanner(System.in).nextInt();

                        while(addAmount < 0  || addAmount + ic.get_amount() > 500){
                            System.out.println("Unrealistic input!\n");
                            System.out.print("How many items would you like to add: ");
                            addAmount = new Scanner(System.in).nextInt();
                        }
                        ic.set_amount(ic.get_amount() + addAmount);
                        addAmountBool = true;
                        break;
                    }
                }
                if(addAmountBool){
                    break;
                }

                int amount;

                System.out.print("How many items: ");
                amount = new Scanner(System.in).nextInt();

                while(amount > 500 || amount < 1){
                    System.out.println("Unrealistic input!\n");
                    System.out.print("How many items: ");
                    amount = new Scanner(System.in).nextInt();
                }

                this.add_item(i, amount);
            }
        }
    }

    public ShoppingCart(){
        this(new ArrayList<>());
    }

    public ShoppingCart(ArrayList<ItemCart> items){
        set_items(items);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("------------------------\n");

        for(ItemCart i : _items){
            s.append(i.toString());
            s.append("------------------------\n");
        }

        s.append("Total shopping cart price: ").append(this.get_totalPrice()).append("\n");

        return s.toString();
    }

}
