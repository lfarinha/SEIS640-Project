package com.project.shell;



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateProcess {

    	BufferedReader console, read;
    	InputStreamReader line;
    	Process process;
    	
		String s, commandLine;
		
    	
		public void setProcess(String commandLine)
		{
			while(true)
			{
				try {

					process = Runtime.getRuntime().exec(commandLine);
        		
					read = new BufferedReader(new InputStreamReader(process.getInputStream()));
        		
					while ((s = read.readLine()) != null)
						System.out.println(s);
            			process.waitFor();
            			//System.out.println ("exit: " + process.exitValue());
            			process.destroy();
            		
				} catch (Exception e) {}
				break;
			}
		}
}