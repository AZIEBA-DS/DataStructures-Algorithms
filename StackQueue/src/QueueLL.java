package stackQueue;

import java.util.*;

public class QueueLL<T extends Comparable<T>> implements IQueue<T>
{
   public static void main(String args[])
   {
	   
	   IQueue<Integer> queue = new QueueLL<Integer>();
	   
	   queue.enqueue(1); 
       queue.enqueue(4); 
       queue.enqueue(10); 
       queue.enqueue(8); 
       queue.enqueue(7); 
       queue.enqueue(6); 
       queue.enqueue(5); 
       queue.enqueue(2); 
       queue.enqueue(9); 
       queue.enqueue(3);
       
       System.out.println("Original: " + queue.toString());
       
       queue.reverse();
       System.out.println("Reversed: " + queue.toString());
       
       queue.sort();
       System.out.println("Sorted Ascending: " + queue.toString());
       
   }
   
    
	private Node m_head;
	private int m_count;
	
	public QueueLL()
	{
		m_head = new Node(null);
		m_count = 0;
	}
	
	public void reverse()
	{
		IStack<T> stack = new StackLL<T>();
		
		while(getSize() != 0)
		{
			stack.push(dequeue());
		}
		
		while(stack.getSize() != 0)
		{
			enqueue(stack.pop());
		}
	}
	
	public void sort()
	{
		ArrayList<T> list = new ArrayList<T>();
		int counter = 0;
		
		while(getSize() != 0)
		{
			list.add(dequeue());
		}
		
		Collections.sort(list);
		
		while(counter < list.size())
		{
			enqueue(list.get(counter));
			counter++;
		}
		
	}
	
	@Override
	public void enqueue(T item)
	{
		// runs in constant time ...
		
		// FIFO: this queue places new items at the head of the queue
		// and removes items from the tail of the queue...
		
		Node n = new Node(item);
		n.m_next = m_head.m_next;
		m_head.m_next = n;
		m_count++;
	}

	@Override
	public T dequeue()
	{
		// runs in O(n) time
		
		// FIFO: this queue places new items at the head of the queue
		// and removes items from the tail of the queue...
		
		if (isEmpty())
			throw new IllegalStateException("dequeue error: queue is empty!");
		
		T ret = null;
		Node cur = m_head;
		
		// while not at the tail...
		while (cur.m_next != null)
		{
			// if I am at the second from the tail of the queue...
			if (cur.m_next.m_next == null)
			{
				// grab the data from the last item in the queue...
				ret = cur.m_next.m_data;
				
				// detatch the last item in the queue...
				cur.m_next = null;
				
				break;
			}
			else
			{
				// otherwise, continue moving towards the tail of the queue...
				cur = cur.m_next;
			}
		}
		
		m_count--;
		return ret;
	}

	@Override
	public boolean isEmpty()
	{ 
		return getSize() == 0;
	}
	
	@Override
	public int getSize()
	{
		return m_count;
	}
	
	@Override
	public String toString()
	{	
		// runs in linear time...
		
		StringBuffer sb = new StringBuffer("rear->");
		if (!isEmpty())
		{
			Node node = m_head.m_next;
			sb.append(node.m_data.toString());
			while (node.m_next != null)
			{
				node = node.m_next;
				sb.append("->");
				sb.append(node.m_data.toString());
			}
		}
		return sb.toString();
	}

	private class Node
	{
	 	private T m_data;
	 	private Node m_next;
		
		public Node(T data)
		{
			m_data = data;
			m_next = null;
		}
	}
}
