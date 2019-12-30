import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import javax.swing.Timer;

class ScoreBoard extends JFrame
{
	private Container c;
	private JScrollPane scrollPane;
	private JTextArea score_board_area;
	private PriorityQueue<PlayerRecord> player_list;
	public ScoreBoard(PriorityQueue<PlayerRecord> player_list)
	{
		this.player_list = player_list;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{

				System.exit(0);
			}
		});
		//wholePanel = new JPanel();
		//wholePanel.setLayout(new GridLayout(2,1));
		c=getContentPane();
		c.setLayout(new BorderLayout());//set layout for window....
		
		score_board_area = new JTextArea();
		score_board_area.setEditable(false);
		score_board_area.setFont(new Font("TimesRoman",Font.BOLD,40));
		score_board_area.setForeground(Color.BLUE);
		score_board_area.append("                                           Score Board\n");
		addString();
		scrollPane = new JScrollPane(score_board_area);
		c.add(scrollPane,BorderLayout.CENTER);
		setVisible(true);
		setBounds(((int)toolkit.getScreenSize().getWidth()-1280)/2,((int)toolkit.getScreenSize().getHeight()-1000)/2,1280,1000);

	}
	public void addString()
	{
		while(!player_list.isEmpty())
		{
			PlayerRecord temp = player_list.poll();
			score_board_area.append(temp.getName()+": ");
			score_board_area.append(temp.getScore()+"\n");
		}
	}
}