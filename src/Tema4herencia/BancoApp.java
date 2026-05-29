package Tema4herencia;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class BancoApp extends Application {

    // Lista en memoria para gestionar las cuentas durante la ejecución
    private List<CuentaHabiente> listaCuentas;
    
    // Elementos visuales que necesitamos actualizar constantemente
    private ComboBox<String> comboCuentas;
    private ObservableList<String> itemsCombo;
    private Label lblDetallesCuenta;
    private Label lblSaldoActual;

    @Override
    public void start(Stage primaryStage) {

        listaCuentas = GestorArchivos.cargarCuentas();
        itemsCombo = FXCollections.observableArrayList();
        actualizarCombo();

        primaryStage.setTitle("Sistema Bancario - MiBanco");

        VBox seccionCrear = new VBox(10);
        seccionCrear.setPadding(new Insets(15));
        seccionCrear.setStyle("-fx-border-color: #ccc; -fx-border-radius: 5; -fx-background-color: #f9f9f9;");
        
        Label lblTituloCrear = new Label("Crear Nueva Cuenta");
        lblTituloCrear.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        
        TextField txtNuevoNumero = new TextField();
        txtNuevoNumero.setPromptText("Número de Cuenta (ej: 12345)");
        
        TextField txtNuevoSaldo = new TextField();
        txtNuevoSaldo.setPromptText("Saldo Inicial ($)");
        
        ComboBox<String> comboTipoNuevo = new ComboBox<>();
        comboTipoNuevo.getItems().addAll("Básico", "Nómina");
        comboTipoNuevo.setValue("Básico");
        
        Button btnCrear = new Button("Registrar Cuenta");
        btnCrear.setMaxWidth(Double.MAX_VALUE);

        seccionCrear.getChildren().addAll(lblTituloCrear, txtNuevoNumero, txtNuevoSaldo, comboTipoNuevo, btnCrear);

        VBox seccionOperar = new VBox(10);
        seccionOperar.setPadding(new Insets(15));
        seccionOperar.setStyle("-fx-border-color: #ccc; -fx-border-radius: 5; -fx-background-color: #f4f4f4;");
        
        Label lblTituloOperar = new Label("Operaciones de Cuenta");
        lblTituloOperar.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        
        comboCuentas = new ComboBox<>(itemsCombo);
        comboCuentas.setPromptText("--- Selecciona una Cuenta ---");
        comboCuentas.setMaxWidth(Double.MAX_VALUE);
        
        lblDetallesCuenta = new Label("Cuenta: Ninguna seleccionada");
        lblSaldoActual = new Label("Saldo: $0.00");
        lblSaldoActual.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: green;");
        
        TextField txtMonto = new TextField();
        txtMonto.setPromptText("Monto para Transacción ($)");
        
        HBox botonesTransaccion = new HBox(10);
        Button btnDepositar = new Button("Depositar");
        Button btnRetirar = new Button("Retirar");
        btnDepositar.setPrefWidth(120);
        btnRetirar.setPrefWidth(120);
        botonesTransaccion.getChildren().addAll(btnDepositar, btnRetirar);
        botonesTransaccion.setAlignment(Pos.CENTER);

        seccionOperar.getChildren().addAll(lblTituloOperar, comboCuentas, lblDetallesCuenta, lblSaldoActual, txtMonto, botonesTransaccion);

        HBox root = new HBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(seccionCrear, seccionOperar);

        btnCrear.setOnAction(e -> {
            try {
                String numero = txtNuevoNumero.getText().trim();
                double saldo = Double.parseDouble(txtNuevoSaldo.getText());
                String tipo = comboTipoNuevo.getValue();

                if (numero.isEmpty()) {
                    mostrarAlerta("Error", "El número de cuenta no puede estar vacío.");
                    return;
                }

                CuentaHabiente nuevaCuenta;

                if (tipo.equals("Básico")) {
                    nuevaCuenta = new CuentaHabienteBasico(numero, saldo);
                } else {
                    nuevaCuenta = new CuentaHabienteNomina(numero, saldo);
                }

                listaCuentas.add(nuevaCuenta);
                actualizarCombo();

                GestorArchivos.registrarTransaccion(numero, "APERTURA (" + tipo + ")", saldo, saldo);

                txtNuevoNumero.clear();
                txtNuevoSaldo.clear();
                mostrarAlerta("Éxito", "Cuenta creada exitosamente.");
            } catch (NumberFormatException ex) {
                mostrarAlerta("Error", "Por favor ingresa un saldo inicial válido (número).");
            }
        });

        comboCuentas.setOnAction(e -> {
            int index = comboCuentas.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                CuentaHabiente seleccionada = listaCuentas.get(index);
                lblDetallesCuenta.setText("Cuenta: " + seleccionada.getNumeroDeCuenta() + " [" + seleccionada.getTipoDeCuenta() + "]");
                lblSaldoActual.setText("Saldo: $" + seleccionada.getSaldo());
            }
        });

        btnDepositar.setOnAction(e -> {
            int index = comboCuentas.getSelectionModel().getSelectedIndex();
            if (index < 0) {
                mostrarAlerta("Error", "Selecciona una cuenta primero.");
                return;
            }
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                CuentaHabiente cuenta = listaCuentas.get(index);

                if (cuenta.depositar(monto)) {
                    lblSaldoActual.setText("Saldo: $" + cuenta.getSaldo());

                    GestorArchivos.registrarTransaccion(cuenta.getNumeroDeCuenta(), "DEPOSITO", monto, cuenta.getSaldo());
                    txtMonto.clear();
                } else {
                    mostrarAlerta("Error", "El monto debe ser mayor a 0.");
                }
            } catch (NumberFormatException ex) {
                mostrarAlerta("Error", "Ingresa un monto numérico válido.");
            }
        });

        btnRetirar.setOnAction(e -> {
            int index = comboCuentas.getSelectionModel().getSelectedIndex();
            if (index < 0) {
                mostrarAlerta("Error", "Selecciona una cuenta primero.");
                return;
            }
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                CuentaHabiente cuenta = listaCuentas.get(index);
                
                if (cuenta.retiro(monto)) {
                    lblSaldoActual.setText("Saldo: $" + cuenta.getSaldo());

                    GestorArchivos.registrarTransaccion(cuenta.getNumeroDeCuenta(), "RETIRO", monto, cuenta.getSaldo());
                    txtMonto.clear();
                } else {
                    mostrarAlerta("Error", "Fondos insuficientes o monto inválido.");
                }
            } catch (NumberFormatException ex) {
                mostrarAlerta("Error", "Ingresa un monto numérico válido.");
            }
        });

        primaryStage.setOnCloseRequest(e -> {
            GestorArchivos.guardarCuentas(listaCuentas);
            System.out.println("Datos guardados en MiBanco.db de forma segura.");
        });

        Scene scene = new Scene(root, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void actualizarCombo() {
        itemsCombo.clear();
        for (CuentaHabiente c : listaCuentas) {
            itemsCombo.add(c.getNumeroDeCuenta() + " (" + c.getTipoDeCuenta().trim() + ")");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}