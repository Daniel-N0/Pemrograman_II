package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Pelanggan;
import service.PelangganService;

public class PelangganController {

    @FXML private TextField txtNama;
    @FXML private TextField txtEmail;
    @FXML private TextField txtTelepon;
    
    @FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, String> colNama;
    @FXML private TableColumn<Pelanggan, String> colEmail;
    @FXML private TableColumn<Pelanggan, String> colTelepon;

    private final PelangganService service = new PelangganService();
    private int selectedId = 0; 

    @FXML
    public void initialize() {
        colNama.setCellValueFactory(cell -> cell.getValue().namaProperty());
        colEmail.setCellValueFactory(cell -> cell.getValue().emailProperty());
        colTelepon.setCellValueFactory(cell -> cell.getValue().teleponProperty());

        loadData();

        tblPelanggan.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                selectedId = newVal.getId();
                txtNama.setText(newVal.getNama());
                txtEmail.setText(newVal.getEmail());
                txtTelepon.setText(newVal.getTelepon());
            }
        });
    }

    private void loadData() {
        try {
            ObservableList<Pelanggan> list = FXCollections.observableArrayList(service.getAll());
            tblPelanggan.setItems(list);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    @FXML
    private void onAdd() {
        try {
            Pelanggan p = new Pelanggan(txtNama.getText(), txtEmail.getText(), txtTelepon.getText());
            service.addData(p);
            clearForm();
            loadData();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data berhasil disimpan!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    @FXML
    private void onEdit() {
        if (selectedId == 0) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih data di tabel dulu!");
            return;
        }
        try {
            Pelanggan p = new Pelanggan(selectedId, txtNama.getText(), txtEmail.getText(), txtTelepon.getText());
            service.updateData(p);
            clearForm();
            loadData();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data berhasil diupdate!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    @FXML
    private void onDelete() {
        if (selectedId == 0) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih data di tabel dulu!");
            return;
        }
        try {
            service.deleteData(selectedId);
            clearForm();
            loadData();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data berhasil dihapus!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    private void clearForm() {
        txtNama.clear();
        txtEmail.clear();
        txtTelepon.clear();
        selectedId = 0;
        tblPelanggan.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType type, String title, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}