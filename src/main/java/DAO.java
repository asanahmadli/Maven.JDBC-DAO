import java.util.List;
import java.util.Set;

public interface DAO<T> {
    public T findById(int id);
    public Set<Car> findAll();
    public T update(T car);
    public T create(T car);
    public void delete(int id);


}
