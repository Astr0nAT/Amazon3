package models;

public class Tutorial extends Video {
    private double _rating;

    public double get_rating() {
        return _rating;
    }
    public void set_rating(double rating) {
        if(rating > 0 && rating <= 5)this._rating = rating;
    }

    public Tutorial(String itemNumber, double price, Category category, String name, String brand,
                    int lenghtInSeconds, double rating){
        super(itemNumber, price, category, name, brand, lenghtInSeconds);
        this.set_rating(rating);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Rating: " + this.get_rating() + "\n";
    }
}
