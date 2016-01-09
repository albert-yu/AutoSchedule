package com.opencsv;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

/**
 * A GUI for AutoSchedule
 * @author Albert Yu
 *
 */
@SuppressWarnings("serial")
public class GUI extends JFrame
{
   private JTextArea guiConsole = new JTextArea();
   private JTextArea userTextArea = new JTextArea();
   private JFileChooser fileChooser = new JFileChooser();
   private File file;
   
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
      
      // add greeting message to console
      guiConsole.setText("Hello and welcome! To begin, press the 'Open' button!\n");
      // make sure console scrolls and line wraps
      guiConsole.setAutoscrolls(true);
      guiConsole.setLineWrap(true);
      JScrollPane console = new JScrollPane(guiConsole);
      
      inputPanel.add(openButton);
      inputPanel.add(userTextArea);
      inputPanel.add(submitButton);
      
      contents.setLayout(new BorderLayout());
      contents.add(inputPanel, BorderLayout.SOUTH);
      contents.add(console, BorderLayout.CENTER);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      setSize(400, 600);
      setVisible(true);
   }
   
   private class OpenListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         try
         {
            // Customize our file opening dialogue window
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                  "CSV Files", "csv");
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Open CSV file");
            
            // opens file chooser
            fileChooser.showOpenDialog(getParent());
            
            file = fileChooser.getSelectedFile();
   
            // prints out pathname
            userTextArea.setText(null);
            userTextArea.append(file.getPath());
         }
         
         catch (NullPointerException err)
         {
            
         }
      }
   }

   private class SubmitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Interact with file here
         try
         {
            HashMap2D<String, ArrayList<String>> masterSched = AutoSchedule.fillMasterSched(file.getAbsolutePath());
            for (int i = 0; i < Schedule.weekdays.length; i++)
            {
               guiConsole.append(Schedule.weekdays[i] + ": ");
               guiConsole.append("\n");
               guiConsole.append("\n");
               for (int j = 0; j < Schedule.listOfTimes.length; j++)
               {
                  guiConsole.append("Students available at " + Schedule.listOfTimes[j]);
                  guiConsole.append("\n");
                  guiConsole.append((masterSched.get(Schedule.weekdays[i], Schedule.listOfTimes[j])).toString());
                  guiConsole.append("\n");
                  guiConsole.append("\n");
               }
            }
         }
         
         catch (NullPointerException err)
         {
            guiConsole.append("No file selected. Use the 'Open' button to browse for a file!");
            guiConsole.append("\n");
         }
      }
   }

   public static void main(String[] args)
   {
      new GUI();
   }
}
