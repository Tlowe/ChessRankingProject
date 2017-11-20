/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chessrankingproject;

/**
 *
 * @author Travis Lowe
 */

import java.io.File;
import java.nio.file.Files;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DataBasetoXML {
    private PlayerArrayList dbPlayerList;
    DocumentBuilderFactory PlayerDocFactory;
    DocumentBuilder PlayerDocBuilder;
    Document PlayerDoc;
   
    NodeList nodeList;
    
    File xmlDBfile;
    private ArrayList<PlayerEventListener> listenerList = new ArrayList<>();
    public DataBasetoXML(){ // default constructor
        
    }
    
    
    
    public DataBasetoXML(String PlayerFirst, String PlayerLast)throws Exception{ // create a brand new database with a basic player as an argument
        PlayerDocFactory = DocumentBuilderFactory.newInstance();
        PlayerDocBuilder = PlayerDocFactory.newDocumentBuilder();
        
        PlayerDoc = PlayerDocBuilder.newDocument();
        
        Element PlayerDatabase = PlayerDoc.createElement("PlayerDatabase");
        PlayerDoc.appendChild(PlayerDatabase);
        
        Element player = PlayerDoc.createElement("Player");
        PlayerDatabase.appendChild(player);
        
        Element firstName = PlayerDoc.createElement("FirstName");
        firstName.appendChild(PlayerDoc.createTextNode(PlayerFirst));
        player.appendChild(firstName);
        
        Element lastName = PlayerDoc.createElement("lastName");
        lastName.appendChild(PlayerDoc.createTextNode(PlayerLast));
        player.appendChild(lastName);
        
        Element pID = PlayerDoc.createElement("ID");
        pID.appendChild(PlayerDoc.createTextNode("0"));
        player.appendChild(pID);
        
        Element gamesPlayed = PlayerDoc.createElement("gamesPlayed");
        gamesPlayed.appendChild(PlayerDoc.createTextNode("0"));
        player.appendChild(gamesPlayed);
        
        Element gamesWon = PlayerDoc.createElement("gamesWon");
        gamesWon.appendChild(PlayerDoc.createTextNode("0"));
        player.appendChild(gamesWon);
        
        Element gamesLost = PlayerDoc.createElement("gamesLost");
        gamesLost.appendChild(PlayerDoc.createTextNode("0"));
        player.appendChild(gamesLost);
        
        Element gamesDrawn = PlayerDoc.createElement("gamesDrawn");
        gamesDrawn.appendChild(PlayerDoc.createTextNode("0"));
        player.appendChild(gamesDrawn);
        
        Element highestRating = PlayerDoc.createElement("highestRating");
        highestRating.appendChild(PlayerDoc.createTextNode("0"));
        player.appendChild(highestRating);
        
        Element lowestRating = PlayerDoc.createElement("lowestRating");
        lowestRating.appendChild(PlayerDoc.createTextNode("0"));
        player.appendChild(lowestRating);
        
        Element currentRating = PlayerDoc.createElement("currentRating");
        currentRating.appendChild(PlayerDoc.createTextNode("0"));
        player.appendChild(currentRating);
        
        Element DatabaseRank = PlayerDoc.createElement("DatabaseRank");
        DatabaseRank.appendChild(PlayerDoc.createTextNode("0"));
        player.appendChild(DatabaseRank);
        
        Element playerHistory = PlayerDoc.createElement("PlayerHistory");
        player.appendChild(playerHistory);
        
        Element result = PlayerDoc.createElement("gameResult");
        result.appendChild(PlayerDoc.createTextNode("1")); // 1 is for win
        playerHistory.appendChild(result);
        
        Element plRating = PlayerDoc.createElement("playerRating");
        plRating.appendChild(PlayerDoc.createTextNode("1300")); // 1 is for win
        playerHistory.appendChild(plRating);
        
        Element Opponent = PlayerDoc.createElement("Opponent");
        playerHistory.appendChild(Opponent);
        
        Element oppFirstName = PlayerDoc.createElement("oppFirstName");
        oppFirstName.appendChild(PlayerDoc.createTextNode("Neegan"));
        Opponent.appendChild(oppFirstName);
        
        Element oppLastName = PlayerDoc.createElement("oppLastName");
        oppLastName.appendChild(PlayerDoc.createTextNode("Opps"));
        Opponent.appendChild(oppLastName);
        
        Element opponentID = PlayerDoc.createElement("oppID");
        opponentID.appendChild(PlayerDoc.createTextNode("245"));
        Opponent.appendChild(opponentID);
        
        Element opponentRating = PlayerDoc.createElement("oppRating");
        opponentRating.appendChild(PlayerDoc.createTextNode("1500"));
        Opponent.appendChild(opponentRating);
        
        Element date = PlayerDoc.createElement("date");
        date.appendChild(PlayerDoc.createTextNode("12-11-17"));
        playerHistory.appendChild(date);
        
        Element time = PlayerDoc.createElement("time");
        time.appendChild(PlayerDoc.createTextNode("12:37:52"));
        playerHistory.appendChild(time);
        
       
        
       
        
        TransformerFactory TrannyFactory  = TransformerFactory.newInstance();
        Transformer tranny = TrannyFactory.newTransformer();
        tranny.setOutputProperty(OutputKeys.INDENT, "yes");
        tranny.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source  = new DOMSource(PlayerDoc);
        
        
        
        //Path root = Paths.get("C://ChessGame");
//        Path root = Paths.get(System.getProperty("user.home"), "ChessGame");
//        
//        try {
//            Files.createDirectory(root);// create chessGame directory in windows or linux (maybe mac??)
//        }
//        catch(FileAlreadyExistsException e){
//            System.out.println("Its ok. The Chess Game File directory already exists. Carry on");
//        }
//        catch (Exception e) {
//            System.out.println("Failed because" + e);
//        }
// 
        
        
        
        
        StreamResult streamResult = new StreamResult(new File("PlayerDataBase.xml"));
        
        tranny.transform(source, streamResult);
        
        
        
    }
    
    
    
   

    public PlayerArrayList getAllPlayersSorted(PlayerArrayList inPlayers)throws Exception {
        try {
            
        
        //xmlDBfile = new File("C://ChessGame//PlayerDataBase.xml");
        xmlDBfile = new File("PlayerDataBase.xml");
        
        NodeList playerNodeList;
        NodeList historyNodeList;
        PlayerDocFactory = DocumentBuilderFactory.newInstance();
        PlayerDocBuilder = PlayerDocFactory.newDocumentBuilder();
        
        PlayerDoc = PlayerDocBuilder.parse(xmlDBfile);
        PlayerDoc.getDocumentElement().normalize();
        
        
        playerNodeList = PlayerDoc.getElementsByTagName("Player");
        dbPlayerList = new PlayerArrayList();
        for(int i = 0; i< playerNodeList.getLength();i++){
         
         Element playerElement = (Element)playerNodeList.item(i);
         Player tempPlayer = new Player(playerElement) ;
         
         historyNodeList = playerElement.getElementsByTagName("PlayerHistory");
         for(int j = 0; j< historyNodeList.getLength();j++){
         
         Element histElement = (Element)historyNodeList.item(j);
         
         PlayerHistory tempPlayerHist = new PlayerHistory(histElement);
         
         
         
         
         tempPlayer.addToGameHistory(tempPlayerHist);
         
         
         }
         
         
        dbPlayerList.add(tempPlayer);
         inPlayers.add(tempPlayer);
        
            System.out.println("Pulled Player " + tempPlayer.getFirstName() + " " + tempPlayer.getLastName() + " from database");
            
        }
           
        Collections.sort(dbPlayerList, Comparator.comparing(Player::getLastName));
        
        return dbPlayerList.getPlayerArrayListCopy();
        
        } catch (Exception e) {
          
            fireEvent(new PlayerTextEvent("No database found. Please add a new player.\n\n** optionally: \nif you"
                    + " have a PlayerDatabaseXML file in the correct format, add it to the same directory as this\n"
                    + "program and then restart the program."));
        }
        
        return null;
        
    }

    void recalculateDatabaseRankings(PlayerArrayList newPlayerList) throws ParserConfigurationException {
        
        try {
           
            
            // sort first by rating and then by name
            Collections.sort(newPlayerList, Collections.reverseOrder(Comparator.comparing(Player::getCurrentRating).thenComparing(Player::getLastName).reversed()));
            // once sorted, sequentially reassign Database rank;
            // Dummy Comment
            int i = newPlayerList.size() ;
            for(Player p : newPlayerList){
                p.setDatabaseRank(i--);
                
            }
            //call rewrite database with this new list
            rewriteDatabase(newPlayerList);
        } catch (TransformerException ex) {
            Logger.getLogger(DataBasetoXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void rewriteDatabase(PlayerArrayList DatabaseList) throws ParserConfigurationException, TransformerConfigurationException, TransformerException{
        
        PlayerDocFactory = DocumentBuilderFactory.newInstance();
        PlayerDocBuilder = PlayerDocFactory.newDocumentBuilder();
        
        PlayerDoc = PlayerDocBuilder.newDocument();
        
        Element PlayerDatabase = PlayerDoc.createElement("PlayerDatabase");
        PlayerDoc.appendChild(PlayerDatabase);
        
        
        for(Player p : DatabaseList){
        
        Element player = PlayerDoc.createElement("Player");
        PlayerDatabase.appendChild(player);
        
        Element firstName = PlayerDoc.createElement("FirstName");
        firstName.appendChild(PlayerDoc.createTextNode(p.getFirstName()));
        player.appendChild(firstName);
        
        Element lastName = PlayerDoc.createElement("lastName");
        lastName.appendChild(PlayerDoc.createTextNode(p.getLastName()));
        player.appendChild(lastName);
        
        Element pID = PlayerDoc.createElement("ID");
        pID.appendChild(PlayerDoc.createTextNode(Integer.toString(p.getId())));
        player.appendChild(pID);
        
        Element gamesPlayed = PlayerDoc.createElement("gamesPlayed");
        gamesPlayed.appendChild(PlayerDoc.createTextNode(Integer.toString(p.getGamesPlayed())));
        player.appendChild(gamesPlayed);
        
        Element gamesWon = PlayerDoc.createElement("gamesWon");
        gamesWon.appendChild(PlayerDoc.createTextNode(Integer.toString(p.getGamesWon())));
        player.appendChild(gamesWon);
        
        Element gamesLost = PlayerDoc.createElement("gamesLost");
        gamesLost.appendChild(PlayerDoc.createTextNode(Integer.toString(p.getGamesLost())));
        player.appendChild(gamesLost);
        
        Element gamesDrawn = PlayerDoc.createElement("gamesDrawn");
        gamesDrawn.appendChild(PlayerDoc.createTextNode(Integer.toString(p.getGamesDrawn())));
        player.appendChild(gamesDrawn);
        
        Element highestRating = PlayerDoc.createElement("highestRating");
        highestRating.appendChild(PlayerDoc.createTextNode(Float.toString(p.getHighestRating())));
        player.appendChild(highestRating);
        
        Element lowestRating = PlayerDoc.createElement("lowestRating");
        lowestRating.appendChild(PlayerDoc.createTextNode(Float.toString(p.getLowestRating())));
        player.appendChild(lowestRating);
        
        Element currentRating = PlayerDoc.createElement("currentRating");
        currentRating.appendChild(PlayerDoc.createTextNode(Float.toString(p.getCurrentRating())));
        player.appendChild(currentRating);
        
        Element DatabaseRank = PlayerDoc.createElement("DatabaseRank");
        DatabaseRank.appendChild(PlayerDoc.createTextNode(Integer.toString(p.getDatabaseRank())));
        player.appendChild(DatabaseRank);
        
        
        for(PlayerHistory pH : p.getGameHistory()){
        
            Element playerHistory = PlayerDoc.createElement("PlayerHistory");
            player.appendChild(playerHistory);

            Element result = PlayerDoc.createElement("gameResult");
            result.appendChild(PlayerDoc.createTextNode(Integer.toString(pH.getResultCode()))); // 1 is for win
            playerHistory.appendChild(result);
            
            Element plRating = PlayerDoc.createElement("playerRating");
            plRating.appendChild(PlayerDoc.createTextNode(Float.toString(pH.Player.getCurrentRating()))); // 1 is for win
            playerHistory.appendChild(plRating);

            Element Opponent = PlayerDoc.createElement("Opponent");
            playerHistory.appendChild(Opponent);

            Element oppFirstName = PlayerDoc.createElement("oppFirstName");
            oppFirstName.appendChild(PlayerDoc.createTextNode(pH.Opponent.getFirstName()));
            Opponent.appendChild(oppFirstName);

            Element oppLastName = PlayerDoc.createElement("oppLastName");
            oppLastName.appendChild(PlayerDoc.createTextNode(pH.Opponent.getLastName()));
            Opponent.appendChild(oppLastName);

            Element opponentID = PlayerDoc.createElement("oppID");
            opponentID.appendChild(PlayerDoc.createTextNode(Integer.toString(pH.Opponent.getId())));
            Opponent.appendChild(opponentID);

            Element opponentRating = PlayerDoc.createElement("oppRating");
            opponentRating.appendChild(PlayerDoc.createTextNode(Float.toString(pH.Opponent.getCurrentRating())));
            Opponent.appendChild(opponentRating);

            Element date = PlayerDoc.createElement("date");
            date.appendChild(PlayerDoc.createTextNode(pH.getDate()));
            playerHistory.appendChild(date);

            Element time = PlayerDoc.createElement("time");
            time.appendChild(PlayerDoc.createTextNode(pH.getTime()));
            playerHistory.appendChild(time);
        }
        }
        
        TransformerFactory TrannyFactory  = TransformerFactory.newInstance();
        Transformer tranny = TrannyFactory.newTransformer();
        tranny.setOutputProperty(OutputKeys.INDENT, "yes");
        tranny.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source  = new DOMSource(PlayerDoc);
        
        
        
        Path root = Paths.get("C://ChessGame");
        //Path root = Paths.get(System.getProperty("user.home"), "ChessGame");
        
        try {
            Files.createDirectory(root);// create chessGame directory in windows or linux (maybe mac??)
        }
        catch(FileAlreadyExistsException e){
            System.out.println("Its ok. The Chess Game File directory already exists. Carry on");
        }
        catch (Exception e) {
            System.out.println("Failed because" + e);
        }
 
        
        
        
        
        //StreamResult streamResult = new StreamResult(new File("C://ChessGame//PlayerDataBase.xml"));
        StreamResult streamResult = new StreamResult(new File("PlayerDataBase.xml"));
        
        tranny.transform(source, streamResult);
        
        
        
        
        
        
    }
    
    
     public void AddPlayertoDatabase(Player newPlayer){
        // this function should throw an exception if no database exists
        // this function should throw an exception if player already exists
        
        // add xml code to search through file to check if player exists. if not update database with new player
    
    }
    
    private void removePlayerFromDatabase(Player toRemovePlayer){
    
        // parse through database by id ??
        
    }

        
    
    public synchronized void addListener (PlayerEventListener listener){ // add functions that will listen for the changes on this frame
        
        listenerList.add(listener);
    
    }
    
    private synchronized void fireEvent(java.util.EventObject evt){
        
        if(evt instanceof PlayerTextEvent){
          
                for(PlayerEventListener eachplistener : listenerList){

                    eachplistener.updateDebugText(((PlayerTextEvent) evt).getText());
                    }
        
        
        }
    }
}



     