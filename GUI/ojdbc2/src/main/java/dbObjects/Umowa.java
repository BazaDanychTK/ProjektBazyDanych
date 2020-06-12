package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Umowa {
    SimpleIntegerProperty id_umowy;
    SimpleObjectProperty<Date> dataStart;
    SimpleObjectProperty<Date> dataKoniec;
    SimpleStringProperty imieNazwisko;
    SimpleStringProperty nazwisko;
    SimpleStringProperty nazwauslugi;
    SimpleStringProperty predkosc_lacza;
    SimpleStringProperty nazwarodzajulacza;

    public Umowa(Integer id_umowy, Date dataStart, Date dataKoniec, String imie, String nazwisko, String nazwauslugi, String predkosc_lacza, String nazwarodzajulacza) {
        this.id_umowy = new SimpleIntegerProperty (id_umowy);
        this.dataStart = new SimpleObjectProperty<Date> (dataStart);
        this.dataKoniec = new SimpleObjectProperty<Date> (dataKoniec);
        this.imieNazwisko = new SimpleStringProperty (imie+" "+nazwisko);
        this.nazwisko = new SimpleStringProperty (nazwisko);
        this.nazwauslugi = new SimpleStringProperty (nazwauslugi);
        this.predkosc_lacza = new SimpleStringProperty (predkosc_lacza);
        this.nazwarodzajulacza = new SimpleStringProperty (nazwarodzajulacza);

    }


    public int getId_umowy() {
        return id_umowy.get();
    }

    public SimpleIntegerProperty id_umowyProperty() {
        return id_umowy;
    }

    public void setId_umowy(int id_umowy) {
        this.id_umowy.set(id_umowy);
    }

    public Date getDataStart() {
        return dataStart.get();
    }

    public SimpleObjectProperty<Date> dataStartProperty() {
        return dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart.set(dataStart);
    }

    public Date getDataKoniec() {
        return dataKoniec.get();
    }

    public SimpleObjectProperty<Date> dataKoniecProperty() {
        return dataKoniec;
    }

    public void setDataKoniec(Date dataKoniec) {
        this.dataKoniec.set(dataKoniec);
    }

    public String getImieNazwisko() {
        return imieNazwisko.get();
    }

    public SimpleStringProperty imieNazwiskoProperty() {
        return imieNazwisko;
    }

    public void setImieNazwisko(String imieNazwisko) {
        this.imieNazwisko.set(imieNazwisko);
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

    public String getNazwauslugi() {
        return nazwauslugi.get();
    }

    public SimpleStringProperty nazwauslugiProperty() {
        return nazwauslugi;
    }

    public void setNazwauslugi(String nazwauslugi) {
        this.nazwauslugi.set(nazwauslugi);
    }

    public String getPredkosc_lacza() {
        return predkosc_lacza.get();
    }

    public SimpleStringProperty predkosc_laczaProperty() {
        return predkosc_lacza;
    }

    public void setPredkosc_lacza(String predkosc_lacza) {
        this.predkosc_lacza.set(predkosc_lacza);
    }

    public String getNazwarodzajulacza() {
        return nazwarodzajulacza.get();
    }

    public SimpleStringProperty nazwarodzajulaczaProperty() {
        return nazwarodzajulacza;
    }

    public void setNazwarodzajulacza(String nazwarodzajulacza) {
        this.nazwarodzajulacza.set(nazwarodzajulacza);
    }

}
