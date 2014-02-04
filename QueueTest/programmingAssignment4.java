//Jeremiah Crowley 

import java.util.*; 

public class programmingAssignment4 
{

	public static void main (String[] args)
	{
		//Enter command
		Scanner input = new Scanner(System.in);
		        
		System.out.print("Enter number of queue operations: ");
		String command = input.next();
		System.out.print("Enter index number: ");
		String command1 = input.next();
		
		//Create queue
		MyQueue queue = new MyQueue(Integer.parseInt(command1),Integer.parseInt(command));
		
		int n = Integer.parseInt(command);
		double totalDelay = 0.0;
		double p = 0.8;
		long startTime = System.currentTimeMillis();
		
		//Generate random number
		Random generator = new Random();
		
		for(int i = 0; i < n; i++ )
		{ 
			//Heads or Tails
			double random = generator.nextDouble();
			
			if(random < p)
			{
				double priority = generator.nextDouble(); 
				queue.addQueue(new job(i,priority));
			}
			
			else if(queue.checkEmpty() == false)
			{
				job nextJob = queue.popBestJob();
				totalDelay =+ 
						(i - nextJob.creationTime) * nextJob.priority;
			}
			
			 
			//Stage2
			if(i == n/2) 
			{
				p = 0.2;
			}
		}
		
		System.out.println("Running Time = " + (System.currentTimeMillis() - startTime) + ". Average Delay = " + totalDelay/n);
		
		input.close();
		
	}
}






