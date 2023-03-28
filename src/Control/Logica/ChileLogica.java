/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Logica;

import Modelo.ChileVO;
import Control.Conexion.*;
import Control.DAO.ChileDAO;
import Modelo.ProductoVO;
import Vista.Consultar;
import Vista.Ingresar;
import Vista.Menu;
import Vista.Modificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Penagos
 */
public class ChileLogica implements ActionListener {

    private ChileDAO chileDao;
    private ChileProperties chileProp;
    private ArrayList<ProductoVO> listaChiles1;
    private ArrayList<ProductoVO> listaChiles2;
    private ArrayList<String> Nombres;
    private ChileConexionAleatorio chileAle;
    private ProductoVO chile;//Sustitución de liskov
    private Ingresar ingresar;
    private Consultar consultar;
    private Menu menu;
    private Modificar modificar;

    public ChileLogica() {
        chileProp = new ChileProperties(this);//Se hace la inyección
        listaChiles1 = new ArrayList<ProductoVO>();
        listaChiles2 = new ArrayList<ProductoVO>();
        Nombres = new ArrayList<String>();
        chileDao = new ChileDAO(this);//Se hace la inyección

        ingresar = new Ingresar();
        consultar = new Consultar();
        menu = new Menu();
        modificar = new Modificar();
        chile = new ChileVO();//Sustitución de liskov

        this.menu.Bttoningresar.addActionListener(this);
        this.menu.Bttonconsulta.addActionListener(this);
        this.menu.Bttonsalir.addActionListener(this);
        this.menu.btnArchivo.addActionListener(this);
        this.ingresar.Bttonguardar.addActionListener(this);
        this.ingresar.Bttonsalir.addActionListener(this);
        this.ingresar.BttonSannuum.addActionListener(this);
        this.ingresar.BttonSbaccatum.addActionListener(this);
        this.ingresar.BttonSchinense.addActionListener(this);
        this.ingresar.BttonSfrutescens.addActionListener(this);
        this.ingresar.BttonSpubescens.addActionListener(this);
        this.ingresar.BttonSrhomboideum.addActionListener(this);

        this.consultar.Bttonconsulta.addActionListener(this);
        this.consultar.Bttonlimpiar.addActionListener(this);
        this.consultar.Bttonmodificar.addActionListener(this);
        this.consultar.btnEliminar.addActionListener(this);
        this.consultar.btnSalir.addActionListener(this);
        this.modificar.Bttonmodificar.addActionListener(this);

        InsercionInicial(ChilesIniciales());
        Iniciar();
    }
    
    /**
     * Metodo para iniciar el aplicativo
     */
    public void Iniciar() {
        this.menu.setVisible(true);
        this.menu.setTitle("Scoville APP");
        this.menu.setLocationRelativeTo(null);
    }

    /**
     * Método para crear datos tipo Chile
     *
     * @param Nombre Nombre del Chile
     * @param Color Color del Chile
     * @param Pais Pais de Origen del Chile
     * @param Categoria Indica el nivel de picante
     * @param minShu Scoville Scale. Rango minimo del chile
     * @param maxShu Scoville Scale. Rango minimo del chile
     * @param Especie Especie del chile
     * @return Chile
     */
    public ProductoVO CrearChile(String Nombre, String Color, String Pais, String Categoria, String minShu, String maxShu, String Especie) {
        chile = new ChileVO();
        chile.setNombre(Nombre);
        chile.setColor(Color);
        chile.setPais(Pais);
        chile.setCategoria(Categoria);
        chile.setMinShu(minShu);
        chile.setMaxShu(maxShu);
        chile.setEspecie(Especie);
        return chile;
    }

    /**
     * Crea una lista solamente con los datos del properties
     *
     * @return Chiles Iniciales
     */
    public ArrayList<ProductoVO> ChilesIniciales() {
        for (int i = 1; i <= chileProp.NumChiles(); i++) {
            ProductoVO aux = CrearChile(chileProp.Nombre(i), chileProp.Color(i), chileProp.Pais(i), chileProp.Categoria(i), chileProp.minShu(i), chileProp.maxShu(i), chileProp.Especie(i));
            listaChiles1.add(aux);
        }
        return listaChiles1;
    }

