//Jeremiah Crowley
import java.util.*;

public class programmingAssignment3
{

	public static void main(String[] args) 
	{
		Folder root = new Folder("ROOT"); //Root folder created
		Folder currentDirectory = root; //Root folder made current folder
		
		
		
		//Infinite Loop
		for( ;; )
		{
			//Enter command
			Scanner input = new Scanner(System.in);
			        
			System.out.print("Enter command: ");
			String command = input.next();
			      
			if (command.equals("C"))
			{
				 Scanner input1 = new Scanner(System.in);
		        
			     System.out.print("Enter name: ");
			     String command1 = input1.next();
			     String nameCommand = command1.toLowerCase();
			     
			     if( nameCommand.equals("root") ) 
			     {
			    	 System.out.println("Can't name to root. Try again.");
			     }
			     
			     else
			     {
				     if( currentDirectory.equals(nameCommand) == false)
				     {
				    	 Folder newFolder = new Folder(nameCommand); //Create new folder
				    	 currentDirectory.children.add(newFolder); //Add to currentDirectory's children
				    	 newFolder.parent = currentDirectory; //Make the currentDirectory the newfolder's parent
				    	 currentDirectory.addNode(currentDirectory); //Add node 
				     }
				     else
				     {
				    	 System.out.println("Folder already in subFolder.");
				     }

			     }
			}
			
			if (command.equals("D"))
			{
				 Scanner input1 = new Scanner(System.in);
			        
			     System.out.print("Enter name: ");
			     String command1 = input1.next();
			     String nameCommand = command1.toLowerCase();
			     
			     if( currentDirectory.equals(nameCommand) == true) 
			     {
			    	 currentDirectory = currentDirectory.children.get(currentDirectory.index(nameCommand));
			     }
			     else
			     {
			    	 System.out.println("File does not exist.");
			     }
			}
			
			if (command.equals("U"))
			{
				if( currentDirectory == root)
				{
					System.out.println("ROOT File.");
				}
				
				else
			    {
			    	 currentDirectory = currentDirectory.parent;
			    }
			}
			
			if (command.equals("R"))
			{
				Scanner input1 = new Scanner(System.in);
		        
			    System.out.print("Enter name: ");
			    String command1 = input1.next();
			    String nameCommand = command1.toLowerCase();
			     
			    if( currentDirectory.equals(nameCommand) == true)
			    {
			    	Folder removeFolder = currentDirectory.children.get(currentDirectory.index(nameCommand)); 
			    	currentDirectory.removeNode(removeFolder, removeFolder.numNodes);
			    	currentDirectory.children.remove(currentDirectory.index(nameCommand));
			    	
			    }
			    else
			    {
			    	System.out.println("File does not exist.");
			    }
			}
			
			if (command.equals("L"))
			{
				if( currentDirectory.children.size() >= 2)
			    {
		    		currentDirectory.sort(currentDirectory.children); 
			    }
				for(int i = 0; i < currentDirectory.children.size(); i++)
			    {
					System.out.print(currentDirectory.children.get(i).name + " ");
			    }
				System.out.println("");
			}
			
			if (command.equals("P"))
			{
				currentDirectory.path(currentDirectory);
				System.out.println("");
			}
			
			if (command.equals("N"))
			{
				System.out.println(currentDirectory.numNodes);
			}
			
			//Sentinel 
		    if (command.equals("X"))
		    {
		        break;
		    }
		}
	}



}
