/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometriccollector;

import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * ‘******************************************************
 * ‘***  FileWriter
 * ‘***  Author: Erik Clary
 * ‘******************************************************
 * ‘*** Purpose: This class captures the key input from the user.
 * ‘******************************************************
 * ‘*** October 14, 2015
 * ‘******************************************************
 * ‘*** Oct 14: Initial code written
 * ‘*** Oct 26: Modified constructor to use a File instead of RandomAccessFile
 * ‘*** Oct 26: Added appropriate methods to handle writing to File, deleted methods used for RandomAccessFile
 * ‘*** Nov 13: Modified filewriter to use BufferedWriter, this way a buffer is included with the writer.
 * ‘******************************************************
 * ‘*** Look at this!
 * ‘*** List all the places in the code where you did something interesting,
 * ‘*** clever or elegant.  If you did good work in this program and you want
 * ‘*** me to consider it in your grade, point it out here.
 * ‘*******************************************************
 */
public class FileWriter {
    File usedFile;
    BufferedWriter bWriter;
    
    /*
    ‘******************************************************
    ‘***  FileWriter
    ‘***  Author: Erik Clary
    ‘******************************************************
    ‘*** Purpose: This method sets the random access file to rw and gives it the file to use.
    ‘*** Method Inputs:
    ‘*** N/A
    ‘*** Return value:
    ‘*** N/A
    ‘******************************************************
    ‘*** October 14, 2015
    ‘******************************************************
    */
    public FileWriter() throws FileNotChosenException {    
        JOptionPane.showMessageDialog(null, "Please enter your user ID as the filename.");
        JFileChooser myChooser = new JFileChooser();
        myChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = myChooser.showSaveDialog(myChooser);
        if(result != JFileChooser.CANCEL_OPTION)
            usedFile = myChooser.getSelectedFile();
        else{
            throw new FileNotChosenException();
        }
        try{
            bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(usedFile)));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new Frame(),ex.getMessage());
        }
    }
    
    /*
    ‘******************************************************
    ‘***  addToBuffer
    ‘***  Author: Erik Clary
    ‘******************************************************
    ‘*** Purpose: This method adds the keys to the FileBuffer.
    ‘***          The keys are added by their toString form.
    ‘*** Method Inputs:
    ‘*** N/A
    ‘*** Return value:
    ‘*** N/A
    ‘******************************************************
    ‘*** November 13, 2015
    ‘******************************************************
    */
    public void addToBuffer(KeyPress key){
        try {
            bWriter.append(key.toString());
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    ‘******************************************************
    ‘***  flushBuffer
    ‘***  Author: Erik Clary
    ‘******************************************************
    ‘*** Purpose: This method writes whatever has been added to the buffer to the file.
    ‘*** Method Inputs:
    ‘*** N/A
    ‘*** Return value:
    ‘*** N/A
    ‘******************************************************
    ‘*** November 13, 2015
    ‘******************************************************
    */
    public void flushBuffer(){
        try {
            bWriter.flush();
            bWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 /*
 * ‘******************************************************
 * ‘***  FileNotChosenException
 * ‘***  Author: Erik Clary
 * ‘******************************************************
 * ‘*** Purpose: This class contans the exception when the user decides not to choose a file.
 * ‘******************************************************
 * ‘*** November 13, 2015
 * ‘******************************************************
 * ‘*** Nov 13: Initial code written
 * ‘******************************************************
 * ‘*** Look at this!
 * ‘*** List all the places in the code where you did something interesting,
 * ‘*** clever or elegant.  If you did good work in this program and you want
 * ‘*** me to consider it in your grade, point it out here.
 * ‘*******************************************************
 */
    public static class FileNotChosenException extends Exception {
        
        private String msg;
        public FileNotChosenException() {
            msg = "File not chosen, any data will be lost.";
        }
        
        public String getMessage(){
            return msg;
        }
    }
}
