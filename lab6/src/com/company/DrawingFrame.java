package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawingFrame extends JFrame {
    public DrawingFrame(String title){
        super(title);
        setSize(200,100);
    }

    public void paint(Graphics g) { super.paint(g);
// Apelam metoda paint a clasei Frame
        g.setFont(new Font("Arial", Font.BOLD, 11));
        g.setColor(Color.red);
        g.drawString("DEMO Version", 5, 35);
    }




}
