package ru.geekbrains;

@Entity(tableName = "st_cat")
public final class Cat {
    private String name;
    private double price;
    @Column(field = "id", data = 3.1415)
    private String barcode;
    public Cat() {
    }
    @LogParams
    public Cat(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public String getBarcode() {
        return barcode;
    }
}


