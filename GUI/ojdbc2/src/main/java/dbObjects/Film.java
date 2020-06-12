package Tabele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Film {
    SimpleIntegerProperty id_filmu;
    SimpleStringProperty tytul;
    SimpleStringProperty dlugosc;
    SimpleStringProperty gatunek;
    SimpleStringProperty opis;
    SimpleStringProperty typ;

    public Film(Integer id_filmu, String tytul, String gatunek, String opis, String typ, String dlugosc) {
        this.id_filmu = new SimpleIntegerProperty(id_filmu);
        this.tytul = new SimpleStringProperty(tytul);

        this.gatunek = new SimpleStringProperty(gatunek);
        this.opis = new SimpleStringProperty(opis);
        this.typ = new SimpleStringProperty(typ);
        this.dlugosc = new SimpleStringProperty(dlugosc);
    }


    public int getId_filmu() {
        return id_filmu.get();
    }

    public SimpleIntegerProperty id_filmuProperty() {
        return id_filmu;
    }

    public void setId_filmu(int id_filmu) {
        this.id_filmu.set(id_filmu);
    }

    public String getTytul() {
        return tytul.get();
    }

    public SimpleStringProperty tytulProperty() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul.set(tytul);
    }

    public String getDlugosc() {
        return dlugosc.get();
    }

    public SimpleStringProperty dlugoscProperty() {
        return dlugosc;
    }

    public void setDlugosc(String dlugosc) {
        this.dlugosc.set(dlugosc);
    }

    public String getGatunek() {
        return gatunek.get();
    }

    public SimpleStringProperty gatunekProperty() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek.set(gatunek);
    }

    public String getOpis() {
        return opis.get();
    }

    public SimpleStringProperty opisProperty() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis.set(opis);
    }

    public String getTyp() {
        return typ.get();
    }

    public SimpleStringProperty typProperty() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ.set(typ);
    }
}
