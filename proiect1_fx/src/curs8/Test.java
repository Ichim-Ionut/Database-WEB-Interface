package curs8;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Test {
	private final IntegerProperty idtest;
	private final StringProperty prenumeStudent;
	private final StringProperty numeStudent;
	private final StringProperty subject;
    private final ObjectProperty<Date> data;
    private final IntegerProperty nota;

    public Test(Integer idtest, String numeStudent, String prenumeStudent,String subject,Date data, Integer nota) {
        this.idtest = new SimpleIntegerProperty(idtest);
        this.numeStudent = new SimpleStringProperty(numeStudent);
        this.prenumeStudent = new SimpleStringProperty(prenumeStudent);
        this.subject = new SimpleStringProperty(subject);
        this.data = new SimpleObjectProperty<Date>(data);
        this.nota = new SimpleIntegerProperty(nota);
    }

    public Integer getIdTest() {
        return idtest.get();
    }

    public String getNumeStudent() {
        return numeStudent.get();
    }

    public String getPrenumeStudent() {
        return prenumeStudent.get();
    }
    
    public String getSubject() {
        return subject.get();
    }
    
    public Date getData() {
        return data.get();
    }

    public Integer getNota() {
        return nota.get();
    }

    public void setIdTest(Integer valoare) {
        idtest.set(valoare);
    }

    public void setNumeStudent(String valoare) {
        numeStudent.set(valoare);
    }
    
    public void setPrenumeStudent(String valoare) {
        prenumeStudent.set(valoare);
    }
    
    public void setSubject(String valoare) {
        subject.set(valoare);
    }

    public void setData(Date valoare) {
        data.set(valoare);
    }

    public void setNota(Integer valoare) {
        nota.set(valoare);
    }

    public IntegerProperty idtestProperty() {
        return idtest;
    }

    public StringProperty numeStudentProperty() {
        return numeStudent;
    }
    
    public StringProperty prenumeStudentProperty() {
        return prenumeStudent;
    }
    
    public StringProperty subjectProperty() {
        return subject;
    }

    public ObjectProperty<Date> dataProperty() {
        return data;
    }

    public IntegerProperty notaProperty() {
        return nota;
    }
	
	
	
}
