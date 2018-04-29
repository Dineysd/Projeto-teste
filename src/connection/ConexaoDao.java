package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDao {
	private static String banco = "jdbc:postgresql://localhost:5432/projeto2?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	static {conectar();}

	public ConexaoDao() {conectar();}

	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				
				System.out.println("conectado com sucesso!");
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar com a base de dados."+ e);
		}
	}
	public static Connection getConnection() {
		return connection;
	}

}
