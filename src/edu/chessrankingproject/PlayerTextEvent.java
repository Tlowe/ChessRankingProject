/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chessrankingproject;


public class PlayerTextEvent extends java.util.EventObject {

    String eventString;
    public PlayerTextEvent(String source) {
        super(source);
        
        eventString = source;
    }
    
    
    public String getText(){
    
    return eventString;
    }
}
