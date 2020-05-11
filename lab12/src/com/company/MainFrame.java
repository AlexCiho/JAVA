package com.company;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainFrame extends JFrame {
     ControlPanel controlPanel;
        DesignPanel designPanel;
        public MainFrame() {
            super("Swing Designer");
            init();
        }
        private void init() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            //create and add to the frame the controlPanel and designPanel objects
            pack();
        }
    public static void main(String[] args) {
	// write your code here
    }
}
