package dao.impl;

import dao.PenjualanDao;
import model.Penjualan;
import util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenjualanDaoImpl implements PenjualanDao {
    @Override
    public void save(Penjualan p) throws Exception {
        String sql = "INSERT INTO Penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getJumlah());
            ps.setDouble(2, p.getTotalHarga());
            ps.setDate(3, Date.valueOf(p.getTanggal()));
            ps.setInt(4, p.getPelangganId());
            ps.setInt(5, p.getBukuId());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Penjualan p) throws Exception {
        String sql = "UPDATE Penjualan SET jumlah=?, total_harga=?, tanggal=?, pelanggan_id=?, buku_id=? WHERE penjualan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getJumlah());
            ps.setDouble(2, p.getTotalHarga());
            ps.setDate(3, Date.valueOf(p.getTanggal()));
            ps.setInt(4, p.getPelangganId());
            ps.setInt(5, p.getBukuId());
            ps.setInt(6, p.getPenjualanId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM Penjualan WHERE penjualan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Penjualan> findAll() throws Exception {
        List<Penjualan> list = new ArrayList<>();
        String sql = "SELECT p.*, pel.nama as nama_pelanggan, b.judul as judul_buku " +
                     "FROM Penjualan p " +
                     "LEFT JOIN Pelanggan pel ON p.pelanggan_id = pel.pelanggan_id " +
                     "LEFT JOIN Buku b ON p.buku_id = b.buku_id " +
                     "ORDER BY p.penjualan_id DESC";
        
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Penjualan(
                    rs.getInt("penjualan_id"),
                    rs.getInt("jumlah"),
                    rs.getDouble("total_harga"),
                    rs.getDate("tanggal").toLocalDate(),
                    rs.getInt("pelanggan_id"),
                    rs.getInt("buku_id"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("judul_buku")
                ));
            }
        }
        return list;
    }
}