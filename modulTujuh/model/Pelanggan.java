package model;
import javafx.beans.property.*;

public class Pelanggan {
    private final IntegerProperty id;
    private final StringProperty nama;
    private final StringProperty email;
    private final StringProperty telepon; 
    
    public Pelanggan(int id, String nama, String email, String telepon) {
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon); 
    }
    public Pelanggan(String nama, String email, String telepon) { this(0, nama, email, telepon); }
    
    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }
    public IntegerProperty idProperty() { return id; }
    
    public String getNama() { return nama.get(); }
    public StringProperty namaProperty() { return nama; }
    
    public String getEmail() { return email.get(); }
    public StringProperty emailProperty() { return email; }
    
    public String getTelepon() { return telepon.get(); }
    public StringProperty teleponProperty() { return telepon; }
    
    @Override public String toString() { return nama.get(); }
}