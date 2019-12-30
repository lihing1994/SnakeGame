import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import javax.swing.Timer;

class SnakeGame extends JFrame implements ActionListener
{
	private Container c;
	private int snakeLength =1;
	private PriorityQueue<PlayerRecord> player_list = new PriorityQueue<PlayerRecord>();
	private LinkedList<Point> snakeBody = new LinkedList<Point>();
	private Point pointSnakeHead;
	private Random random = new Random();
	private SnakeGameMap snake_map;
	private int is_one_player_game;
	private int difficulty;
    private Timer timer;
    private String player_one_name;
    private String player_two_name;
	public SnakeGame(int is_one_player_game,int difficulty,String player_one_name,String player_two_name)
	{
		this.is_one_player_game=is_one_player_game;
		this.difficulty=difficulty;
        timer=new Timer(difficulty,this);
		addKeyListener(new KeyInput(this));
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				if (JOptionPane.showConfirmDialog(null, "Do you want to exit the game?","Exit?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION)
				{
					if(is_one_player_game==1)
					{
						PlayerRecord temp = new PlayerRecord(snake_map.get_player_one_name(),snake_map.get_player_one_score());
						player_list.add(temp);
						setVisible(false);
						ScoreBoard scoreBoard = new ScoreBoard(player_list);
						dispose();
					}
					else if(is_one_player_game==2)
					{
						PlayerRecord temp = new PlayerRecord(snake_map.get_player_one_name(),snake_map.get_player_one_score());
						player_list.add(temp);
						temp = new PlayerRecord(snake_map.get_player_two_name(),snake_map.get_player_two_score());
						player_list.add(temp);
						setVisible(false);
						ScoreBoard scoreBoard = new ScoreBoard(player_list);
						dispose();
					}
				}
				else
				{
					snake_map.setStart();
				}
			}
		});
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
		c = getContentPane();
		setBackground(Color.WHITE);
		snake_map = new SnakeGameMap(is_one_player_game,player_one_name,player_two_name);
		c.add(snake_map);
		setVisible(true);	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(((int)toolkit.getScreenSize().getWidth()-1000)/2,((int)toolkit.getScreenSize().getHeight()-1000)/2,1000,1000);
        timer.start();
        this.player_one_name = player_one_name;
        this.player_two_name = player_two_name;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void keyPressed(KeyEvent e)
    {
      int temp_key =e.getKeyCode();
      if(is_one_player_game==1)
      {
        	if(temp_key == KeyEvent.VK_UP)
     	    {
     		  snake_map.setUp_one();
     	    }	
     	    else if(temp_key == KeyEvent.VK_DOWN)
     	    {
     		  snake_map.setDown_one();
     	    }
     	    else if(temp_key == KeyEvent.VK_LEFT)
     	    {
              snake_map.setLeft_one();
     	    }
         	else if(temp_key == KeyEvent.VK_RIGHT)
     	    {
     		  snake_map.setRight_one();
     	    }
     	    else if(temp_key == KeyEvent.VK_W)
     	    {
              snake_map.setUp_one();
     	    }
     	    else if(temp_key == KeyEvent.VK_A)
     	    {
     		  snake_map.setLeft_one();
         	}
     	    else if(temp_key == KeyEvent.VK_S)
     	    {
     		  snake_map.setDown_one();
     	    }
     	    else if(temp_key == KeyEvent.VK_D)
     	    {
     		  snake_map.setRight_one();
     	    } 
     	    else if(temp_key == KeyEvent.VK_ENTER)
     	    {
     		  if(snake_map.getGameOver())
     	   	  {
     	   	  	PlayerRecord tempPlayer = new PlayerRecord(snake_map.get_player_one_name(),snake_map.get_player_one_score());
     	   	  	player_list.add(tempPlayer);
     	   	  	snake_map.reStart_the_game();
     	   	  }
     	    }
     	    else if(temp_key ==  KeyEvent.VK_ESCAPE)
         	{
     	     	snake_map.setStop();
     		    if (JOptionPane.showConfirmDialog(null, "Do you want to exit the game?","Exit?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION)
				{
					
					if(is_one_player_game==1)
                    {
                        PlayerRecord temp = new PlayerRecord(snake_map.get_player_one_name(),snake_map.get_player_one_score());
                        player_list.add(temp);
                        setVisible(false);
                        ScoreBoard scoreBoard = new ScoreBoard(player_list);
                        dispose();
                    }
                    else if(is_one_player_game==2)
                    {
                        PlayerRecord temp = new PlayerRecord(snake_map.get_player_one_name(),snake_map.get_player_one_score());
                        player_list.add(temp);
                        temp = new PlayerRecord(snake_map.get_player_two_name(),snake_map.get_player_two_score());
                        player_list.add(temp);
                        setVisible(false);
                        ScoreBoard scoreBoard = new ScoreBoard(player_list);
                        dispose();
                    }
				}
				else
				{
					snake_map.setStart();
				}

     	    }
       }
       else if(is_one_player_game==2)
       {
           if(temp_key == KeyEvent.VK_UP)
     	   {
     		 snake_map.setUp_two();
     	   }
     	   else if(temp_key == KeyEvent.VK_DOWN)
     	   {
     		 snake_map.setDown_two();
     	   }
     	   else if(temp_key == KeyEvent.VK_LEFT)
     	   {
             snake_map.setLeft_two();
           }
     	   else if(temp_key == KeyEvent.VK_RIGHT)
     	   {
     		  snake_map.setRight_two();

     	   }
     	   else if(temp_key == KeyEvent.VK_W)
     	   {
     		
               snake_map.setUp_one();
     	   }
     	   else if(temp_key == KeyEvent.VK_A)
     	   {
     		  snake_map.setLeft_one();
     	   }
     	   else if(temp_key == KeyEvent.VK_S)
     	   {
     		  snake_map.setDown_one();
     	   }
     	   else if(temp_key == KeyEvent.VK_D)
     	   {
     		  snake_map.setRight_one();
     	   }
     	   else if(temp_key == KeyEvent.VK_ENTER)
     	   {
     	   	  if(snake_map.getGameOver())
     	   	  {
     	   	  	PlayerRecord tempPlayer = new PlayerRecord(snake_map.get_player_one_name(),snake_map.get_player_one_score());
     	   	  	player_list.add(tempPlayer);
     	   	  	tempPlayer = new PlayerRecord(snake_map.get_player_two_name(),snake_map.get_player_two_score());
     	   	  	player_list.add(tempPlayer);
     	   	  	snake_map.reStart_the_game();
     	   	  }
     	   }
     	   else if(temp_key ==  KeyEvent.VK_ESCAPE)
     	   {
     		  	snake_map.setStop();
     		    if (JOptionPane.showConfirmDialog(null, "Do you want to exit the game?","Exit?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION)
				{
					if(is_one_player_game==1)
                    {
                        PlayerRecord temp = new PlayerRecord(snake_map.get_player_one_name(),snake_map.get_player_one_score());
                        player_list.add(temp);
                        setVisible(false);
                        ScoreBoard scoreBoard = new ScoreBoard(player_list);
                        dispose();
                    }
                    else if(is_one_player_game==2)
                    {
                        PlayerRecord temp = new PlayerRecord(snake_map.get_player_one_name(),snake_map.get_player_one_score());
                        player_list.add(temp);
                        temp = new PlayerRecord(snake_map.get_player_two_name(),snake_map.get_player_two_score());
                        player_list.add(temp);
                        setVisible(false);
                        ScoreBoard scoreBoard = new ScoreBoard(player_list);
                        dispose();
                    }
				}
				else
				{
					snake_map.setStart();
				}

     	   }
        }
	}
   @Override
   public void actionPerformed(ActionEvent args)
   {
	   snake_map.repaint();
   }
}
