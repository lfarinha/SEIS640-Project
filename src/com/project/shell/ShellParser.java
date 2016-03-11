package com.project.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class ShellParser
{
	
	private int lineCount=1, aCount=0;
	private String commandLine, tag="LF,RD";
	private String[] lineHistory = new String[100];

	
	public void readLine()
	{
			
	try
	{
	InputStreamReader line = new InputStreamReader(System.in);
	BufferedReader console = new BufferedReader(line);
	
	
	// we break out with <control><C>
	while (true) {
		
	  // read what the user entered
	  System.out.print(this.tag+"-"+this.lineCount+"> ");
	  commandLine = console.readLine();
	  	  
	  
	  String[] shellHistory = commandLine.split(" ");

	  
	  if(this.aCount<=10)
	  {
	  // if the user entered a return, just loop again
	  if (commandLine.equals(""))
	  {
		  continue;
		} else if(commandLine.equalsIgnoreCase("exit"))  
		{
		  this.lineCount++;
		  System.out.println("Goodbye");
		  System.exit(0);
		} else if(commandLine.equalsIgnoreCase("version"))  
		{
			lineHistory[aCount]= "History line: "+this.tag+(this.lineCount-1)+" "+shellHistory[0];
			  this.lineCount++;
			  System.out.println("current version: v1.0");
			  aCount++;
		} else if(commandLine.equalsIgnoreCase("help"))  
		{
			  lineHistory[aCount]= "History line: "+this.tag+(this.lineCount-1)+" "+shellHistory[0];
		      this.lineCount++;
			  System.out.println("list of commands: exit, version, help, time, date, history");
			  aCount++;
		}
		else if(commandLine.equalsIgnoreCase("time"))  
		{
			  lineHistory[aCount]= "History line: "+this.tag+(this.lineCount-1)+" "+shellHistory[0];
			  String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		      this.lineCount++;
			  System.out.println("The current time is: "+timeStamp.toString());
			  aCount++;
		}else if(commandLine.equalsIgnoreCase("date"))  
		{
			  lineHistory[aCount]= "History line: "+this.tag+(this.lineCount-1)+" "+shellHistory[0];
			  Date date = new Date();
			  System.out.println(date.toString());
		      this.lineCount++;
			  aCount++;
		}else if (commandLine.equalsIgnoreCase("history"))
		{
			lineHistory[aCount]= "History line: "+this.tag+(this.lineCount-1)+" "+shellHistory[0];
  			for(int i=0; i<this.aCount; i++)
  			{
  			System.out.println(lineHistory[i]);
  			}
			this.lineCount++;
			aCount++;
		}else if (commandLine.equals("exit")==false || commandLine.equals("version")==false  || commandLine.equals("time")==false || commandLine.equals("date")==false || commandLine.equals("history")==false)
		{
			lineHistory[aCount]= "History line: "+this.tag+(this.lineCount-1)+" "+shellHistory[0];
			System.out.println("''"+shellHistory[0]+"'' is an invalid command.");
			this.lineCount++;
			aCount++;
		
		}
	  }else{
		  this.aCount=0;
	  }
	}
    } catch (Exception e) {
        e.printStackTrace();
      }
	}
	

}
