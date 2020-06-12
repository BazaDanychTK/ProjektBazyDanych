package controllers;

import dbObjects.Klient;
import dbObjects.Oplata;
import dbObjects.Umowa;
import dbObjects.Usluga;
import dbUtils.CallableStatementParameter;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UmowyController {
    public Text infoTxt;
    public ComboBox<Usluga> comboUsluga;
    public ComboBox<Klient> comboKlient;
    public ComboBox<Integer> comboIleMiesiecy;
    public DatePicker datePickerPoczątekUmowy;
    public Tab tabUmowy;
    public TableView<Umowa> tabelaUmow;
    public TableColumn uslugaCol;
    public TableColumn typLaczaCol;
    public TableColumn predkoscCol;
    public TextField txtFieldSzukaj;
    public Tab tabSzczegoly;
    public TableView<Oplata> tabelaSzczegoly;
    public TableColumn colTermin;
    public TableColumn colCzyZaplacone;
    public TextField txtKwota;
    public TableColumn poczatekCol;
    public TableColumn koniecCol;
    CallableStatementParameter cspie = new CallableStatementParameter();
    private List listaMiesiecy =  new ArrayList();
    SortedList<Umowa> sortedData;
    private Umowa aktualnieWybranaUmowa;

    public void initialize(){
        ladujComboUslugi();
        ladujComboKlienci();
        ladujComboMiesiace();

        uslugaCol.setCellValueFactory(new PropertyValueFactory<>("nazwauslugi"));
        typLaczaCol.setCellValueFactory(new PropertyValueFactory<>("nazwarodzajulacza"));
        predkoscCol.setCellValueFactory(new PropertyValueFactory<>("predkosc_lacza"));
        poczatekCol.setCellValueFactory(new PropertyValueFactory<>("dataStart"));
        koniecCol.setCellValueFactory(new PropertyValueFactory<>("dataKoniec"));

        ladujTabeleUslugUmow();

        wyszukiwanieUmowKlienta();

        tabSzczegoly.setDisable(true);

        colTermin.setCellValueFactory(new PropertyValueFactory<>("termin_platnosci"));
        colCzyZaplacone.setCellValueFactory(new PropertyValueFactory<>("czy_zaplaconetxt"));
    }

    private void wyszukiwanieUmowKlienta() {
        FilteredList<Umowa> filteredData = new FilteredList<>(Objects.requireNonNull(FXCollections.observableArrayList(cspie.widokUslugaUmowa())), p -> true);
        txtFieldSzukaj.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getImieNazwisko().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else return person.getImieNazwisko().toLowerCase().contains(lowerCaseFilter);
            });
        });
        sortedData = new SortedList<>(filteredData);

        tabelaUmow.setItems(sortedData);
    }

    public void ladujComboMiesiace(){

        listaMiesiecy.clear();
        int max_month = 24;
        for (Integer i = 1; i <= max_month; i++) {
            listaMiesiecy.add(i);
        }
        comboIleMiesiecy.setItems(FXCollections.observableArrayList(listaMiesiecy));

    }

    public void ladujTabeleUslugUmow(){
        tabelaUmow.setItems(FXCollections.observableArrayList(cspie.widokUslugaUmowa()));


    }

    public void ladujTabeleSzczegolow(int id){
        tabelaSzczegoly.setItems(FXCollections.observableArrayList(cspie.widokOplat(id)));


    }

    public void ladujComboUslugi(){
        comboUsluga.setItems(FXCollections.observableArrayList(cspie.widokUslug()));
    }

    public void ladujComboKlienci(){
        comboKlient.setItems(FXCollections.observableArrayList(cspie.widokKlientow()));
    }

    public void dodajUsluge(ActionEvent actionEvent) {
        if (comboIleMiesiecy.getSelectionModel().getSelectedItem() == null){
            infoTxt.setText("Wprowadź okres zobowiązania");
        }else if(comboUsluga.getSelectionModel().getSelectedItem() == null){
            infoTxt.setText("Wybierz usługę");
        }else if(comboKlient.getSelectionModel().getSelectedItem() == null){
            infoTxt.setText("Wybierz klienta");
        }else if(datePickerPoczątekUmowy.getValue() == null){
            infoTxt.setText("Wskaż początek umowy");
        } else{
            infoTxt.setText(cspie.proceduraZapiszUmowe(
                    comboUsluga.getSelectionModel().getSelectedItem().getId(),
                    comboKlient.getSelectionModel().getSelectedItem().getId(),
                    java.sql.Date.valueOf(datePickerPoczątekUmowy.getValue()),
                    java.sql.Date.valueOf(datePickerPoczątekUmowy.getValue().plusMonths(comboIleMiesiecy.getSelectionModel().getSelectedItem())),
                    txtKwota.getText()));
            ladujTabeleUslugUmow();
        }
    }

    public void usunUmowe(ActionEvent actionEvent) {
        infoTxt.setText(cspie.usunUmowe(tabelaUmow.getSelectionModel().getSelectedItem().getId_umowy()));
        ladujTabeleUslugUmow();
    }

    public void onMouseClickedOnUmowy(MouseEvent mouseEvent) {
        if (tabelaUmow.getSelectionModel().getSelectedItem() != null){
            aktualnieWybranaUmowa = tabelaUmow.getSelectionModel().getSelectedItem();
            tabSzczegoly.setDisable(false);
            aktualnieWybranaUmowa=tabelaUmow.getSelectionModel().getSelectedItem();
            ladujTabeleSzczegolow(aktualnieWybranaUmowa.getId_umowy());



        }else{
            tabSzczegoly.setDisable(true);
        }
    }

    public void oznaczJakoOplacona(ActionEvent actionEvent) {
        cspie.oznaczJakoOplacone(tabelaSzczegoly.getSelectionModel().getSelectedItem().getId_oplaty());
        ladujTabeleSzczegolow(aktualnieWybranaUmowa.getId_umowy());
    }
}
