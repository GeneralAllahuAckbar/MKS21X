import java.util.*;
public class SuperArray implements Iterable<String>{
  private String[] data;
  private int size;

  public SuperArray() {
    data = new String[10];
  }

  public Iterator<String> iterator() {
      return new SuperArrayIterator(this);
  }
  public void clear() {
    data = new String[data.length];
    size = 0;
  }
  public boolean isEmpty() {
    return toString().equals("[]");
  }
  public int size() {
    return size;
  }

  public boolean add(String element) {
    resize();
    data[size()] = element;
    size++;
    return true;
  }

  public String toString() {
    if (size == 0) {
      return "[]";
    }
    String s = "[";
    for(int i = 0; i < size-1; i++) {
      s += get(i) + ", ";
    }
    return s + get(size()-1) + "]";
  }

  public String get(int i) {
    if (i >= size() || i < 0) {
      System.out.println("Method get() Invalid Index: Given index " + i);
      return null;
    }
    return data[i];
  }

  public String set(int i, String element) {
    if (i > size() || i < 0) {
      System.out.println("Method set() Invalid Index: Given Index " + i);
      return null;
    }
    String s = get(i);
    data[i] = element;
    return s;
  }

  private void resize() {
    if (size() == data.length) {

      String[] neww = new String[size() * 2];
      for (int i = 0; i < size();i++) {
        neww[i] = get(i);
      }
      data = neww;
    }
  }

  public boolean contains(String s) {
    for (int i = 0; i < size(); i++) {
      if (s.equals(get(i))) {
        return true;
      }
    }
    return false;
  }
  public int indexOf(String s) {
    for (int i = 0; i < size(); i++) {
      if (get(i).equals(s)) {
        return i;
      }
    }
    return -1;
  }
  public int lastIndexOf(String s) {
    for (int i = size()-1; i > -1; i++) {
      if (get(i).equals(s)) {
        return i;
      }
    }
    return -1;
  }

  public void add(int index , String s) {
    if (index > size() || index < 0) {
      System.out.println("Method add() Invalid Index: Given index " + index);
    } else {
      size++;
  	  for (int i = size()-2; i > index-1; i--) {
         resize();
         set(i+1, get(i));
  	    }
  	  set(index, s);
     }

  }

  public String remove(int i) {
    if (i >= size() || i < 0) {
      System.out.println("Method remove() Invalid Index: Given index " + i);
      return null;
    }
  	String s = get(i);
  	set(i, null);
  	for (int index = i+1; index < size(); index++) {
  		set(index-1, get(index));
      set(index, null);
  	}
    size--;
  	return s;
  }

  public boolean remove(String s) {
    return remove(indexOf(s)).equals(s);
  }





}
