package com.opencsv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A GUI for AutoSchedule
 * @author Albert Yu
 *
 */
public class GUI extends JFrame
{
   private JTextArea textArea = new JTextArea();
   private JTextField userInputField = new JTextField();
   
   public GUI()
   {
      // set the window title
      super("AutoSchedule! Yay!");
      
      // get the content pane so we can add stuff to it
      Container content = getContentPane();
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      setSize(400, 600);
      setVisible(true);
   }

   private class SubmitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // String input = userInputField.getText() <- contains filename
      }
   }

   public static void main(String[] args)
   {
      new GUI();
   }
}
