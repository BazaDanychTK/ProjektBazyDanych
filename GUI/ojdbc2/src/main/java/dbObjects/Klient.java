package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Klient {
    SimpleIntegerProperty id;
    SimpleStringProperty imie;
    SimpleStringProperty nazwisko;
    SimpleStringProperty kod_pocztowy;
    SimpleStringProperty ulica;
    SimpleStringProperty numer_lokalu;
    SimpleStringProperty tel_kontakt;
    SimpleStringProperty nazwa_miejscowosci;


    public Klient(Integer id, String imie, String nazwisko, String kod_pocztowy, String ulica, String numer_lokalu, String tel_kontakt, String nazwa_miejscowosci) {
        this.id = new SimpleIntegerProperty (id);
        this.imie = new SimpleStringProperty (imie);
        this.nazwisko = new SimpleStringProperty (nazwisko);
        this.kod_pocztowy = new SimpleStringProperty (kod_pocztowy);
        this.ulica = new SimpleStringProperty (ulica);
        this.numer_lokalu = new SimpleStringProperty (numer_lokalu);
        this.tel_kontakt = new SimpleStringProperty (tel_kontakt);
        this.nazwa_miejscowosci = new SimpleStringProperty (nazwa_miejscowosci);

    }


    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getImie() {
        return imie.get();
    }

    public SimpleStringProperty imieProperty() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public SimpleStringProperty nazwiskoProperty() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public String getKod_pocztowy() {
        return kod_pocztowy.get();
    }

    public SimpleStringProperty kod_pocztowyProperty() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy.set(kod_pocztowy);
    }

    public String getUlica() {
        return ulica.get();
    }

    public SimpleStringProperty ulicaProperty() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica.set(ulica);
    }

    public String getNumer_lokalu() {
        return numer_lokalu.get();
    }

    public SimpleStringProperty numer_lokaluProperty() {
        return numer_lokalu;
    }

    public void setNumer_lokalu(String numer_lokalu) {
        this.numer_lokalu.set(numer_lokalu);
    }

    public String getTel_kontakt() {
        return tel_kontakt.get();
    }

    public SimpleStringProperty tel_kontaktProperty() {
        return tel_kontakt;
    }

    public void setTel_kontakt(String tel_kontakt) {
        this.tel_kontakt.set(tel_kontakt);
    }

    public String getNazwa_miejscowosci() {
        return nazwa_miejscowosci.get();
    }

    public SimpleStringProperty nazwa_miejscowosciProperty() {
        return nazwa_miejscowosci;
    }

    public void setNazwa_miejscowosci(String nazwa_miejscowosci) {
        this.nazwa_miejscowosci.set(nazwa_miejscowosci);
    }

    @Override
    public String toString() {
        return imie.get()+" "+nazwisko.get();
    }
}
