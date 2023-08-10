import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
	
	private int size;
    private Node<T> top;
    
	public LinkedStack() {
		top = null;
        size = 0;
	}
	
	public boolean isEmpty() {
        return top == null;
    }
	
	public void push(T data) {
		Node<T> node = new Node<T>(data, top);
		top = node;
		size++;
    }

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException(); 
		}
		else {
			return top.getData();
		}
	}

	public T pop() {
		T data = peek();    
        top = top.getNext();
        size--;
        return data;  
	}

	public void clear() {
		top = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
        if (top == null) {
        	sb.append("Stack empty");
        }
        else {
            Node<T> temp = top;
            while (temp != null) {
            	sb.append(temp.getData());
                temp = temp.getNext();
            }
        }
        return sb.toString();
	}
}
