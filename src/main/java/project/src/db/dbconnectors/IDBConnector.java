package project.src.db.dbconnectors;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDBConnector {
    void execute(String sqlRequest) throws SQLException;
    ResultSet executeQuery(String sqlRequest) throws SQLException;
    void close() throws SQLException;
}
