package project.src.db.table;

import project.src.animals.AbsAnimal;
import project.src.data.AnimalType;
import project.src.db.dbconnectors.MySQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class AnimalTable extends AbsTable {
    private static final String NAME = "animals313";
    private final String []initColumns = {"id INT PRIMARY KEY NOT NULL AUTO_INCREMENT",
                                        "name VARCHAR(255)",
                                        "age INT",
                                        "weight FLOAT",
                                        "color VARCHAR(50)",
                                        "type VARCHAR(50)"};
    private final String [] columnsNamesWithoutId = {"name", "age", "weight", "color", "type"};


    public AnimalTable(MySQLConnector conn) throws SQLException {
        super(NAME);
        connector = conn;
    }

    public boolean exist() throws SQLException {
        ResultSet set = connector.executeQuery("SHOW TABLES;");
        String columnName = String.format("Tables_in_%s", connector.getDBName());
        while (set.next()) {
            if (set.getString(columnName).equals(NAME))
                return true;
        }
        return false;
    }

    @Override
    public void clear() throws SQLException {
        connector.execute(String.format("DELETE FROM %s;", NAME));
    }

    @Override
    public boolean isEmpty() throws SQLException {
        return !connector.executeQuery("SELECT * FROM animals313 LIMIT 1;").next();
    }

    @Override
    public void update(int id, AbsAnimal correctedAnimal) throws SQLException {

    }


    public void insert(AbsAnimal newbornAnimal, AnimalType type) throws SQLException {
        String columnsString = String.join(",", columnsNamesWithoutId);
        String values =String.format("%s, '%s'", newbornAnimal.getAll(), type.toString().toLowerCase());
        String query = String.format("INSERT INTO %s (%s) VALUES (%s);", NAME, columnsString, values);
        connector.execute(query);
    }

    public List<String> getInitColumns(){
        return Arrays.asList(initColumns);
    }

    public List<String> getColumnsNames(){
        return Arrays.asList(columnsNamesWithoutId);
    }


    @Override
    public void update(int id, AbsAnimal correctedAnimal, AnimalType type) throws SQLException {
        String columnsAndValues = String.format("%s='%s',%s=%s,%s=%s,%s='%s',%s='%s'",
                columnsNamesWithoutId[0], correctedAnimal.getName(),
                columnsNamesWithoutId[1], correctedAnimal.getAge(),
                columnsNamesWithoutId[2], correctedAnimal.getWeight(),
                columnsNamesWithoutId[3], correctedAnimal.getColor(),
                columnsNamesWithoutId[4], type.toString().toLowerCase());
        String predicates = id > 0 ? String.format("where id=%s", id) : "";
        connector.execute(String.format("UPDATE %s SET %s %s;", NAME, columnsAndValues, predicates));
    }
}
