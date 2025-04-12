package org.example;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        frame.add(textArea);





        //add menus to menubar
        menuBar.add(file);
        menuBar.add(edit);

        //

        //set menuBar to frame
        frame.setJMenuBar(menuBar);


        //set dimensions of the frame
        frame.setBounds(100, 100, 400, 400);
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
    }
    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor();
    }
}