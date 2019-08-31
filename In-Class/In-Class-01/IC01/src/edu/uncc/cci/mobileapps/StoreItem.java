package edu.uncc.cci.mobileapps;

/**
 * @author venky
 */
public class StoreItem {
    private String name;
    private int id;
    private double price;

    public String getName() {
        return name;
    }

    @Override public String toString() {
        return "StoreItem{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
