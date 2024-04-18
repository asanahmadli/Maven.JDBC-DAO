import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DAOConcreate implements DAO{
    public static  Car car;
    @Override
    public Object findById(int id) {

        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cars where id ="+id);
            if(resultSet.next()){
                car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setMake(resultSet.getString("make"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getString("year"));
                car.setColor(resultSet.getString("color"));
                car.setVin(resultSet.getString("vin"));
                return car;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Set<Car> findAll() {
        System.out.println("all cars founded");
        return null;
    }

    @Override
    public Object update(Object dto) {
        System.out.println("Car database updated");
        return null;
    }

    @Override
    public Object create(Object dto) {
        System.out.println("New car created");
        return null;
    }

    @Override
    public void delete(int id) {
        System.out.println("Car deleted by id");
    }

    @Override
    public String toString() {
        return car.getId()+ " " + car.getMake() + " " + car.getModel() + " " +  car.getYear() + " " + car.getColor() + " " + car.getVin();
    }
}
