package curs8;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *d
 * @author alex ;p
 */
@SuppressWarnings("unused")
public class Controller implements Initializable {
    
    @FXML
    private TableView<Student> tabela_students;
    @FXML
    private Tab tab_students;
    @FXML
    private Button buton_IncarcareStudents;
    @FXML
    private TableColumn<Student, Integer> atribut_idstudent;
    @FXML
    private TableColumn<Student, String> atribut_numeStudent;
    @FXML
    private TableColumn<Student, String> atribut_prenumeStudent;
    @FXML
    private TableColumn<Student, String> atribut_adresaStudent;
    @FXML
    private TableColumn<Student, Integer> atribut_varstaStudent;
    
    @FXML
    private TableView<Subject> tabela_subjects;
    @FXML
    private Tab tab_subjects;
    @FXML
    private Button buton_incarcareSubjects;
    @FXML
    private TableColumn<Subject, Integer> atribut_idsubject;
    @FXML
    private TableColumn<Subject, String> atribut_numeSubject;
    @FXML
    private TableColumn<Subject, Integer> atribut_numarDeCredite;
    @FXML
    private TableColumn<Subject, Integer> atribut_numarDeOre;
    
    @FXML
    private TableView<Test> tabela_tests;
    @FXML
    private Tab tab_tests;
    @FXML
    private Button buton_IncarcareTests;
    @FXML
    private TableColumn<Test, Integer> atribut_idtest;
    @FXML
    private TableColumn<Test, String> atribut_testNumeStudent;
    @FXML
    private TableColumn<Test, String> atribut_testPrenumeStudent;
    @FXML
    private TableColumn<Test, Date> atribut_data;
    @FXML
    private TableColumn<Test, Integer> atribut_nota;
    @FXML
    private TableColumn<Test, String> atribut_testNumeSubject;
   
    private ObservableList<Student> dateStudents;
    private ObservableList<Subject> dateSubjects;
    private ObservableList<Test> dateTests;
    private DBOperations jb;
    
    @FXML
    private TextField field_numeSubject;
    @FXML
    private TextField field_numarDeCrediteSubject;
    @FXML
    private TextField field_numarDeOreSubject;
    @FXML
    private Button buton_adaugaSubject;
    
    @FXML
    private TextField field_idSubjectDelete;
    @FXML
    private Button buton_stergereSubject;
    
    @FXML
    private TextField field_idSubjectUpdate;
    @FXML
    private TextField field_numeSubjectUpdate;
    @FXML
    private TextField field_numarDeCrediteUpdate;
    @FXML
    private TextField field_numarDeOreUpdate;
    @FXML
    private Button buton_modificaSubject;
    
    @FXML
    private TextField field_numeStudent;
    @FXML
    private TextField field_prenumeStudent;
    @FXML
    private TextField field_adresaStudent;
    @FXML
    private TextField field_varstaStudent;
    @FXML
    private Button buton_adaugaStudent;
    
    @FXML
    private TextField field_idStudentDelete;
    @FXML
    private Button buton_stergereStudent;
    
    @FXML
    private TextField field_idStudentUpdate;
    @FXML
    private TextField field_numeStudentUpdate;
    @FXML
    private TextField field_prenumeStudentUpdate;
    @FXML
    private TextField field_adresaStudentUpdate;
    @FXML
    private TextField field_varstaStudentUpdate;
    @FXML
    private Button buton_modificaStudent;
    
    @FXML
    private TextField field_idStudentTest;
    @FXML
    private TextField field_idSubjectTest;
    @FXML
    private TextField field_dataTest;
    @FXML
    private TextField field_notaTest;
    @FXML
    private Button buton_adaugaTest;
    
    @FXML
    private TextField field_idTestDelete;
    @FXML
    private Button buton_stergereTest;
    
