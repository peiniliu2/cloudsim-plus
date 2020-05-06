package org.tianchi.results.evaluation;

import java.util.List;
import java.util.Objects;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.map.PassiveExpiringMap;

public class Main {
	


    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
        
//        List<String> collectionA = new ArrayList<String>();
//        collectionA.add("a");
//        collectionA.add("a1");
//        List<String> collectionB = new ArrayList<String>();
//        collectionA.add("b");
//        collectionA.add("b1");
//    	
//    	Stream<String> combinedStream = Stream.concat(
//    			  collectionA.stream(),
//    			  collectionB.stream());
//    	System.out.println(combinedStream.toString());
//    	
//    	Stream<String> combinedStream1 = Stream.of(collectionA, collectionB)
//    			  .flatMap(Collection::stream);
//    			Collection<String> collectionCombined = 
//    			  combinedStream1.collect(Collectors.toList());
//    	System.out.println(combinedStream1.toString());
    	
    	Person person = new Person("peini", 0);
    	Person person2 = new Person("jie", 0);
    	Person person3 = new Person("yu", 0);
    	Identity identity = new Identity("yu",3);
    	List<Person> p1 = new ArrayList<Person>();
    	p1.add(person); p1.add(person2); p1.add(person3);
    	List<Identity> p2 = new ArrayList<Identity>();
    	p2.add(identity);
    	System.out.println(compareListHitData(p1, p2).toString());
    	
    }
    
    public static List<Person> compareListHitData(List<Person> oneList, List<Identity> twoList) {
        List<Person> list=oneList.stream().map(person -> twoList.stream()
                .filter(identity -> Objects.equals(person.getName(),identity.getName()))
                .findFirst().map(i -> {
                    person.setAge(i.getAge());
                    return person;
                }).orElse(null))
                .filter(Objects::nonNull).collect(Collectors.toList());
        return list;
    }
    
    
    

}

class Identity{
	public Identity(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

class Person{
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}