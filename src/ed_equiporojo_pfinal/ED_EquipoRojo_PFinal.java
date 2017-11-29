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
public class ED_EquipoRojo_PFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph test = new Graph(13);
        test.insertE(1,2);
        test.insertE(2,3);
        test.insertE(2,5);
        test.insertE(3,8);
        test.insertE(3,9);
        test.insertE(5,11);
        test.insertE(5,6);
        test.insertE(6,11);
        test.insertE(6,4);
        test.insertE(6,7);
        test.insertE(7,12);
        test.insertE(7,8);
        test.insertE(8,10);
        test.insertE(9,13);
        test.insertE(11,6);
        test.insertE(12,9);
        System.out.println(test.DFS(1));
        System.out.println(test.BFS(1));
    }
    
}
