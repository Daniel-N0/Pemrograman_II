package model;

import javafx.beans.property.*;

public class Buku {
    private final IntegerProperty bukuId;
    private final StringProperty judul;
    private final StringProperty penulis;
    private final DoubleProperty harga;
    private final IntegerProperty stok;
    
    public Buku(int bukuId, String judul, String penulis, double harga, int stok) {
        this.bukuId = new SimpleIntegerProperty(bukuId);
        this.judul = new SimpleStringProperty(judul);
        this.penulis = new SimpleStringProperty(penulis);
        this.harga = new SimpleDoubleProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);
    }
    
    public Buku(String judul, String penulis, double harga, int stok) {
        this(0, judul, penulis, harga, stok);
    }
    
    
    public int getBukuId() { return bukuId.get(); }
    public void setBukuId(int bukuId) { this.bukuId.set(bukuId); }
    public IntegerProperty bukuIdProperty() { return bukuId; }
    
    public String getJudul() { return judul.get(); }
    public void setJudul(String judul) { this.judul.set(judul); }
    public StringProperty judulProperty() { return judul; }
    
    public String getPenulis() { return penulis.get(); }
    public void setPenulis(String penulis) { this.penulis.set(penulis); }
    public StringProperty penulisProperty() { return penulis; }
    
    public double getHarga() { return harga.get(); }
    public void setHarga(double harga) { this.harga.set(harga); }
    public DoubleProperty hargaProperty() { return harga; }
    
    public int getStok() { return stok.get(); }
    public void setStok(int stok) { this.stok.set(stok); }
    public IntegerProperty stokProperty() { return stok; }
    
    @Override
    public String toString() {
        return judul.get();
    }
}