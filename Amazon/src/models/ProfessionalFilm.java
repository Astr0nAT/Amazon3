package models;

public class ProfessionalFilm extends Video {
    private String _director;

    public String get_director() {
        return _director;
    }

    public void set_director(String _director) {
        this._director = _director;
    }

    public ProfessionalFilm(){
        this("", 0.0, Category.notSpecified, "", "", 0, "");
    }

    public ProfessionalFilm(String itemNumber, double price, Category category, String name, String brand,
                            int lenghtInSeconds, String director){
        super(itemNumber,price,category,name, brand, lenghtInSeconds);
        this.set_director(director);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Director: " + this.get_director() + "\n";
    }
}
