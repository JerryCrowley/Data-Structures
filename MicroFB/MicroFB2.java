//Jeremiah Crowley

import java.util.*;

public class MicroFB2 
{	
	public static Hashtable<String,Person> allPeople = new Hashtable(); //Used from Java Library
	public static Hashtable<String,String> allFriends = new Hashtable(); //Used from Java Library
	
	public static int peopleCount = 0;
	public static int friendCount = 0;
	
	
	public static void main(String args[])
	{
		//Infinite Loop
		for( ;; )
		{
		
		  //Enter command
		  Scanner input = new Scanner(System.in);
	        
	      System.out.print("Enter command: ");
	      String command = input.next();
	      
	      if (command.equals("P"))
	      {
	    	  Scanner input1 = new Scanner(System.in);
		        
		      System.out.print("Enter name: ");
		      String nameCommand = input1.next();
		     
		      Person person1 = new Person(nameCommand); 

		      if(allPeople.get(nameCommand) == null)
		      {
		    	  allPeople.put(nameCommand,person1); 
		    	  peopleCount++;
		      }
		      
		      else
		      {
		    	  System.out.println("Person already added.");
		      }
		  }
		
	      
	      if (command.equals("F"))
	      {
	    	  //Scanner for two names
	    	  Scanner input1 = new Scanner(System.in);
	    	  Scanner input2 = new Scanner(System.in);
		        
		      System.out.println("Enter name1: ");
		      String nameCommand = input1.next();
		      System.out.println("Enter name2: ");
		      String nameCommand2 = input2.next();
		      
		      try
		      {
			      //If person is not in allPeople list. 
			      if (allPeople.get(nameCommand) == null || allPeople.get(nameCommand2) == null)
			      {
			    	  System.out.println("Person not found");
			      }
			      
			      else
			      {
			    	  //Add friend
			    	  allPeople.get(nameCommand).addFriend(  allPeople.get(nameCommand2) );
			    	  
			    	  allFriends.put( nameCommand+"*"+nameCommand2 , nameCommand+"*"+nameCommand2 ); 
			    	  friendCount++;
			      }

		      }
		      
		      
		      //If any other errors are raised
		      catch(Exception e)
		      {
		    	  System.out.println("Error.");
		      }
	      }
	      
	      if (command.equals("L"))
	      {
	    	  Scanner input4 = new Scanner(System.in);
		        
		      System.out.print("Enter name: ");
		      String nameCommand = input4.next();
		     
		      //If person is not found
		      if(allPeople.get(nameCommand) == null) 
		      {
		    	  System.out.println("Person not found");
		      }
		       
		      //If found, keep going
		      else
		      {
		    	  //If they have no friends
			      if(allPeople.get(nameCommand).numFriends == 0)
			      {
			    	  System.out.println("Person has no friends.");
			      }
			      
			      else
			      { 
				      System.out.print("Friends: ");
					  
				      for(int i = 0; i < allPeople.get(nameCommand).numFriends; i++)
				      {
				    	  //Loop through list and print friend's name
				    	  System.out.print(allPeople.get(nameCommand).friends.get(i).name + " "); 
				      }
				      
				      System.out.println(" ");
			      }
		      }
	      }
	      
	      if (command.equals("U"))
	      {
	    	  //Scanner for two names
	    	  Scanner input1 = new Scanner(System.in);
	    	  Scanner input2 = new Scanner(System.in);
		        
		      System.out.println("Enter name1: ");
		      String nameCommand = input1.next();
		      System.out.println("Enter name2: ");
		      String nameCommand2 = input2.next();
		      
		      //If person is not in allPeople list. 
		      if (allPeople.get(nameCommand) == null || allPeople.get(nameCommand2) == null)
		      {
		    	  System.out.println("Person not found");
		      }
		      
		      else
		      {
		    	  //Remove friend
		    	  allPeople.get(nameCommand).removeFriend(  allPeople.get(nameCommand2) );
		    	  
		    	  allFriends.remove(nameCommand+"*"+nameCommand2); 
		    	  friendCount--;
		      }
	      }
	      
	      if (command.equals("Q"))
	      {
	    	  Scanner input1 = new Scanner(System.in);
	    	  Scanner input2 = new Scanner(System.in);
		        
		      System.out.println("Enter name1: ");
		      String nameCommand = input1.next();
		      System.out.println("Enter name2: ");
		      String nameCommand2 = input2.next();
		      
		      boolean isTrue = true; 
		      
		     try
		     { 
			      //If either of the people do not exist
			      if (allPeople.get(nameCommand) == null || allPeople.get(nameCommand2) == null)
			      {
			    	  System.out.println("One of the people not found");
			      }
			      
			      else
			      {
				      if(allFriends.containsKey(nameCommand+"*"+nameCommand2) == true || allFriends.containsKey(nameCommand2+"*"+nameCommand) == true)
				      {
				    	  System.out.println("Yes");
				      }
				    
				      else
				      {
				    	  System.out.println("No");
				      }
			      }
		      }
		     
		     catch(Exception e)
		     {
		    	 if(isTrue == true)
		    	 { 
		    		 System.out.println("Error found, try again.");
		    	 }
		     }
	      }
	      
	      //Sentinel 
	      if (command.equals("X"))
	      {
	    	  break;
	      }
		}
	     

	}
}
