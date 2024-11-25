package bankomat2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conn {

    Connection c;
    Statement s;
    public Conn() {
        
        try {
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem","root","root");
            s=c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
