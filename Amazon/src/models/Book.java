package models;

public abstract class Book extends Item{
    private int _numberpages;

    public int get_numberpages() {
        return _numberpages;
    }

    public void set_numberpages(int numberpages) {
        if(numberpages > 0) {
            this._numberpages = numberpages;
        }
    }

    public Book(){
        this("",0.0,Category.notSpecified,"","",0.0,0);
    }
    public Book(String itemNumber, double price, Category category, String name, String brand, double weight, int numberPages){
        super(itemNumber, price, category, name, brand, weight);
        this.set_numberpages(numberPages);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Number of pages: " + this.get_numberpages() + "\n";
    }
}
