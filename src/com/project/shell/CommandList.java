package com.project.shell;

public class CommandList {
	
	CommandList exit, version, help, time, date;
	
	public Boolean checkCommand(String command)
	{
		if(command != "exit" || command != "help")
		{
			System.out.println("Wrong Command, you can have some help with -help command!S");
			return true;
		}
		return null;
	}

}
