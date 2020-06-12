package controllers;

import dbObjects.Klient;
import dbUtils.CallableStatementParameter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class KlienciController {
    public TextField txtImie;
    public TextField txtMieszkanie;
    public TextField txtUlica;
    public TextField txtMiejscowosc;
    public TextField txtKod;
    public TextField txtNazwisko;
    public Text infoTxt;
    public TextField txtTelefon;
    public TableView<Klient> tabelaKlientow;
    public TableColumn imieCol;
    public TableColumn nazwiskoCol;
    public TableColumn miejscowoscCol;
    public TableColumn kodCol;
    public TableColumn ulicaCol;
    public TableColumn mieszkanieCol;
    public TableColumn telefonCol;
    CallableStatementParameter cspie = new CallableStatementParameter();

    public void initialize(){
        ladujTabeleKlientow();
    }

    public void ladujTabeleKlientow(){
        imieCol.setCellValueFactory(new PropertyValueFactory<>("imie"));
        nazwiskoCol.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        miejscowoscCol.setCellValueFactory(new PropertyValueFactory<>("nazwa_miejscowosci"));
        kodCol.setCellValueFactory(new PropertyValueFactory<>("kod_pocztowy"));
        ulicaCol.setCellValueFactory(new PropertyValueFactory<>("ulica"));
        mieszkanieCol.setCellValueFactory(new PropertyValueFactory<>("numer_lokalu"));
        telefonCol.setCellValueFactory(new PropertyValueFactory<>("tel_kontakt"));

        tabelaKlientow.setItems(FXCollections.observableArrayList(cspie.widokKlientow()));
    }

    public void dodajKlienta(ActionEvent actionEvent) {
        infoTxt.setText(cspie.proceduraZapiszKlienta(txtImie.getText(),txtNazwisko.getText(),txtKod.getText(),txtUlica.getText(),txtMieszkanie.getText(),txtTelefon.getText()));
        ladujTabeleKlientow();
    }

    public void dodajMiejscowosc(ActionEvent actionEvent) {
        infoTxt.setText(cspie.proceduraZapiszMiejscowosc(txtKod.getText(),txtMiejscowosc.getText()));
    }

    public void usunKlienta(ActionEvent actionEvent) {
        infoTxt.setText(cspie.usunKlienta(tabelaKlientow.getSelectionModel().getSelectedItem().getId()));
        ladujTabeleKlientow();
    }
}
