package Modelo;
import java.sql.*;

public class BaseDatos
{    
//    HOST: sigloxxi.ctquolecsxie.us-east-1.rds.amazonaws.com
//    PUERTO: 1521
//    SID: orcl
//    USER: admin
//    PASSWORD: 12345678
    private String Driver = "oracle.jdbc.driver.OracleDriver";
    private String DBName = "jdbc:oracle:thin:@rsigloxxi-1.ciptbsikfloq.us-east-1.rds.amazonaws.com:1521:orcl";
    private String DBUser = "admin";
    private String DBPass = "12345678";
        
    public Connection getConnection()
    {
        Connection connection;
        
        try
        {
            Class.forName(Driver);
            connection = DriverManager.getConnection(DBName, DBUser, DBPass);
            return connection;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
