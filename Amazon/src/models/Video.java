package models;

public abstract class Video extends Item {
    private int _lenghtInSeconds;

    public int get_lenghtInSeconds() {
        return _lenghtInSeconds;
    }

    public void set_lenghtInSeconds(int lenghtInSeconds) {
       if(lenghtInSeconds > 0) this._lenghtInSeconds = lenghtInSeconds;
    }

    public Video(){this("", 0.0, Category.notSpecified, "", "",0);}
    public Video(String itemNumber, double price, Category category, String name, String brand, int lenghtInSeconds){
        super(itemNumber, price, category, name, brand, 0.0);
        this.set_lenghtInSeconds(lenghtInSeconds);
    }

    @Override
    public String toString(){
        return "Itemnumber: " + this.get_itemNumber() + "\n" +
                "Category: " + this.get_category() + "\n" +
                "Brand: " + this.get_brand() + "\n" +
                "Name: " + this.get_name() + "\n" +
                "Price: " + this.get_price() + "€\n" +
                "Length in Seconds: " + this.get_lenghtInSeconds() + "\n";
    }
}
