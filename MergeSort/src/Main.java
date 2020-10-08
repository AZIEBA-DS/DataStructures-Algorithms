package mergeSort;

import java.util.*;

public class Main
{    
    public static void main(String args[])
    {
      // -----------------------------------
      // do not edit main...       
      // -----------------------------------
      List<Person> people = new ArrayList<Person>();
      
      people.add(new Person("Frank", "Denton", 73));
      people.add(new Person("Mark", "Cohen", 44)); 
      people.add(new Person("Tim", "Smith", 22));
      people.add(new Person("Steve", "Denton", 16)); 
      people.add(new Person("Andy", "Ashton", 44)); 
      people.add(new Person("Albert", "Denton", 58)); 
      
      List<Person> ans = mergeSort(people);
      System.out.println(ans);
      // -----------------------------------
    }
    
    public static List<Person> mergeSort(List<Person> items)
    {
        List<Person> sorted = new ArrayList<Person>();
        if (items.size() == 1) // base case...
        {
            return items; 
        }
        else 
        {
            
            int midpoint = items.size() / 2;
            List<Person> left = Arrays.asList(new Person[midpoint]);
            List<Person> right;
            
            if (items.size() % 2 == 0) {
            	
            	right = Arrays.asList(new Person[midpoint]);
            	
            } else {
            	
            	right = Arrays.asList(new Person[midpoint + 1]);
            	
            }
            
            for(int i = 0; i < midpoint; i++) {
            	
            	left.set(i, items.get(i));
            	
            }
            
            for (int j = 0; j < right.size(); j++) {
            	
            	right.set(j, items.get(midpoint + j));
            	
            }
            
            left = mergeSort(left);
            right = mergeSort(right);
            sorted = merge(left, right);
        }
        
        return sorted;
    }
    
    private static List<Person> merge(List<Person> partA, List<Person> partB)
    {
         List<Person> merged = Arrays.asList(new Person[partA.size() + partB.size()]);
         
         int aPointer = 0;
         int bPointer = 0;
         int mergedPointer = 0; 
         
         while (aPointer < partA.size() || bPointer < partB.size()) {
        	 
        	 if(aPointer < partA.size() && bPointer < partB.size()) {
        		 
        		 if (partA.get(aPointer).compareTo(partB.get(bPointer)) < 1) {
        			 
        			 merged.set(mergedPointer++, partA.get(aPointer++));
        			 
        		 } else {
        			 
        			 merged.set(mergedPointer++, partB.get(bPointer++));
        			 
        		 }
        	 }
        	 
        	 else if(aPointer < partA.size()) {
        		 
        		 merged.set(mergedPointer++, partA.get(aPointer++));
        	 }
        	 
        	 else if(bPointer < partB.size()) {
        		 
        		 merged.set(mergedPointer++, partB.get(bPointer++));
        	 }
         }
         
         return merged;
    }
}
