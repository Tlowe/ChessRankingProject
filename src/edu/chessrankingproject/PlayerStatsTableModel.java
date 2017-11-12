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
public class PlayerStatsTableModel extends AbstractTableModel {
    
    int[][] data;
    
    ArrayList<PlayerHistory> HistoryList = new ArrayList<>();

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    public PlayerStatsTableModel() {
        
    }
    
    public PlayerStatsTableModel(ArrayList plArrayList){
    
         HistoryList = plArrayList;
            
         
    }
    
    public PlayerStatsTableModel(Player newP){
    
         HistoryList = newP.getCopy().getGameHistory();
         
         
         for(PlayerHistory p : HistoryList){
         
         
         
         }
            
         
    }
    
    public void updatePlayerList(ArrayList plArrayList){
    
         HistoryList = plArrayList;
    }

    @Override
    public int getRowCount() {
            return HistoryList.size(); 
    }

    @Override
    public int getColumnCount() {
              return 6; // each column is an attribute of the specific player

    }

    @Override
    public String getColumnName(int column) {
        switch (column){
        
            case 0 :
                return "Date";
            case 1 :
                return "Time";
            case 2:
                return "Game Result";
            case 3 :
                return "Score";
            case 4 :
                return "Opponent";
            case 5:
                return "Opponent Score";
            default :
                return "Unknown Column Type";
                        
        
        
        }
    }

    
    
    
    
   @Override
    public Object getValueAt(int row, int column) {
        
        switch(column){
        
            case 0:
              
                return HistoryList.get(row).Date;
            case 1:
                return HistoryList.get(row).Time;
            case 2:
                return HistoryList.get(row).getResultStringfromCode(HistoryList.get(row).getResultCode());
            case 3:
                return HistoryList.get(row).Player.getCurrentRating();
            case 4:
                return HistoryList.get(row).Opponent.getCombNameFL();
            case 5:
                return HistoryList.get(row).Opponent.getCurrentRating();
            default:
                return null;
        }
        
    }
    
    public Player getplayerAtRow(int row){
    
    return HistoryList.get(row).Player;
    
    }
    
    
}
