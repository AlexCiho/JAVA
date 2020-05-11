package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Canvas extends JPanel {


    public void drawNode(int x, int y) {
        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //for "smooth" drawing
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(0xFFFFFF))); //you may use a random color or the one specified in the toolbar
        //Graphics.fill(new NodeShape(x, y, radius));
        graphics.fill(new NodeShape(x,y,10));
        paint(graphics);
    }


}
