package curs8;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ionut
 */
public class DBOperations {

	String error;
	Connection con;
	// Conectarea la baza de date

	public DBOperations() {
	}

	public void connect() throws ClassNotFoundException, SQLException, Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/facultate?useSSL=false", "root", "tete12345");
		} catch (ClassNotFoundException cnfe) {
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
			throw new ClassNotFoundException(error);
		} catch (SQLException cnfe) {
			error = "SQLException: Nu se poate conecta la baza de date.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
			throw new Exception(error);
		}
	}
	// end connect()

	public ResultSet vedeTabel(String tabel) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select * from `facultate`.`" + tabel + "`;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	}
	public ResultSet vedeTeste() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("SELECT \r\n"
					+ "    a.nume NumeStudent,\r\n"
					+ "    a.prenume PrenumeStudent,\r\n"
					+ "    a.adresa,\r\n"
					+ "    a.varsta,\r\n"
					+ "    b.nume NumeSubject,\r\n"
					+ "    b.`numar de credite` NumarDeCredite,\r\n"
					+ "    b.`numar de ore` NumarDeOre,\r\n"
					+ "    c.idtest,\r\n"
					+ "    c.idstudent idstudent_test,\r\n"
					+ "    c.idsubject idsubject_test,\r\n"
					+ "    c.data,\r\n"
					+ "    c.nota\r\n"
					+ "FROM\r\n"
					+ "    facultate.students a,\r\n"
					+ "    facultate.subjects b,\r\n"
					+ "    facultate.tests c\r\n"
					+ "WHERE\r\n"
					+ "    a.idstudent = c.idstudent\r\n"
					+ "        AND b.idsubject = c.idsubject;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	}
	

	public void disconnect() throws SQLException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
			throw new SQLException(error);
		}
	} // disconnect()
	public void adaugaStudent(String Nume, String Prenume, String Adresa, int Varsta) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `facultate`.`students` (`nume`, `prenume`, `adresa`, `varsta`) values('" + Nume + "', '" + Prenume + "', '" + Adresa + "', '" + Varsta + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}

    
	public void adaugaSubject(String Nume, int NumarDeCredite, int NumarDeOre) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			                  
			stmt.executeUpdate("insert into `facultate`.`subjects` (`nume`, `numar de credite`, `numar de ore`) values ('"+Nume+"', '"+NumarDeCredite+"', '"+ NumarDeOre+"');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	
	public void adaugaTest(int idstudent, int idsubject, Date data, int nota) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `facultate`.`tests`(`idstudent`, `idsubject`, `data`, `nota`) values('" + idstudent + "', '" + idsubject + "', '" + data + "', '" + nota + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}

	public void stergeTabela(String tabela, String denumirePK, long id) throws SQLException, Exception {
		if (con != null) {
			try {
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("delete from " + tabela + " where " + denumirePK + " = '" + id + "';");
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of stergeTabela()

	public void modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
			throws SQLException, Exception {
		//UPDATE `facultate`.`subjects` SET `nume` = 'test2', `numar de credite` = '1234', `numar de ore` = '4567' WHERE (`idsubject` = '10');
		String update = "update `facultate`." + tabela + " set ";
		String temp = "";
		if (con != null) {
			try {
				for (int i = 0; i < campuri.length; i++) {
					if (i != (campuri.length - 1)) {
						temp = temp + campuri[i] + "='" + valori[i] + "', ";
					} else {
						temp = temp + campuri[i] + "='" + valori[i] + "' where (`" + primarykey + "` = '" + ID + "');";
					}
				}
				update = update + temp;
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();

				stmt.executeUpdate(update);
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of modificaTabela()

}