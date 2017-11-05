/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chessrankingproject;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Travis Lowe
 */
public class PlayerTableModel extends AbstractTableModel {
    
    int[][] data;
    
    ArrayList<Player> PlayerList;

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    public PlayerTableModel() {
        
    }
    
    public PlayerTableModel(DataBasetoXML db){
    
         PlayerList = db.PlayerList;
         
         
         
    }

    @Override
    public int getRowCount() {
            return PlayerList.size(); 
    }

    @Override
    public int getColumnCount() {
              return 8; // each column is an attribute of the specific player

    }

    @Override
    public String getColumnName(int column) {
        switch (column){
        
            case 0 :
                return "Name";
            case 1 :
                return "gamesPlayed";
            case 2 :
                return "currentRank";
            case 3 :
                return "gamesWon";
            case 4 :
                return "gamesLost";
            case 5 :
                return "gamesDrawn";
            case 6 :
                return "highestRating";
            case 7 :
                return "lowestRating";
            case 8 :
                return "DatabaseRank";
            default :
                return "Unknown Column Type";
                        
        
        
        }
    }

    
    
    
    
   @Override
    public Object getValueAt(int row, int column) {
        
        switch(column){
        
            case 0:
                String first = PlayerList.get(row).firstName;
                String last  = PlayerList.get(row).lastName;
                String name = last + ", " + first;
                return name;
            case 1:
                return PlayerList.get(row).gamesPlayed;
            case 2:
                return PlayerList.get(row).currentRank;
            case 3:
                return PlayerList.get(row).gamesWon;
            case 4:
                return PlayerList.get(row).gamesLost;
            case 5:
                return PlayerList.get(row).gamesDrawn;
            case 6:
                return PlayerList.get(row).highestRating;
            case 7:
                return PlayerList.get(row).lowestRating;
            case 8:
                return PlayerList.get(row).DatabaseRank;
            default:
                return null;
        }
        
    }
    
    
}
