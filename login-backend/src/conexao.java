import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    public static Connection conectar() {
        Connection conn = null;
        try {
            // Nome do banco: sistemarocha, usuário padrão do XAMPP: root, sem senha
            String url = "jdbc:mysql://localhost:3306/db_rocha";
            String usuario = "root";
            String senha = "";

            conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ Conectado com sucesso ao banco de dados!");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }

        return conn;
    }
}
