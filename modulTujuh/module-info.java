module modul7 {
    // Membutuhkan library JavaFX
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    
    // Membutuhkan library SQL
    requires java.sql;
    
    // Membuka akses paket ke JavaFX
    opens application to javafx.graphics, javafx.fxml;
    opens controller to javafx.fxml;
    opens model to javafx.base; // PENTING: Agar Tabel bisa baca data!
    
    exports application;
}