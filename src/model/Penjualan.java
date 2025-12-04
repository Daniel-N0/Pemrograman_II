package model;
import javafx.beans.property.*;
import java.time.LocalDate;

public class Penjualan {
    private final IntegerProperty penjualanId;
    private final IntegerProperty jumlah;
    private final DoubleProperty totalHarga;
    private final ObjectProperty<LocalDate> tanggal;
    private final IntegerProperty pelangganId;
    private final IntegerProperty bukuId;
    private final StringProperty namaPelanggan;
    private final StringProperty judulBuku;
    
    public Penjualan(int jumlah, double totalHarga, LocalDate tanggal, int pelangganId, int bukuId) {
        this(0, jumlah, totalHarga, tanggal, pelangganId, bukuId, "", "");
    }
    public Penjualan(int penjualanId, int jumlah, double totalHarga, LocalDate tanggal, int pelangganId, int bukuId, String namaPelanggan, String judulBuku) {
        this.penjualanId = new SimpleIntegerProperty(penjualanId);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleDoubleProperty(totalHarga);
        this.tanggal = new SimpleObjectProperty<>(tanggal);
        this.pelangganId = new SimpleIntegerProperty(pelangganId);
        this.bukuId = new SimpleIntegerProperty(bukuId);
        this.namaPelanggan = new SimpleStringProperty(namaPelanggan);
        this.judulBuku = new SimpleStringProperty(judulBuku);
    }
    
    public int getPenjualanId() { return penjualanId.get(); }
    public IntegerProperty penjualanIdProperty() { return penjualanId; }
    
    public int getJumlah() { return jumlah.get(); }
    public IntegerProperty jumlahProperty() { return jumlah; }
    
    public double getTotalHarga() { return totalHarga.get(); }
    public DoubleProperty totalHargaProperty() { return totalHarga; }
    
    public LocalDate getTanggal() { return tanggal.get(); }
    public ObjectProperty<LocalDate> tanggalProperty() { return tanggal; }
    
    public int getPelangganId() { return pelangganId.get(); }
    public int getBukuId() { return bukuId.get(); }
    
    public String getNamaPelanggan() { return namaPelanggan.get(); }
    public StringProperty namaPelangganProperty() { return namaPelanggan; }
    
    public String getJudulBuku() { return judulBuku.get(); }
    public StringProperty judulBukuProperty() { return judulBuku; }
}