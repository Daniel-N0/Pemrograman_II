package service;

import dao.BukuDao;
import dao.impl.BukuDaoImpl;
import model.Buku;
import java.util.List;

public class BukuService {
    private final BukuDao dao = new BukuDaoImpl();

    public List<Buku> getAll() throws Exception {
        return dao.findAll();
    }

    public void addData(Buku b) throws Exception {
        validate(b);
        dao.save(b);
    }

    public void updateData(Buku b) throws Exception {
        validate(b);
        dao.update(b);
    }

    public void deleteData(int id) throws Exception {
        dao.delete(id);
    }

    private void validate(Buku b) throws Exception {
        if (b.getJudul() == null || b.getJudul().isEmpty()) {
            throw new Exception("Judul buku tidak boleh kosong!");
        }
        if (b.getHarga() < 0) {
            throw new Exception("Harga tidak boleh negatif!");
        }
        if (b.getStok() < 0) {
            throw new Exception("Stok tidak boleh negatif!");
        }
    }
}