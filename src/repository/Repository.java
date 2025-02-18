package repository;
import java.util.List;

public interface Repository<T> {
    void create(T obj);
    void update(T startObj, T obj);
    void delete(T obj);
    T get(T obj);
    List<T> getAll();
}
