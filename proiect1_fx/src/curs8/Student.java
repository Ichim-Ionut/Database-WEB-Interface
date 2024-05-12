package curs8;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author alex ;p
 */
public class Student {

    private final IntegerProperty idstudent;
    private final StringProperty nume;
    private final StringProperty prenume;
    private final StringProperty adresa;
    private final IntegerProperty varsta;

    public Student(Integer idstudent, String nume, String prenume,String adresa, Integer varsta) {
        this.idstudent = new SimpleIntegerProperty(idstudent);
        this.nume = new SimpleStringProperty(nume);
        this.prenume = new SimpleStringProperty(prenume);
        this.adresa = new SimpleStringProperty(adresa);
        this.varsta = new SimpleIntegerProperty(varsta);
    }

    public Integer getIdstudent() {
        return idstudent.get();
    }

    public String getNume() {
        return nume.get();
    }

    public String getPrenume() {
        return prenume.get();
    }
    
    public String getAdresa() {
        return adresa.get();
    }

    public Integer getVarsta() {
        return varsta.get();
    }

    public void setIdStudent(Integer valoare) {
        idstudent.set(valoare);
    }

    public void setNume(String valoare) {
        nume.set(valoare);
    }
    
    public void setAdresa(String valoare) {
        adresa.set(valoare);
    }

    public void setPrenume(String valoare) {
        prenume.set(valoare);
    }

    public void setVarsta(Integer valoare) {
        varsta.set(valoare);
    }

    public IntegerProperty idstudentProperty() {
        return idstudent;
    }

    public StringProperty NumeProperty() {
        return nume;
    }
    
    public StringProperty AdresaProperty() {
        return adresa;
    }

    public StringProperty PrenumeProperty() {
        return prenume;
    }

    public IntegerProperty VarstaProperty() {
        return varsta;
    }
}