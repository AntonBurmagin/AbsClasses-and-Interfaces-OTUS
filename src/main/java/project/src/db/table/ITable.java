package project.src.db.table;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ITable {
    public void create(List<String> columns) throws SQLException;
    public void delete() throws SQLException;
    ResultSet select(List<String> columns, String... predicatesIn) throws SQLException;
    public boolean exist() throws SQLException;
}