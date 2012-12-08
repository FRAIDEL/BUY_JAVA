//IMPORTAMOS COMPLENTO JAVA UTIL
import java.util.*;

/*
 * NOMBRE DE LA CLASE : Calendario.java
 * AUTORES : Fidel Jose Villero y Blanca Bertha Torres.
 * FECHA CREACION :
 * FECHA MODIFICACION : 20-Mayo-2010.
 * DESCRIPCION : Brida informacion de la fecha Actual .
 * PARAMETROS : 
 *
 */

 class Calendario  {
  
      Calendar calendario;
      int dayOfWeek; 
      int days;      
  	 
  public Calendario() {
      calendario = new GregorianCalendar();
  }
  
  public void mostar(int ano,int mes ){
     //2006    a�o   4 es el mes menos uno y 11 el dia
     calendario.set(ano,mes,1);  
     dayOfWeek = calendario.get( Calendar.DAY_OF_WEEK );
     days = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
     System.out.println("el numero de dias del mes es : "+days);
  }
  
    public int  getDayOfWeek(){
        return dayOfWeek;
    }
  
    public int getDays(){
        return days;
    }
}	