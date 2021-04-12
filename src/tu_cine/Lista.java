/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tu_cine;

import javax.swing.JOptionPane;

/**
 *
 * @author jesusl
 */
public class Lista {

    private nodo inicio;
    private nodo fin;

    public Lista() {
        inicio = null;
        fin = null;
    }

    public boolean estaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(FacturaTicket factura) {
        nodo actual;
        if (estaVacia()) {
            actual = new nodo(null, factura);
            inicio = actual;
            fin = actual;
        } else {
            actual = new nodo(null, factura);
            fin.setSiguiente(actual);
            fin = actual;
        }
    }

    public void insertarf(String hora) {
        nodo actual;
        if (estaVacia()) {
            actual = new nodo(null, hora);
            inicio = actual;
            fin = actual;
        } else {
            actual = new nodo(null, hora);
            fin.setSiguiente(actual);
            fin = actual;
        }
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("NO HAY TIQUETES VENDIDOS AÚN");
            return;
        } else {
            nodo temporal;
            temporal = inicio;
            while (temporal != null) {
                System.out.println(temporal.getDato().toString());
                RecaudoController.recaudoc =+ RecaudoController.recaudoc+temporal.getDato().getValor();
                temporal = temporal.getSiguiente();
            }
        }
    }

    public void mostrarf() {
        int i = 1;
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null,"No hay programacion disponible" );
            return;
        } else {
            nodo temporal;
            temporal = inicio;
            while (temporal != null) {
                System.out.println(temporal.getDatoo());
                temporal = temporal.getSiguiente();

            }

        }
    }
}


