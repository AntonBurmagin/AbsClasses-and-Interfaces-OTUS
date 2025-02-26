package project.src.db.table;

import project.src.db.dbconnectors.IDBConnector;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

abstract public class AbsTable implements ITable{
    protected IDBConnector connector;
    private String tableName = "";

    public AbsTable(String name){
        tableName = name;
    };

    public abstract boolean exist() throws SQLException;

    @Override
    public void create(List<String> columns) throws SQLException {
        delete();
        connector.execute(String.format("CREATE table %s(%s);", tableName, String.join(",", columns)));
    }

    @Override
    public void delete() throws SQLException {
        connector.execute(String.format("drop table if exists %s;", tableName));
    }

    @Override
    public ResultSet select(List<String> columns, String... predicatesIn) throws SQLException {
        String col = columns.isEmpty() ? "*" : String.join(",", columns);
        String predicates = predicatesIn.length == 0 ? ""
                : String.format("where %s", String.join("and", predicatesIn));
        return connector.executeQuery(String.format("SELECT %s FROM %s %s;", col, tableName, predicates));
    }


}
