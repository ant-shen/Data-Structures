
public class ArrayBagTest {
	public static void main(String args[]) {
		unionTest();
		intersectionTest();
		differenceTest();
	}
	
	public static void unionTest() {
		System.out.println("-----unionTest-------------------------------------");
		BagInterface<Integer> bag1 = getBag1();
		BagInterface<Integer> bag2 = getBag2();
		BagInterface<Integer> unionBag = bag1.union(bag2);
		System.out.println("bag1 : " + bag1);
		System.out.println("bag1 : " + bag2);
		System.out.println("bag1.union(bag2): " + unionBag);
		unionBag = bag2.union(bag1);
		System.out.println("bag2.union(bag1): " + unionBag);
	}

	public static void intersectionTest() {
		System.out.println("-----intersectionTest-------------------------------------");
		BagInterface<Integer> bag1 = getBag1();
		BagInterface<Integer> bag2 = getBag2();
		BagInterface<Integer> intersection = bag1.intersection(bag2);
		System.out.println("bag1 : " + bag1);
		System.out.println("bag2 : " + bag2);
		System.out.println("bag1.intersection(bag2): " + intersection);
		intersection = bag2.intersection(bag1);
		System.out.println("bag2.intersection(bag1): " + intersection);
	}
	
	public static void differenceTest() {
		System.out.println("-----differenceTest-------------------------------------");
		BagInterface<Integer> bag1 = getBag1();
		BagInterface<Integer> bag2 = getBag2();
		BagInterface<Integer> difference = bag1.difference(bag2);
		System.out.println("bag1 : " + bag1);
		System.out.println("bag1 : " + bag2);
		System.out.println("bag1.difference(bag2): " + difference);
		difference = bag2.difference(bag1);
		System.out.println("bag2.difference(bag1): " + difference);
	}
	
	public static BagInterface<Integer> getBag1() {
		ResizableArrayBag<Integer> bag = new ResizableArrayBag<>();
		bag.add(20);
		bag.add(4);
		bag.add(15);
		bag.add(10);
		
		bag.add(2);
		bag.add(5);
		bag.add(15);
		bag.add(5);
		return bag;
	    
	}
	
	public static BagInterface<Integer> getBag2() {
		ResizableArrayBag<Integer> bag = new ResizableArrayBag<>();
		bag.add(10);
		bag.add(3);
		bag.add(8);
		bag.add(10);
		
		bag.add(6);
		bag.add(5);
		bag.add(12);
		bag.add(5);
		
		return bag;
	}
}