    @FXML
    private TextField field_idTestUpdate;
    @FXML
    private TextField field_idStudentTestUpdate;
    @FXML
    private TextField field_idSubjectTestUpdate;
    @FXML
    private TextField field_dataTestUpdate;
    @FXML
    private TextField field_notaTestUpdate;
    @FXML
    private Button buton_modificaTest;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jb = new DBOperations();
    }    

    @FXML
    private void incarcaStudenti(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateStudents = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("students");
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
            dateStudents.add(new Student(rs.getInt("idstudent"), rs.getString("nume"), rs.getString("prenume"), rs.getString("adresa"),rs.getInt("varsta")));
        }

        atribut_idstudent.setCellValueFactory(new PropertyValueFactory<>("idstudent"));
        atribut_numeStudent.setCellValueFactory(new PropertyValueFactory<>("nume"));
        atribut_prenumeStudent.setCellValueFactory(new PropertyValueFactory<>("prenume"));
        atribut_adresaStudent.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        atribut_varstaStudent.setCellValueFactory(new PropertyValueFactory<>("varsta"));
        
        tabela_students.setItems(null);
        tabela_students.setItems(dateStudents);
        jb.disconnect();
    }

    @FXML
    private void incarcaSubjects(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateSubjects = FXCollections.observableArrayList();
        
        ResultSet rs = jb.vedeTabel("subjects");
        while (rs.next()) {
            dateSubjects.add(new Subject(rs.getInt("idsubject"), rs.getString("nume"), rs.getInt("numar de credite"), rs.getInt("numar de ore")));
        }

        atribut_idsubject.setCellValueFactory(new PropertyValueFactory<>("idsubject"));
        atribut_numeSubject.setCellValueFactory(new PropertyValueFactory<>("nume"));
        atribut_numarDeCredite.setCellValueFactory(new PropertyValueFactory<>("numarDeCredite"));
        atribut_numarDeOre.setCellValueFactory(new PropertyValueFactory<>("numarDeOre"));
        
        tabela_subjects.setItems(null);
        tabela_subjects.setItems(dateSubjects);
        jb.disconnect();
    }
    @FXML
    private void incarcaTests(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateTests = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTeste();
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
            dateTests.add(new Test(rs.getInt("idtest"), rs.getString("NumeStudent"), rs.getString("PrenumeStudent"),rs.getString("NumeSubject"), rs.getDate("data"),rs.getInt("nota")));
        }

        atribut_idtest.setCellValueFactory(new PropertyValueFactory<>("idtest"));
        atribut_testNumeStudent.setCellValueFactory(new PropertyValueFactory<>("numeStudent"));
        atribut_testPrenumeStudent.setCellValueFactory(new PropertyValueFactory<>("prenumeStudent"));
        atribut_testNumeSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        atribut_data.setCellValueFactory(new PropertyValueFactory<>("data"));
        atribut_nota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        
        tabela_tests.setItems(null);
        tabela_tests.setItems(dateTests);
        jb.disconnect();
    }
    @FXML
	private void adaugaSubject(ActionEvent event) throws SQLException, Exception {
		jb.connect();
		String nume = field_numeSubject.getText();
		Integer numarDeCredite = Integer.valueOf(field_numarDeCrediteSubject.getText());
		Integer numarDeOre=Integer.valueOf(field_numarDeOreSubject.getText());
		jb.adaugaSubject(nume, numarDeCredite, numarDeOre);
		incarcaSubjects(event);
		jb.disconnect();
	}
    @FXML
    private void stergeSubject(ActionEvent event) throws SQLException, Exception {
		jb.connect();
		Integer idSubject=Integer.valueOf(field_idSubjectDelete.getText());
		jb.stergeTabela("subjects","idsubject",idSubject);
		incarcaSubjects(event);
		jb.disconnect();
	}
    @FXML
   	private void modificaSubject(ActionEvent event) throws SQLException, Exception {
   		jb.connect();
   		Long idSubject = Long.valueOf(field_idSubjectUpdate.getText());
   		String nume = field_numeSubjectUpdate.getText();
   		String numarDeCredite = field_numarDeCrediteUpdate.getText();
   		String numarDeOre=field_numarDeOreUpdate.getText();
   		String[] campuri= {"`nume`","`numar de credite`","`numar de ore`"};
   		String[] valori= {nume,numarDeCredite,numarDeOre};
   		jb.modificaTabela("`subjects`", "idsubject", idSubject, campuri, valori);
   		incarcaSubjects(event);
   		jb.disconnect();
   	}
    @FXML
	private void adaugaStudent(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
		String nume = field_numeStudent.getText();
		String prenume = field_prenumeStudent.getText();
		String adresa = field_adresaStudent.getText();
		Integer varsta=Integer.valueOf(field_varstaStudent.getText());
		jb.adaugaStudent(nume, prenume, adresa , varsta);
		incarcaStudenti(event);
		jb.disconnect();
	}
    @FXML
    private void stergeStudent(ActionEvent event) throws SQLException, Exception {
		jb.connect();
		Integer idStudent=Integer.valueOf(field_idStudentDelete.getText());
		jb.stergeTabela("students","idstudent",idStudent);
		incarcaStudenti(event);
		jb.disconnect();
	}
    @FXML
   	private void modificaStudent(ActionEvent event) throws SQLException, Exception {
   		jb.connect();
   		Long idStudent = Long.valueOf(field_idStudentUpdate.getText());
   		String nume = field_numeStudentUpdate.getText();
   		String prenume = field_prenumeStudentUpdate.getText();
   		String adresa=field_adresaStudentUpdate.getText();
   		String varsta=field_varstaStudentUpdate.getText();
   		String[] campuri= {"`nume`","`prenume`","`adresa`","`varsta`"};
   		String[] valori= {nume,prenume,adresa,varsta};
   		jb.modificaTabela("`students`", "idstudent", idStudent, campuri, valori);
   		incarcaStudenti(event);
   		jb.disconnect();
   	}
    @FXML
   	private void adaugaTest(ActionEvent event) throws SQLException, Exception {
       	jb.connect();
   		Integer idStudent = Integer.valueOf(field_idStudentTest.getText());
   		Integer idSubject = Integer.valueOf(field_idSubjectTest.getText());
   		Date data = Date.valueOf(field_dataTest.getText());
   		Integer nota=Integer.valueOf(field_notaTest.getText());
   		jb.adaugaTest(idStudent, idSubject, data, nota);
   		incarcaTests(event);
   		jb.disconnect();
   	}
       @FXML
       private void stergeTest(ActionEvent event) throws SQLException, Exception {
   		jb.connect();
   		Integer idTest=Integer.valueOf(field_idTestDelete.getText());
   		jb.stergeTabela("tests","idtest",idTest);
   		incarcaTests(event);
   		jb.disconnect();
   	}
       @FXML
      	private void modificaTest(ActionEvent event) throws SQLException, Exception {
      		jb.connect();
      		Long idTest = Long.valueOf(field_idTestUpdate.getText());
      		String idSubject = field_idSubjectTestUpdate.getText();
      		String idStudent = field_idStudentTestUpdate.getText();
      		String data=field_dataTestUpdate.getText();
      		String nota=field_notaTestUpdate.getText();
      		String[] campuri= {"`idstudent`","`idsubject`","`data`","`nota`"};
      		String[] valori= {idStudent,idSubject,data,nota};
      		jb.modificaTabela("`tests`", "idtest", idTest, campuri, valori);
      		incarcaTests(event);
      		jb.disconnect();
      	}
    
}