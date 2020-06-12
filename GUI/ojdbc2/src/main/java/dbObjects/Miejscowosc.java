package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Miejscowosc {
    SimpleStringProperty kod_pocztowy;
    SimpleStringProperty nazwa;


    public Miejscowosc(String kod_pocztowy, String nazwa) {
        this.kod_pocztowy = new SimpleStringProperty (kod_pocztowy);
        this.nazwa = new SimpleStringProperty (nazwa);
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

    public String getNazwa() {
        return nazwa.get();
    }

    public SimpleStringProperty nazwaProperty() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa.set(nazwa);
    }

    @Override
    public String toString() {
        return nazwa.get();
    }
}
