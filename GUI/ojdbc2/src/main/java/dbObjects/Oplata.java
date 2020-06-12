package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Oplata {
    SimpleIntegerProperty id_oplaty;
    SimpleIntegerProperty id_umowy;
    SimpleIntegerProperty czy_zaplacone;
    SimpleStringProperty czy_zaplaconetxt;
    SimpleObjectProperty<Date> termin_platnosci;

    public Oplata(Integer id_oplaty, Integer id_umowy, Integer czy_zaplacone, Date termin) {
        this.id_oplaty = new SimpleIntegerProperty (id_oplaty);
        this.id_umowy = new SimpleIntegerProperty (id_umowy);
        this.czy_zaplacone = new SimpleIntegerProperty (czy_zaplacone);
        this.termin_platnosci = new SimpleObjectProperty<Date>(termin);
        if(czy_zaplacone.equals(-1)){
            this.czy_zaplaconetxt= new SimpleStringProperty("Nie");
        }else{
            this.czy_zaplaconetxt= new SimpleStringProperty("Tak");
        }
    }

    public int getId_oplaty() {
        return id_oplaty.get();
    }

    public SimpleIntegerProperty id_oplatyProperty() {
        return id_oplaty;
    }

    public void setId_oplaty(int id_oplaty) {
        this.id_oplaty.set(id_oplaty);
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

    public int getCzy_zaplacone() {
        return czy_zaplacone.get();
    }

    public SimpleIntegerProperty czy_zaplaconeProperty() {
        return czy_zaplacone;
    }

    public void setCzy_zaplacone(int czy_zaplacone) {
        this.czy_zaplacone.set(czy_zaplacone);
    }

    public Date getTermin_platnosci() {
        return termin_platnosci.get();
    }

    public SimpleObjectProperty<Date> termin_platnosciProperty() {
        return termin_platnosci;
    }

    public void setTermin_platnosci(Date termin_platnosci) {
        this.termin_platnosci.set(termin_platnosci);
    }

    public String getCzy_zaplaconetxt() {
        return czy_zaplaconetxt.get();
    }

    public SimpleStringProperty czy_zaplaconetxtProperty() {
        return czy_zaplaconetxt;
    }

    public void setCzy_zaplaconetxt(String czy_zaplaconetxt) {
        this.czy_zaplaconetxt.set(czy_zaplaconetxt);
    }
}
