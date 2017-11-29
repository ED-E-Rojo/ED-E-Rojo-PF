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

    public Edge(int dest) {
        this.dest = dest;
        this.weight = 0.0;
    }

    public Edge(int dest, double weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public double getDest() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" + "dest=" + dest + ", weight=" + weight + '}';
    }
    
}
