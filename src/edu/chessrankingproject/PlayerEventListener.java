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
public interface PlayerEventListener {
 
    void updateDatabase(PlayerArrayList PlayerList);
    
    void updateDebugText(String newstring);
    
    void windowClosing();
}
