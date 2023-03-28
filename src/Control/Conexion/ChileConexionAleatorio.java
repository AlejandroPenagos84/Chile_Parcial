/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Conexion;

import Control.Logica.ChileLogica;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Alejandro Penagos
 */
public class ChileConexionAleatorio{

    private File archivo;
    private RandomAccessFile fl;
    private ChileLogica chile;
    private long tamreg;
    private long canreg;
    
    /**
     * Constructor
     * @param arch Archivo Aleatorio
     * @param ch Inyección de la clase ChileLogica para que este pueda hacer uso
     * del método mostrar
     */
    public ChileConexionAleatorio(File arch, ChileLogica ch) {
        this.chile = ch;
        this.tamreg = 232;
        this.canreg = 0;
        this.archivo = arch;
        getConexion();
    }
    
    /**
     * Realiza la conexión con el archivo Aleatorio
     */
    public void getConexion(){
        try {
            fl = new RandomAccessFile(archivo, "rw");
        }catch (FileNotFoundException e){
            
        }
    }
    
    /**
     *Valida la longitud de una cadena, si es corta, la rellena con espacios
     * si es larga, la corta según el tamaño especificado
     * @param m Cadena
     * @param num Tamaño
     * @return Cadena "Corregida"
     */
    public String ValidarString(String m, int num) {
        if (m.length() < num) {
            for (int i = m.length(); i < num; i++) {
                m += " ";
            }
        } else {
            m = m.substring(0, num);
        }
        return m;
    }
    
    /**
     * Escribe sobre el archivo un chile con sus respectivo atributos
     * @param name Nombre del Chile
     * @param colorX Color del chile
     * @param country Pais de donde viene el chile
     * @param category Categoria del chile
     * @param min Minimo Shu
     * @param max Maximo Shu
     * @param species Especie
     */
    public void EscribirArchivo(String name, String colorX, String country, String category, String min, String max, String species) {
        //Metodo de ingreso
        try {
                //Nombre
                String nombreA = ValidarString(name,20);
                
                //Metodo color
                String colorA = ValidarString(colorX,10);

                //Metodo pais
                String paisA = ValidarString(country,20);
                
                // Metodo minimo
                String escalaMinA = ValidarString(min,10);
               
                // Metodo maximo
                String escalaMaxA = ValidarString(max,10);
                
                // Metodo categoria
                String categoriaA = ValidarString(category,20);   

                // Metodo especie
                String speciesA = ValidarString(species,20);
               

                fl.writeChars(nombreA);
                fl.writeChars(colorA);
                fl.writeChars(paisA);
                fl.writeChars(escalaMinA);
                fl.writeChars(escalaMaxA);
                fl.writeChars(categoriaA);
                fl.writeChars(speciesA);

        } catch (IOException e) {
            chile.Mostrar("No se pudo encontrar el archivo");
        }
    }
}
