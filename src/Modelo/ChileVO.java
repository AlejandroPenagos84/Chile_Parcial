/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alejandro Penagos
 */
public class ChileVO extends ProductoVO{

    private String color;
    private String pais;
    private String categoria;
    private String minShu;
    private String maxShu;
    private String especie;

    @Override
    public String getColor() {
        return color;
    }
    
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String getPais() {
        return pais;
    }
    
    @Override
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    @Override
    public String getCategoria() {
        return categoria;
    }
    
    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String getMinShu() {
        return minShu;
    }
    
    @Override
    public void setMinShu(String minShu) {
        this.minShu = minShu;
    }
    
    @Override
    public String getMaxShu() {
        return maxShu;
    }
    
    @Override
    public void setMaxShu(String maxShu) {
        this.maxShu = maxShu;
    }
    
    @Override
    public String getEspecie() {
        return especie;
    }
    
    @Override
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    
    
}
