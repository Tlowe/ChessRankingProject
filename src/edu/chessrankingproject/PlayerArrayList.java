/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chessrankingproject;

import java.util.ArrayList;

/**
 *
 * @author Travis Lowe
 */
public class PlayerArrayList extends ArrayList<Player>{
    
    public PlayerArrayList getPlayerArrayListCopy() {
        PlayerArrayList copy = new PlayerArrayList();
        
        for(Player p : this){
        
            Player c ;
            c = p.getCopy();
            copy.add(c);
        
        }
        
        return copy;
    }
    
}