    /**
     * Con la listaChile1 se mandan los datos al método InsertarChile de la
     * clase ChileDAO para meter los datos dentro de la base datos
     *
     * @param list listaChile1
     */
    public void InsercionInicial(ArrayList<ProductoVO> list) {
        for (int i = 0; i < list.size(); i++) {
            chileDao.InsertarChile(listaChiles1.get(i).getNombre(), listaChiles1.get(i).getColor(), listaChiles1.get(i).getPais(), listaChiles1.get(i).getCategoria(), listaChiles1.get(i).getMinShu(), listaChiles1.get(i).getMaxShu(), listaChiles1.get(i).getEspecie());
        }
    }

    /**
     * Crea una lista con los datos que se encuentran en la base de datos
     *
     * @param Nombre Nombre del Chile
     * @param Color Color del Chile
     * @param Pais Pais de Origen del Chile
     * @param Categoria Indica el nivel de picante
     * @param minShu Scoville Scale. Rango minimo del chile
     * @param maxShu Scoville Scale. Rango minimo del chile
     * @param Especie Especie del chile
     * @return
     */
    public ArrayList<ProductoVO> ListaChilesMostrar(String Nombre, String Color, String Pais, String Categoria, String minShu, String maxShu, String Especie) {
        boolean estado = false;
        if (!listaChiles2.isEmpty()) {
            for (ProductoVO ch : listaChiles2) {
                if (ch.getNombre().equals(Nombre)) {
                    estado = true;
                    break;
                }
            }
        }

        if (!estado) {
            chile = CrearChile(Nombre, Color, Pais, Categoria, minShu, maxShu, Especie);
            listaChiles2.add(chile);
        }

        return listaChiles2;
    }

    /**
     * Elimina un chile de la listaChile2, para ello usa el nombre como
     * parametro
     *
     * @param Nombre Nombre del Chile que se va a eliminar
     * @return
     */
    public ArrayList<ProductoVO> Eliminar(String Nombre) {
        boolean estado = false;
        int indice = 0;
        if (!listaChiles2.isEmpty()) {
            for (int i = 0; i < listaChiles2.size(); i++) {
                if (listaChiles2.get(i).getNombre().equals(Nombre)) {
                    estado = true;
                    indice = i;
                }
            }
        }

        if (estado) {
            listaChiles2.remove(indice);
            NombresEliminar(indice);

        }

        return listaChiles2;
    }
    
    /**
     * Método utilizado para modificar los datos de la lista
     * @param nombreAnterior Nombre que se 
     * @param nombreActual
     * @return 
     */
    public ArrayList<ProductoVO> ModificarLista(String nombreAnterior, String nombreActual) {
        for (int i = 0; i < listaChiles2.size(); i++) {
            if (listaChiles2.get(i).getNombre().equalsIgnoreCase(nombreAnterior)) {
                listaChiles2.get(i).setNombre(nombreActual);
                NombresModificar(i, nombreActual);
            }
        }
        return listaChiles2;
    }

    /**
     * La lista Nombres solo tienen los nombres de los chiles, su objetivo es
     * mostrarlos en JComboBox de la interfaz Consultar, para consultar las
     * caracteristicas de un chile cuando son seleccionadas
     *
     * @return
     */
    public ArrayList<String> NombresInsertar() {
        for (int i = 0; i < listaChiles2.size(); i++) {
            String nom = listaChiles2.get(i).getNombre();
            if (!Nombres.contains(nom)) {
                Nombres.add(nom);
            }
        }
        return Nombres;
    }

    public ArrayList<String> NombresModificar(int i, String nombreActual) {
        Nombres.set(i, nombreActual);
        return Nombres;
    }

    /**
     * Se elimina un nombre de un chile de la lista Nombres
     *
     * @param i Posición del objeto
     * @return Lista Sin el Nombre
     */
    public ArrayList<String> NombresEliminar(int i) {
        Nombres.remove(i);
        return Nombres;
    }
    
    /**
     * Método para subir los datos al archivo de acceso aleatorio
     * @param list Lista de chiles con los datos
     */
    public void CargaAleatorio(ArrayList<ProductoVO> list) {
        for (int i = 0; i < list.size(); i++) {
            chileAle.EscribirArchivo(list.get(i).getNombre(),
                    list.get(i).getColor(),
                    list.get(i).getPais(),
                    list.get(i).getCategoria(),
                    list.get(i).getMinShu(),
                    list.get(i).getMaxShu(),
                    list.get(i).getEspecie());
        }
    }

