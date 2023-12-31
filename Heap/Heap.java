import java.util.Arrays; 

public final class Heap<T extends Comparable<? super T>> implements MaxHeapInterface<T>{
	
	private T[] heap; 
	private int lastIndex; 
	private boolean initialized = false; 
	private static final int DEFAULT_CAPACITY = 25; 
	private static final int MAX_CAPACITY = 10000;
	
	public Heap() {
		this(DEFAULT_CAPACITY);
	}
	
	public Heap(int initialCapacity) {
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY; 
		else
			checkCapacity(initialCapacity); 
		
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[initialCapacity +1]; 
		heap = tempHeap; 
		lastIndex =0; 
		initialized = true; 
		
	}
	

	public T getMax() {
		checkInitialization(); 
		T root = null; 
		if(!(isEmpty()))
			root = heap[1];
		return root; 
	}
	
	public boolean isEmpty() {
		return lastIndex < 1;
	}
	
	public int getSize() {
		return lastIndex; 
	}
	
	public void clear() {
		checkInitialization(); 
		while (lastIndex > -1) {
			heap[lastIndex] = null; 
			lastIndex--; 
		}
		lastIndex = 0; 
	}
	
	public void add (T newEntry) {
		checkInitialization(); 
		int newIndex = lastIndex + 1; 
		int parentIndex = newIndex / 2;
		while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
			heap[newIndex] = heap[parentIndex]; 
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
		}
		heap[newIndex] = newEntry; 
		lastIndex++; 
		ensureCapacity(); 
	}

	private void reheap (int rootIndex) {
		boolean done = false; 
		T orphan = heap[rootIndex]; 
		int leftChildIndex = 2* rootIndex; 
		
		while(!done && (leftChildIndex <= lastIndex)) {
			int largerChildIndex = leftChildIndex; 
			int rightChildIndex = leftChildIndex + 1; 
			if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex])>0) {
				largerChildIndex = rightChildIndex;
			}
			if (orphan.compareTo(heap[largerChildIndex]) < 0) {
				heap[rootIndex] = heap[largerChildIndex]; 
				rootIndex = largerChildIndex; 
				leftChildIndex = 2* rootIndex; 
			}
			else
				done = true; 
		}
		heap[rootIndex] = orphan; 
	}
	
	public T removeMax() {
		checkInitialization(); 
		T root = null; 
		if (!isEmpty()) { 
			root = heap[1]; 
			heap[1] = heap[lastIndex]; 
			lastIndex--; 
			reheap(1); 
		}
		return root; 
	}
	
	//smart way
	public Heap(T[] entries) { 
		this(entries.length); 
		assert initialized = true; 
		for (int index = 0; index < entries.length; index++)
			heap[index+1] = entries[index]; 
		for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex --)
			reheap(rootIndex);
	}
	
	public void checkInitialization() {
		// TODO Auto-generated method stub
		
	}
	
	public void ensureCapacity() {
		// TODO Auto-generated method stub
		
	}
	
	public void checkCapacity(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}
}
