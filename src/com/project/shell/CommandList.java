package com.project.shell;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class CommandList {
	
	String EXIT="Goodbye", 
		   VERSION="Leonardo Farinha & Rohan Dayananda's CLI, Version 1.0", 
		   HELP="list of commands: exit, version, help, time, date, history",
		   TIME="The current time is: ",
		   DATE="";
	
	public void checkCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		stack.push(aCount, lineCount+": "+shellHistory[0]);
		System.out.println("''"+shellHistory[0]+"'' is an invalid command.");
	}
	
	public void setExitCommand(String commandLine)
	{
		if(commandLine.equalsIgnoreCase("exit"))
		{
			System.out.println(this.EXIT);
			System.exit(0);
		}
	}
	
	public void setVersionCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		stack.push(aCount, lineCount+": "+shellHistory[0]);
		System.out.println(this.VERSION);
	}
	
	public void setHelpCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		stack.push(aCount, lineCount+": "+shellHistory[0]);
		System.out.println(this.HELP);
	}
	
	public void setTimeCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		  stack.push(aCount, lineCount+": "+shellHistory[0]);
		  String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		  System.out.println(TIME+timeStamp.toString());	
	}
	
	public void setDateCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		  stack.push(aCount, lineCount+": "+shellHistory[0]);
		  Date date = new Date();
		  System.out.println(date.toString());
	}
	
	public void setHistoryCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		stack.push(aCount, lineCount+": "+shellHistory[0]);
	}

	public void printHistory(int aCount, StringStack stack, boolean isMoreThan10)
	{
		if (isMoreThan10 == false)
			for(int i=0; i<aCount; i++)
			{
				System.out.println("      "+stack.peek(i));
			}
		else{
			for(int i=0; i<10; i++)
			{
				System.out.println("      "+stack.peek(i));
			}
		}
	}
	
}
