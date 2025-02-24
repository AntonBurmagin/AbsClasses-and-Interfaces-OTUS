package project.src.db.table;

import project.src.animals.AbsAnimal;
import project.src.db.dbconnectors.MySQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalTable extends AbsTable {
    private static final String NAME = "animals";

    public AnimalTable(MySQLConnector conn) throws SQLException {
        super(NAME);
        connector = conn;
    }

    //подумать, как реализовать в AbsTable!!!
    public boolean exist() throws SQLException {
        ResultSet set = connector.executeQuery("SHOW TABLES;");
        MySQLConnector mySQLConnector = new MySQLConnector();
        String columnName = String.format("Tables_in_%s", mySQLConnector.getDBName());
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


//    @Override
//    public void create(List<String> columns) throws IOException {
//        super.create(columns);
//    }
//
//    @Override
//    public void delete() throws IOException {
//        super.delete();
//    }
}
