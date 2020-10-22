package aStackQueue;

import java.util.ArrayList;

public class StackAL<T> implements IStack<T> {

	private ArrayList<T> list = new ArrayList<T>();
	
	@Override
	public void push(T item)
	{
		
		list.add(item);
		
	}
	
	@Override
	public T pop()
	{
		
		if(list.size() == 0) 
		{
			throw new IllegalStateException("Stack is empty");
		}
		
		return list.remove(list.size() - 1);
		
	}
	
	@Override
	public T top()
	{
		if(isEmpty())
		{
			throw new IllegalStateException("Stack is empty");
		}
		return list.get(getSize() - 1);
		
	}
	
	@Override
	public boolean isEmpty()
	{
		
		return getSize() == 0;
		
	}
	
	@Override
	public int getSize()
	{
		
		return list.size();
		
	}
	
	@Override
	public void clear()
	{
		list.clear();
	}
	
	@Override
	public String toString()
	{
		
		StringBuffer sb = new StringBuffer("top->");
			if (!isEmpty())
			{
				for (int i = getSize() - 1; i >= 0; i--)
				{
					if (i == getSize() - 1)
					{
						sb.append(list.get(i));
					}
					else 
					{
						sb.append( "->" + list.get(i));
					}
				}
			}
		
		return sb.toString();
	}
	
}
