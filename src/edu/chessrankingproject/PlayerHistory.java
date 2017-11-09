/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chessrankingproject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author Travis Lowe
 */
public class PlayerHistory {
    
    Player Player;
    Player Opponent;
    DateTimeFormatter formatter ;
    LocalDateTime TimeOfGame ;
    int win = 0;
    int loss = 0;
    int draw = 0;

    public PlayerHistory() {
    }

    PlayerHistory(String actionCommand, Player player, Player opponent) {
        
        this.Player = player;
        this.Opponent = opponent;
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss  yyyy-MM-dd");
        TimeOfGame = LocalDateTime.now();
        switch(Integer.parseInt(actionCommand)){
        
            case 1:
                win = 1;
                break;
            case 2:
                loss = 1;
                break;
            case 3:
                draw = 1;
                break;
            default:
                break;
                
        
        
        }
        
    }

    
    
    
    @Override
    public String toString() {
        String result = " ";
        if(win == 1){
            result = " WON ";
           
        }
        else if(loss == 1){
            
            result = " LOST ";
        }
        else if(draw == 1){
            result = " DREW ";
        }else{
            result = "did nothing";
        }
        
        
        String formattedTime = TimeOfGame.format(formatter);
         return Player.getCombNameFL() + result + "against " + Opponent.getCombNameFL() + " @ " + formattedTime;
    }
    
    
    
}
