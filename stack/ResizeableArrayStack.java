import java.util.Arrays;

public class ResizeableArrayStack<T> implements StackInterface<T> {
	
	private T[] stack;
	private int size;
	private int topIndex; 
	public boolean integrityOK = false; 
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10000;
	
	public ResizeableArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	 
	public ResizeableArrayStack(int initialCapacity) {
		integrityOK = false; 
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
		size = 0;
		topIndex = -1;
		integrityOK = true; 
	}

	public void push(T item) {
		if (item != null && size == stack.length) {
			expand();
		}
        stack[size++] = item;
	}
	
	public T pop() {
		if(!isEmpty()) {
			T top = stack[--size];
	        stack[size] = null;
	        return top;
		}
		return null;
	}
	
	public T peek() {
		return isEmpty() ? null : stack[size - 1];
	}
	
	public boolean isEmpty() {
		return size <= 0;
	}
	
	public void clear() {
		while(size > 0) {
			stack[--size] = null;
		}
	}
	
	private void expand() {
		int newLength = size*2;
		checkCapacity(newLength);
	    stack = Arrays.copyOf(stack, newLength);
	}
	
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
	
	@Override
    public String toString() {
         StringBuilder sb = new StringBuilder();
         
         for(int i = 0; i < size ;i++) {
             sb.append(stack[i].toString());
             if(i < size-1){
                 sb.append(",");
             }
         }
        
         return sb.toString();
    }
}
