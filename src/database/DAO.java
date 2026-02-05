package database;

import java.util.List;

public interface DAO<T> {
    boolean insert(T t);
    boolean update(T t);
    boolean deleteById(int id);
    List<T> getAll();
}