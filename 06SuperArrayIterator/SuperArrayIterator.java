import java.util.*;
public class SuperArrayIterator implements Iterator<String> {
    private int current = 0;
    private SuperArray hah;

    public SuperArrayIterator(SuperArray thing) {
	hah = thing;
    }
    public boolean hasNext(){
	return current < hah.size();
    }
    public String next() {
	if(hasNext()) {
	    return hah.get(current++);
	}
	throw new NoSuchElementException();
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }



}
