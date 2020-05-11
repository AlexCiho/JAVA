package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Main {

    public static void main(String[] args) {
        DrawingFrame f = new DrawingFrame("Test");
        f.setLayout (new FlowLayout());
        f.setVisible(true);
    }
}
