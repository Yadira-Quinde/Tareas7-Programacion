package application;

import demo_jdbc.respositories.ConstructorsResultRepository;
import demo_jdbc.respositories.DriverResultRepository;
import demo_jdbc.respositories.QueryRepository;
import demo_jdbc.respositories.SeasonRepository;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private DriverResultRepository driverResultRepository;
    private SeasonRepository seasonRepository;
    private QueryRepository queryRepository;
    private ConstructorsResultRepository constructorsResultRepository;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aplicación de Fórmula 1");

        driverResultRepository = new DriverResultRepository();
        seasonRepository = new SeasonRepository();
        queryRepository = new QueryRepository();
        constructorsResultRepository = new ConstructorsResultRepository();

        // Crear los botones
        Button btnConductores = createStyledButton("CONSULTAR RESULTADOS DE LOS DRIVERS");
        btnConductores.setOnAction(e -> openConductoresWindow());

        Button btnConstructores = createStyledButton("CONSULTAR RESULTADOS DE LOS CONSTRUCTORS");
        btnConstructores.setOnAction(e -> openConstructoresWindow());

        Button btnGraficoConductores = createStyledButton("CONSULTAR GRAFICO DE BARRAS DE LOS DRIVERS");
        btnGraficoConductores.setOnAction(e -> openGraficoConductoresWindow());

        Button btnGraficoConstructores = createStyledButton("CONSULTAR GRAFICO DE BARRAS DE LOS CONSTRUCTORS");
        btnGraficoConstructores.setOnAction(e -> openGraficoConstructoresWindow());

        // Crear etiquetas
        Label titleLabel = new Label("RESULTADOS DE LA FORMULA 1");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        Label instructionLabel = new Label("SELECCIONE LA OPCION QUE DESEA CONSULTAR:");

        // Organizar layout
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(50));
        vbox.getChildren().addAll(titleLabel, instructionLabel, btnConductores, btnConstructores, btnGraficoConductores, btnGraficoConstructores);

        Scene scene = new Scene(vbox, 600, 400); // Ajustar el tamaño de la escena según tus necesidades
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px; -fx-background-color: #f0f0f0; -fx-border-color: #d0d0d0;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px; -fx-background-color: #f0f0f0; -fx-border-color: #d0d0d0; -fx-effect: dropshadow(three-pass-box, blue, 10, 0, 0, 0);"));
        button.setOnMouseExited(e -> button.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px; -fx-background-color: #f0f0f0; -fx-border-color: #d0d0d0;"));
        return button;
    }

    private void openConductoresWindow() {
        ConductoresWindow conductoresWindow = new ConductoresWindow(driverResultRepository, seasonRepository);
        conductoresWindow.start(new Stage());
    }

    private void openConstructoresWindow() {
        ConstructoresWindow constructoresWindow = new ConstructoresWindow(constructorsResultRepository, seasonRepository);
        constructoresWindow.start(new Stage());
    }

    private void openGraficoConductoresWindow() {
        GraficoConductoresWindow graficoConductoresWindow = new GraficoConductoresWindow(queryRepository);
        graficoConductoresWindow.start(new Stage());
    }

    private void openGraficoConstructoresWindow() {
        GraficoConstructoresWindow graficoConstructoresWindow = new GraficoConstructoresWindow(queryRepository);
        graficoConstructoresWindow.start(new Stage());
    }
}
