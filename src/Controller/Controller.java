package Controller;

import Model.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller {

    @FXML
    private TableView<Mahasiswa> tableView;

    @FXML
    private TableColumn<Mahasiswa, String> nimCol;

    @FXML
    private TableColumn<Mahasiswa, String> namaCol;

    private final ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
            new Mahasiswa("24108111", "Andi Pratama"),
            new Mahasiswa("24108112", "Budiono Siregar"),
            new Mahasiswa("24108113", "Citra Lesmana"),
            new Mahasiswa("24108124", "Dendi Rahadian"),
            new Mahasiswa("24108125", "Eko Widodo"),
            new Mahasiswa("24108126", "Fulan Putra"),
            new Mahasiswa("24108137", "Ganjar Setiawan"),
            new Mahasiswa("24108138", "Hasan Bahli"),
            new Mahasiswa("24108139", "Irwan Putra"),
            new Mahasiswa("24108140", "Joko Wiyatno")
    );

    @FXML
    private void initialize() {
        nimCol.setCellValueFactory(cellData -> cellData.getValue().nimProperty());
        namaCol.setCellValueFactory(cellData -> cellData.getValue().namaProperty());

        tableView.setItems(data);
    }
}
