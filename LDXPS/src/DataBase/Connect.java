/* File:          Connect.java
Date: 09/00]4/21
Description: CLASSSE RESPONSAVEL POR CONECTAR AO SERCIDOR
References:
Author:Luiz da Silva Moura.
Modifications:
*/

package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Connect {

	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet resultset = null;

	public static void StartConnect() {
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/ldxps";
		final String USER = "root";
		final String PASS = "Senha";

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);
			statement = connection.createStatement();
		} catch (Exception e) {
			throw new RuntimeException("Erro na conex?o com o banco de dados");
		}
	}

	public static void Disconect() {
		/*try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao desconectar");
		}
		*/

	}


	public static Boolean Status() {
		if (connection != null) {
			return true;
		}
		return false;
	}

}
