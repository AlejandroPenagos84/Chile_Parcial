/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Conexion;

/**
 *
 * @author Alejandro Penagos
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import Control.Logica.ChileLogica;

public class ChileProperties{
    private Properties propiedades;
    private InputStream entrada;
    private ChileLogica c;
    
    
    /**
     * Constructor
     * @param ch Inyección de la clase ChileLogica para que este pueda hacer uso
     * del método mostrar
     */
    public ChileProperties(ChileLogica ch) {
        this.c = ch;
        propiedades = new Properties();
        entrada = null;
        getConexion();
    }
    
    /**
     * Hace la conexión con el archivo de propiedades
     */
    public void getConexion() {
        try {
            entrada = new FileInputStream("docs/chile.properties");
            propiedades.load(entrada);

        } catch (IOException e) {
            c.Mostrar("No se puedo mostrar el mensaje");
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    c.Mostrar("El archivo está vacio");
                }
            }

        }
    }
     /**
      * Lee el Nombre del un chile donde su número se indica con la variable i
      * @param i Número del chile
      * @return Nombre del chile
      */
    public String Nombre(int i) {
        return propiedades.getProperty("chile" + i + ".nombre");
    }
    
    /**
      * Lee el color del un chile donde su número se indica con la variable i
      * @param i Número del chile
      * @return Color del chile
      */
    public String Color(int i) {
        return propiedades.getProperty("chile" + i + ".color");
    }
    
    /**
      * Lee el pais de donde viene un chile donde su número se indica con la variable i
      * @param i Número del chile
      * @return Pais donde viene el chile
      */
    public String Pais(int i) {
        return propiedades.getProperty("chile" + i + ".pais");
    }
    
    /**
      * Lee la categoria de  un chile donde su número se indica con la variable i
      * @param i Número del chile
      * @return Categoria del chile
      */
    public String Categoria(int i) {
        return propiedades.getProperty("chile" + i + ".categoria");
    }
    
    /**
      * Lee el minShu un chile donde su número se indica con la variable i
      * @param i Número del chile
      * @return minShu del chile
      */
    public String minShu(int i) {
        return propiedades.getProperty("chile" + i + ".minimoshu");
    }
    
    /**
      * Lee el maxShu un chile donde su número se indica con la variable i
      * @param i Número del chile
      * @return maxShu del chile
      */
    public String maxShu(int i) {
        return propiedades.getProperty("chile" + i + ".maximoshu");
    }
    
    /**
      * Lee la especie de  un chile donde su número se indica con la variable i
      * @param i Número del chile
      * @return Especie del chile
      */
    public String Especie(int i) {
        return propiedades.getProperty("chile" + i + ".especie");
    }
    
    /**
     * Devuelve el número total de chiles registrados
     * @return Número de chiles
     */
    public int NumChiles() {
        return propiedades.size() / 7;
    }

}
