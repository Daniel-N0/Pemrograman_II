package dao.impl;

import dao.BukuDao;
import model.Buku;
import util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuDaoImpl implements BukuDao {
    @Override
    public void save(Buku b) throws Exception {
        String sql = "INSERT INTO Buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Buku b) throws Exception {
        String sql = "UPDATE Buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.setInt(5, b.getBukuId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM Buku WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Buku> findAll() throws Exception {
        List<Buku> list = new ArrayList<>();
        String sql = "SELECT * FROM Buku ORDER BY buku_id DESC";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Buku(
                    rs.getInt("buku_id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getDouble("harga"),
                    rs.getInt("stok")
                ));
            }
        }
        return list;
    }

    @Override
    public Buku findById(int id) throws Exception {
        String sql = "SELECT * FROM Buku WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Buku(
                    rs.getInt("buku_id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getDouble("harga"),
                    rs.getInt("stok")
                );
            }
        }
        return null;
    }
}