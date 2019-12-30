import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.text.*;

public class TestMenu
{
   public static void main(String [] args)
   {
      Menu m1= new Menu();
      
   }
}



class Menu extends JFrame 
{
    private Container c;
	private JLabel titleLabel;
	private JLabel backgroundImageLabel;
	private JLabel comboxLabel;
	private JPanel comboxPanel;
	private JPanel backgroundImagePanel;
	private JPanel textFileAndLabelPanel;
	private JPanel btnPanelAndCheckBox;
	private JPanel checkboxAndComBoxPanel;
	private JPanel wholePanel;
	private JTextField textField_Of_Player_One;
	private JTextField textField_Of_Player_two;
	private JButton btn_Start_Game;
	private JButton btn_Ext_Game;
	private JLabel lable_Of_Player_One;
	private JLabel lable_Of_Player_two;
	private JCheckBox is_One_Player_Game;
	//private JComboBox difficulty ;
    private  JComboBox<String> combox_difficulty;
    private int difficulty;
    
   
    public Menu()
    {
        c=getContentPane();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));//set layout for window....
		if((int)toolkit.getScreenSize().getHeight()>=1200)
		{
			backgroundImageLabel=new JLabel(new ImageIcon("SnakeMenuBackGround.png"));
		}
		else if((int)toolkit.getScreenSize().getHeight()>=700)
		{
			backgroundImageLabel=new JLabel(new ImageIcon("SnakeMenuBackGround_2.png"));
		}
		else
		{
			System.out.println("You screen resolution is too low, please reset you computer screen resolution then run the game again");
			System.exit(0);
		}
		backgroundImagePanel=new JPanel();
		checkboxAndComBoxPanel = new JPanel();
		checkboxAndComBoxPanel.setLayout(new GridLayout(1,1));
		backgroundImagePanel.setLayout(new FlowLayout());
		backgroundImagePanel.add(backgroundImageLabel);
		textFileAndLabelPanel= new JPanel();
		btnPanelAndCheckBox =new JPanel();
		textFileAndLabelPanel.setLayout(new GridLayout(2,2));//set panel layout to GridLayout...
		btnPanelAndCheckBox.setLayout(new GridLayout(1,2));
		//Add textfield and label to panel...
		lable_Of_Player_One = new JLabel("Player 1 Name:");
        lable_Of_Player_two = new JLabel("Player 2 Name:");
		textField_Of_Player_One = new JTextField(20);
		textField_Of_Player_two = new JTextField(20);
		textField_Of_Player_two.setDisabledTextColor(Color.GRAY);
		textFileAndLabelPanel.add(lable_Of_Player_One);
		textFileAndLabelPanel.add(textField_Of_Player_One);
		textFileAndLabelPanel.add(lable_Of_Player_two);
		textFileAndLabelPanel.add(textField_Of_Player_two);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
    		@Override
    		public void windowClosing(WindowEvent we)
    		{ 
				 if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Exit?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION)
				 {
					 
					 System.exit(0);
				 }
    		}
		});
		//c.add(textFileAndLabelPanel);
		//End of add..
        btn_Start_Game=new JButton("Start Game");
		
		btn_Start_Game.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				  if(is_One_Player_Game.isSelected())//checkbox is seleted...
				  {

				  	   if(textField_Of_Player_One.getText().equals(""))
				  	   {

					           JOptionPane.showConfirmDialog(null,"Please fill the Player #1 name","Warning",JOptionPane.DEFAULT_OPTION);
				  	   }
				  	   else
				  	   { 

				  	   		String player_one_name = textField_Of_Player_One.getText();
				  	   		player_one_name = player_one_name.substring(0,1).toUpperCase() + player_one_name.substring(1).toLowerCase();
                            setVisible(false);
                            difficulty=combox_difficulty.getSelectedIndex();
                            if(difficulty==0)
                            {
                            	difficulty=100;
                            }
                            else if(difficulty==1)
                            {
                            	difficulty=75;
                            }
                            else
                            {
                            	difficulty=50;
                            }
                            setVisible(false);
				  	   	    SnakeGame snakegame= new SnakeGame(1,difficulty,player_one_name," ");
                            dispose();  
				  	   }
				  }
				  else//
				  {
				  	    if(textField_Of_Player_One.getText().equals(""))
				  	   {

					           JOptionPane.showConfirmDialog(null,"Please fill the Player #1 name","Warning",JOptionPane.DEFAULT_OPTION);
				  	   }
				  	   else if(textField_Of_Player_two.getText().equals(""))
				  	   {

					           JOptionPane.showConfirmDialog(null,"Please fill the Player #2 name","Warning",JOptionPane.DEFAULT_OPTION);
				  	   }
				  	   else
				  	   {
				  	   	    String player_one_name = textField_Of_Player_One.getText();
				  	   	    player_one_name = player_one_name.substring(0,1).toUpperCase() + player_one_name.substring(1).toLowerCase();
				  	   	    String player_two_name = textField_Of_Player_two.getText();
				  	   	    player_two_name = player_two_name.substring(0,1).toUpperCase() + player_two_name.substring(1).toLowerCase();
				  	   	    difficulty=combox_difficulty.getSelectedIndex();
                            if(difficulty==0)
                            {
                            	difficulty=100;
                            }
                            else if(difficulty==1)
                            {
                            	difficulty=75;
                            }
                            else
                            {
                            	difficulty=50;
                            }
                            setVisible(false);
				  	   	    SnakeGame snakegame = new SnakeGame(2,difficulty,player_one_name,player_two_name);
				  	   	  	dispose();  
				  	   }
				  }
			}
		});


      		
		btn_Ext_Game=new JButton("Exit");
		
		
		btn_Ext_Game.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				 if(JOptionPane.showConfirmDialog(null, "Do you want to continue playing?","Exit?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION)
				 {
					
					 System.exit(0);
				 }
			}
		});
	
		is_One_Player_Game= new JCheckBox("One Player Game");
		is_One_Player_Game.addItemListener(new ItemListener(){
              public void itemStateChanged(ItemEvent e) 
              {
                    if(e.getStateChange() == ItemEvent.SELECTED)
                    {
                    	  lable_Of_Player_two.setVisible(false);
                          textField_Of_Player_two.setEnabled(false);
                          textField_Of_Player_two.setVisible(false);

                    }
                    else
                    {
                    	lable_Of_Player_two.setVisible(true);
                    	textField_Of_Player_two.setEnabled(true);
                    	textField_Of_Player_two.setVisible(true);
                    }
              }
		});

        textField_Of_Player_One.addFocusListener(new FocusListener() {
           public void focusGained(FocusEvent e) 
           {
              textField_Of_Player_One.setBackground(Color.YELLOW);
           }

           public void focusLost(FocusEvent e) {
              textField_Of_Player_One.setBackground(Color.WHITE);
           }

		});


		textField_Of_Player_two.addFocusListener(new FocusListener() {
           public void focusGained(FocusEvent e) 
           {
              textField_Of_Player_two.setBackground(Color.YELLOW);
           }

           public void focusLost(FocusEvent e) {
              textField_Of_Player_two.setBackground(Color.WHITE);
           }

		});

		btnPanelAndCheckBox.add(btn_Start_Game,BorderLayout.WEST);
		btnPanelAndCheckBox.add(btn_Ext_Game,BorderLayout.EAST);
		//c.add(btnPanelAndCheckBox);
		titleLabel =  new JLabel("Welcome to the Snake Game");
		titleLabel.setFont(new Font("Arial",Font.BOLD,40));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setOpaque(false);
		is_One_Player_Game.setFont(new Font("Arial",Font.BOLD,15));
		//setting Combobox..
		String [] strdifficulty ={"Easy","Medium","Hard"};
        combox_difficulty=new JComboBox<String>(strdifficulty);
        comboxLabel =new JLabel("Difficulty:");
		comboxPanel = new JPanel();
		comboxPanel.setLayout(new FlowLayout());
		comboxLabel.setFont(new Font("Arial",Font.BOLD,15));
		checkboxAndComBoxPanel.add(is_One_Player_Game);
		comboxPanel.add(comboxLabel);
		comboxPanel.add(combox_difficulty);
	    checkboxAndComBoxPanel.add(comboxPanel);
		//setting end..
		wholePanel = new JPanel();
		wholePanel.setLayout(new GridLayout(4,1));
		wholePanel.add(titleLabel);
		wholePanel.add(textFileAndLabelPanel);
		wholePanel.add(checkboxAndComBoxPanel);
		wholePanel.add(btnPanelAndCheckBox);
		wholePanel.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
		wholePanel.setBackground(new Color(192,192,192));
		c.setBackground(new Color(192,192,192));
		c.add(backgroundImagePanel);
		c.add(wholePanel);
		if((int)toolkit.getScreenSize().getHeight()>=1200)
		{
			setBounds(((int)toolkit.getScreenSize().getWidth()-1280)/2,((int)toolkit.getScreenSize().getHeight()-1000)/2,1280,1000);
		}
		else
		{
			setBounds(0,0,(int)toolkit.getScreenSize().getWidth(),(int)toolkit.getScreenSize().getHeight());
		}
		setVisible(true);
    }
    
}


