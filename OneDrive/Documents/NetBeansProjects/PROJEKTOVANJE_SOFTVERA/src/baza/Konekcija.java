/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Aleksandra
 */
public class Konekcija {
    private static Konekcija instance;
    private Connection connection;

    private Konekcija() {
        try {
            String url="jdbcmysql://localhost:3306/biblioteka";
            connection=DriverManager.getConnection(url,"root","");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public static Konekcija getInstance(){
        if(instance==null){
            instance=new Konekcija();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return connection;
    
    }
    
}
