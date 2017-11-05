/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chessrankingproject;


import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Travis Lowe
 */
public class Player {
    
    String firstName;
    String lastName;
    int gamesPlayed ;
    int gamesWon ;
    int gamesLost ;
    int gamesDrawn ;
    float highestRating;
    float lowestRating;
    int currentRank ; // what should be the default rank?
    int DatabaseRank;
    int newvallu;

    public Player(){
    
    
    }
    
    
    public Player(String nameFirst, String nameLast){
       
    this.firstName = nameFirst;
    this.lastName = nameLast;
    
    }

    public Player(String firstName, String lastName, int gamesPlayed, int gamesWon, int gamesLost, int gamesDrawn, float highestRating, float lowestRating, int currentRank, int DatabaseRank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.gamesDrawn = gamesDrawn;
        this.highestRating = highestRating;
        this.lowestRating = lowestRating;
        this.currentRank = currentRank;
        this.DatabaseRank = DatabaseRank;
    }

    Player(Node node) {
        Element pElement   = (Element) node;
        this.firstName     = pElement.getElementsByTagName("FirstName").item(0).getTextContent(); 
        this.lastName      = pElement.getElementsByTagName("lastName").item(0).getTextContent(); 
        this.gamesPlayed   = Integer.parseInt(pElement.getElementsByTagName("gamesPlayed").item(0).getTextContent()); 
        this.gamesWon      = Integer.parseInt(pElement.getElementsByTagName("gamesWon").item(0).getTextContent()); 
        this.gamesLost     = Integer.parseInt(pElement.getElementsByTagName("gamesLost").item(0).getTextContent()); 
        this.gamesDrawn    = Integer.parseInt(pElement.getElementsByTagName("gamesLost").item(0).getTextContent()); 
        this.highestRating = Integer.parseInt(pElement.getElementsByTagName("highestRating").item(0).getTextContent()); 
        this.lowestRating  = Integer.parseInt(pElement.getElementsByTagName("lowestRating").item(0).getTextContent()); 
        this.currentRank   = Integer.parseInt(pElement.getElementsByTagName("currentRank").item(0).getTextContent()); 
        this.DatabaseRank  = Integer.parseInt(pElement.getElementsByTagName("DatabaseRank").item(0).getTextContent()); 
     }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getGamesDrawn() {
        return gamesDrawn;
    }

    public void setGamesDrawn(int gamesDrawn) {
        this.gamesDrawn = gamesDrawn;
    }

    public float getHighestRating() {
        return highestRating;
    }

    public void setHighestRating(float highestRating) {
        this.highestRating = highestRating;
    }

    public float getLowestRating() {
        return lowestRating;
    }

    public void setLowestRating(float lowestRating) {
        this.lowestRating = lowestRating;
    }

    public int getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(int currentRank) {
        this.currentRank = currentRank;
    }

    public int getDatabaseRank() {
        return DatabaseRank;
    }

    public void setDatabaseRank(int DatabaseRank) {
        this.DatabaseRank = DatabaseRank;
    }
    
    
    
    
}
