package comercial.chile.vista;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JRException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import comercial.chile.modelo.clsArmados;
import comercial.chile.modelo.clsUtil;
import comercial.chile.reportes.clsVisorReporte;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;

public class ArmadosController {
	
	@FXML
	private ComboBox<String> cbLocal;
	
	@FXML
	private TextField tfDesde;
	
	@FXML
	private TextField tfHasta;
	
	@FXML
	private Button btnGenerar;
	
	
	public ArmadosController() {
		
	}
	
	@FXML
	private void initialize() {
		cbLocal.setItems(FXCollections.observableArrayList("CHILE 1","CHILE 2","CHILE 4"));
		cbLocal.getSelectionModel().selectFirst();
		tfDesde.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				if (!arg2.matches("\\d*")) {
					tfDesde.setText(arg2.replaceAll("[^\\d]", ""));
		        }
			}    
		});
		tfHasta.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				if (!arg2.matches("\\d*")) {
					tfHasta.setText(arg2.replaceAll("[^\\d]", ""));
		        }
			}    
		});
	}
	
	@FXML
	private void GenerarArmados() {
		
		try {
			int intInicio, intFin, intDiferencia, intAnio, intMes;
			Date fechaActual = new Date();
			LocalDate localDate = fechaActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			ArrayList<clsArmados> colArmado = new ArrayList<clsArmados>();
			intInicio = Integer.parseInt(tfDesde.getText().toString());
			intFin = Integer.parseInt(tfHasta.getText().toString());
			intDiferencia = intFin - intInicio + 1;
			intAnio = localDate.getYear();
			intMes = localDate.getMonthValue();
			for(int i=0; i<=intDiferencia; i++) {
				clsArmados armado = new clsArmados();
				armado.setStrLocal(cbLocal.getSelectionModel().getSelectedItem().toString());
				armado.setStrNumeracion1("#"+intAnio+" - "+clsUtil.completarCeros(2, ""+intMes)+" - "+clsUtil.completarCeros(5, ""+(i+intInicio)));
				i++;
				armado.setStrNumeracion2("#"+intAnio+" - "+clsUtil.completarCeros(2, ""+intMes)+" - "+clsUtil.completarCeros(5, ""+(i+intInicio)));
				colArmado.add(armado);
			}
            new clsVisorReporte().mostrarReporte(colArmado);
        } catch (JRException e1) {
            e1.printStackTrace();
        }

	}
}
