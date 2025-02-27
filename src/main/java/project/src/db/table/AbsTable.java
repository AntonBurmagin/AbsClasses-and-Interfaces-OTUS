package project.src.db.table;

import project.src.animals.AbsAnimal;
import project.src.data.AnimalType;
import project.src.db.dbconnectors.IDBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

abstract public class AbsTable implements ITable{
    protected IDBConnector connector;
    private String tableName = "";

    public AbsTable(String name){
        tableName = name;
    };


    @Override
    public void create(List<String> columns) throws SQLException {
        drop();
        connector.execute(String.format("CREATE table %s(%s);", tableName, String.join(",", columns)));
    }

    @Override
    public void drop() throws SQLException {
        connector.execute(String.format("drop table if exists %s;", tableName));
    }

    @Override
    public ResultSet select(List<String> columns, String... predicatesIn) throws SQLException {
        String col = columns.isEmpty() ? "*" : String.join(",", columns);
        String predicates = predicatesIn.length == 0 ? ""
                : String.format("where %s", String.join("and", predicatesIn));
        System.out.println(String.format("SELECT %s FROM %s %s;", col, tableName, predicates));
        return connector.executeQuery(String.format("SELECT %s FROM %s %s;", col, tableName, predicates));
    }


    public abstract void update(int id, AbsAnimal correctedAnimal, AnimalType type) throws SQLException;
}
