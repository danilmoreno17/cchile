
package comercial.chile;

import java.io.IOException;

import comercial.chile.vista.OpcionesController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class COMERCIALCHILE extends Application {

	private Stage primaryStage;
	
	private BorderPane layoutRaiz;
	@FXML
	private ListView<String> lvOpcionPrincipal;
	private ObservableList<String> opciones = FXCollections.observableArrayList();
	
	public COMERCIALCHILE() {
		opciones.add("Reporte de Armados");
		opciones.add("Calculo Horas Extras");
	}
	
	public ObservableList<String> getOpcion(){
		return opciones;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("COMERCIAL CHILE");
		inicio();		
		mostrarOpciones();
	}

	private void inicio() {
		try {
			layoutRaiz = FXMLLoader.load(getClass().getResource("vista/ComercialChile.fxml"));
			Scene scene = new Scene(layoutRaiz);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarOpciones() {
        try {
        	FXMLLoader loader = new FXMLLoader(COMERCIALCHILE.class.getResource("vista/Opciones.fxml"));           
        	AnchorPane apOpciones = (AnchorPane)loader.load();
        	
        	
        	OpcionesController controlador = loader.getController();        	
            controlador.setCOMERCIALCHILE(this);
            layoutRaiz.setCenter(apOpciones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
