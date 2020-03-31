package models;

import java.util.ArrayList;
import java.util.List;

public class manual extends Book {
    private List<Language> _languages = new ArrayList<>();

    public List<Language> get_languages() {
        return _languages;
    }
    public void set_languages(List<Language> _languages) {
        this._languages = _languages;
    }

    public manual(){this("",0.0,Category.notSpecified,"","",0.0,0,
            null);}
    public manual(String itemNumber, double price, Category category, String name, String brand, double weight,
                  int numberPages, List<Language> language){
        super(itemNumber, price, category, name, brand, weight, numberPages);
        this.set_languages(language);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());

        s.append("Languages: ");

        for(int i = 0; i<this.get_languages().size(); i++){

            s.append(this.get_languages().get(i));
            if(i + 1 < this.get_languages().size()){
                s.append(", ");
            }
        }

        s.append("\n");

        return s.toString();
    }
}
