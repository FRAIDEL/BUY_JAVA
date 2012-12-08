 import java.util.*;
 import java.text.*;

 public class Fecha{
	Date fecha=new Date();
	String fechasistema;
	String horasistema;
	String horasistemamili;
	SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
	public Fecha(){
		fechasistema=formato.format(fecha);
	}
	
	
}