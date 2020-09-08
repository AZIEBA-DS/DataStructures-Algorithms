package Interfaces;

public class InterfacesMain {
	public static void main(String[] args) {
	Pig pig = new Pig("Pig");
	Duck duck = new Duck("Duck");
	
	System.out.println(duck.makeSound());
	System.out.println(pig.makeSound());
	}
}
