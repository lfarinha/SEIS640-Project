package com.project.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.omg.CORBA.portable.InputStream;

public class ShellParser
{
	
	private int lineCount=1;
	private String commandLine, tag="LF, RD>";

	
	public void readLine()
	{
		
	//ParserHistory history;
		
	try
	{
	InputStreamReader line = new InputStreamReader(System.in);
	BufferedReader console = new BufferedReader(line);
	
	// we break out with <control><C>
	while (true) {
	  // read what the user entered
	  System.out.print(this.tag+this.lineCount+" ");
	  commandLine = console.readLine();
	  	  
	  // if the user entered a return, just loop again
	  if (commandLine.equals(""))
	  {
		  this.lineCount++;
		continue;
		} else if(commandLine.equalsIgnoreCase("exit"))  
		{
		  this.lineCount++;
		  System.out.println("Goodbye");
		  System.exit(0);
		} else if(commandLine.equalsIgnoreCase("version"))  
		{
	      this.lineCount++;
		  System.out.println("current version: v1.0");
		} else if(commandLine.equalsIgnoreCase("help"))  
		{
		      this.lineCount++;
			  System.out.println("list of commands: exit, version, help, time, date");
		}
		else if(commandLine.equalsIgnoreCase("time"))  
		{
			  String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		      this.lineCount++;
			  System.out.println("The current time is: "+timeStamp.toString());
		}else if(commandLine.equalsIgnoreCase("date"))  
		{
			  Date date = new Date();
			  System.out.println(date.toString());
		      this.lineCount++;
		}else if (commandLine.equals("exit")==false || commandLine.equals("version")==false  || commandLine.equals("time")==false || commandLine.equals("date")==false)
		{
			System.out.println("I can't recognize that command, maybe you should try the help command ;)");
			this.lineCount++;
		}
	  
	  
	  	ArrayList<String> readLines = new ArrayList<String>();
	  	String[] shellHistory = commandLine.split(" ");

	  	int size = shellHistory.length;
	  	for (int i=0; i<size; i++)  {

	  		readLines.add(this.tag+(this.lineCount-1)+" "+shellHistory[i]); 
	  		System.out.println(readLines.get(i));  // testing, wanted to make sure its working
	  		}
	  			
	  			
	  

	 
	  
	  }
    } catch (Exception e) {
        e.printStackTrace();
      }
	}
}
