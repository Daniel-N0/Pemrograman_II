package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Buku;
import service.BukuService;

public class BukuController {

    @FXML private TextField txtJudul;
    @FXML private TextField txtPenulis;
    @FXML private TextField txtHarga;
    @FXML private TextField txtStok;

    @FXML private TableView<Buku> tblBuku;
    @FXML private TableColumn<Buku, String> colJudul;
    @FXML private TableColumn<Buku, String> colPenulis;
    @FXML private TableColumn<Buku, Number> colHarga;
    @FXML private TableColumn<Buku, Number> colStok;

    private final BukuService service = new BukuService();
    private int selectedId = 0;

    @FXML
    public void initialize() {
        colJudul.setCellValueFactory(cell -> cell.getValue().judulProperty());
        colPenulis.setCellValueFactory(cell -> cell.getValue().penulisProperty());
        colHarga.setCellValueFactory(cell -> cell.getValue().hargaProperty());
        colStok.setCellValueFactory(cell -> cell.getValue().stokProperty());

        loadData();

        tblBuku.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                selectedId = newVal.getBukuId();
                txtJudul.setText(newVal.getJudul());
                txtPenulis.setText(newVal.getPenulis());
                txtHarga.setText(String.valueOf(newVal.getHarga()));
                txtStok.setText(String.valueOf(newVal.getStok()));
            }
        });
    }

    private void loadData() {
        try {
            ObservableList<Buku> list = FXCollections.observableArrayList(service.getAll());
            tblBuku.setItems(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onAdd() {
        try {
            Buku b = new Buku(
                txtJudul.getText(),
                txtPenulis.getText(),
                Double.parseDouble(txtHarga.getText()),
                Integer.parseInt(txtStok.getText())
            );
            service.addData(b);
            clearForm();
            loadData();
            showAlert("Sukses", "Buku berhasil disimpan!");
        } catch (Exception e) {
            showAlert("Error", e.getMessage());
        }
    }

    @FXML
    private void onEdit() {
        if (selectedId == 0) return;
        try {
            Buku b = new Buku(
                selectedId,
                txtJudul.getText(),
                txtPenulis.getText(),
                Double.parseDouble(txtHarga.getText()),
                Integer.parseInt(txtStok.getText())
            );
            service.updateData(b);
            clearForm();
            loadData();
            showAlert("Sukses", "Buku berhasil diupdate!");
        } catch (Exception e) {
            showAlert("Error", e.getMessage());
        }
    }

    @FXML
    private void onDelete() {
        if (selectedId == 0) return;
        try {
            service.deleteData(selectedId);
            clearForm();
            loadData();
            showAlert("Sukses", "Buku berhasil dihapus!");
        } catch (Exception e) {
            showAlert("Error", e.getMessage());
        }
    }

    private void clearForm() {
        txtJudul.clear(); txtPenulis.clear(); txtHarga.clear(); txtStok.clear();
        selectedId = 0;
        tblBuku.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}