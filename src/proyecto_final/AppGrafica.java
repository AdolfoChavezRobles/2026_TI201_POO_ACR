package proyecto_final;

import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AppGrafica extends Application {

    private LineChart<Number, Number> lineChart;
    private int terminosActuales = 1;
    private Timeline animacion;
    private SerieMatematica serieSeleccionada; // POLIMORFISMO: Guarda cualquier hijo de SerieMatematica

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simulador de Computación Numérica - Panel de Control");

        VBox sidebar = new VBox(15);
        sidebar.setStyle("-fx-background-color: #2c3e50; -fx-padding: 20;");
        
        Label title = new Label("Menú Series");
        title.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16;");

        Button btnFourier = new Button("Serie Fourier");
        Button btnFourierTri = new Button("Fourier Triangular");
        Button btnTaylorEx = new Button("Series Taylor (e^x)");
        Button btnTaylorLog = new Button("Maclaurin (ln(1+x))");
        
        btnFourier.setMaxWidth(Double.MAX_VALUE);
        btnFourierTri.setMaxWidth(Double.MAX_VALUE);
        btnTaylorEx.setMaxWidth(Double.MAX_VALUE);
        btnTaylorLog.setMaxWidth(Double.MAX_VALUE);

        Slider sliderTerminos = new Slider(1, 50, 1);
        sliderTerminos.setShowTickLabels(true);
        Label lblTerminos = new Label("Términos: 1");
        lblTerminos.setStyle("-fx-text-fill: white;");

        sidebar.getChildren().addAll(title, btnFourier, btnFourierTri, btnTaylorEx, btnTaylorLog, lblTerminos, sliderTerminos);

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Gráfica de Aproximación en Tiempo Real");
        lineChart.setCreateSymbols(false); 

        BorderPane root = new BorderPane();
        root.setLeft(sidebar);
        root.setCenter(lineChart);

        serieSeleccionada = new OndaCuadrada();

        btnFourier.setOnAction(e -> {
            animacion.stop();
            serieSeleccionada = new OndaCuadrada();
            actualizarGrafico(serieSeleccionada, (int) sliderTerminos.getValue());
        });

        btnFourierTri.setOnAction(e -> {
            animacion.stop();
            serieSeleccionada = new OndaTriangular();
            actualizarGrafico(serieSeleccionada, (int) sliderTerminos.getValue());
        });

        btnTaylorEx.setOnAction(e -> {
            animacion.stop();
            serieSeleccionada = new SerieExponencial(); 
            actualizarGrafico(serieSeleccionada, (int) sliderTerminos.getValue());
        });

        btnTaylorLog.setOnAction(e -> {
            animacion.stop();
            serieSeleccionada = new SerieLogaritmica();
            actualizarGrafico(serieSeleccionada, (int) sliderTerminos.getValue());
        });

        sliderTerminos.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblTerminos.setText("Términos: " + newVal.intValue());
            actualizarGrafico(serieSeleccionada, newVal.intValue());
        });

        animacion = new Timeline(new KeyFrame(Duration.millis(250), event -> {
            if (terminosActuales < 40) {
                terminosActuales++;
                sliderTerminos.setValue(terminosActuales);
            } else {
                terminosActuales = 1;
            }
        }));
        animacion.setCycleCount(Timeline.INDEFINITE);
        animacion.play(); 

        Scene scene = new Scene(root, 1000, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void actualizarGrafico(SerieMatematica serie, int terminos) {
        lineChart.getData().clear();
        XYChart.Series<Number, Number> seriesData = new XYChart.Series<>();
        seriesData.setName(serie.getNombre() + " (" + terminos + " t)");

        double inicio = (serie instanceof SerieTaylor) ? -1.0 : -2.0;
        double fin = (serie instanceof SerieTaylor) ? 1.0 : 2.0;
        double paso = 0.02;

        for (double x = inicio; x <= fin; x += paso) {
            double y = serie.calcular(x, terminos); 
            seriesData.getData().add(new XYChart.Data<>(x, y));
        }

        lineChart.getData().add(seriesData);
    }

    public static void main(String[] args) {
        launch(args);
    }
}