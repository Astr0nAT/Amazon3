package models;

public abstract class Electronics extends Item {

    private String _resolution;
    private int _batteryCapacity;

    public String get_resolution() {
        return _resolution;
    }
    public void set_resolution(String resolution) {
        this._resolution = resolution;
    }

    public int get_batteryCapacity() {
        return _batteryCapacity;
    }
    public void set_batteryCapacity(int batteryCapacity) {
        if(batteryCapacity > 0)this._batteryCapacity = batteryCapacity;
    }

    public Electronics(){
        this("", 0.0, Category.notSpecified, "", "", 0.0, "",
                0);
    }

    public Electronics(String itemNumber, double price, Category category, String name, String brand, double weight,
                       String resolution, int batteryCapacity){

        super(itemNumber, price, category, name, brand, weight);
        this.set_resolution(resolution);
        this.set_batteryCapacity(batteryCapacity);
    }

    public String toString(){
        return super.toString() +
                "Resolution: " + this.get_resolution() + "\n" +
                "Battery capacity: " + this.get_batteryCapacity() + " mAh\n";
    }



}
