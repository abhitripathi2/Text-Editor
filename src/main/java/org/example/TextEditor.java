package org.example;


import javax.swing.*;

public class TextEditor {

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
    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor();
    }
}