
public interface StackInterface <T> {
	
	//adds new entry to the top of the stack 
	//@param newEntry an object to be added newEntry
	public void push (T newEntry);
	
	/** Removes and returns this stack's top entry.
	 * @returnThe object at the top of the stack. 
	 * @throwsEmptyStackExceptionif the stack is empty before the operation. */
	public T pop(); 
	
	/** Retrieves this stack's top entry.
	 * @returnThe object at the top of the stack.
	 * @throwsEmptyStackExceptionif the stack is empty. */
	public T peek(); 
	
	/** Detects whether this stack is empty.
	 * @returnTrue if the stack is empty. */
	public boolean isEmpty(); 
	
	//removes all entries from the stack
	public void clear(); 
}
