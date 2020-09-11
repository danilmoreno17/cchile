package comercial.chile.vista;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import comercial.chile.COMERCIALCHILE;
import comercial.chile.modelo.clsEmpleado;
import comercial.chile.modelo.clsRegistroMarcacion;
import comercial.chile.modelo.clsRubroTC;
import groovyjarjarcommonscli.ParseException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

public class HorasExtrasController {

	@FXML
	private Button btnFCReporteDobra;
	@FXML
	private Button btnFCEstadoCuenta;
	
	@FXML
	private Label lblNAReporteDobra;
	@FXML
	private Label lblNAEstadoCuenta;
	
	@FXML
	private Label lblAviso;
	
	@FXML
	private TableView tvHoraFaltante;
	
	@FXML
	private Button btnCalcular;
	
	private COMERCIALCHILE comercialChile;
	
	public HorasExtrasController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void Calcular() {
		
	}
	
	@FXML
	private void BuscadorRD() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(this.comercialChile.getPrimaryStage());
        if (file != null) {
           lblNAReporteDobra.setText(file.getName());
           readExcelFile(file);
        }
	}
	
	@FXML
	private void BuscadorEC() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(this.comercialChile.getPrimaryStage());
        if (file != null) {
           lblNAEstadoCuenta.setText(file.getName());
           readExcelFile(file);
        }
	}
	
	private void readExcelFile(File file) {
        try {
            // get excel workbook
            Workbook workbook = WorkbookFactory.create(file);
            // get excel sheet
            Sheet sheet = workbook.getSheetAt(0);
           
           readSheet(sheet);             
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
    }
	
    private void readSheet(Sheet sheet) throws ParseException{
        Iterator<Row> rowItr = sheet.iterator();
        List<clsRubroTC> colRubroTc = new ArrayList<clsRubroTC>();
        String strBanco = "";              
        while(rowItr.hasNext()) {
            clsRubroTC rubroTc = new clsRubroTC();
        	Row row = rowItr.next();
            if(row.getRowNum() == 0) {
                continue;
            }                  
            String Det = (String)getValueFromCell(row.getCell(5));          
            if(Det.toUpperCase().contains("BANCO")) {
            	strBanco = Det;
            }
            if(Det.toUpperCase().contains("TC-LOTE")) {
                String det[] = Det.split(" ");
                rubroTc.setStrLote(det[3]);
                rubroTc.setStrFecha(det[6]);
                rubroTc.setStrValorDobra(((Double)getValueFromCell(row.getCell(7))).toString());
                rubroTc.setStrBanco(strBanco);
                colRubroTc.add(rubroTc);
            }
        }                
    }
	
	    
    private Object getValueFromCell(Cell cell) {
    	CellType celltp = cell.getCellType();
        switch(cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                }
                return cell.getNumericCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";                                
        }
    }
	  
    private void setRegistroFecha(Cell cell, clsRegistroMarcacion registro) {
    	String strFecha = (String)getValueFromCell(cell);
    	String strSplitFecha[] = strFecha.split("/"); 
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strSplitFecha[0]));
    	cal.set(Calendar.MONTH, Integer.parseInt(strSplitFecha[1]));
    	cal.set(Calendar.YEAR, Integer.parseInt(strSplitFecha[2]));
    	cal.set(Calendar.HOUR_OF_DAY, 0);
    	cal.set(Calendar.MINUTE, 0);
    	cal.set(Calendar.SECOND, 0);
    	registro.setDtFechaHoraEntrada(cal.getTime());
    	registro.setDtFechaHoraSalida(cal.getTime());
    }
    
    private void setRegistroHoraEntrada(Cell cell, clsRegistroMarcacion registro) {
    	Date dtHoraMarcacion = (Date)getValueFromCell(cell);
    	Calendar calCell = Calendar.getInstance();
    	calCell.setTime(dtHoraMarcacion);
    	Calendar calRegistro = Calendar.getInstance();
    	calRegistro.setTime(registro.getDtFechaHoraEntrada());
    	calRegistro.set(Calendar.HOUR_OF_DAY, calCell.get(Calendar.HOUR_OF_DAY));
    	calRegistro.set(Calendar.MINUTE, calCell.get(Calendar.MINUTE));
    	calRegistro.set(Calendar.SECOND, calCell.get(Calendar.SECOND));
    	registro.setDtFechaHoraEntrada(calRegistro.getTime());
    }
    
    private void setRegistroHoraSalida(Cell cell, clsRegistroMarcacion registro) {
    	Date dtHoraMarcacion = (Date)getValueFromCell(cell);
    	Calendar calCell = Calendar.getInstance();
    	calCell.setTime(dtHoraMarcacion);
    	Calendar calRegistro = Calendar.getInstance();
    	calRegistro.setTime(registro.getDtFechaHoraSalida());
    	calRegistro.set(Calendar.HOUR_OF_DAY, calCell.get(Calendar.HOUR_OF_DAY));
    	calRegistro.set(Calendar.MINUTE, calCell.get(Calendar.MINUTE));
    	calRegistro.set(Calendar.SECOND, calCell.get(Calendar.SECOND));
    	registro.setDtFechaHoraSalida(calRegistro.getTime());
    }
    
	public void setComercialChile(COMERCIALCHILE pComercialChile) {
		 this.comercialChile = pComercialChile;
	}
}
