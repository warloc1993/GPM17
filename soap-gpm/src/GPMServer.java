import java.sql.*;
 
/**
 * @desc A singleton database access class for MySQL
 * @author Ramindu
 */
public final class GPMServer {
    public Connection conn;
    private Statement statement;
    public static GPMServer db;
    private GPMServer() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "gpm_server1";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "gpm17";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized GPMServer getDbCon() {
        if ( db == null ) {
            db = new GPMServer();
        }
        return db;
 
    }
    /**
     *
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not available
     * @throws SQLException
     */
    public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    /**
     * @desc Method to insert data to a table
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;
 
    }
 
}
