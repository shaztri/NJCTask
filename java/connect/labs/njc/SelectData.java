package labs.njc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class SelectApp {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Users/vinit/downloads/sqlite/db/Moviesilub.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT * FROM Movies";
        String sqlwithparam = "SELECT id,moviename,leadactor,leadactress,year,director FROM Movies WHERE director = 'Akira Kurosawa'";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql))
             ResultSet rswp = stmt.executeQuery(sqlwithparam);
        {
            
            // loop through the result set
            System.out.println("Query without parameters");
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("moviename") + "\t" +
                                   rs.getString("leadactor")); + "\t" +
                                   rs.getString("leadactress"));  + "\t" +
                                   rs.getString("year");  + "\t" +
                                   rs.getString("director");
            }
            System.out.println("Query with parameters");
            while (rswp.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("moviename") + "\t" +
                                   rs.getString("leadactor")); + "\t" +
                                   rs.getString("leadactress"));  + "\t" +
                                   rs.getString("year");  + "\t" +
                                   rs.getString("director");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }

}