/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chessrankingproject;


import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.*;
/**
 *
 * @author Travis Lowe
 */
public class Player {
    
private String firstName;
private String lastName;
private int gamesPlayed ;
private int gamesWon ;
private int gamesLost ;
private int gamesDrawn ;
private float highestRating;
private float lowestRating;
private float currentRating ; // what should be the default rank?
private int DatabaseRank;
private int id; // this will help sort through database faster.


//create new class for player history with timestamps and all that jazz...
private ArrayList<PlayerHistory> gameHistory = new ArrayList<>();
    

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
        this.currentRating = currentRank;
        this.DatabaseRank = DatabaseRank;
    }

    Player(Node node) {
        Element pElement   = (Element) node;
        this.firstName     = pElement.getElementsByTagName("FirstName").item(0).getTextContent(); 
        this.lastName      = pElement.getElementsByTagName("lastName").item(0).getTextContent();
        this.id            = Integer.parseInt(pElement.getElementsByTagName("ID").item(0).getTextContent());
        this.gamesPlayed   = Integer.parseInt(pElement.getElementsByTagName("gamesPlayed").item(0).getTextContent()); 
        this.gamesWon      = Integer.parseInt(pElement.getElementsByTagName("gamesWon").item(0).getTextContent()); 
        this.gamesLost     = Integer.parseInt(pElement.getElementsByTagName("gamesLost").item(0).getTextContent()); 
        this.gamesDrawn    = Integer.parseInt(pElement.getElementsByTagName("gamesLost").item(0).getTextContent()); 
        this.highestRating = Float.parseFloat(pElement.getElementsByTagName("highestRating").item(0).getTextContent()); 
        this.lowestRating  = Float.parseFloat(pElement.getElementsByTagName("lowestRating").item(0).getTextContent()); 
        this.currentRating = Float.parseFloat(pElement.getElementsByTagName("currentRating").item(0).getTextContent()); 
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

    public float getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(int currentRating) {
        this.currentRating = currentRating;
    }

    public int getDatabaseRank() {
        return DatabaseRank;
    }

    public void setDatabaseRank(int DatabaseRank) {
        this.DatabaseRank = DatabaseRank;
    }
    
    public String getCombinedName(){
    
        return lastName + "." + firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    @Override
    public String toString() {
        return getCombinedName();
    }

    
    

    void updateStats( Player SelectedOppnt, int selectedPlwins, int selectedPlLosses, int Draws) {
        this.gamesWon += selectedPlwins;
        this.gamesLost += selectedPlLosses;
        this.gamesDrawn += Draws;
        this.gamesPlayed += selectedPlwins + selectedPlLosses + Draws;
        
        
        SelectedOppnt.gamesWon += selectedPlLosses;
        SelectedOppnt.gamesLost +=  selectedPlwins;
        SelectedOppnt.gamesDrawn += Draws;
        SelectedOppnt.gamesPlayed += selectedPlwins + selectedPlLosses + Draws;
    }

    Player getCopy() {
        Player p = new Player();
        
        p.firstName = this.firstName;
        p.lastName = this.lastName;
        p.id = this.id;
        p.gamesPlayed = this.gamesPlayed ;
        p.gamesWon = this.gamesWon;
        p.gamesLost = this.gamesLost;
        p.gamesDrawn = this.gamesDrawn;  
        p.highestRating = this.highestRating;
        p.lowestRating = this.lowestRating;
        p.currentRating = this.currentRating; // what should be the default rank?
        p.DatabaseRank = this.DatabaseRank;
        return p;
    }
    
    
}
