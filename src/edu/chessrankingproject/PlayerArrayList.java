/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chessrankingproject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Travis Lowe
 */
public class PlayerArrayList extends ArrayList<Player>{
    
    public int emptyStatus = 0;
    
    
    public PlayerArrayList getPlayerArrayListCopy() {
        PlayerArrayList copy = new PlayerArrayList();
        
        for(Player p : this){
        
            Player c ;
            c = p.getCopy();
            copy.add(c);
        
        }
        
        return copy;
    }
    
    public Player getPlayerByID(int id){
    
        for(Player p : this){
        
            if ( p.getId() == id)
                
                return p;
        
        }
        
            return null;
               
                
    }
    
    
}
