package models;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Item> _items = new ArrayList<Item>();

    public List<Item> get_items() {
        return _items;
    }
    public void set_items(List<Item> items){
        _items = items;
    }

    public Catalog(){
        this(new ArrayList<Item>());
    }

    public Catalog(List<Item> items){
        set_items(items);
    }

    @Override
    public String toString(){
        String s = "------------------------\n";

        for(Item i : this.get_items()){
            s = s + i.toString();
            s = s + "------------------------\n";
        }

        return s;
    }
    public static void addItems(Catalog catalog){
        Item laptop = new Laptop("EL001", 699.00, Category.Electronics, "Aspire 5", "Acer", 2.76, "1920x1080", 4100, false);
        catalog.get_items().add(laptop);

        Item phone = new Phone ( "EL002", 549.00, Category.Electronics,"iPhone 8", "Apple", 0.148, "1920x1080" ,3100, OperatingSystem.iOS);
        catalog.get_items().add(phone);

        Item professionalFilm = new ProfessionalFilm("VD001", 12.99, Category.Video, "Guardians of the Galaxy", "Marvel Studios", 7500, "James Gunn");
        catalog.get_items().add(professionalFilm);

        Item tutorial = new Tutorial("VD002", 4.99, Category.Video, "How to code in Java", "Skillshare", 5000, 4.5);
        catalog.get_items().add(tutorial);

        Item novel = new Novel("BK001", 10.99, Category.Book, "Harry Potter and the Philosopher's Stone", "Scholastic Corporation", 0.7, 233, "Joanne K. Rowling");
        catalog.get_items().add(novel);

        List<Language> languages = new ArrayList<>();
        languages.add(Language.German);
        languages.add(Language.English);
        Item manual = new manual("BK002", 50.0, Category.Book, "Dungeons & Dragons Monster manual", "Chris Sims", 1.7, 150, languages);
        catalog.get_items().add(manual);
    }
}
