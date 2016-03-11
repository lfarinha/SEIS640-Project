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
	  } else if(commandLine.equalsIgnoreCase("exit"))  
	  {
		  this.lineCount++;
		  this.commandList.setExitCommand(commandLine);
		  
		} else if(commandLine.equalsIgnoreCase("version"))  
		{
			  commandList.setVersionCommand(stack, aCount, lineCount, commandLine, shellHistory);;
			  this.lineCount++;
			  aCount++;
		} else if(commandLine.equalsIgnoreCase("help"))  
		{
			  commandList.setHelpCommand(stack, aCount, lineCount, commandLine, shellHistory);;
		      this.lineCount++;
			  aCount++;
		}
		else if(commandLine.equalsIgnoreCase("time"))  
		{
			  commandList.setTimeCommand(stack, aCount, lineCount, commandLine, shellHistory);;
		      this.lineCount++;
			  aCount++;
		}else if(commandLine.equalsIgnoreCase("date"))  
		{
			  commandList.setDateCommand(stack, aCount, lineCount, commandLine, shellHistory);;
		      this.lineCount++;
			  aCount++;
		}else if (commandLine.equalsIgnoreCase("history"))
		{
			commandList.setHistoryCommand(stack, aCount, lineCount, commandLine, shellHistory);;
			this.lineCount++;
			aCount++;
			commandList.printHistory(this.aCount, this.stack, false);
			
		}else if (commandLine.equals("exit")==false || commandLine.equals("version")==false  || commandLine.equals("time")==false || commandLine.equals("date")==false || commandLine.equals("history")==false)
		{
			commandList.checkCommand(stack, aCount, lineCount, commandLine, shellHistory);
			this.lineCount++;
			aCount++;
		}
	  }else{ //else if the count of commands is more than 10 than...

		   
//		   if(commandLine.equalsIgnoreCase("version"))  
//			{
//				  this.stack.push(9, this.lineCount+": "+shellHistory[0]);
//				  this.lineCount++;
//				  System.out.println("Leonardo Farinha & Rohan Dayananda's CLI, Version 1.0");
//				  aCount++;
//			}else if (commandLine.equalsIgnoreCase("history"))
//			{
//				stack.pop();
//				this.stack.push(9, this.lineCount+": "+shellHistory[0]);
//				this.lineCount++;
//				aCount++;
//							
//				for(int i=0; i<10; i++)
//				{
//					System.out.println("          ---more than 10--    "+this.stack.peek(i));
//				}
//
//			}
			
		  if (commandLine.equals(""))
		  {
			  continue;
		  } else if(commandLine.equalsIgnoreCase("exit"))  
		  {
			  this.lineCount++;
			  this.commandList.setExitCommand(commandLine);
			  
			} else if(commandLine.equalsIgnoreCase("version"))  
			{
				  stack.pop();
				  commandList.setVersionCommand(stack, 9, lineCount, commandLine, shellHistory);;
				  this.lineCount++;
				  aCount++;
			} else if(commandLine.equalsIgnoreCase("help"))  
			{
				  stack.pop();
				  commandList.setHelpCommand(stack, 9, lineCount, commandLine, shellHistory);;
			      this.lineCount++;
				  aCount++;
			}
			else if(commandLine.equalsIgnoreCase("time"))  
			{
				  stack.pop();
				  commandList.setTimeCommand(stack, 9, lineCount, commandLine, shellHistory);;
			      this.lineCount++;
				  aCount++;
			}else if(commandLine.equalsIgnoreCase("date"))  
			{
				  stack.pop();
				  commandList.setDateCommand(stack, 9, lineCount, commandLine, shellHistory);;
			      this.lineCount++;
				  aCount++;
			}else if (commandLine.equalsIgnoreCase("history"))
			{
				stack.pop();
				commandList.setHistoryCommand(stack, 9, lineCount, commandLine, shellHistory);;
				this.lineCount++;
				aCount++;
				commandList.printHistory(9, this.stack, true);
				
			}else if (commandLine.equals("exit")==false || commandLine.equals("version")==false  || commandLine.equals("time")==false || commandLine.equals("date")==false || commandLine.equals("history")==false)
			{
			   // stack.pop();
				commandList.checkCommand(stack, 9, lineCount, commandLine, shellHistory);
				this.lineCount++;
				aCount++;
			}
		  
	  }
	}
    } catch (Exception e) {
			e.printStackTrace();
      }
	}
	

}
