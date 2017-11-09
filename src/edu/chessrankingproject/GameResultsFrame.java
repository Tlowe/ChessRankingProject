/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chessrankingproject;

import java.awt.event.TextEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Travis Lowe
 */
public class GameResultsFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewGameResultsFrame
     */
    private PlayerArrayList PlayerList = new PlayerArrayList();
    private PlayerArrayList OldPlayerList = new PlayerArrayList();
    public PlayerArrayList  OpponentList = new PlayerArrayList();
    DefaultListModel<Player> PlayerListModel = new DefaultListModel<>();
    DefaultListModel<Player> OpponentListModel = new DefaultListModel<>();
    Player SelectedPlayer = new Player();
    Player SelectedOppnt = new Player();
    
    private ArrayList<PlayerEventListener> listenerList = new ArrayList<>();
    private boolean GoodResults;
    
    
    public synchronized void addListener (PlayerEventListener listener){ // add functions that will listen for the changes on this frame
        
        listenerList.add(listener);
    
    }
    
    
    public GameResultsFrame() {
        initComponents();
    }

    public GameResultsFrame(PlayerArrayList plist) {
        initComponents();
        this.PlayerList =  plist.getPlayerArrayListCopy();
        this.OldPlayerList =  plist.getPlayerArrayListCopy();
        
        intialSetup();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        winsTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        LossTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        DrawsTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        UpdateResultsButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        ChooseOpponentLastTextField = new javax.swing.JTextField();
        OpponentSearchButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ChosenOpponentList = new javax.swing.JList<Player>();
        jPanel6 = new javax.swing.JPanel();
        PlayerSearchButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ChosenPlayerList = new javax.swing.JList<Player>();
        ChoosePlayerLastTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DebugResultsTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setText("1. Choose Player :");

        jLabel3.setText("2. Choose Opponent :");

        jLabel4.setText("3. Enter Game Results :");

        jButton2.setText("OK");

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 300));

        winsTextField.setText(" ");
        winsTextField.setPreferredSize(new java.awt.Dimension(10, 20));

        jLabel1.setText("Win(s)");

        LossTextField.setText(" ");
        LossTextField.setPreferredSize(new java.awt.Dimension(10, 20));

        jLabel5.setText("Loss(es)");

        DrawsTextField.setText(" ");

        jLabel6.setText("Draw(s)");

        UpdateResultsButton.setText("Update");
        UpdateResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateResultsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(winsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LossTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DrawsTextField))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UpdateResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(winsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LossTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DrawsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UpdateResultsButton)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ChooseOpponentLastTextField.setText("Search Last Name . . .");
        ChooseOpponentLastTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChooseOpponentLastTextFieldMouseClicked(evt);
            }
        });

        OpponentSearchButton.setText("Search");

        ChosenOpponentList.setModel(OpponentListModel);
        ChosenOpponentList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ChosenOpponentListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ChosenOpponentList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ChooseOpponentLastTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OpponentSearchButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(ChooseOpponentLastTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OpponentSearchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PlayerSearchButton.setText("Search");
        PlayerSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerSearchButtonActionPerformed(evt);
            }
        });

        ChosenPlayerList.setModel(PlayerListModel);
        ChosenPlayerList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ChosenPlayerListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(ChosenPlayerList);

        ChoosePlayerLastTextField.setText("Search Last Name . . .");
        ChoosePlayerLastTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChoosePlayerLastTextFieldMouseClicked(evt);
            }
        });
        ChoosePlayerLastTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoosePlayerLastTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ChoosePlayerLastTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerSearchButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(ChoosePlayerLastTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlayerSearchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("New Game Results");

        DebugResultsTextArea.setBackground(new java.awt.Color(240, 240, 240));
        DebugResultsTextArea.setColumns(20);
        DebugResultsTextArea.setRows(5);
        jScrollPane1.setViewportView(DebugResultsTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(205, 205, 205)
                .addComponent(jLabel4)
                .addGap(127, 127, 127))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChoosePlayerLastTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoosePlayerLastTextFieldActionPerformed
        
    }//GEN-LAST:event_ChoosePlayerLastTextFieldActionPerformed

    private void ChoosePlayerLastTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChoosePlayerLastTextFieldMouseClicked
      ChoosePlayerLastTextField.setText("");
    }//GEN-LAST:event_ChoosePlayerLastTextFieldMouseClicked

    private void ChooseOpponentLastTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChooseOpponentLastTextFieldMouseClicked
       ChooseOpponentLastTextField.setText("");
    }//GEN-LAST:event_ChooseOpponentLastTextFieldMouseClicked

    private void PlayerSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayerSearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlayerSearchButtonActionPerformed

    private void UpdateResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateResultsButtonActionPerformed
        
        int wins = 0;
        int losses = 0;
        int draws = 0;
        try {
            try {
                 wins = Integer.parseInt(winsTextField.getText().trim());
            } catch (Exception e) {
                DebugResultsTextArea.append("invalid entry changing wins to 0\n\n");
                wins = 0;
            }
            
            try {
                 losses = Integer.parseInt(LossTextField.getText().trim());
            } catch (Exception e) {
                DebugResultsTextArea.append("invalid entry changing losses to 0\n\n");
                losses = 0;
            }
            
            try {
                 draws = Integer.parseInt(DrawsTextField.getText().trim());
            } catch (Exception e) {
                DebugResultsTextArea.append("invalid entry changing losses to 0\n\n");
                draws = 0;
            }
            
            
            
            javax.swing.JPanel pan = new dialogForm(OldPlayerList,SelectedPlayer,SelectedOppnt, wins,losses,draws);
            
            
          
            int result = JOptionPane.showConfirmDialog(null,pan, "Confirmation Window",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
    
            
                SelectedPlayer.updateStats(SelectedOppnt, wins, losses,draws);
        
                fireEvent(new UpdateDatabaseEvent(PlayerList));
                fireEvent(new PlayerTextEvent(" Player " + SelectedPlayer.getCombinedName() + " and Player " + SelectedOppnt.getCombinedName()+ " have updated stats"));
                
            
            } else {
                DebugResultsTextArea.append("User canceled. No player stats were updated.\n\n");
            }
              
              
            
             
             
        } catch (NullPointerException e) {
         
        }catch(NumberFormatException e){
        
        DebugResultsTextArea.setText("Invalid entry :\n\n only Integers are allowed for Win/Lose/Draw entries");
        }catch(Exception e){
        
            DebugResultsTextArea.setText("Something Bad Happened. Try Again");
        }
        
        
        
       
    }//GEN-LAST:event_UpdateResultsButtonActionPerformed

    private void ChosenPlayerListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ChosenPlayerListValueChanged
        
        OpponentListModel.clear();
        SelectedPlayer = ChosenPlayerList.getSelectedValue();
        OpponentList =  PlayerList.getPlayerArrayListCopy();
        OpponentList.remove(SelectedPlayer);
        
        Iterator<Player> itP = OpponentList.listIterator();
        
        while(itP.hasNext()){
        
         if(itP.next().getId() == SelectedPlayer.getId()){
             
             itP.remove();
             break;
         }
        
        }
        
        for (Player p : OpponentList){
            
            OpponentListModel.addElement(p);
        }
        ChosenOpponentList.setModel(OpponentListModel);
        
        
    }//GEN-LAST:event_ChosenPlayerListValueChanged

    private void ChosenOpponentListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ChosenOpponentListValueChanged
        SelectedOppnt = ChosenOpponentList.getSelectedValue();
        UpdateResultsButton.setEnabled(true);
    }//GEN-LAST:event_ChosenOpponentListValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fireEvent( new WindowClosingEvent(evt));
    }//GEN-LAST:event_formWindowClosing

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
       fireEvent( new WindowClosingEvent(evt));
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameResultsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameResultsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameResultsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameResultsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameResultsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField ChooseOpponentLastTextField;
    private javax.swing.JTextField ChoosePlayerLastTextField;
    private javax.swing.JList<Player> ChosenOpponentList;
    private javax.swing.JList<Player> ChosenPlayerList;
    private javax.swing.JTextArea DebugResultsTextArea;
    private javax.swing.JTextField DrawsTextField;
    private javax.swing.JTextField LossTextField;
    private javax.swing.JButton OpponentSearchButton;
    private javax.swing.JButton PlayerSearchButton;
    private javax.swing.JButton UpdateResultsButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField winsTextField;
    // End of variables declaration//GEN-END:variables

    private void intialSetup() {
        
        
        for (Player p : PlayerList){
            
            PlayerListModel.addElement(p);
        }
        ChosenPlayerList.setModel(PlayerListModel);
        UpdateResultsButton.setEnabled(false);
    }
    
    
    
    
    private synchronized void fireEvent(java.util.EventObject evt){
        
        if (evt instanceof UpdateDatabaseEvent){ 
    
                if( !( PlayerList == null || PlayerList.isEmpty() )  ){    
                    for(PlayerEventListener eachplistener : listenerList){

                    eachplistener.updateDatabase(PlayerList);
                    }
                }
        }
        else if(evt instanceof PlayerTextEvent){
          
                for(PlayerEventListener eachplistener : listenerList){

                    eachplistener.updateDebugText(((PlayerTextEvent) evt).getText());
                    }
        
        
        }
        
        else if(evt instanceof WindowClosingEvent){
        
            for(PlayerEventListener eachplistener : listenerList){

                    eachplistener.windowClosing();
                    }
        
        }
    }
    
    
}
