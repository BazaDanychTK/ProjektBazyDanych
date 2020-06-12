package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Usluga {
    SimpleIntegerProperty id;
    SimpleStringProperty nazwa;
    SimpleIntegerProperty predkosc;
    SimpleIntegerProperty rodzaj_id;
    SimpleStringProperty nazwa_lacza;


    public Usluga(Integer id, String nazwa, Integer predkosc, Integer rodzaj_id) {
        this.id = new SimpleIntegerProperty (id);
        this.nazwa = new SimpleStringProperty (nazwa);
        this.predkosc = new SimpleIntegerProperty (predkosc);
        this.rodzaj_id = new SimpleIntegerProperty (rodzaj_id);
    }
    public Usluga(Integer id, String nazwa, Integer predkosc, String nazwa_lacza) {
        this.id = new SimpleIntegerProperty (id);
        this.nazwa = new SimpleStringProperty (nazwa);
        this.predkosc = new SimpleIntegerProperty (predkosc);
        this.nazwa_lacza = new SimpleStringProperty (nazwa_lacza);
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

    public String getNazwa() {
        return nazwa.get();
    }

    public SimpleStringProperty nazwaProperty() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa.set(nazwa);
    }

    public int getPredkosc() {
        return predkosc.get();
    }

    public SimpleIntegerProperty predkoscProperty() {
        return predkosc;
    }

    public void setPredkosc(int predkosc) {
        this.predkosc.set(predkosc);
    }

    public int getRodzaj_id() {
        return rodzaj_id.get();
    }

    public SimpleIntegerProperty rodzaj_idProperty() {
        return rodzaj_id;
    }

    public void setRodzaj_id(int rodzaj_id) {
        this.rodzaj_id.set(rodzaj_id);
    }

    public String getNazwa_lacza() {
        return nazwa_lacza.get();
    }

    public SimpleStringProperty nazwa_laczaProperty() {
        return nazwa_lacza;
    }

    public void setNazwa_lacza(String nazwa_lacza) {
        this.nazwa_lacza.set(nazwa_lacza);
    }

    @Override
    public String toString() {
        return nazwa.get();
    }
}
