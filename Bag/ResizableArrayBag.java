import java.util.Arrays;

public class ResizableArrayBag <T> implements BagInterface<T> {

	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10000;
	
	private T[] bag;
	private int length;
	
	public ResizableArrayBag() {
		this(DEFAULT_CAPACITY); 
	}
	
	public ResizableArrayBag(int capacity) {
		checkCapacity(capacity);
        @SuppressWarnings("unchecked")
        T[] aBag = (T[])new Object[capacity];
        bag = aBag;
		length = 0;
	}

	@Override
	public BagInterface<T> union(BagInterface<T> aBag) {
		ResizableArrayBag<T> unionBag = new ResizableArrayBag<>();
	    ResizableArrayBag<T> otherBag = (ResizableArrayBag<T>)aBag;
	      
	    // Add elements from this bag to the union bag
	    int index;
	    for (index = 0; index < length; index++) {
	    	unionBag.add(bag[index]);
	    }
	    
	    if(otherBag == null || otherBag.isEmpty()) {
			return unionBag;
		}
	    
	    // Add elements from the other bag to the union bag
	    for (index = 0; index < otherBag.length; index++) {
	    	unionBag.add(otherBag.bag[index]);
	    }
	    return unionBag;
	}

	@Override
	public BagInterface<T> intersection(BagInterface<T> aBag) {
		ResizableArrayBag<T> intersectionBag = new ResizableArrayBag<>();
	    ResizableArrayBag<T> otherBag = (ResizableArrayBag<T>)aBag;
	    
	    if(otherBag == null || otherBag.isEmpty()) {
			return intersectionBag;
		}
	    
	    ResizableArrayBag<T> copyOfOtherBag = new ResizableArrayBag<>();
	    
	    int index;
	      
	    for (index = 0; index < otherBag.size(); index++) {
	    	copyOfOtherBag.add(otherBag.bag[index]);
	    }
	      
	    // Add item to intersectionBag from this bag that matches item in copyOfOtherBag, and remove it from copyOfOtherBag
	    for (index = 0; index < this.length; index++) {
	    	T item = bag[index];
	    	if (copyOfOtherBag.contains(item)) {
	            intersectionBag.add(item);
	            copyOfOtherBag.remove(item);
	        } 
	    }
	    return intersectionBag;
	}

	@Override
	public BagInterface<T> difference(BagInterface<T> aBag) {
		ResizableArrayBag<T> differenceBag = new ResizableArrayBag<>();
	    ResizableArrayBag<T> otherBag = (ResizableArrayBag<T>)aBag;
	      
	    int index;
	    for (index = 0; index < this.length; index++) {
	         differenceBag.add(bag[index]);
	    }
	    
	    if(otherBag == null || otherBag.isEmpty()) {
			return differenceBag;
		}
	      
	    // Remove the ones that are in otherBag
	    for (index = 0; index < otherBag.size(); index++) {
	    	differenceBag.remove(otherBag.bag[index]);
	    }
	    return differenceBag;
	}
	
	public boolean add(T element) {
		if(element == null) {
			return false;
		}
		if (length == bag.length) {
			expand();
		}
		//set element to the position: index = length
		bag[length++] = element;
		return true;
	}
	
	public boolean remove(T target) {
		if(target == null) {
			return false;
		}
		boolean found = false;
		for (int i = 0; i < length; i++) {
			T elem = bag[i];
			if (target.equals(elem)) {
				found = true;
			}
			//shifting of all elements right of the element we wanted to remove
			if(found && i+1 < length) {
				bag[i] = bag[i+1];
			}
		}
		if(found) {
			bag[--length] = null;
		}
		return found;
	}

	/**
	 * Doubles the size of the bag
	 */
	private void expand() {
		int newLength = length*2;
		checkCapacity(newLength);
	    bag = Arrays.copyOf(bag, newLength);
	}
	
	/**
	 * Capacity check
	 * @param capacity
	 */
	private void checkCapacity(int capacity) {
		if(capacity < 0 || capacity > MAX_CAPACITY) {
			StringBuilder message = new StringBuilder("Invalid capacity: ").append(capacity);
			if(capacity < 0) {
				message.append(" - capacity must be positive.");
			} else  {
				message.append(" - capacity exceeds maximum of ").append(MAX_CAPACITY);
			}
			throw new IllegalStateException(message.toString());
		}
	}
	
	public boolean contains(T target) {
		return indexOf(target) >= 0;
	}
	
	public int indexOf(T target) {
		for (int i = 0; i < length; i++) {
			T elem = bag[i];
			if ((target == null && elem == null) || (target != null && target.equals(elem))) {
				return i;
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		return length <= 0;
	}
	
	public int size() {
		return length;
	}
	
	@Override
	public String toString() {
		return "ResizableArrayBag [bag=" + Arrays.toString(bag) + ", length=" + length + "]";
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isArrayfull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
