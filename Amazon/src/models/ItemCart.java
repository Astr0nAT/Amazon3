package models;

public class ItemCart {

    private Item _item;
    private int _amount;

    public Item get_item() {
        return _item;
    }
    public void set_item(Item item) {
        this._item = item;
    }

    public int get_amount() {
        return _amount;
    }
    public void set_amount(int amount) {
        if(amount > 0) this._amount = amount;
    }

    public double get_priceOfAll(){
        return this.get_item().get_price() * this.get_amount();
    }

    public ItemCart(Item item, int amount){
        this.set_item(item);
        this.set_amount(amount);
    }

    @Override
    public String toString(){
        return "Itemnumber: " + this.get_item().get_itemNumber()+ "\n" +
                "Single price: " + this.get_item().get_price() + "\n" +
                "Brand: " + this.get_item().get_brand() + "\n" +
                "Name: " + this.get_item().get_name() + "\n" +
                "Amount: " + this.get_amount() + "\n" +
                "Total price: " + this.get_priceOfAll() + "\n";
    }
}