    /**
     * Insertar un chile en la base de datos
     *
     * @param ch Chile a ingresar
     */
    public void InsertarChile(ProductoVO ch) {
        chileDao.InsertarChile(ch.getNombre(), ch.getColor(), ch.getPais(), ch.getCategoria(), ch.getMinShu(), ch.getMaxShu(), ch.getEspecie());
    }

    /**
     * Obtiene UN solo registro por el nombre
     *
     * @param nm
     */
    public void ObtenerRegistro(String nm) {
        chileDao.ConsultarDatos(nm);
    }

    /**
     * Obtiene todos los registros de la base de datos y los mete en la
     * listaChiles2
     */
    public void ObtenerRegistros() {
        chileDao.ConsultarDatosTodos();
    }

    /**
     * Elimina un registro de la base de datos y listaChile2
     *
     * @param nm Nombre del Chile que se eliminará
     */
    public void EliminarRegistro(String nm) {
        chileDao.Eliminar(nm);
    }
    
    /**
     * Método para modificar el nombre de un chile
     * @param nAnterior Nombre que tiene el chile. Se usa para identificarlo
     * @param nActual Nuevo nombre del chile
     */
    public void ModificarRegistro(String nAnterior, String nActual) {
        chileDao.Modificar(nAnterior, nActual);
    }
    
    /**
     * Método para validar que una cadena solo tenga números
     * @param m Cadena que se va a evaluar
     * @return estado
     */
    public boolean ValidarNumeros(String m) {
        boolean estado = true;
        for (int i = 0; i < m.length(); i++) {
            if (!Character.isDigit(m.charAt(i))) {
                estado = false;
            }
        }
        return estado;
    }
    
    /**
     * Valida que una cadena solo tenga minusculas
     * @param m Cadena a evaluar
     * @return estado
     */
    public boolean ValidarLetras(String m) {
        boolean estado = true;
        for (int i = 0; i < m.length(); i++) {
            if (!Character.isLowerCase(m.charAt(i)) && !Character.isWhitespace(m.charAt(i))) {
                estado = false;
                break; // si se encuentra un caracter no válido, se detiene la verificación
            }
        }
        return estado;
    }
    
    /**
     * Es el método que se utiliza para mostrar un mensaje en las clase conexión
     * usando la inyección y asi no romper con la ley de Demeter
     * @param mensaje 
     */
    public void Mostrar(String mensaje) {
        this.consultar.Mensajes(mensaje);
    }
    
