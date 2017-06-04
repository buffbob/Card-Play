package playingCards;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CardTable extends Canvas {
	BufferedImage bi ;

    private Image[][] images;
    private int cardWidth, cardHeight;

    /**
     * Creates a CardTable.
     * cardset is the name of the folder that contains the card images.
     */
    public CardTable(String cardset) {
        setBackground(new Color(0x088A4B));

        // create a 2-D array of card images
        images = new Image[14][4];
        String suits = "cdhs";
        cardset = "images/cardset";

        for (int suit = 0; suit <= 3; suit++) {
            char c = suits.charAt(suit);

            for (int rank = 1; rank <= 13; rank++) {
                String s = String.format("%s/%d%c.gif",
                                         cardset, rank, c);
                
                images[rank][suit] = new ImageIcon(s).getImage();
            }
        }
      

        // get the width and height of the cards and set the size of
        // the frame accordingly
        cardWidth = images[2][2].getWidth(null);
        cardHeight = images[3][2].getHeight(null);
        System.out.println(cardHeight);
        System.out.println(cardWidth);

        // set the size temporarily to get the insets
        setTableSize(14, 4);
    }

    /**
     * Sets the table size.
     * x and y are in units of card width/height.
     */
    public void setTableSize(double x, double y) {
        setSize((int) (x * cardWidth),
                (int) (y * cardHeight));
    }

    /**
     * Draws a card at the given coordinates.
     * x and y are in units of card width/height.
     */
    public void drawCard(Graphics g, int rank, int suit, double x, double y) {
        Image image = images[rank][suit];
        int buffer = 20;
        g.drawImage(image,
                    (int) ((x * cardWidth)+buffer),
                    (int) ((y * cardHeight)+ buffer),
                    null);
    }

    /**
     * Special method invoked when the Frame needs to be drawn.
     */
    public void paint(Graphics g) {

        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 0; suit <= 3; suit++) {
                double x = rank - 1 + suit / 5.0;
                double y = (suit / 2.0);
                drawCard(g, rank, suit, x, y);
               
            }
        }
    }

    public static void main(String[] args) {
    	
        // make the frame
        JFrame frame = new JFrame("Card Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the CardTable
        String cardset = "images/cardset";
        Canvas canvas = new CardTable(cardset);
        frame.getContentPane().add(canvas);

        // show the frame
        frame.pack();
        frame.setVisible(true);
    }

}
