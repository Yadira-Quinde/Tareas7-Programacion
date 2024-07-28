package application;



import demo_jdbc.models.DriverMaxPoint;
import demo_jdbc.respositories.QueryRepository;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class GraficoConstructoresWindow extends Application {

    private QueryRepository queryRepository;

    public GraficoConstructoresWindow(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("GRAFICO DEL TOTAL DE PUNTOS DE LOS CONSTRUCTORS");

        // Crear ejes del gráfico
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("CONSTRUCTORS");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("PUNTOS TOTALES");

        // Crear gráfico de barras
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        // Cargar datos y crear series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("PUNTOS TOTALES");

        List<DriverMaxPoint> constructorsMaxPoints = queryRepository.getConstructorsMaxPoints();
        for (DriverMaxPoint constructor : constructorsMaxPoints) {
            series.getData().add(new XYChart.Data<>(constructor.getDriverName(), constructor.getPoints()));
        }

        barChart.getData().add(series);

        // Organizar layout
        VBox vbox = new VBox(barChart);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
