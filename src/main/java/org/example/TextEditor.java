package org.example;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor implements ActionListener {

    //Declaring the properties of text Editor
    JFrame frame;

    JMenuBar menuBar;

    JMenu file, edit;

    //file menu item
    JMenuItem newFile, openFile, saveFile;
    //edit menu item
    JMenuItem cut, copy, paste, selectAll, close;

    //text area
    JTextArea textArea;


    TextEditor(){
        //Initialize a frame
        frame = new JFrame();

        //Initialize a menuBar
        menuBar = new JMenuBar();

        //Initialize text area
        textArea = new JTextArea();


        //Initialize menus
        file = new JMenu("File");
        edit = new JMenu("Edit");

        //Initialize file menuItems
        newFile = new JMenuItem("New Window");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");
        //add Action Listener to file menu item
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        //add these menu items to file menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        //Initialize EDIT menuItems
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");

        //add Action Listener to Edit menu items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        //add these menu items to edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        //add text area to frame
        //frame.add(textArea);

        //Create Content panel
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        //Add the text area to the panel
        panel.add(textArea, BorderLayout.CENTER);
        //Create Scroll Pane
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //Add the scroll pane to the panel
        panel.add(scrollPane);
        //add panel to the frame
        frame.add(panel);





        //add menus to menubar
        menuBar.add(file);
        menuBar.add(edit);

        //

        //set menuBar to frame
        frame.setJMenuBar(menuBar);


        //set dimensions of the frame
        frame.setBounds(100, 100, 400, 400);
        frame.setTitle("Text Editor");
        frame.setVisible(true);
        frame.setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if (actionEvent.getSource()==cut){
            //perform cut operation
            textArea.cut();
        }
        if (actionEvent.getSource()==copy){
            //perform copy operation
            textArea.copy();
        }
        if (actionEvent.getSource()==paste){
            //perform paste operation
            textArea.paste();
        }
        if (actionEvent.getSource()==selectAll){
            //perform select all operations
            textArea.selectAll();
        }
        if (actionEvent.getSource()==close){
            //perform close operation
            System.exit(0);
        }
        if (actionEvent.getSource()==openFile){
            //open a file chooser
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\abhit\\OneDrive\\Desktop");
            int chooseOption = fileChooser.showOpenDialog(null);
            //if we click on open button
            if (chooseOption==JFileChooser.APPROVE_OPTION){
                //getting selected option
                File file = fileChooser.getSelectedFile();
                //get the path of selected file
                String filePath = file.getPath();
                try {
                    //Initialize file read
                    FileReader fileReader = new FileReader(filePath);
                    //Initialize Buffered reader
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String intermediate = "", output = "";
                    //Read content of file line by line
                    while ((intermediate = bufferedReader.readLine())!=null){
                        output+=intermediate+"\n";
                    }
                    //Set the output String to text area
                    textArea.setText(output);
                }
                catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
        //if we click on save button
        if (actionEvent.getSource()==saveFile){
            //open a file chooser
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\abhit\\OneDrive\\Desktop");
            //get choose option from file chooser
            int chooseOption = fileChooser.showSaveDialog(null);
            //check if we click on sae button
            if (chooseOption==JFileChooser.APPROVE_OPTION){
                //create a new file with chosen directory path and file name
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                try {
                    //initialize file writer
                    FileWriter fileWriter = new FileWriter(file);
                    //Initialize buffered writer
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    //write contents of text area to file
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                }
                catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
        //if we click on new button
        if (actionEvent.getSource()==openFile){
            TextEditor newTextEditor = new TextEditor();
        }
    }
    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor();
    }
}