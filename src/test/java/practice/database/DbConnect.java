package practice.database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnect {
    private static final Properties PROP = getProperties();
    private static String showCategories = "DESCRIBE Categories";

    private static String showCustomers = "DESCRIBE Customers";
    private static String showEmployees = "DESCRIBE Employees";
    private static String showOrderDetails = "DESCRIBE OrderDetails";
    private static String showOrders = "DESCRIBE Orders";
    private static String showProducts = "DESCRIBE Products";
    private static String showShippers = "DESCRIBE Shippers";
    private static String showSuppliers = "DESCRIBE Suppliers";
    private static String selectFromZ_Train = "SELECT * FROM Z_Train";


    public static void main(String[] args) {

        execStatement("SELECT City FROM Customers WHERE City = 'Bergamo'", 1);
//        execStatement(listOfCategories, 1);
//        execStatement(selectFromZ_Train, 1);

    }

    private static MysqlDataSource getDataSource() {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(PROP.getProperty("HOST"));
        dataSource.setPort(Integer.parseInt(PROP.getProperty("PORT")));
        dataSource.setUser(PROP.getProperty("USER"));
        dataSource.setPassword(PROP.getProperty("PWD"));
        dataSource.setDatabaseName(PROP.getProperty("DBNAME"));

        return dataSource;
    }


    private static Properties getProperties() {

        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("src/test/resources/db.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    private static void execStatement(String query, int index) {

        try (Connection connection = getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//        PROP.forEach((k, v) -> System.out.println(v.toString()));




