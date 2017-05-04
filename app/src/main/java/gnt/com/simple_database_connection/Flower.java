package gnt.com.simple_database_connection;

/**
 * Created by PC-05 on 5/3/2017.
 */

public class Flower {
    public String name;

    public String price;

    public Flower(String name, String price) {
        this.name = name;

        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
