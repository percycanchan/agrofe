package ar.com.agromayor.Jasper.factura;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Vector;

import ar.com.agromayor.DB.factura.FacturaItems;
import ar.com.agromayor.factura.componentes.Items;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class ItemsFactory {
	static Collection<Object> collection = null;

	public void setItems(Collection<Object> pcollection){
		collection = pcollection;
	}
	
	
	//-----Metodos Para JasperReport
	public static Collection<Object> getColleccionGenerada(){
		generateCollection();
		return collection;
	}
	
	/**
     * Devuelve la Collection. Para iReport
     * @return
     */
	public static Collection<Object> getBeanCollection() {
		return collection;
	}
	
	/**
	 * Devuelve un DataSource. Se usa para cuando se pasa por parametro a un SubReporte
	 * @return
	 */
	public JRBeanCollectionDataSource getJRBeanCollectionDataSource() {
    	return new JRBeanCollectionDataSource(getBeanCollection());
    }
	
	public ItemsFactory getMe()
	{
		return this;
	}
	
	//Para testing
	public static void generateCollection(){
		collection = new Vector<Object>();
		
		for (int i = 0; i < 54; i++) {
			collection.add(  (new Items(getFactItemAleatoreo(i)))  );
		}
	}


	public static FacturaItems getFactItemAleatoreo(int i) {
		double randServ = Math.random();
		String serv;
		
		if (randServ >= 0 && randServ<= 0.1){
			serv = "Servico por conexion";
		} else if (randServ > 0.1 && randServ <= 0.3){
			serv = "Mantenimiento";
		} else if (randServ > 0.3 && randServ <= 0.5){
			serv = "Abono mensual";
		} else if (randServ > 0.5 && randServ <= 0.7){
			serv = "Adicional 1";
		} else if (randServ >= 0.7 && randServ <= 0.9){
			serv = "Adicionales de Instlacion";
		} else {
			serv = "Recargo por falta de pago";
		} 
		
		FacturaItems item1 = new FacturaItems();
		
		item1.setDetCodProd(String.valueOf(i));
		item1.setDetDescripcion(String.valueOf( Math.random()*100).substring(0, 3).replace(".", "")+" - "+serv);
		item1.setDetCantidad( ((Integer)((Double)(Math.random()*10)).intValue()).toString());
		
		item1.setDetPrecioUnitario( (BigDecimal.valueOf(Math.random()*100)) );
		item1.setDetSubTotal((BigDecimal.valueOf(Math.random()*100)) );
		
		return item1;
	}
	
}
