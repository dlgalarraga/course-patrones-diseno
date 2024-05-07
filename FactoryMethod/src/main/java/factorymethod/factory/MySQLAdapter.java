package factorymethod.factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Oscar Blancarte <oscarblancarte3@gmail.com>
 */
public class MySQLAdapter implements IDBAdapter{
    
    static{
        try {
            new com.mysql.cj.jdbc.Driver();
        } catch (Exception e) {}
    }

    @Override
    public Connection getConnection() {
        try {
            System.out.println("vino a mysql =>");
            String connectionString = getConnectionString();
            String user = "root";
            String password = "G4l4rr4g3#";
            Connection connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Connection class => " + connection.getClass().getCanonicalName());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    private String getConnectionString(){
        return "jdbc:mysql://localhost:3306/edata?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    }
}
