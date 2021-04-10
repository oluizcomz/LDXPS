package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import Only.Cliente;

public class ClientesBD {

	private SimpleDateFormat formatout = new SimpleDateFormat("yyyy/MM/dd");

	public ClientesBD() {
		if (Connect.Status() == false)
			Connect.StartConnect();
	}

	public ArrayList<Cliente> List() {
		ArrayList<Cliente> listcliente = new ArrayList<Cliente>();
		String query = "SELECT * FROM CLIENTES ORDER BY DSNOME;";
		try {
			Connect.resultset = Connect.statement.executeQuery(query);
			ResultSet result = Connect.resultset;
			while (result.next()) {
				listcliente.add(new Cliente(result.getString("CDCL"), result.getString("DSNOME"),
						result.getString("IDTIPO"), result.getString("CDVEND"), result.getDouble("DSLIM")));

			}
			return listcliente;

		} catch (SQLException e) {
			throw new RuntimeException("Error list all");
		}
	}

	public ArrayList<Cliente> List(String CDVEND) {
		ArrayList<Cliente> listcliente = new ArrayList<Cliente>();
		String query = "SELECT * FROM CLIENTES WHERE CDVEND = '" + CDVEND + "' ORDER BY DSNOME;";
		;
		try {
			Connect.resultset = Connect.statement.executeQuery(query);
			ResultSet result = Connect.resultset;
			while (result.next()) {
				listcliente.add(new Cliente(result.getString("CDCL"), result.getString("DSNOME"),
						result.getString("IDTIPO"), result.getString("CDVEND"), result.getDouble("DSLIM")));

			}
			return listcliente;

		} catch (SQLException e) {
			throw new RuntimeException("Error list all");
		}
	}

	public void Insert(String CDVEND, String DSNOME, String IDTIPO, double DSLIM) {
		String CDCL = UUID.randomUUID().toString();

		String query = "INSERT INTO CLIENTES (CDCL,CDVEND,DSNOME,IDTIPO,DSLIM) VALUES ('" + CDCL + "','" + CDVEND
				+ "','" + DSNOME + "','" + IDTIPO + "'," + DSLIM + ");";
		try {
			// System.out.println(query);
			Connect.statement.executeUpdate(query);
		} catch (SQLException e) {
			throw new RuntimeException("Error insert cliente");
		}
	}

	public void edit(String CDCL, String CDVEND, String DSNOME, String IDTIPO, double DSLIM) {

		String query = "UPDATE CLIENTES SET CDVEND = '" + CDVEND + "',DSNOME = '" + DSNOME + "', IDTIPO = '" + IDTIPO
				+ "', DSLIM = " + DSLIM + " WHERE CDCL = '" + CDCL + "';";
		try {
			Connect.statement.executeUpdate(query);
		} catch (SQLException e) {
			throw new RuntimeException("Error insert cliente");
		}

	}

	public void deleteVendedor(String CDVEND) {
		String query = "DELETE FROM CLIENTES WHERE CDVEND = '" + CDVEND + "';";
		try {
			Connect.statement.executeUpdate(query);
			// System.out.println(query);
		} catch (SQLException e) {
			throw new RuntimeException("Error insert cliente");
		}

	}

	public void delete(String CDCL) {
		String query = "DELETE FROM CLIENTES WHERE CDCL = '" + CDCL + "';";
		try {
			Connect.statement.executeUpdate(query);
			// System.out.println(query);
		} catch (SQLException e) {
			throw new RuntimeException("Error insert cliente");
		}

	}

	public static void main(String[] args) throws ParseException {
	}

}
