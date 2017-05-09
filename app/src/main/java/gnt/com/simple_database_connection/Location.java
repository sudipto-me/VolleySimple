package gnt.com.simple_database_connection;

/**
 * Created by PC-05 on 5/7/2017.
 */

public class LocationDatabase {

    public String location_name;
    public int location_id;

    public LocationDatabase(){


    }

    public LocationDatabase(String name) {

        name = this.location_name;



    }

    public LocationDatabase(int id, String name) {

        id = this.location_id;
        name = this.location_name;
    }





    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
}
