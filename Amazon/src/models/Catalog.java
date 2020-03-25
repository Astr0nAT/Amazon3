package models;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private ArrayList<Item> _items = new ArrayList<Item>();

    public ArrayList<Item> get_items() {
        return _items;
    }
    public void set_items(ArrayList<Item> items){
        _items = items;
    }

    public Catalog(){
        this(new ArrayList<Item>());
    }

    public Catalog(ArrayList<Item> items){
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

    public ArrayList<Item> createExampleItems(){
        ArrayList<Item> exampleItems = new ArrayList<Item>();
        Item laptop = new Laptop("EL001", 699.00, Category.Electronics, "Aspire 5", "Acer", 2.76, "1920x1080", 4100, false);
        Item phone = new Phone ( "EL002", 549.00, Category.Electronics,"iPhone 8", "Apple", 0.148, "1920x1080" ,3100, OperatingSystem.iOS);
        Item professionalFilm = new ProfessionalFilm("VD001", 12.99, Category.Video, "Guardians of the Galaxy", "Marvel Studios", 7500, "James Gunn");
        Item tutorial = new Tutorial("VD002", 4.99, Category.Video, "How to code in Java", "Skillshare", 5000, 4.5);
        Item novel = new Novel("BK001", 10.99, Category.Book, "Harry Potter and the Philosopher's Stone", "Scholastic Corporation", 0.7, 233, "Joanne K. Rowling");
        List<Language> languages = new ArrayList<>();
        languages.add(Language.German);
        languages.add(Language.English);
        Item manual = new manual("BK002", 50.0, Category.Book, "Dungeons & Dragons Monster manual", "Chris Sims", 1.7, 150, languages);

        exampleItems.add(laptop);
        exampleItems.add(phone);
        exampleItems.add(professionalFilm);
        exampleItems.add(tutorial);
        exampleItems.add(novel);
        exampleItems.add(manual);

        this.set_items(exampleItems);
        return exampleItems;
    }
}
