import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import javax.swing.Timer;

class KeyInput extends KeyAdapter
{
	 SnakeGame game;
	 public KeyInput(SnakeGame game)
	 {
         this.game = game;

	 }
     public void keyPressed(KeyEvent e) 
     {
        game.keyPressed(e);
     	
     }
}