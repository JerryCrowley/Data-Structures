//Jeremiah Crowley 
import java.util.*;

public class MyQueue
{

public int qIndex;
	
	//Constructor
	public MyQueue(int index, int size)
	{
		qIndex = index; 
		
		if(index == 3)
		{
			heapQueue heapQueue = new heapQueue(size);
		}
	}
	
	//Implementation1
	public static class stackQueue 
	{
		static LinkedList<job> stackQueue = new LinkedList();  //Used from Java Libraries 
		
		public static void addQueue(job newJob)
		{ 
			stackQueue.addFirst(newJob);
		}
		
		public static job popBestJob()
		{
			return stackQueue.pop();
		}
		
		public static boolean checkEmpty()
		{
			if(stackQueue.size() == 0)
			{
				return true;
			}
			else
			{
				return false; 
			}
		}
	}
	
	//Implementation2
	public static class linkedListQueue  
	{
		
		static LinkedList<job> linkedListQueue = new LinkedList();  //Used from Java Libraries 
		
		public static void addQueue(job newJob)
		{
			linkedListQueue.addFirst(newJob);
		}
		
		public static job popBestJob()
		{
			double maxPriority = 0; 
			job returnedJob = null;
			
			for(int i = 0; i < linkedListQueue.size(); i++)
			{
				if(linkedListQueue.get(i).priority > maxPriority)
				{
					maxPriority = linkedListQueue.get(i).priority;
				}
			}
			
			for(int i = 0; i < linkedListQueue.size(); i++)
			{
				if(maxPriority == linkedListQueue.get(i).priority)
				{
					returnedJob = linkedListQueue.get(i); 
					linkedListQueue.remove(i); 
					break; 
				}
			}
			
			return returnedJob; 
		}
		public static boolean checkEmpty()
		{
			if(linkedListQueue.size() == 0)
			{
				return true;
			}
			else
			{
				return false; 
			}
		}
	}
	
	//Add Job
	public void addQueue(job newJob)
	{
		if(qIndex == 1)
		{
			stackQueue.addQueue(newJob);
		}
		if(qIndex == 2)
		{
			linkedListQueue.addQueue(newJob);
		}
		if(qIndex == 3)
		{
			heapQueue.addQueue(newJob);
		}
	}
	
	//Pop Highest Priority Job
	public job popBestJob()
	{
		job returnedJob = null;
		
		if(qIndex == 1)
		{
			returnedJob = stackQueue.popBestJob();
		}
		if(qIndex == 2)
		{
			returnedJob = linkedListQueue.popBestJob();
		}
		if(qIndex == 3)
		{
			returnedJob = heapQueue.getMax();
			heapQueue.removeMax();
		}
		
		return returnedJob; 
	}
	
	//Check if Empty
	public boolean checkEmpty()
	{
		boolean isEmpty = false; 
		
		if(qIndex == 1)
		{
			isEmpty = stackQueue.checkEmpty();
		}
		if(qIndex == 2)
		{
			isEmpty = linkedListQueue.checkEmpty();
		}
		if(qIndex == 3)
		{
			isEmpty = heapQueue.checkEmpty();
		}
		
		return isEmpty;
	}
	
}