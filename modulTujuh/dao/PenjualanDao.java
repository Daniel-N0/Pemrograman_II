package dao;
import model.Penjualan;
import java.util.List;

public interface PenjualanDao {
    void save(Penjualan p) throws Exception;
    void update(Penjualan p) throws Exception;
    void delete(int id) throws Exception;
    List<Penjualan> findAll() throws Exception;
}