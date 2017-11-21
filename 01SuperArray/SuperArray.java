public class SuperArray {
  private String[] data;
  private int size;

  public SuperArray() {
    data = new String[10];
  }

  public void clear() {
    data = new String[data.length];
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(String element) {
    if (size() == data.length) {
      resize();
    }
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
    return data[i]; //Need to add error, but returning string is bad
  }

  public String set(int i, String element) {
    if (i >= size() || i < 0) {
      return "Invalid Index";
    }
    String s = get(i);
    data[i] = element;
    return s;
  }

  private void resize() {
    String[] neww = new String[size() * 2];
    for (int i = 0; i < size();i++) {
      neww[i] = get(i);
    }
    data = neww;
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
  	if (size() == data.length) {
  		resize();
  	}
  	for (int i = size()-1; i > index-1; i--) {
  		set(i+1, get(i));
  	}
  	set(index, s);
  }
  
  public String remove(int i) {
  	String s = get(i);
  	set(i, new String);
  	for (int index = i+1; i < size(); i++) {
  		set(i-1, get(i));
  	}
  	return s;
  }
  






}
