/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tu_cine;

/**
 *
 * @author jesusl
 */
public class FacturaTicket {
    private String nombre, pelicula, fecha_funcion, ubicacion;
    private int valor, nfactura;

    public FacturaTicket(String nombre, String pelicula, String fecha_funcion, String ubicacion, int valor, int nfactura) {
        this.nombre = nombre;
        this.pelicula = pelicula;
        this.fecha_funcion = fecha_funcion;
        this.ubicacion = ubicacion;
        this.valor = valor;
        this.nfactura = nfactura;
    }

    public String toString(){
        return "Nombre: "+nombre
                + "\nPelicula: "+pelicula
                + "\nFecha: "+ fecha_funcion
                + "\nUbicacion: "+ubicacion
                + "\nValor: $"+valor
                + "\nNumero de de Ticket: "+nfactura+"\n";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getFecha_funcion() {
        return fecha_funcion;
    }

    public void setFecha_funcion(String fecha_funcion) {
        this.fecha_funcion = fecha_funcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNfactura() {
        return nfactura;
    }

    public void setNfactura(int nfactura) {
        this.nfactura = nfactura;
    }


    
    
    
}
