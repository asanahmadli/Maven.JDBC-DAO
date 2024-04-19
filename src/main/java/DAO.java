import java.util.List;
import java.util.Set;

public interface DAO<T> {
    public T findById(int id);
    public List<Car> findAll();
    public T update(T car);
    public boolean create(T car);
    public boolean delete(int id);


}
