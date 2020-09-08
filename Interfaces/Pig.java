package Interfaces;

public class Pig implements IAnimal{
	
	private String m_name;
	
	public Pig(String name) {
		m_name = name;
	}
	
	@Override
	public String makeSound() {
		return this.m_name + " says: oink oink oink!";
	}
}
