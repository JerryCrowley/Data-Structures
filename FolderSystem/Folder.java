//Jeremiah Crowley
import java.util.*;

public class Folder {

	//Fields
	String name;
	LinkedList<Folder> children = new LinkedList(); //Used from Java Libraries
	Folder parent = null;
	Folder nextSibling; 
	int numNodes = 1; 
	
	//Constructor
	public Folder(String n)
	{
		name = n;
	}
	
	public boolean equals(Object o)
	{
		int isTrue = 0; 
		for(int i = 0; i < this.children.size(); i++)
		{
			if(this.children.get(i).name.equals(o)) //If name is found
			{
				isTrue = 1;
			}
		}
		
		if(isTrue == 1)
		{
			return true;
		}
		else
		{
			return false;
		} 
	}
	
	public int index(Object o)
	{
		int index = 0; 
		for(int i = 0; i < this.children.size(); i++)
		{
			if(this.children.get(i).name.equals(o)) //If name is found, return index
			{
				index = i;
			}
		}
		
		return index;
	}
	
	public void path(Folder n)
	{
		LinkedList<String>Names = new LinkedList<String>(); //Used from Java Libraries
		
		if(n.parent == null) //Recursively travel from folder to root, adding name to linkedList
		{
			Names.add("ROOT"); 
		}
		else
		{
			Names.add(n.name);
			path(n.parent);
		}
		
		for(int j = Names.size() - 1; j >= 0; j--) //Print likedList backwards
		{
			System.out.print(Names.get(Names.size()-1) + "/");
		}
	}
	
	public void addNode(Folder n)
	{
		if(n.parent == null) //Recursively go from parent to root, adding one to each's numNodes. 
		{
			n.numNodes++; 
		}
		else
		{
			n.numNodes++;
			addNode(n.parent);
		}
	}
	
	public void removeNode(Folder n, int numNodes)
	{
		if(n.parent.parent == null) //Recursively go from parent to root, deleting numNodes from each. 
		{
			n.parent.numNodes = n.parent.numNodes - numNodes;
		}
		
		else
		{
			n.parent.numNodes = n.parent.numNodes - numNodes;
			removeNode(n.parent, numNodes); 
		}
	}
	
	public void sort(LinkedList<Folder> n) //Sort children in alphabetical order
	{
		for (int i=0; i < n.size()-1; i++)
		{
			 for (int j=n.size()-1; j > i; j--) 
			 {
				 if (n.get(j).name.compareTo(n.get(j-1).name) < 0 )
				 {
					 Folder temp = n.get(j-1);
					 n.set(j-1, n.get(j));
					 n.set(j, temp);
				 }
			 }
		}
	}
	

}
