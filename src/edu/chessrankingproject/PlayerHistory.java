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
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Travis Lowe
 */
public class PlayerHistory {
    
    Player Player;
    Player Opponent;
    DateTimeFormatter formatter ;
    LocalDate DateOfGame ;
    LocalDateTime TimeOfGame;
    String Date;
    String Time;
    private int win = 0;
    private int loss = 0;
    private int draw = 0;
    String StringResult;

    public PlayerHistory() {
    }

    PlayerHistory(String actionCommand, Player player, Player opponent) {
        
        this.Player = player;
        this.Opponent = opponent;
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        TimeOfGame = LocalDateTime.now();
        DateOfGame = LocalDate.now();
        Time = TimeOfGame.format(formatter);
        Date = DateOfGame.toString();
        
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

    PlayerHistory(Element histElement) {
      this.Opponent = new Player();
      this.Player = new Player();
        this.setResultFromCode(Integer.parseInt(histElement.getElementsByTagName("gameResult").item(0).getTextContent()));
        this.Player.setCurrentRating(Float.parseFloat(histElement.getElementsByTagName("playerRating").item(0).getTextContent()));
        this.Opponent.setFirstName(histElement.getElementsByTagName("oppFirstName").item(0).getTextContent()); 
        this.Opponent.setLastName( histElement.getElementsByTagName("oppLastName").item(0).getTextContent() );
        this.Opponent.setId( Integer.parseInt(histElement.getElementsByTagName("oppID").item(0).getTextContent()) );
        this.Opponent.setCurrentRating(Float.parseFloat(histElement.getElementsByTagName("oppRating").item(0).getTextContent())); 
        this.Time = histElement.getElementsByTagName("time").item(0).getTextContent();
        this.Date = histElement.getElementsByTagName("date").item(0).getTextContent();
    
    
    
    }

    PlayerHistory(Player player, Player opponent, String Date, String Time, int result) {
        
        this.Player = player.getCopy();
        this.Opponent = opponent.getCopy();
        this.Date = Date;
        this.Time = Time;
        StringResult = getResultStringfromCode(result);
        setResultFromCode(result);
        
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
    
    
    public int getResultCode(){
        int resultcode;
        
      if(win == 1){
            resultcode = 1;
           
        }
        else if(loss == 1){
            
            resultcode = 2;
        }
        else if(draw == 1){
            resultcode = 3;
        }else{
           resultcode = 0;
        }  
      
      return resultcode;
    }
    
    public String getResultStringfromCode(int i){
    
        switch(i){

            case 1 :
                return "win";
            case 2:
                return "lose";
            case 3:
                return "draw";
            default:
                return "null";
                

        }
    
    }
    
    public void setResultFromCode(int i){
    
    switch(i){
    
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

    String getTime() {
        return Time;
    }

    String getDate() {
        return Date;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    int getAntiResultCode() {
        int resultcode;
        
        if(win == 1){
            resultcode = 2;
           
        }
        else if(loss == 1){
            
            resultcode = 1;
        }
        else if(draw == 1){
            resultcode = 3;
        }else{
           resultcode = 0;
        }  
      
      return resultcode;
    }
    
    
    public PlayerHistory getCopy(){
    
    PlayerHistory p = new PlayerHistory();
    
    p.Date = this.Date;
    p.Time = this.Time;
    p.DateOfGame = this.DateOfGame;
    p.TimeOfGame = this.TimeOfGame;
    p.Opponent = this.Opponent;
    p.Player = this.Player;
    p.formatter  = this.formatter;
    
    
    p.win = this.win;
    p.loss = this.loss;
    p.draw = this.draw;
    p.StringResult = this.StringResult;
    
    return p;
    
    }
    
    
}
