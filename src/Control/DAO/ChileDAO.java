/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import Control.Conexion.ChileConexionBD;
import Control.Logica.ChileLogica;
/**
 *
 * @author Alejandro Penagos
 */
public class ChileDAO {
    
    private ChileLogica chile;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    /**
     * Constructor 
     * @param ch Inyección de la clase ChileLogica para que este pueda hacer uso
     *de los métodos CrearChiles y ListaChilesMostrar para poder enviarle a la 
     * clase ChileLogica los chiles
     */
    public ChileDAO(ChileLogica ch) {
        con = null;
        st = null;
        rs = null;
        this.chile = ch;
    }
    
    /**
     * Inserta un chile dentro de la base de datos
     * @param Nombre Nombre del Chile
     * @param Color Color del Chile
     * @param Pais Pais de Origen del Chile
     * @param Categoria Indica el nivel de picante
     * @param minShu Scoville Scale. Rango minimo del chile
     * @param maxShu Scoville Scale. Rango minimo del chile
     * @param Especie Especie del chile
     */
    public void InsertarChile(String Nombre, String Color, String Pais, String Categoria, String minShu, String maxShu, String Especie){
        try{
            con = ChileConexionBD.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO APP.CHILES VALUES('" +Nombre + "','" + Color+ "','"+Pais  + "','"+ Categoria + "','"+ minShu + "','"+maxShu+"','"+ Especie + "')";
            st.executeUpdate(insercion);
            st.close();
            ChileConexionBD.desconectar();
        }catch(SQLException ex){
            chile.Mostrar("No se pudo insertar el chile");
        }
    }
    
    /**
     * Saca todos los datos almacenados en la tabla chile y usando la inyección de dependencias
     * se hace uso del método "ListaChilesMostrar" para agregar todos los elementos dentro de la 
     * listaChiles2
     */
    public void ConsultarDatosTodos(){
        String consulta = "SELECT * FROM App.CHILES";
        try{
            con = (Connection) ChileConexionBD.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            
            while(rs.next()){
                chile.ListaChilesMostrar(rs.getString("nombre"), 
                                  rs.getString("color"), 
                                 rs.getString("pais"), 
                               rs.getString("categoria"), 
                                 rs.getString("minShu"), 
                                 rs.getString("maxShu"),
                                rs.getString("especie"));
                
            }
            ChileConexionBD.desconectar();
        }catch(SQLException ex){
            chile.Mostrar("No se pudo mostrar los chiles");
        }
        
    }
    
    /**
     * Se saca solo un dato de la base de datos con el nombre que el usuario haya seleccionado.
     * Se hace uso de la inyección de dependencias crear un Chile y mostrar todos los datos
     * Se crea un  nuevo objeto porque es más dificil usar los datos ya almacenados en la lista =D
     * El objeto es un objeto auxiliar 
     * @param nombre Nombre del Chile que se va a consultar
     */
    public void ConsultarDatos(String nombre){
        String consulta = "SELECT * FROM App.CHILES where nombre='" + nombre + "'";
        try{
            con = (Connection) ChileConexionBD.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            
            if(rs.next()){
                chile.CrearChile(rs.getString("nombre"), 
                                  rs.getString("color"), 
                                 rs.getString("pais"), 
                               rs.getString("categoria"), 
                                 rs.getString("minShu"), 
                                 rs.getString("maxShu"),
                                rs.getString("especie"));
                
            }
            ChileConexionBD.desconectar();
        }catch(SQLException ex){
            chile.Mostrar("No se pudo mostrar el chile");
        }  
    }
    
    /**
     * Elimina un chile de la base de datos y del la lista listaChiles2
     * @param Nombre Nombre del Chile que se va a eliminar
     */
    public void Eliminar(String Nombre){
        String eliminar = "DELETE FROM App.Chiles where nombre='"+Nombre+"'";
        try{
            con = (Connection) ChileConexionBD.getConexion();
            st = con.createStatement();
            st.executeUpdate(eliminar);
            st.close();
            chile.Eliminar(Nombre);
            ChileConexionBD.desconectar();
            
        }catch(SQLException ex){
            chile.Mostrar("No se pudo eliminar el chile");
        }
    }
    
    /**
     * Modifica en la tabla Chile el nombre de un chile
     * @param NombreAnterior Nombre que va a modificar
     * @param NombreActual Nuevo nombre
     */
    public void Modificar(String NombreAnterior, String NombreActual){
        String modificar = "UPDATE App.CHILES SET nombre = '"+NombreActual+"' WHERE nombre = '"+NombreAnterior+"'";
        try{
            con = (Connection) ChileConexionBD.getConexion();
            st = con.createStatement();
            st.executeUpdate(modificar);
            st.close();
            ChileConexionBD.desconectar();
            chile.ModificarLista(NombreAnterior, NombreActual);
        }catch(SQLException ex){
            chile.Mostrar("No se pudo modificar el chile");
        }
    }
    
    /**
     * Selecciona la categoria que especifico el usuario a través de un código
     * @param num Código
     * @return Categoria
     */
    public String ConsultarCategoria(String num){
        String category = null;
        String consulta = "SELECT CATEGORIA FROM App.CATEGORIAS WHERE CODIGO = '" +num+ "'";
        try{
            con = (Connection) ChileConexionBD.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if(rs.next()) { // Mover el cursor al primer registro
                category = rs.getString("CATEGORIA"); // Obtener el valor de la columna "CATEGORIA"
            }
            ChileConexionBD.desconectar();
        }catch(SQLException ex){
            chile.Mostrar("No se pudo mostrar la categoria");
        }  
        return category;
    }
    
    /**
     * Selecciona la especie que especifico el usuario
     * @param especies Especie
     * @return Especie
     */
    public String ConsultarEspecie(String especies){
        String specie = null;
        String consulta = "SELECT * FROM App.ESPECIES WHERE especie = '" +especies+ "'";
        try{
            con = (Connection) ChileConexionBD.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if(rs.next()) { 
                specie = rs.getString("especie");
            }
            ChileConexionBD.desconectar();
        }catch(SQLException ex){
            chile.Mostrar("No se pudo mostrar especie");
        }  
        
        return specie;
    }
    
    
}
