package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import Only.Vendedor;

public class VendedoresBD {
	
	private SimpleDateFormat formatout = new SimpleDateFormat("yyyy/MM/dd");

	public VendedoresBD() {
		if (Connect.Status() == false)
			Connect.StartConnect();
	}

	public ArrayList<Vendedor> List() {
		ArrayList<Vendedor> listvendedor = new ArrayList<Vendedor>();
		String query = "SELECT * FROM VENDEDORES ORDER BY DSNOME;";
		try {
			Connect.resultset = Connect.statement.executeQuery(query);
			ResultSet result = Connect.resultset;
			while (result.next()) {
				listvendedor.add(new Vendedor(result.getString("CDVEND"), result.getString("DSNOME"),
						result.getInt("CDTAB"), result.getDate("DTNASC")));

			}
			return listvendedor;

		} catch (SQLException e) {
			throw new RuntimeException("Error list all");
		}
	}

	public void Insert(String DSNOME, int CDTAB, Date DTNASC) {
		String CDVEND = UUID.randomUUID().toString();
		
		String query = "INSERT INTO VENDEDORES (CDVEND,DSNOME,CDTAB,DTNASC) VALUES ('" + CDVEND + "','" + DSNOME + "','"
				+ CDTAB + "','" + formatout.format(DTNASC) + "');";
		try {
			Connect.statement.executeUpdate(query);
		} catch (SQLException e) {
			throw new RuntimeException("Error insert vendedor");
		}
	}

	public void edit(String CDVEND, String DSNOME, int CDTAB, Date DTNASC) {
	
		String query = "UPDATE VENDEDORES SET DSNOME = '" + DSNOME + "', CDTAB = '" + CDTAB + "', DTNASC = '" + formatout.format(DTNASC)
				+ "' WHERE CDVEND = '" + CDVEND + "';";
		try {
			Connect.statement.executeUpdate(query);
		} catch (SQLException e) {
			throw new RuntimeException("Error insert vendedor");
		}

	}

	public void delete(String CDVEND) {
		String query = "DELETE FROM VENDEDORES WHERE CDVEND = '" + CDVEND + "';";
		try {
			Connect.statement.executeUpdate(query);
			// System.out.println(query);
		} catch (SQLException e) {
			throw new RuntimeException("Error insert vendedor");
		}

	}

	public static void main(String[] args) throws ParseException {

	}

}
