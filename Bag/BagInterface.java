

public interface BagInterface<T> {
	
	public int getCurrentSize();
	
	public boolean isEmpty();
	
	public boolean add(T newEntry);
	
	public T remove();
	
	public boolean remove(T anEntry);
	
	public void clear();
	
	public int getFrequencyOf(T anEntry);
	
	public boolean contains(T anEntry);
	
	public boolean isArrayfull();
	
	public T[] toArray();
	
	//union of bags 
	public BagInterface<T> union(BagInterface<T> anotherBag);
	
	//intersection of bags
	public BagInterface<T> intersection(BagInterface<T> anotherBag);
	
	//difference of bags
	public BagInterface<T> difference(BagInterface<T> anotherBag);
	
}
