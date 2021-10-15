package labs.njc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertApp {

    /**
     * Connect to the moviesilub.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Users/vinit/downloads/sqlite/db/moviesilub.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the movies table
     *
     */
    public void insert(String moviename, String leadactor, String leadactress, String year, String director) {
        String sql = "INSERT INTO Movies(moviename,leadactor,leadactress,year,director) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, moviename);
            pstmt.setString(2, leadactor);
            pstmt.setString(3, leadactress);
            pstmt.setString(4, year);
            pstmt.setString(5, director);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("Fight Club","Brad Pitt","Helena Bonham Carter","1999","David Fincher");
        app.insert("Schindler's List","Liam Neeson","Caroline Goodall","1993","Steven Spielberg");
        app.insert("The Silence of the Lambs","Anthony Hopkins","Jodie Foster","1991","Jonathan Demme");
        app.insert("Pulp Fiction","John Travolta","Uma Thurman","1994","Quentin Tarantino");
        app.insert("Inception","Leonardo DiCaprio","Elliot Page","2010","Christopher Nolan");
        app.insert("Seven Samurai","Toshirô Mifune","Keiko Tsushima","1954","Akira Kurosawa");
    }

}