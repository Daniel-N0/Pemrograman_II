package dao;
import model.Buku;
import java.util.List;

public interface BukuDao {
    void save(Buku b) throws Exception;
    void update(Buku b) throws Exception;
    void delete(int id) throws Exception;
    List<Buku> findAll() throws Exception;
    Buku findById(int id) throws Exception;
}