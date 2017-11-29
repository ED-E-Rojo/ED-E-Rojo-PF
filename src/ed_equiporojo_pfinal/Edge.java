/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_equiporojo_pfinal;
/**
 *
 * @author Rodrigo
 */
public class Edge {
    private int dest;
    private double weight;

    //Consturctor por defecto
    public Edge(int dest) {
        this.dest = dest;
        this.weight = 0.0;
    }

    //Consturctor con un elemento
    public Edge(int dest, double weight) {
        this.dest = dest; 
        this.weight = weight;
    }

    //Obtener destino
    public double getDest() {
        return dest;
    }

    //Obtener peso
    public double getWeight() {
        return weight;
    }

    //Imprimir edge
    @Override
    public String toString() {
        return "Edge{" + "dest=" + dest + ", weight=" + weight + '}';
    }
}
