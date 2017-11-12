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
    
    public PlayerTableModel(ArrayList plArrayList){
    
         PlayerList = plArrayList;
            
         
    }
    
    public void updatePlayerList(ArrayList plArrayList){
    
         PlayerList = plArrayList;
    }

    @Override 
    public int getRowCount() {
            return PlayerList.size(); 
    }

    @Override
    public int getColumnCount() {
              return 11; // each column is an attribute of the specific player

    }

    @Override
    public String getColumnName(int column) {
        switch (column){
        
            case 0 :
                return "Last Name";
            case 1 :
                return "First Name";
            case 2:
                return "ID";
            case 3 :
                return "Games Played";
            case 4 :
                return "Current Rating";
            case 5:
                return "Games Won";
            case 6 :
                return "Games Lost";
            case 7:
                return "Games Drawn";
            case 8:
                return " Highest Rating";
            case 9 :
                return "Lowest Rating";
            case 10 :
                return "Database Rank";
            default :
                return "Unknown Column Type";
                        
        
        
        }
    }

    
    
    
    
   @Override
    public Object getValueAt(int row, int column) {
        
        switch(column){
        
            case 0:
              //  String first = PlayerList.get(row).firstName;
              //  String last  = PlayerList.get(row).lastName;
              //  String name = last + "." + first;
              //  return name;
                return PlayerList.get(row).getLastName();
            case 1:
                return PlayerList.get(row).getFirstName();
            case 2:
                return PlayerList.get(row).getId();
            case 3:
                return PlayerList.get(row).getGamesPlayed();
            case 4:
                return PlayerList.get(row).getCurrentRating();
            case 5:
                return PlayerList.get(row).getGamesWon();
            case 6:
                return PlayerList.get(row).getGamesLost();
            case 7:
                return PlayerList.get(row).getGamesDrawn();
            case 8:
                return PlayerList.get(row).getHighestRating();
            case 9:
                return PlayerList.get(row).getLowestRating();
            case 10:
                return PlayerList.get(row).getDatabaseRank();
            default:
                return null;
        }
        
    }
    
    
}
