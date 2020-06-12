package controllers;

import dbObjects.RodzajLacza;
import dbObjects.Usluga;
import dbUtils.CallableStatementParameter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class UslugiController {
    public TextField txtNazwa;
    public TextField tytTyp;
    public TextField txtPredkosc;
    public Text infoTxt;
    public ComboBox<RodzajLacza> comboTyp;
    public TableView<Usluga> tabelaUslug;
    public TableColumn uslugaCol;
    public TableColumn typLaczaCol;
    public TableColumn predkoscCol;
    CallableStatementParameter cspie = new CallableStatementParameter();

    public void initialize(){
        ladujComboBoxTypyPolaczen();
        ladujTabeleUslug();
    }

    public void ladujComboBoxTypyPolaczen(){
        comboTyp.setItems(FXCollections.observableArrayList(cspie.widokRodzajowLacza()));
    }

    public void ladujTabeleUslug(){
        uslugaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        typLaczaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa_lacza"));
        predkoscCol.setCellValueFactory(new PropertyValueFactory<>("predkosc"));

        tabelaUslug.setItems(FXCollections.observableArrayList(cspie.widokUslug()));
    }

    public void dodajUsluge(ActionEvent actionEvent) {
        if(!txtNazwa.getText().equals("")&&(!txtPredkosc.getText().equals("")||comboTyp.getSelectionModel().getSelectedItem()!=null)){
            try {
                infoTxt.setText(cspie.proceduraZapiszUsluge(txtNazwa.getText(), Integer.valueOf(txtPredkosc.getText()), comboTyp.getSelectionModel().getSelectedItem().getId()));
                ladujTabeleUslug();
            }catch(NumberFormatException e){
                infoTxt.setText("Error - prędkość musi być liczbą całkowitą");
            }catch(NullPointerException n){
                infoTxt.setText("Error - wybierz typ łącza lub nie podawaj jego prędkości");
            }
        }else{
            System.out.println("ZapiszUsluge2");
            infoTxt.setText(cspie.proceduraZapiszUsluge2(txtNazwa.getText()));
            ladujTabeleUslug();
        }

    }

    public void dodajTyp(ActionEvent actionEvent) {
        infoTxt.setText(cspie.proceduraZapiszRodzajLacza(tytTyp.getText()));
        ladujComboBoxTypyPolaczen();
    }

    public void usunUsluge(ActionEvent actionEvent) {
        infoTxt.setText(cspie.usunUsluge(tabelaUslug.getSelectionModel().getSelectedItem().getId()));
        ladujTabeleUslug();
    }

    public void usunTyp(ActionEvent actionEvent) {
        infoTxt.setText(cspie.usunRodzajLacza(comboTyp.getSelectionModel().getSelectedItem().getId()));
        ladujComboBoxTypyPolaczen();
    }
}
