package repository;

import java.util.ArrayList;
import java.util.List;

public class Repo<T> implements Repository<T> {
    private final List<T> data = new ArrayList<>();

    @Override
    public void create(T object) {data.add(object); }

    @Override
    public void delete(T object){
        data.remove(object);
    }

    @Override
    public void update(T startObject, T object) {
        data.set(data.indexOf(startObject), object);
    }

    @Override
    public List<T> getAll(){
        return data;
    }

    @Override
    public T get(T object){return object;}

}
