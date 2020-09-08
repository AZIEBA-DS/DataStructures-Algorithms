package Interfaces;

public class Duck implements IAnimal{
	
	private String m_name;
	
	public Duck(String name) {
		m_name = name;
	}
	
	@Override
	public String makeSound() {
		return this.m_name + " says: quack quack quack!";
	}
}
