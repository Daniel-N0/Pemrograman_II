package service;

import dao.PenjualanDao;
import dao.BukuDao;
import dao.impl.PenjualanDaoImpl;
import dao.impl.BukuDaoImpl;
import model.Penjualan;
import model.Buku;
import java.util.List;

public class PenjualanService {
    private final PenjualanDao dao = new PenjualanDaoImpl();
    private final BukuDao bukuDao = new BukuDaoImpl();

    public List<Penjualan> getAll() throws Exception {
        return dao.findAll();
    }

    public void addData(Penjualan p) throws Exception {
        Buku buku = bukuDao.findById(p.getBukuId());
        if (buku == null) {
            throw new Exception("Buku tidak ditemukan!");
        }
        if (buku.getStok() < p.getJumlah()) {
            throw new Exception("Stok buku tidak mencukupi! Sisa: " + buku.getStok());
        }

        buku.setStok(buku.getStok() - p.getJumlah());
        bukuDao.update(buku);

        dao.save(p);
    }
    
    public void deleteData(int id) throws Exception {
        dao.delete(id);
    }
}