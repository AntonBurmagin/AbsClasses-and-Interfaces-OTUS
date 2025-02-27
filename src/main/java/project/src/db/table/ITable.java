package project.src.db.table;

import project.src.animals.AbsAnimal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ITable {
    void create(List<String> columns) throws SQLException;
    void drop() throws SQLException;
    ResultSet select(List<String> columns, String... predicatesIn) throws SQLException;
    boolean exist() throws SQLException;
    void clear() throws SQLException;
    boolean isEmpty() throws SQLException;
    void update(int id, AbsAnimal correctedAnimal) throws SQLException;
}