import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.logging.Logger;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/bmw";
    public static final String USER = "asan";
    public static final String PASS = "pass";
    public static String query = "select * from cars;";
    static Logger demoLog =  Logger.getLogger("demoJDBC");
    public static Connection getConnection(){
        try {
            DriverManager.registerDriver(new Driver());
            return  DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database",e);
        }
    }

    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            String universityData = "";
            for (int i = 1; i<=6;i++){
                universityData += resultSet.getString(i) + ":";
            }
            System.out.println(universityData);
        }


    }//main

}//class
