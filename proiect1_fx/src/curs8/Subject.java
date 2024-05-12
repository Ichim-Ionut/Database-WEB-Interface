package curs8;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author alex ;p
 */
public class Subject {

    private final IntegerProperty idsubject;
    private final StringProperty nume;
    private final IntegerProperty numarDeCredite;
    private final IntegerProperty numarDeOre;

    public Subject(Integer idsubject, String nume, Integer numarDeCredite, Integer numarDeOre) {
        this.idsubject = new SimpleIntegerProperty(idsubject);
        this.nume = new SimpleStringProperty(nume);
        this.numarDeCredite = new SimpleIntegerProperty(numarDeCredite);
        this.numarDeOre = new SimpleIntegerProperty(numarDeOre);
    }

    public Integer getIdsubject() {
        return idsubject.get();
    }

    public String getNume() {
        return nume.get();
    }

    public Integer getnumarDeCredite() {
        return numarDeCredite.get();
    }

    public Integer getnumarDeOre() {
        return numarDeOre.get();
    }

    public void setidsubject(Integer valoare) {
        idsubject.set(valoare);
    }

    public void setnume(String valoare) {
        nume.set(valoare);
    }

    public void setnumarDeCredite(Integer valoare) {
        numarDeCredite.set(valoare);
    }

    public void setnumarDeOre(Integer valoare) {
        numarDeOre.set(valoare);
    }

    public IntegerProperty idsubjectProperty() {
        return idsubject;
    }

    public StringProperty numeProperty() {
        return nume;
    }

    public IntegerProperty numarDeCrediteProperty() {
        return numarDeCredite;
    }

    public IntegerProperty numarDeOreProperty() {
        return numarDeOre;
    }
}