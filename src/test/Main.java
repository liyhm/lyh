package test;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Dog dog = new Dog(1);
		Dog dog2 = new Dog(2);
		Dog dog3 = new Dog(3);
		Dog dogarr[] = {dog3,dog,dog2};
		Sorter<Dog> sorter = new Sorter<Dog>();
		sorter.sort(dogarr, new DogComparator());
		System.out.println(Arrays.toString(dogarr));
	}
	
}
