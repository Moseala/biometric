/*
 * ‘******************************************************
 * ‘***  BiometicCollector
 * ‘***  Author: Erik Clary
 * ‘******************************************************
 * ‘*** Purpose: This is the main class for the program.
 * ‘******************************************************
 * ‘*** October 14, 2015
 * ‘******************************************************
 * ‘*** Oct 14: Initial code written
 * ‘******************************************************
 * ‘*** Look at this!
 * ‘*** List all the places in the code where you did something interesting,
 * ‘*** clever or elegant.  If you did good work in this program and you want
 * ‘*** me to consider it in your grade, point it out here.
 * ‘*******************************************************
 */
package biometriccollector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Erik
 */
public class MainBMGUI extends javax.swing.JFrame{
    /*
    ‘******************************************************
    ‘***  updateAndOrgainze
    ‘***  Author: Erik Clary
    ‘******************************************************
    ‘*** Purpose: This method updates and orgainizes the gui.
    ‘*** Method Inputs:
    ‘*** N/A
    ‘*** Return value:
    ‘*** N/A
    ‘******************************************************
    ‘*** October 14, 2015
    ‘******************************************************
    */
    private void updateAndOrgainize(){
        HashMap<Integer, Integer> keyCount = new HashMap<>();
        if(true){
            keystrokesAL.sort(null); //orgainizes inputs so to avoid reconstrucing what the user types.
            for(KeyPress x : keystrokesAL){ //this loop goes over all entries in keystrokesAL (the user's inputs) and re-calculates the 
                try{
                    Integer added = keyCount.get(x.getUnicodeValue())+1;//literally: for every key pressed, add its unicode value to the hashmap (null returned from get), if found, add 1 to its hash value.
                    keyCount.put(x.getUnicodeValue(), added);
                }
                catch(NullPointerException npex){
                    keyCount.put(x.getUnicodeValue(), 1);
                }
            }
            updateProgressBars(getTop10(keyCount));
            
            if(testFinished(keyCount)){
                //flush to file and end the program NOT IMPLEMENTED YET
                JOptionPane.showMessageDialog(null, "Test is finished.");
                outFile.flushBuffer();
            }
            
        }
    }
    /*
    ‘******************************************************
    ‘***  updateProgressBars
    ‘***  Author: Erik Clary
    ‘******************************************************
    ‘*** Purpose: This method updates the progress bars on the gui.
    ‘*** Method Inputs:
    ‘*** N/A
    ‘*** Return value:
    ‘*** N/A
    ‘******************************************************
    ‘*** October 14, 2015
    ‘******************************************************
    */
    private void updateProgressBars(ArrayList<KeyCountWrapper> aList){
        try{
            pb0.setMaximum(MINNUMACCEPTED);
            pb0.setValue(aList.get(0).getCount());
        }
        catch(IndexOutOfBoundsException iooEx){
            
        }
    }
    
    /*
    ‘******************************************************
    ‘***  testFinished
    ‘***  Author: Erik Clary
    ‘******************************************************
    ‘*** Purpose: This method tests to see if the test is finished or not.
    ‘*** Method Inputs:
    ‘*** N/A
    ‘*** Return value:
    ‘*** N/A
    ‘******************************************************
    ‘*** October 14, 2015
    ‘******************************************************
    */
    private boolean testFinished(HashMap keyCount){
        int totalOverMIN = 0;
        Iterator<Map.Entry<Integer, Integer>> iMap = keyCount.entrySet().iterator();
        while(iMap.hasNext()){
            if(iMap.next().getValue()>=MINNUMACCEPTED)//i hope that works >> next returns each key?
                totalOverMIN++;
        } //code adapted from http://examples.javacodegeeks.com/core-java/util/hashmap/java-hashmap-example/
        return totalOverMIN >= MINDIFFERENT;
    }
    
    /*
    ‘******************************************************
    ‘***  getTop10
    ‘***  Author: Erik Clary
    ‘******************************************************
    ‘*** Purpose: This method gets only the top 10 key presses and puts them into a list for the gui to use.
    ‘*** Method Inputs:
    ‘*** N/A
    ‘*** Return value:
    ‘*** N/A
    ‘******************************************************
    ‘*** October 14, 2015
    ‘******************************************************
    */
    public ArrayList getTop10(HashMap keyCount){
        ArrayList<KeyCountWrapper> top10  = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iMap = keyCount.entrySet().iterator();
        while(iMap.hasNext()){
            Map.Entry<Integer, Integer> x = iMap.next();
            top10.add(new KeyCountWrapper(x.getKey(), x.getValue()));
        }
        top10.sort(null);
        return top10;
    }

    /**
     * Creates new form MainBMGUI
     */
    public MainBMGUI() {
        initComponents();
        try {
            outFile = new FileWriter();
        } catch (FileWriter.FileNotChosenException ex2) {
            JOptionPane.showMessageDialog(this,ex2.getMessage());
        }
        Random n = new Random();
        if(n.nextInt(40) > 20){
            //these will be the guided prompts, asking a user to transcribe a document
        }
        else
        {
            //these will be the creative prompts, where the user is asked to describe something they have done 
            //these prompts must be expansive enough for the user to be able to hit their minimum difference.
            //maybe these prompts will have to end after a time period or with a completion button.
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar12 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMain = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pb0 = new javax.swing.JProgressBar();
        lbl0 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taMain.setColumns(20);
        taMain.setLineWrap(true);
        taMain.setRows(5);
        taMain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taMainKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                taMainKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taMainKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(taMain);

        lbl0.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextPane1.setEditable(false);
        jScrollPane2.setViewportView(jTextPane1);
        jTextPane1.getAccessibleContext().setAccessibleName("txtPrompt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pb0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbl3)
                            .addComponent(lbl4)
                            .addComponent(lbl5)
                            .addComponent(lbl6)
                            .addComponent(lbl7)
                            .addComponent(lbl8)
                            .addComponent(lbl9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl0)
                            .addComponent(lbl1)
                            .addComponent(lbl2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl0, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl1)
                        .addGap(21, 21, 21)
                        .addComponent(lbl2)
                        .addGap(36, 36, 36)
                        .addComponent(lbl3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl4)
                        .addGap(20, 20, 20)
                        .addComponent(lbl5)
                        .addGap(36, 36, 36)
                        .addComponent(lbl6)
                        .addGap(22, 22, 22)
                        .addComponent(lbl7)
                        .addGap(24, 24, 24)
                        .addComponent(lbl8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl9)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addGap(28, 28, 28)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pb0, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void taMainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taMainKeyPressed
        startTime = System.nanoTime();
    }//GEN-LAST:event_taMainKeyPressed

    private void taMainKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taMainKeyReleased
        endTime = System.nanoTime();
        keystrokesAL.add(new KeyPress(evt.getKeyCode(),(endTime-startTime)));
        outFile.addToBuffer(new KeyPress(evt.getKeyCode(),(endTime-startTime)));
    }//GEN-LAST:event_taMainKeyReleased

    private void taMainKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taMainKeyTyped
        updateAndOrgainize();
    }//GEN-LAST:event_taMainKeyTyped

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
            java.util.logging.Logger.getLogger(MainBMGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainBMGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainBMGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainBMGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainBMGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbl0;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JProgressBar pb0;
    private javax.swing.JTextArea taMain;
    // End of variables declaration//GEN-END:variables
        
    private final int MINNUMACCEPTED = 10; //100
    private final int MINDIFFERENT = 10;
    private ArrayList<KeyPress> keystrokesAL = new ArrayList<>();
    private long startTime, endTime = 0;
    private FileWriter outFile;
}