    /**
     * Es el método que se encarga de realizar determinadas acciones ya especificadas
     * si el usuario oprime un botón
     * @param e Evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.menu.Bttoningresar) {
            this.menu.setVisible(false);
            this.ingresar.setLocationRelativeTo(null);
            this.ingresar.setVisible(true);
        }
        if (e.getSource() == this.menu.Bttonconsulta) {
            ObtenerRegistros();
            consultar.AgregarElementosJBox(this);
            this.menu.setVisible(false);
            this.consultar.setLocationRelativeTo(null);
            this.consultar.setVisible(true);

        }

        if (e.getSource() == this.menu.Bttonsalir) {
            ObtenerRegistros();
            for (int i = 0; i < listaChiles2.size(); i++) {
                chileAle.EscribirArchivo(listaChiles2.get(i).getNombre(),
                        listaChiles2.get(i).getColor(),
                        listaChiles2.get(i).getPais(),
                        listaChiles2.get(i).getCategoria(),
                        listaChiles2.get(i).getMinShu(),
                        listaChiles2.get(i).getMaxShu(),
                        listaChiles2.get(i).getEspecie());
            }

            this.menu.setVisible(false);
            this.consultar.dispose();
            this.menu.dispose();
            this.ingresar.dispose();
            this.modificar.dispose();
        }

        if (e.getSource() == this.ingresar.Bttonguardar) {
            if (this.ingresar.Camponombre.getText().isEmpty() || this.ingresar.Campocolor.getText().isEmpty() || this.ingresar.Campopais.getText().isEmpty() || this.ingresar.Campominimoshu.getText().isEmpty() || this.ingresar.Campomaximoshu.getText().isEmpty()) {
                this.ingresar.Mensajes("Complete los campos");
            } else {
                String categoria;
                if (this.ingresar.Slider.getValue() == 0) {
                    categoria = chileDao.ConsultarCategoria("0");

                    if (!ValidarNumeros(this.ingresar.Campominimoshu.getText()) || !ValidarNumeros(this.ingresar.Campomaximoshu.getText())) {
                        this.ingresar.Mensajes("No puede ingresar LETRAS en el maximo y/o minimo SHU");
                    } else if ((!ValidarLetras(this.ingresar.Camponombre.getText())) || (!ValidarLetras(this.ingresar.Campocolor.getText())) || (!ValidarLetras(this.ingresar.Campopais.getText()))) {
                        this.ingresar.Mensajes("Ingrese un dato válido en los campos de Nombre, Color, Pais");
                    } else if (Integer.parseInt(this.ingresar.Campominimoshu.getText()) >= 0 && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= 2000
                            && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) >= 0 && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) <= 2000
                            && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= Integer.parseInt(this.ingresar.Campomaximoshu.getText())) {

                        String especie = null;
                        
                        if (this.ingresar.BttonSannuum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Annuum");
                        } else if (this.ingresar.BttonSbaccatum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Baccatum");
                        } else if (this.ingresar.BttonSchinense.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Chinense");
                        } else if (this.ingresar.BttonSeximiun.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Eximium");
                        } else if (this.ingresar.BttonSfrutescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Frutescens");
                        } else if (this.ingresar.BttonSpubescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Pubescens");
                        } else if (this.ingresar.BttonSrhomboideum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Rhomboideum");
                        } else {
                            this.ingresar.Mensajes("Selecciona la Especie");
                        }

                        ProductoVO aux = CrearChile(
                                this.ingresar.Camponombre.getText(),
                                this.ingresar.Campocolor.getText(),
                                this.ingresar.Campopais.getText(),
                                categoria,
                                this.ingresar.Campominimoshu.getText(),
                                this.ingresar.Campomaximoshu.getText(),
                                especie);
                        InsertarChile(aux);
                        ObtenerRegistros();
                        this.ingresar.Mensajes("Chile Agregado");
                        consultar.AgregarElementosJBox(this);
                        ingresar.BlanquearCampos();

                    } else {
                        this.ingresar.Mensajes("Ingrese un rango de numeros valido");
                    }
                }

                if (this.ingresar.Slider.getValue() == 1) {

                    categoria = chileDao.ConsultarCategoria("1");

                    if (!ValidarNumeros(this.ingresar.Campominimoshu.getText()) || !ValidarNumeros(this.ingresar.Campomaximoshu.getText())) {
                        this.ingresar.Mensajes("No puede ingresar LETRAS en el maximo y/o minimo SHU");
                    } else if ((!ValidarLetras(this.ingresar.Camponombre.getText())) || (!ValidarLetras(this.ingresar.Campocolor.getText())) || (!ValidarLetras(this.ingresar.Campopais.getText()))) {
                        this.ingresar.Mensajes("Ingrese un dato válido en los campos de Nombre, Color, Pais");
                    } else if (Integer.parseInt(this.ingresar.Campominimoshu.getText()) >= 2000 && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= 25000
                            && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) >= 2000 && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) <= 25000
                            && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= Integer.parseInt(this.ingresar.Campomaximoshu.getText())) {

                        String especie = null;

                         if (this.ingresar.BttonSannuum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Annuum");
                        } else if (this.ingresar.BttonSbaccatum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Baccatum");
                        } else if (this.ingresar.BttonSchinense.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Chinense");
                        } else if (this.ingresar.BttonSeximiun.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Eximium");
                        } else if (this.ingresar.BttonSfrutescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Frutescens");
                        } else if (this.ingresar.BttonSpubescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Pubescens");
                        } else if (this.ingresar.BttonSrhomboideum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Rhomboideum");
                        } else {
                            this.ingresar.Mensajes("Selecciona la Especie");
                        }

                        ProductoVO aux = CrearChile(
                                this.ingresar.Camponombre.getText(),
                                this.ingresar.Campocolor.getText(),
                                this.ingresar.Campopais.getText(),
                                categoria,
                                this.ingresar.Campominimoshu.getText(),
                                this.ingresar.Campomaximoshu.getText(),
                                especie);
                        InsertarChile(aux);
                        ObtenerRegistros();
                        this.ingresar.Mensajes("Chile Agregado");
                        consultar.AgregarElementosJBox(this);
                        ingresar.BlanquearCampos();

                    } else {
                        this.ingresar.Mensajes("Ingrese un rango de numeros valido");
                    }
                }

                if (this.ingresar.Slider.getValue() == 2) {
                    categoria = chileDao.ConsultarCategoria("2");

                    if (!ValidarNumeros(this.ingresar.Campominimoshu.getText()) || !ValidarNumeros(this.ingresar.Campomaximoshu.getText())) {
                        this.ingresar.Mensajes("No puede ingresar LETRAS en el maximo y/o minimo SHU");
                    } else if ((!ValidarLetras(this.ingresar.Camponombre.getText())) || (!ValidarLetras(this.ingresar.Campocolor.getText())) || (!ValidarLetras(this.ingresar.Campopais.getText()))) {
                        this.ingresar.Mensajes("Ingrese un dato válido en los campos de Nombre, Color, Pais");
                    } else if (Integer.parseInt(this.ingresar.Campominimoshu.getText()) >= 25000 && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= 50000
                            && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) >= 25000 && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) <= 50000
                            && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= Integer.parseInt(this.ingresar.Campomaximoshu.getText())) {

                        String especie = null;

                         if (this.ingresar.BttonSannuum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Annuum");
                        } else if (this.ingresar.BttonSbaccatum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Baccatum");
                        } else if (this.ingresar.BttonSchinense.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Chinense");
                        } else if (this.ingresar.BttonSeximiun.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Eximium");
                        } else if (this.ingresar.BttonSfrutescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Frutescens");
                        } else if (this.ingresar.BttonSpubescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Pubescens");
                        } else if (this.ingresar.BttonSrhomboideum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Rhomboideum");
                        } else {
                            this.ingresar.Mensajes("Selecciona la Especie");
                        }

                        ProductoVO aux = CrearChile(
                                this.ingresar.Camponombre.getText(),
                                this.ingresar.Campocolor.getText(),
                                this.ingresar.Campopais.getText(),
                                categoria,
                                this.ingresar.Campominimoshu.getText(),
                                this.ingresar.Campomaximoshu.getText(),
                                especie);
                        InsertarChile(aux);
                        ObtenerRegistros();
                        this.ingresar.Mensajes("Chile Agregado");
                        consultar.AgregarElementosJBox(this);
                        ingresar.BlanquearCampos();

                    } else {
                        this.ingresar.Mensajes("Ingrese un rango de numeros valido");
                    }
                }
                if (this.ingresar.Slider.getValue() == 3) {
                    categoria = chileDao.ConsultarCategoria("3");

                    if (!ValidarNumeros(this.ingresar.Campominimoshu.getText()) || !ValidarNumeros(this.ingresar.Campomaximoshu.getText())) {
                        this.ingresar.Mensajes("No puede ingresar LETRAS en el maximo y/o minimo SHU");
                    } else if ((!ValidarLetras(this.ingresar.Camponombre.getText())) || (!ValidarLetras(this.ingresar.Campocolor.getText())) || (!ValidarLetras(this.ingresar.Campopais.getText()))) {
                        this.ingresar.Mensajes("Ingrese un dato válido en los campos de Nombre, Color, Pais");
                    } else if (Integer.parseInt(this.ingresar.Campominimoshu.getText()) >= 50000 && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= 100000
                            && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) >= 50000 && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) <= 100000
                            && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= Integer.parseInt(this.ingresar.Campomaximoshu.getText())) {

                        String especie = null;

                         if (this.ingresar.BttonSannuum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Annuum");
                        } else if (this.ingresar.BttonSbaccatum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Baccatum");
                        } else if (this.ingresar.BttonSchinense.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Chinense");
                        } else if (this.ingresar.BttonSeximiun.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Eximium");
                        } else if (this.ingresar.BttonSfrutescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Frutescens");
                        } else if (this.ingresar.BttonSpubescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Pubescens");
                        } else if (this.ingresar.BttonSrhomboideum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Rhomboideum");
                        } else {
                            this.ingresar.Mensajes("Selecciona la Especie");
                        }

                        ProductoVO aux = CrearChile(
                                this.ingresar.Camponombre.getText(),
                                this.ingresar.Campocolor.getText(),
                                this.ingresar.Campopais.getText(),
                                categoria,
                                this.ingresar.Campominimoshu.getText(),
                                this.ingresar.Campomaximoshu.getText(),
                                especie);
                        InsertarChile(aux);
                        ObtenerRegistros();
                        this.ingresar.Mensajes("Chile Agregado");
                        consultar.AgregarElementosJBox(this);
                        ingresar.BlanquearCampos();

                    } else {
                        this.ingresar.Mensajes("Ingrese un rango de numeros valido");
                    }
                }

                if (this.ingresar.Slider.getValue() == 4) {
                    categoria = chileDao.ConsultarCategoria("4");
                    if (!ValidarNumeros(this.ingresar.Campominimoshu.getText()) || !ValidarNumeros(this.ingresar.Campomaximoshu.getText())) {
                        this.ingresar.Mensajes("No puede ingresar LETRAS en el maximo y/o minimo SHU");
                    } else if ((!ValidarLetras(this.ingresar.Camponombre.getText())) || (!ValidarLetras(this.ingresar.Campocolor.getText())) || (!ValidarLetras(this.ingresar.Campopais.getText()))) {
                        this.ingresar.Mensajes("Ingrese un dato válido en los campos de Nombre, Color, Pais");
                    } else if (Integer.parseInt(this.ingresar.Campominimoshu.getText()) >= 100000 && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= 250000
                            && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) >= 100000 && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) <= 250000
                            && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= Integer.parseInt(this.ingresar.Campomaximoshu.getText())) {

                        String especie = null;

                         if (this.ingresar.BttonSannuum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Annuum");
                        } else if (this.ingresar.BttonSbaccatum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Baccatum");
                        } else if (this.ingresar.BttonSchinense.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Chinense");
                        } else if (this.ingresar.BttonSeximiun.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Eximium");
                        } else if (this.ingresar.BttonSfrutescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Frutescens");
                        } else if (this.ingresar.BttonSpubescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Pubescens");
                        } else if (this.ingresar.BttonSrhomboideum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Rhomboideum");
                        } else {
                            this.ingresar.Mensajes("Selecciona la Especie");
                        }

                        ProductoVO aux = CrearChile(
                                this.ingresar.Camponombre.getText(),
                                this.ingresar.Campocolor.getText(),
                                this.ingresar.Campopais.getText(),
                                categoria,
                                this.ingresar.Campominimoshu.getText(),
                                this.ingresar.Campomaximoshu.getText(),
                                especie);
                        InsertarChile(aux);
                        ObtenerRegistros();
                        this.ingresar.Mensajes("Chile Agregado");
                        consultar.AgregarElementosJBox(this);
                        ingresar.BlanquearCampos();

                    } else {
                        this.ingresar.Mensajes("Ingrese un rango de numeros valido");
                    }
                }

                if (this.ingresar.Slider.getValue() == 5) {
                    categoria = chileDao.ConsultarCategoria("5");

                    if (!ValidarNumeros(this.ingresar.Campominimoshu.getText()) || !ValidarNumeros(this.ingresar.Campomaximoshu.getText())) {
                        this.ingresar.Mensajes("No puede ingresar LETRAS en el maximo y/o minimo SHU");
                    } else if ((!ValidarLetras(this.ingresar.Camponombre.getText())) || (!ValidarLetras(this.ingresar.Campocolor.getText())) || (!ValidarLetras(this.ingresar.Campopais.getText()))) {
                        this.ingresar.Mensajes("Ingrese un dato válido en los campos de Nombre, Color, Pais");
                    } else if (Integer.parseInt(this.ingresar.Campominimoshu.getText()) >= 250000 && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= 500000
                            && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) >= 250000 && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) <= 500000
                            && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= Integer.parseInt(this.ingresar.Campomaximoshu.getText())) {

                        String especie = null;

                         if (this.ingresar.BttonSannuum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Annuum");
                        } else if (this.ingresar.BttonSbaccatum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Baccatum");
                        } else if (this.ingresar.BttonSchinense.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Chinense");
                        } else if (this.ingresar.BttonSeximiun.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Eximium");
                        } else if (this.ingresar.BttonSfrutescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Frutescens");
                        } else if (this.ingresar.BttonSpubescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Pubescens");
                        } else if (this.ingresar.BttonSrhomboideum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Rhomboideum");
                        } else {
                            this.ingresar.Mensajes("Selecciona la Especie");
                        }

                        ProductoVO aux = CrearChile(
                                this.ingresar.Camponombre.getText(),
                                this.ingresar.Campocolor.getText(),
                                this.ingresar.Campopais.getText(),
                                categoria,
                                this.ingresar.Campominimoshu.getText(),
                                this.ingresar.Campomaximoshu.getText(),
                                especie);
                        InsertarChile(aux);
                        ObtenerRegistros();
                        this.ingresar.Mensajes("Chile Agregado");
                        consultar.AgregarElementosJBox(this);
                        ingresar.BlanquearCampos();

                    } else {
                        this.ingresar.Mensajes("Ingrese un rango de numeros valido");
                    }
                }

                if (this.ingresar.Slider.getValue() == 6) {
                    categoria = chileDao.ConsultarCategoria("6");
                    if (!ValidarNumeros(this.ingresar.Campominimoshu.getText()) || !ValidarNumeros(this.ingresar.Campomaximoshu.getText())) {
                        this.ingresar.Mensajes("No puede ingresar LETRAS en el maximo y/o minimo SHU");
                    } else if ((!ValidarLetras(this.ingresar.Camponombre.getText())) || (!ValidarLetras(this.ingresar.Campocolor.getText())) || (!ValidarLetras(this.ingresar.Campopais.getText()))) {
                        this.ingresar.Mensajes("Ingrese un dato válido en los campos de Nombre, Color, Pais");
                    } else if (Integer.parseInt(this.ingresar.Campominimoshu.getText()) >= 500000 && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= 1000000
                            && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) >= 500000 && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) <= 1000000
                            && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= Integer.parseInt(this.ingresar.Campomaximoshu.getText())) {

                        String especie = null;

                         if (this.ingresar.BttonSannuum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Annuum");
                        } else if (this.ingresar.BttonSbaccatum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Baccatum");
                        } else if (this.ingresar.BttonSchinense.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Chinense");
                        } else if (this.ingresar.BttonSeximiun.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Eximium");
                        } else if (this.ingresar.BttonSfrutescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Frutescens");
                        } else if (this.ingresar.BttonSpubescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Pubescens");
                        } else if (this.ingresar.BttonSrhomboideum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Rhomboideum");
                        } else {
                            this.ingresar.Mensajes("Selecciona la Especie");
                        }

                        ProductoVO aux = CrearChile(
                                this.ingresar.Camponombre.getText(),
                                this.ingresar.Campocolor.getText(),
                                this.ingresar.Campopais.getText(),
                                categoria,
                                this.ingresar.Campominimoshu.getText(),
                                this.ingresar.Campomaximoshu.getText(),
                                especie);
                        InsertarChile(aux);
                        ObtenerRegistros();
                        this.ingresar.Mensajes("Chile Agregado");
                        consultar.AgregarElementosJBox(this);
                        ingresar.BlanquearCampos();
                    } else {
                        this.ingresar.Mensajes("Ingrese un rango de numeros valido");
                    }

                }

                if (this.ingresar.Slider.getValue() == 7) {
                    categoria = chileDao.ConsultarCategoria("7");

                    if (!ValidarNumeros(this.ingresar.Campominimoshu.getText()) || !ValidarNumeros(this.ingresar.Campomaximoshu.getText())) {
                        this.ingresar.Mensajes("No puede ingresar LETRAS en el maximo y/o minimo SHU");
                    } else if ((!ValidarLetras(this.ingresar.Camponombre.getText())) || (!ValidarLetras(this.ingresar.Campocolor.getText())) || (!ValidarLetras(this.ingresar.Campopais.getText()))) {
                        this.ingresar.Mensajes("Ingrese un dato válido en los campos de Nombre, Color, Pais");
                    } else if (Integer.parseInt(this.ingresar.Campominimoshu.getText()) >= 1000000
                            && Integer.parseInt(this.ingresar.Campomaximoshu.getText()) >= 1000000
                            && Integer.parseInt(this.ingresar.Campominimoshu.getText()) <= Integer.parseInt(this.ingresar.Campomaximoshu.getText())) {

                        String especie = null;

                         if (this.ingresar.BttonSannuum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Annuum");
                        } else if (this.ingresar.BttonSbaccatum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Baccatum");
                        } else if (this.ingresar.BttonSchinense.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Chinense");
                        } else if (this.ingresar.BttonSeximiun.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Eximium");
                        } else if (this.ingresar.BttonSfrutescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Frutescens");
                        } else if (this.ingresar.BttonSpubescens.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Pubescens");
                        } else if (this.ingresar.BttonSrhomboideum.isSelected()) {
                            especie = chileDao.ConsultarEspecie("Capsicum Rhomboideum");
                        } else {
                            this.ingresar.Mensajes("Selecciona la Especie");
                        }

                        ProductoVO aux = CrearChile(
                                this.ingresar.Camponombre.getText(),
                                this.ingresar.Campocolor.getText(),
                                this.ingresar.Campopais.getText(),
                                categoria,
                                this.ingresar.Campominimoshu.getText(),
                                this.ingresar.Campomaximoshu.getText(),
                                especie);
                        InsertarChile(aux);
                        ObtenerRegistros();
                        this.ingresar.Mensajes("Chile Agregado");
                        consultar.AgregarElementosJBox(this);
                        ingresar.BlanquearCampos();

                    } else {
                        this.ingresar.Mensajes("Ingrese un rango de numeros valido");
                    }
                }
            }
        }
        if (e.getSource() == this.ingresar.Bttonsalir) {
            this.ingresar.setVisible(false);
            this.menu.setVisible(true);
            this.menu.setLocationRelativeTo(null);
        }

        if (e.getSource() == this.consultar.Bttonlimpiar) {
            this.consultar.BlanquearCampos();
        }

        if (e.getSource() == this.consultar.Bttonconsulta) {
            this.ObtenerRegistro(String.valueOf(this.consultar.jcNombres.getSelectedItem()));
            this.consultar.Campomostrarcolor.setText(chile.getColor());
            this.consultar.Campomostrarpais.setText(chile.getPais());
            this.consultar.Campomostrarminimoshu.setText(chile.getMinShu());
            this.consultar.Campomostrarmaximoshu.setText(chile.getMaxShu());
            this.consultar.Campomostrarclasificacion.setText(chile.getCategoria());
            this.consultar.Campomostrarespecie.setText(chile.getEspecie());
        }

        if (e.getSource() == this.consultar.Bttonmodificar) {
            String nmAnterior = String.valueOf(this.consultar.jcNombres.getSelectedItem());
            this.modificar.setVisible(true);
            this.modificar.setLocationRelativeTo(null);
            this.modificar.Campomostrarnombre.setText(nmAnterior);
        }

        if (e.getSource() == this.modificar.Bttonmodificar) {
            String nmAnterior = String.valueOf(this.consultar.jcNombres.getSelectedItem());
            if (this.modificar.Camponombrenuevo.getText().isEmpty()) {
                this.modificar.Mensajes("Ingresa el nombre nuevo");
            } else {
                this.ModificarRegistro(nmAnterior, this.modificar.Camponombrenuevo.getText());
                this.modificar.Mensajes("Cambio Realizado");
                this.modificar.setVisible(false);
                this.consultar.BlanquearCampos();
                consultar.AgregarElementosJBox(this);
                this.modificar.BlanquearCampos();
            }
        }

        if (e.getSource() == consultar.btnSalir) {
            this.consultar.setVisible(false);
            this.consultar.dispose();
            this.menu.setVisible(true);
        }

        if (e.getSource() == this.consultar.btnEliminar) {
            this.EliminarRegistro(String.valueOf(this.consultar.jcNombres.getSelectedItem()));
            consultar.BlanquearCampos();
            consultar.AgregarElementosJBox(this);
        }

        if (e.getSource() == this.menu.btnArchivo) {
            try {
                chileAle = new ChileConexionAleatorio(this.menu.getFile(), this);
            } catch (NullPointerException o) {
                this.Mostrar("No se puedo encontrar el archivo");
            }
        }
    }
}
