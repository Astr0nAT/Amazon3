package models;

public class Phone extends Electronics {

    private OperatingSystem _operatingSystem;

    public OperatingSystem get_operatingSystem() {
        return _operatingSystem;
    }
    public void set_operatingSystem(OperatingSystem operatingSystem) {
        this._operatingSystem = operatingSystem;
    }

    public Phone(){
        this("", 0.0, Category.notSpecified, "", "", 0.0, "",
                0, OperatingSystem.notSpecified);
    }

    public Phone(String itemNumber, double price, Category category, String name, String brand, double weight,
          String resolution, int batteryCapacity, OperatingSystem operatingSystem){

        super(itemNumber, price, category, name, brand, weight, resolution, batteryCapacity);
        this.set_operatingSystem(operatingSystem);

    }

    public String toString(){
        return super.toString() +
                "Operating system: " + this.get_operatingSystem() + "\n";
    }

}
