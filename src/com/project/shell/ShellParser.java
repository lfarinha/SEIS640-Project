package com.project.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellParser
{

	private int lineCount=1, aCount=0;
	private String commandLine, tag="LF,RD";
	
	private StringStack stack = new StringStack(10);
	private CommandList commandList = new CommandList();
		
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

	  if(this.aCount<10) // we count 10 commands for the history
	  {
	  // if the user entered a return, just loop again
	  if (commandLine.equals(""))
	  {
		  continue;
	  } else if(commandLine.equalsIgnoreCase("exit") || commandLine.equalsIgnoreCase("!20"))  
	  {
		  this.commandList.setExitCommand(commandLine);
		  this.lineCount++;
		  
		} else if(commandLine.equalsIgnoreCase("version") || commandLine.equalsIgnoreCase("!21"))  
		{
			  commandList.setVersionCommand(stack, aCount, lineCount, commandLine, shellHistory);;
			  this.lineCount++;
			  aCount++;
		} else if(commandLine.equalsIgnoreCase("help") || commandLine.equalsIgnoreCase("!22"))  
		{
			  commandList.setHelpCommand(stack, aCount, lineCount, commandLine, shellHistory);;
		      this.lineCount++;
			  aCount++;
		}
		else if(commandLine.equalsIgnoreCase("time") || commandLine.equalsIgnoreCase("!23"))  
		{
			  commandList.setTimeCommand(stack, aCount, lineCount, commandLine, shellHistory);;
		      this.lineCount++;
			  aCount++;
		}else if(commandLine.equalsIgnoreCase("date") || commandLine.equalsIgnoreCase("!24"))  
		{
			  commandList.setDateCommand(stack, aCount, lineCount, commandLine, shellHistory);;
		      this.lineCount++;
			  aCount++;
		}else if (commandLine.equalsIgnoreCase("history") || commandLine.equalsIgnoreCase("!25"))
		{
			commandList.setHistoryCommand(stack, aCount, lineCount, commandLine, shellHistory);;
			this.lineCount++;
			aCount++;
			commandList.printHistory(this.aCount, this.stack, false);
			
		}else if (commandLine.equals("exit")==false || commandLine.equals("version")==false  || commandLine.equals("time")==false || commandLine.equals("date")==false || commandLine.equals("history")==false || commandLine.equals("!20")==false || commandLine.equals("!21")==false ||  commandLine.equals("!22")==false ||  commandLine.equals("!23")==false ||  commandLine.equals("!24")==false ||  commandLine.equals("!25")==false ||  commandLine.equals("!26")==false ||  commandLine.equals("!27")==false)
		{
			commandList.checkCommand(stack, aCount, lineCount, commandLine, shellHistory);
		}
	  }else{ //else if the count of commands is more than 10 than...

			
		  if (commandLine.equals(""))
		  {
			  continue;
		  } else if(commandLine.equalsIgnoreCase("exit"))  
		  {
			  this.lineCount++;
			  this.commandList.setExitCommand(commandLine);
			  
			} else if(commandLine.equalsIgnoreCase("version") || commandLine.equalsIgnoreCase("!21"))  
			{
				  stack.pop();
				  commandList.setVersionCommand(stack, 9, lineCount, commandLine, shellHistory);;
				  this.lineCount++;
				  aCount++;
			} else if(commandLine.equalsIgnoreCase("help") || commandLine.equalsIgnoreCase("!22"))  
			{
				  stack.pop();
				  commandList.setHelpCommand(stack, 9, lineCount, commandLine, shellHistory);;
			      this.lineCount++;
				  aCount++;
			}
			else if(commandLine.equalsIgnoreCase("time") || commandLine.equalsIgnoreCase("!23"))  
			{
				  stack.pop();
				  commandList.setTimeCommand(stack, 9, lineCount, commandLine, shellHistory);;
			      this.lineCount++;
				  aCount++;
			}else if(commandLine.equalsIgnoreCase("date") || commandLine.equalsIgnoreCase("!24"))  
			{
				  stack.pop();
				  commandList.setDateCommand(stack, 9, lineCount, commandLine, shellHistory);;
			      this.lineCount++;
				  aCount++;
			}else if (commandLine.equalsIgnoreCase("history") || commandLine.equalsIgnoreCase("!25"))
			{
				stack.pop();
				commandList.setHistoryCommand(stack, 9, lineCount, commandLine, shellHistory);;
				this.lineCount++;
				aCount++;
				commandList.printHistory(9, this.stack, true);
				
			}else if (commandLine.equals("exit")==false || commandLine.equals("version")==false  || commandLine.equals("time")==false || commandLine.equals("date")==false || commandLine.equals("history")==false || commandLine.equals("!20")==false || commandLine.equals("!21")==false ||  commandLine.equals("!22")==false ||  commandLine.equals("!23")==false ||  commandLine.equals("!24")==false ||  commandLine.equals("!25")==false ||  commandLine.equals("!26")==false ||  commandLine.equals("!27")==false)
			{
				commandList.checkCommand(stack, 9, lineCount, commandLine, shellHistory);
			}
		  
	  }
	}
    } catch (Exception e) {
			e.printStackTrace();
      }
	}
	

}
