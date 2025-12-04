package dao;
import model.Pelanggan;
import java.util.List;

public interface PelangganDao {
    void save(Pelanggan p) throws Exception;
    void update(Pelanggan p) throws Exception;
    void delete(int id) throws Exception;
    List<Pelanggan> findAll() throws Exception;
}