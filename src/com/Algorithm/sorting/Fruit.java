package com.Algorithm.sorting;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/*
 * CompareToBuilder 
 * hashcode 
 * equals 
 */
class Fruit implements Comparable<Fruit> {

	
	private String name;
	private String color;
	
	public Fruit(String name, String color) {
		this.name = name; 
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (this == obj) return true; 
		
		if (obj == null || getClass() != obj.getClass()) return false;		
		Fruit fruit = (Fruit) obj; 
		
        return new EqualsBuilder()
                .append(name, fruit.name)
                .append(color, fruit.color)
                .isEquals();
	}
	
	
	/* 
	 *  returns distinct integers for distinct objects. (This is typically implemented by converting the internal address of the object into an integer [...])". 
	 *  The method in java.lang.Object is declared as native, which means the implementation is provided by the JVM and may vary depending on your runtime environment.
	 *  The hashcode is always the same if the object doesn�t change. Hashcode is a unique code generated by the JVM at time of object creation.
	 *  It can be used to perform some operation on hashing related algorithms like hashtable, hashmap etc
	 */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(color)
                .toHashCode();
    }
	
    /*
     * compare the attributes based on the order you append them, in this example name will compared first then color etc
     * Generating compareTo() method using CompareToBuilder class. For other
     * alternative way we can also use the CompareToBuilder.reflectionCompare()
     * method to implement the compareTo() method.
     */
    public int compareTo(Fruit fruit) {
        return new CompareToBuilder()
                .append(this.name, fruit.name)
                .append(this.color, fruit.color)
                .toComparison();
    }
    
    public class CompareToBuilderDemo {
        public  void main(String[] args) {
            Fruit fruit1 = new Fruit("Orange", "Orange");
            Fruit fruit2 = new Fruit("Watermelon", "Red");

            if (fruit1.compareTo(fruit2) == 0) {
                System.out.printf("%s == %s%n", fruit1.getName(), fruit2.getName());
            } else {
                System.out.printf("%s != %s%n", fruit1.getName(), fruit2.getName());
            }
        }
    }
}
