/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alejandro Penagos
 */
public abstract class ProductoVO {
    private String nombre;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract String getColor();

    public abstract void setColor(String color);

    public abstract String getPais();

    public abstract void setPais(String pais);

    public abstract String getCategoria();

    public abstract void setCategoria(String categoria);

    public abstract String getMinShu();

    public abstract void setMinShu(String minShu);

    public abstract String getMaxShu();

    public abstract void setMaxShu(String maxShu);

    public abstract String getEspecie();

    public abstract void setEspecie(String especie);
}
