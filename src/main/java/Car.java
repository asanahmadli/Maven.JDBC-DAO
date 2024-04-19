public class Car extends DAOConcreate{
/**The aim of this tutorial is to manage the access of a table in database
 * from separate layer written in java, this layer usually called Data Access Layer (DAL)
 *
 * The most benefit from DAL is that it simplifies database access operations through some method calls like insert() and find()
 *rather than making connection and executing some queries
 *
 * this layer instead handles all database related calls and queries inside it.
 * every column in the table would be a member variable in the class.
 *
 * our aim is to order this layer to create, modify, delete or search for an entity
 * Using simple java objects rather than dealing with SQL statements and other database related commands.
 * A good practice is to provide default empty constructor, a full constructor and a full constructor without the id parameter.
 * */

private Integer id;
private String make;
private String model;
private String year;
private String color;
private String vin;

public Car(){

}

    public Car(Integer id, String make, String model, String year, String color, String vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    public Car(String make, String model, String year, String color, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}//class
