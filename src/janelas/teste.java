/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author Leonardo
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pair<Integer,Integer> celPair;
        ArrayList<Pair<Integer,Integer>> vet;
        vet = new ArrayList();
            for(int i = 0; i < 5; i++){
                celPair = new Pair<>(5,2);
                vet.add(celPair);
            }
            /*
            for(Pair<Integer,Integer> pos : vet){
                System.out.println("K: " + pos.getKey() + " V: " + pos.getValue());
            }
            */
            //vet.get(0);
            System.out.println("K: " + vet.get(0).getKey() + " V: " +vet.get(0).getValue());
    }
    
}
