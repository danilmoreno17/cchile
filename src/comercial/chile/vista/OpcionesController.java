package comercial.chile.vista;

import java.io.IOException;

import comercial.chile.COMERCIALCHILE;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class OpcionesController {
	
	@FXML
	private ListView<String> lvOpciones;
	
	@FXML
	private AnchorPane apVentana;
	
	private COMERCIALCHILE comercialChile;
	
	public OpcionesController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
    public void setCOMERCIALCHILE(COMERCIALCHILE pComercialChile) {
        this.comercialChile = pComercialChile;
        
        lvOpciones.setItems(comercialChile.getOpcion());
        lvOpciones.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					FXMLLoader loader = new FXMLLoader();
					BorderPane bpArmados = new BorderPane();
					if(arg2.equals("Reporte de Armados")) {
						loader = new FXMLLoader(COMERCIALCHILE.class.getResource("vista/Armados.fxml"));           			        
						bpArmados = (BorderPane)loader.load();
					}
					if(arg2.equals("Calculo Horas Extras")) {
						loader = new FXMLLoader(COMERCIALCHILE.class.getResource("vista/HorasExtras.fxml"));           			        
						bpArmados = (BorderPane)loader.load();
						HorasExtrasController controlador = loader.getController();
						controlador.setComercialChile(comercialChile);
					}
								
					apVentana.getChildren().add(bpArmados);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
        });
        
    }
    
}
