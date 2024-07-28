package demo_jdbc.respositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo_jdbc.models.Season;

public class SeasonRepository {
    String jdbcUrl = "jdbc:postgresql://localhost:5432/Formula_1";
    String user = "postgres";
    String password = "1234";

    public List<Season> getSeasons() {
        List<Season> seasons = new ArrayList<Season>();

        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);

            // Crear una sentencia
            Statement statement = conn.createStatement();

            // Ejecutar la consulta
            String sql = "SELECT * FROM seasons";
            ResultSet rs = statement.executeQuery(sql);

            // Procesar los resultados
            while (rs.next()) {
                int year = rs.getInt("year");

                Season season = new Season(year);
                seasons.add(season);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return seasons;
    }

    // Nuevo método para obtener los años
    public List<Integer> getYears() {
        List<Integer> years = new ArrayList<>();

        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);

            // Crear una sentencia
            Statement statement = conn.createStatement();

            // Ejecutar la consulta
            String sql = "SELECT DISTINCT year FROM seasons ORDER BY year";
            ResultSet rs = statement.executeQuery(sql);

            // Procesar los resultados
            while (rs.next()) {
                int year = rs.getInt("year");
                years.add(year);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return years;
    }
}
