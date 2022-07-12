package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {



        private static db.DBConnection dbConnection = null;
        private Connection connection;

        //2 rule
        private DBConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kandegedarahardwarestores", "root", "1234");
        }

        // 3 rule
        public static db.DBConnection getInstance() throws SQLException, ClassNotFoundException {
        /*if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;*/
            return (dbConnection==null)? dbConnection= new db.DBConnection(): dbConnection;
        }

        public Connection getConnection() {
            return connection; // DBConnection.getInstance().getConnection();
        }
}
