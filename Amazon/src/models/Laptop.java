package models;

public class Laptop extends Electronics {

    private boolean _touchScreen;

    public boolean is_touchScreen() {
        return _touchScreen;
    }
    public void set_touchScreen(boolean touchScreen) {
        this._touchScreen = touchScreen;
    }

    public Laptop(){
        this("", 0.0, Category.notSpecified, "", "", 0.0, "",
                0, false);
    }

    public Laptop(String itemNumber, double price, Category category, String name, String brand, double weight,
                  String resolution, int batteryCapacity, boolean touchScreen){
        super(itemNumber, price, category, name, brand, weight, resolution, batteryCapacity);
        this.set_touchScreen(touchScreen);
    }

    public String toString(){
        return super.toString() +
                "Has Touchscreen: " + this.is_touchScreen() + "\n";
    }
}
