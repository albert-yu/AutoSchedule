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
   private JFileChooser fileChooser = new JFileChooser();
   
   public GUI()
   {
      // set the window title
      super("AutoSchedule! Yay!");
      
      // get the content pane so we can add stuff to it
      Container contents = getContentPane();
      
      JPanel inputPanel = new JPanel(new GridLayout(3, 1));
      
      JButton openButton = new JButton("Open");
      openButton.addActionListener(new OpenListener());
      
      JButton submitButton = new JButton("Submit");
      submitButton.addActionListener(new SubmitListener());
      
      inputPanel.add(openButton);
      inputPanel.add(textArea);
      inputPanel.add(submitButton);
      
      contents.setLayout(new BorderLayout());
      contents.add(inputPanel, BorderLayout.SOUTH);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      setSize(400, 600);
      setVisible(true);
   }
   
   private class OpenListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // opens file chooser
      }
   }

   private class SubmitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Interact with file here
      }
   }

   public static void main(String[] args)
   {
      new GUI();
   }
}
