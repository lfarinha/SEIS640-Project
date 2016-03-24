package com.project.shell;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class CommandList {
	
	private final String EXIT="FL,RD CLI exiting.", 
						 VERSION="Leonardo Farinha & Rohan Dayananda's CLI, Version 1.0", 
						 HELP=" version: print out the CLI version number " + System.lineSeparator() + " history: displays last 10 commands entered " + System.lineSeparator() + " help: displays list of valid commands " + System.lineSeparator() + " exit: exits CLI /n date prints out current date " + System.lineSeparator() + " time: prints out current time " + System.lineSeparator() + " !<number>: (re)executes command <number> from the history " + System.lineSeparator() + " #<cmd>: executes program <cmd>",
						 TIME="The time is: ",
						 DATE="The date is: ";
	
	public void checkCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		System.out.println("''"+shellHistory[0]+"'' is an invalid command.");
	}
	
	public void setExitCommand(String commandLine)
	{
		if(commandLine.equalsIgnoreCase("exit") || commandLine.equalsIgnoreCase("!20"))
		{
			System.out.println(this.EXIT);
			System.exit(0);
		}
	}
	
	public void setVersionCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		if(commandLine.equalsIgnoreCase("!21"))
		{
			stack.push(aCount, lineCount+": "+"version");
			System.out.println(this.VERSION);
		}else{
			stack.push(aCount, lineCount+": "+shellHistory[0]);
			System.out.println(this.VERSION);
		}
	}
	
	public void setHelpCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		if(commandLine.equalsIgnoreCase("!22"))
		{
			stack.push(aCount, lineCount+": "+"help");
			System.out.println(this.HELP);
		}else{
		stack.push(aCount, lineCount+": "+shellHistory[0]);
		System.out.println(this.HELP);
		}
	}
	
	public void setTimeCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		if(commandLine.equalsIgnoreCase("!23"))
		{
			  stack.push(aCount, lineCount+": "+"time");
			  String timeStamp = new SimpleDateFormat("hh:mm"+".").format(Calendar.getInstance().getTime());
			  System.out.println(TIME+timeStamp.toString());	
		}else{
		  stack.push(aCount, lineCount+": "+shellHistory[0]);
		  String timeStamp = new SimpleDateFormat("hh:mm"+".").format(Calendar.getInstance().getTime());
		  System.out.println(TIME+timeStamp.toString());	
		}
	}
	
	public void setDateCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		if(commandLine.equalsIgnoreCase("!24"))
		{
			  stack.push(aCount, lineCount+": "+"date");
			  Date date = new Date();
			  System.out.println(DATE+new SimpleDateFormat("MM/dd/yyyy").format(date)+".");
		}else{
		  stack.push(aCount, lineCount+": "+shellHistory[0]);
		  Date date = new Date();
		  System.out.println(DATE+new SimpleDateFormat("MM/dd/yyyy").format(date)+".");
		}
	}
	
	public void setHistoryCommand(StringStack stack, int aCount, int lineCount, String commandLine, String[] shellHistory)
	{
		if(commandLine.equalsIgnoreCase("!25"))
		{
			stack.push(aCount, lineCount+": "+"history");
		}else{
			stack.push(aCount, lineCount+": "+shellHistory[0]);
		}
	}
	
	public void setNewProcess(StringStack stack, int aCount, int lineCount, String commandLine, String shellHistory)
	{
		if(commandLine.equalsIgnoreCase("!26"))
		{
			  stack.push(aCount, lineCount+": "+"#");
			  CreateProcess process = new CreateProcess();
			  process.setProcess(shellHistory);
			  
		}else{
			  stack.push(aCount, lineCount+": "+shellHistory);
			  CreateProcess process = new CreateProcess();
			  process.setProcess(shellHistory);
		}
	}

	public void printHistory(int aCount, StringStack stack, boolean isMoreThan10)
	{
		try{
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
		}catch (Exception e) {
			System.out.print("There is no history.");
			e.printStackTrace();
	      }
	}
	
}
