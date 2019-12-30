import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import javax.swing.Timer;

class PlayerRecord implements Comparable<PlayerRecord>
{
	private String name;
	private int score;
	public PlayerRecord(String name, int score)
	{
		this.name = name;
		this.score = score;
	}
	public void setScore(int score)
	{
		this.score = score;
	}
	public int getScore()
	{
		return score;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	@Override
	public int compareTo(PlayerRecord toCompare) 
	{
		return this.score - toCompare.getScore(); 
	}
}