//Jeremiah Crowley

public class heapQueue 
{
	 static job[] data;
     private static int heapSize;

     //Implementation3
     public heapQueue(int size) 
     {
    	   data = new job[size];  
           heapSize = 0;
     }

     //Get Max for PopBestJob
     public static job getMax() 
     {
   	  	   job max = null;
   	  	
   	  	   if (checkEmpty())
   	  	   {
   	  		   System.out.println("Heap is empty");
   	  	   }
   	  	   else
   	  	   {
   	  		   max = data[0];
   	  	   }
   	  	   
   	  	   return max;
     }

     //Check if Empty
     public static boolean checkEmpty() 
     {
           if (heapSize == 0)
           {
           	return true;
           }
           else
           {
           	return false;
           }
     }
     
     //Getters for children and parent
     private static int getLeftChildIndex(int nodeIndex)
     {
           return 2 * nodeIndex + 1;
     }

     private static int getRightChildIndex(int nodeIndex) 
     {
           return 2 * nodeIndex + 2;
     }
     
     private static int getParentIndex(int nodeIndex) 
     {
           return (nodeIndex - 1) / 2;
     }
     
     //Add Job
     public static void addQueue(job value) 
     {
    	 if (heapSize == data.length)
    	 {
    		 System.out.println("Overflow");
    	 }
    	
    	 else
    	 {
	    	 heapSize++;
	         data[heapSize - 1] = value;
	         siftUp(heapSize - 1);
    	 }
     }
     
     //Move new job up queue
     private static void siftUp(int nodeIndex) 
     {
         int parentIndex;
         job tmp;

         if (nodeIndex != 0) 
         {
               parentIndex = getParentIndex(nodeIndex);
               if (data[parentIndex].priority < data[nodeIndex].priority)
               {
                     tmp = data[parentIndex];
                     data[parentIndex] = data[nodeIndex];
                     data[nodeIndex] = tmp;
                     siftUp(parentIndex);
               }
         }
     }
     
     //Remove highest priority job
     public static void removeMax() 
     {
         if (checkEmpty())
               System.out.println("Heap is empty");
         else 
         {
            data[0] = data[heapSize - 1];
            heapSize--;
            if (heapSize > 0)
            	siftDown(0);
         }

   }

   //Move new top job to right spot 
   private static void siftDown(int nodeIndex) 
   {
         int leftChildIndex, rightChildIndex, minIndex;
         job tmp;
         
         leftChildIndex = getLeftChildIndex(nodeIndex);
         rightChildIndex = getRightChildIndex(nodeIndex);

         if (rightChildIndex >= heapSize) 
         {
               if (leftChildIndex >= heapSize)
                     return;
               else
                     minIndex = leftChildIndex;
         }
         else 
         {
               if (data[leftChildIndex].priority >= data[rightChildIndex].priority)
                     minIndex = leftChildIndex;
               else
                     minIndex = rightChildIndex;
         }

         if (data[nodeIndex].priority < data[minIndex].priority)
         {
               tmp = data[minIndex];
               data[minIndex] = data[nodeIndex];
               data[nodeIndex] = tmp;
               siftDown(minIndex);
         }
   }


}