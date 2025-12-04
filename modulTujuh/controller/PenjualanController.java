package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Buku;
import model.Pelanggan;
import model.Penjualan;
import service.BukuService;
import service.PelangganService;
import service.PenjualanService;
import java.time.LocalDate;

public class PenjualanController {

    @FXML private ComboBox<Pelanggan> cbPelanggan;
    @FXML private ComboBox<Buku> cbBuku;
    @FXML private TextField txtJumlah;
    @FXML private DatePicker dpTanggal;

    @FXML private TableView<Penjualan> tblPenjualan;
    @FXML private TableColumn<Penjualan, String> colPelanggan;
    @FXML private TableColumn<Penjualan, String> colBuku;
    @FXML private TableColumn<Penjualan, Number> colJumlah;
    @FXML private TableColumn<Penjualan, Number> colTotal;
    @FXML private TableColumn<Penjualan, LocalDate> colTanggal;

    private final PenjualanService service = new PenjualanService();
    private final PelangganService pelangganService = new PelangganService();
    private final BukuService bukuService = new BukuService();

    @FXML
    public void initialize() {
        colPelanggan.setCellValueFactory(cell -> cell.getValue().namaPelangganProperty());
        colBuku.setCellValueFactory(cell -> cell.getValue().judulBukuProperty());
        colJumlah.setCellValueFactory(cell -> cell.getValue().jumlahProperty());
        colTotal.setCellValueFactory(cell -> cell.getValue().totalHargaProperty());
        colTanggal.setCellValueFactory(cell -> cell.getValue().tanggalProperty());

        loadData();
        
        refreshPelangganList();
        refreshBukuList();
        
        cbPelanggan.setOnShowing(event -> refreshPelangganList());
        
        cbBuku.setOnShowing(event -> refreshBukuList());
    }

    private void loadData() {
        try {
            ObservableList<Penjualan> list = FXCollections.observableArrayList(service.getAll());
            tblPenjualan.setItems(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshPelangganList() {
        try {
            Pelanggan selected = cbPelanggan.getValue();
            ObservableList<Pelanggan> list = FXCollections.observableArrayList(pelangganService.getAll());
            cbPelanggan.setItems(list);
            
            if (selected != null) {
                for (Pelanggan p : list) {
                    if (p.getId() == selected.getId()) {
                        cbPelanggan.setValue(p);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshBukuList() {
        try {
            Buku selected = cbBuku.getValue();
            ObservableList<Buku> list = FXCollections.observableArrayList(bukuService.getAll());
            cbBuku.setItems(list);
            
            if (selected != null) {
                for (Buku b : list) {
                    if (b.getBukuId() == selected.getBukuId()) {
                        cbBuku.setValue(b);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onAdd() {
        try {
            if (cbPelanggan.getValue() == null || cbBuku.getValue() == null) {
                throw new Exception("Harap pilih Pelanggan dan Buku!");
            }
            if (dpTanggal.getValue() == null) {
                throw new Exception("Harap pilih tanggal!");
            }

            int jumlah = Integer.parseInt(txtJumlah.getText());
            double hargaBuku = cbBuku.getValue().getHarga();
            double total = hargaBuku * jumlah;

            Penjualan p = new Penjualan(
                jumlah, 
                total, 
                dpTanggal.getValue(),
                cbPelanggan.getValue().getId(),
                cbBuku.getValue().getBukuId()
            );

            service.addData(p);
            loadData();
            clearForm();
            showAlert("Sukses", "Transaksi berhasil!");
        } catch (Exception e) {
            showAlert("Gagal", e.getMessage());
        }
    }

    @FXML
    private void onDelete() {
        Penjualan selected = tblPenjualan.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Peringatan", "Pilih data penjualan yang mau dihapus!");
            return;
        }
        try {
            service.deleteData(selected.getPenjualanId());
            loadData();
            showAlert("Sukses", "Data penjualan dihapus!");
        } catch (Exception e) {
            showAlert("Gagal", e.getMessage());
        }
    }
    
    private void clearForm() {
        cbPelanggan.setValue(null);
        cbBuku.setValue(null);
        txtJumlah.clear();
        dpTanggal.setValue(null);
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}