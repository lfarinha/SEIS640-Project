package com.project.shell;

import java.util.List;
import java.util.ArrayList;

public class StringStack {

	 private List<String> stack;

	    public StringStack(int SIZE) 
	    {
	        this.stack = new ArrayList<String>(SIZE);
	    }

	    public void push(int i, String string) 
	    {
	       this.stack.add(i, string);
	       
	    }

	     public String pop() 
	     { 
	        if(!stack.isEmpty()){
	           String string = this.stack.get(0);
	           this.stack.remove(0);
	           return string;
	        } else{
	           return null;
	        }
	     }

	     public String peek(int i)
	     {
	        if(!stack.isEmpty()){
	           return this.stack.get(i);
	        } else{
	           return null;
	        }
	     }


	     public boolean isEmpty() 
	     {
	       return this.stack.isEmpty();
	     }
	
	     public int sizeOfStack()
	     {
	    	 return this.stack.size();
	     }
	     
	     public void checkStackSize(int listSize, int count, String string)
	     {
	    		 
	    	 
	    	    
	     }
	     
}
