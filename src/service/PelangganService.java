package service;

import dao.PelangganDao;
import dao.impl.PelangganDaoImpl;
import model.Pelanggan;
import java.util.List;
import java.util.regex.Pattern;

public class PelangganService {
    private final PelangganDao dao = new PelangganDaoImpl();

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]+$");

    public List<Pelanggan> getAll() throws Exception {
        return dao.findAll();
    }

    public void addData(Pelanggan p) throws Exception {
        validate(p);
        dao.save(p);
    }

    public void updateData(Pelanggan p) throws Exception {
        validate(p);
        dao.update(p);
    }

    public void deleteData(int id) throws Exception {
        dao.delete(id);
    }

    private void validate(Pelanggan p) throws Exception {
        if (p.getNama() == null || p.getNama().trim().isEmpty()) {
            throw new Exception("Nama tidak boleh kosong!");
        }
        
        if (p.getEmail() == null || !EMAIL_PATTERN.matcher(p.getEmail()).matches()) {
            throw new Exception("Format email tidak valid! (Contoh: user@email.com)");
        }
        
        if (p.getTelepon() == null || p.getTelepon().isEmpty()) {
            throw new Exception("Telepon tidak boleh kosong!");
        }
        
        if (!PHONE_PATTERN.matcher(p.getTelepon()).matches()) {
            throw new Exception("Nomor telepon harus berupa angka!");
        }
        
        if (p.getTelepon().length() < 10 || p.getTelepon().length() > 15) {
            throw new Exception("Panjang nomor telepon harus 10-15 digit!");
        }
    }
}