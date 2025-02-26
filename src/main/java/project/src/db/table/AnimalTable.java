package project.src.db.table;

import project.src.animals.AbsAnimal;
import project.src.data.ColorType;
import project.src.db.dbconnectors.MySQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalTable extends AbsTable {
    private static final String NAME = "animals313";
    private final String []columns = {"id INT PRIMARY KEY",
                                        "name VARCHAR(255)",
                                        "age INT",
                                        "weight FLOAT",
                                        "color VARCHAR(50)",
                                        "type VARCHAR(50)"};


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

    public void insert(List<AbsAnimal> list) throws SQLException {
        ArrayList<String> animalFullValues = null;
        for (AbsAnimal an : list) {
            animalFullValues.add(String.format("(%s, %s, %s, %s, %s, %s)",
                    an));
        }
//        TYPE нет в данных AbsAnimal!!!!?!?!?!?!
//        id, name, age, weight, color, type
        connector.execute("Select * FROM animals;");
    }

    public List<String> getColumns(){
        return Arrays.asList(columns);
    }

//
//    @Override
//    public void delete() throws IOException {
//        super.delete();
//    }
}
