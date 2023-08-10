public class LinkedBag<T> implements BagInterface<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int length;
	
	public LinkedBag() {
		head = tail = null;
		length = 0;
	}

	@Override
	public BagInterface<T> union(BagInterface<T> aBag) {
		LinkedBag<T> otherBag = (LinkedBag<T>)aBag;
		LinkedBag<T> unionBag = copyBag(this.head);
		if(otherBag == null || otherBag.isEmpty()) {
			return unionBag;
		}
		addBag(unionBag, otherBag.head);
		return unionBag;
	}

	@Override
	public BagInterface<T> intersection(BagInterface<T> aBag) {
		LinkedBag<T> intersectionBag = new LinkedBag<>();
		LinkedBag<T> otherBag = (LinkedBag<T>)aBag;
		if(otherBag == null || otherBag.isEmpty()) {
			return intersectionBag;
		}
		LinkedBag<T> copyOfOtherBag = copyBag(otherBag.head);

		// Add to the new bag each item in this bag that matches an item in the another bag; Once matched, remove it from the second bag  
		Node<T> curr = this.head;
		while(curr != null) {
			T data = curr.getData();
			if (copyOfOtherBag.contains(data)) {
				intersectionBag.add(data);
				copyOfOtherBag.remove(data);
			}
			curr = curr.getNext();
		}
		return intersectionBag;
	}

	@Override
	public BagInterface<T> difference(BagInterface<T> aBag) {
		// The count of an item in the difference is the difference of the counts in the two bags.
		LinkedBag<T> otherBag = (LinkedBag<T>)aBag;
		LinkedBag<T> differenceBag = copyBag(this.head);
		if(otherBag == null || otherBag.isEmpty()) {
			return differenceBag;
		}
		
		// Remove the ones that exist in otherBag  
		Node<T> curr = otherBag.head;
		while(curr != null) {
			T data = curr.getData();
			if (differenceBag.contains(data)) {
				differenceBag.remove(data);
			}
			curr = curr.getNext();
		}
		return differenceBag;
	}
	

	private LinkedBag<T> copyBag(Node<T> head) {
		LinkedBag<T> newBag = new LinkedBag<>();
		Node<T> curr = head;
		while(curr != null) {
			newBag.add(curr.getData());
			curr = curr.getNext();
		}
		return newBag;
	}
	
	private void addBag(LinkedBag<T> bag, Node<T> head) {
		Node<T> curr = head;
		while(curr != null) {
			bag.add(curr.getData());
			curr = curr.getNext();
		}
	}
	
	public boolean contains(T data) {
		Node<T> curr = head;
		while (curr != null) {
			if (data.equals(curr.getData())) {
				return true;
			} else {
				curr = curr.getNext();
			}
		}
		return false;
	}
	
	public boolean add(T element) {
        Node<T> newest = new Node<>(element, null);
        if (head == null) {
            head = newest;
        } else if (tail != null) {
            tail.setNext(newest);
        }
        tail = newest;
        length++;
        return true; 
	}
	
	public boolean remove(T element) {
		
		// Store head node
        Node<T> temp = head;
        Node<T> prev = null;
 
        // If first node itself holds the element to be deleted
        if (temp != null && temp.getData().equals(element)) {
            head = temp.getNext(); // Changed head
            length--;
            return true;
        }
 
        // Search for the element to be deleted, keep track of the previous node as we need to change temp.getNext()
        while (temp != null && !temp.getData().equals(element)) {
            prev = temp;
            temp = temp.getNext();
        }
 
        // It is not present in the bag
        if (temp == null || prev == null) {
            return false;
        }
        // Unlink the node from the bag
    	prev.setNext(temp.getNext());
    	length--;
        return true;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length <= 0;
	}

	@Override
	public String toString() {
		StringBuilder contents = new StringBuilder("[ ");
        Node<T> temp = head;
        while (temp != null) {
        	contents.append(temp.getData()).append(" ");
            temp = temp.getNext();
        }
        return contents.append("]").toString();
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
