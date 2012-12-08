//IMPORTAMOS COMPLEMENTOS JAVA PARA ACCEDER A LA CONEXION DE LA BASE DE DATOS
import java.sql.*;


/*
 * NOMBRE DE LA CLASE : AsignarHorarios.
 * AUTORES : Fidel Jose Villero y Blanca Bertha Torres.
 * FECHA CREACION :
 * FECHA MODIFICACION : 18-Mayo-2010.
 * DESCRIPCION : Permite la coneccion con la base de datos .
 * PARAMETROS : 
 *
 */

public class ConectorMySQL {

  //** Declaracion de variables
  public Connection conexion;
  protected Statement  sentencia;
  protected Statement sentenciaEspecial;

  //** Este constructor recibe como parametros el nombre del servidor
  //** el nombre de la base de datos, un usuario autorizado y el password
  public ConectorMySQL(String servidorNombre, String nombreBD, String usuario,String password) throws Exception{

           //** Se carga el driver para conectarse a la base de datos
           try{
               Class.forName("com.mysql.jdbc.Driver").newInstance();
              }catch  (Exception e) {
                System.out.println("Error" + e.toString());
               }


    // Se conecta a la base de datos
    // Se crea un URL hacia la maquina y la base de datos
    String url = "jdbc:mysql://" + servidorNombre + "/" + nombreBD;
    //**se crea la conexion a la base de datos
    conexion = DriverManager.getConnection(url,usuario,password);
    sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    sentenciaEspecial = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
  }
  //***********************************************************************

   public void ejecutaSentencia(String sentenciaSQL) throws Exception {
            // Se ejecutan las sentencias DML que llegan como parametro
            sentencia.execute(sentenciaSQL);
  }

  //***********************************************************************

  public ResultSet buscarRegistro (String sentenciaSQL) throws Exception {
          // Se hace la busqueda del registro en la B.D
          ResultSet resultado = sentencia.executeQuery(sentenciaSQL);
          return resultado;
  }
  //***********************************************************************
}
