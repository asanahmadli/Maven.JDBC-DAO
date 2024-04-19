import java.sql.*;
import java.util.*;

public class DAOConcreate implements DAO{

    public final static DAOConcreate dao = new DAOConcreate();
    public static DAOConcreate getDao(){
        if (dao == null){
            return new DAOConcreate();
        }
        else {
            return dao;
        }
    }

    private Car extractUserFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();

        car.setId( rs.getInt("id") );
        car.setMake( rs.getString("make") );
        car.setModel( rs.getString("model") );
        car.setYear( rs.getString("year") );
        car.setColor(rs.getString("color"));
        car.setVin(rs.getString("vin"));

        return car;
    }
    @Override
    public Object findById(int id) {
        Car car = new Car();
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cars where id ="+id);
            if(resultSet.next()){
                car = extractUserFromResultSet(resultSet);


                return car;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Car> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        List cars = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cars;");
            while (resultSet.next()){
                Car car  = extractUserFromResultSet(resultSet);
                cars.add(car);
            }
            connection.close();
            return cars;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try{
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }

        return null;


    }

    @Override
    public Object update(Object dto) {
        Car car  = new Car();
        Connection connection = null;
        PreparedStatement ps = null;
         connection = ConnectionFactory.getConnection();
        try {
             ps = connection.prepareStatement("UPDATE cars SET make=?, model=?, year=?,color=?,vin=? where id =?");

            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getYear());
            ps.setString(4, car.getColor());
            ps.setString(5, car.getVin());
            ps.setInt(6, car.getId());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean create(Object dto) {
        Car car  = (Car) dto;
        Connection connection = null;
        PreparedStatement ps = null;
        connection = ConnectionFactory.getConnection();
        try {
            ps = connection.prepareStatement("INSERT INTO cars VALUES (?,?,?,?,?,?)");
            ps.setInt(1, car.getId());
            ps.setString(2,car.getMake());
            ps.setString(3,car.getModel());
            ps.setString(4,car.getYear());
            ps.setString(5,car.getColor());
            ps.setString(6,car.getVin());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
        }


    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM cars WHERE id=" + id);

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }


    public String toString(Car car) {
        return car.getId()+ " " + car.getMake() + " " + car.getModel() + " " +  car.getYear() + " " + car.getColor() + " " + car.getVin();
    }
}
