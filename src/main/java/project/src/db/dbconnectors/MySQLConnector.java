package project.src.db.dbconnectors;

import project.src.db.dbsettings.Settings;

import java.sql.*;
import java.util.Map;

public class MySQLConnector implements IDBConnector {
    private final Map<String, String> settings;
    private static Connection connection;
    private static Statement statement;

    public MySQLConnector() throws SQLException {
        settings = new Settings().getSettings(System.getProperty("user.dir")
                + "/src/main/resources/mysql_settings.properties");
    }

    public void open() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(String.format("%s/%s",settings.get("url"), settings.get("dbname")),
                        settings.get("username"), settings.get("password"));
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getDBName() {
        return settings.get("dbname");
    }

    @Override
    public void execute(String sqlRequest) throws SQLException {
        open();
        try{
            statement.execute(sqlRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet executeQuery(String sqlRequest) throws SQLException {
        open();
        try{
            return statement.executeQuery(sqlRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (statement != null)
            statement.close();
        if (connection != null)
            connection.close();
    }


}
