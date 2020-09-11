package comercial.chile.reportes;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

import comercial.chile.modelo.clsArmados;

public class clsVisorReporte extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public void mostrarReporte(ArrayList<clsArmados> colArmado) throws JRException {		
		
		//File f = new File("src/comercial/chile/reportes/MainArmados.jasper");
		InputStream in = getClass().getResourceAsStream("/comercial/chile/reportes/MainArmados.jasper");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(in);
		//JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(f.getAbsolutePath());
		// Fields for report
        
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        
        for(clsArmados armado : colArmado) {
        	HashMap<String, Object> parameters = new HashMap<String, Object>();
        	parameters.put("strNumeracion1", armado.getStrNumeracion1());
        	parameters.put("strNumeracion2", armado.getStrNumeracion2());
        	parameters.put("strLocal", armado.getStrLocal());
        	list.add(parameters);        	 
        }       
        
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, null, beanColDataSource);
        
        JRViewer viewer = new JRViewer(print);
        viewer.setOpaque(true);
        viewer.setVisible(true);
        this.add(viewer);
        this.setSize(700, 500);
        this.setVisible(true);
        System.out.print("Done!");
	}
}
