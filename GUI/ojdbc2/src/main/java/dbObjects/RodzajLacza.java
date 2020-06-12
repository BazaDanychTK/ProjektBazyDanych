package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class RodzajLacza {
    SimpleIntegerProperty id;
    SimpleStringProperty nazwa;


    public RodzajLacza(Integer id, String nazwa) {
        this.id = new SimpleIntegerProperty (id);
        this.nazwa = new SimpleStringProperty (nazwa);
    }


    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public SimpleIntegerProperty idProperty() {
        return id;
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
