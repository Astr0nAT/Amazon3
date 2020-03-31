package models;

public class Novel extends Book {
    private String _author;

    public String get_author() {
        return _author;
    }

    public void set_author(String author)
    {
        this._author = author;
    }

    public Novel(String itemNumber, double price, Category category, String name, String brand, double weight,
                 int numberPages, String author){
        super(itemNumber, price, category, name, brand, weight, numberPages);
        this.set_author(author);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Author: " + this.get_author() + "\n";
    }
}
