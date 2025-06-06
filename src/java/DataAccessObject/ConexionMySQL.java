
package DataAccessObject;

import java.io.InputStream;
import java.util.Properties;
import java.sql.*;


public class ConexionMySQL {

    private static final String PROPERTIES_FILE = "db.properties";
    private static String url;
    private static String user;
    private static String password;

    // Cargar configuración al iniciar
    static {
        try (InputStream input = ConexionMySQL.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties props = new Properties();
            if (input == null) {
                throw new RuntimeException("No se encontró el archivo " + PROPERTIES_FILE);
            }
            props.load(input);

            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

            if (url == null || user == null) {
                throw new IllegalStateException("Parámetros de conexión faltantes");
            }

        } catch (Exception e) {
            System.err.println("Error al cargar configuración: " + e.getMessage());
        }
    }

    // Método público para obtener la conexión
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        if (conn == null || conn.isClosed()) {
            throw new SQLException("Conexion fallida");
        }
        return conn;
    }

    public static void main(String[] args) {

        try (Connection conn = getConnection()) {
            System.out.println("Conexion exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }

    }
}
