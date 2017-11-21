public class OrderedSuperArray extends SuperArray{

  /*constructor initializes an empty List*/
  public OrderedSuperArray(){
    super();
  }

  public OrderedSuperArray(String[] s) {
    super();
    for (int i = 0; i < s.length; i++) {
      add(s[i]);
    }
  }
  public OrderedSuperArray(int cap) {
    super(cap);
  }

  /*call the proper add.*/
  public void add(int index, String value){
    add(value);
  }
  public String set(int i, String s) {
    throw new UnsupportedOperationException();
  }
  /*Write this method and any
    appropriate helper methods.*/
  public boolean add(String value){
    super.add(place(value),value);
    System.out.println(this);
    return true;
  }
  public int indexOf(String value) {
    int n = place(value);
    if (get(n) == value) {
      return n;
    }
    return -1;
  }

  public int lastIndexOf(String value) {
    int n = indexOf(value);
    if (n == -1 || n == size()) {
      return n;
    }
    while (get(n)==value) {
      n++;
    }
    return n-1;
  }
  private int place(String s) {
    if (size() == 0) {
      return 0;
    }
    int start = 0;
    int end = size();
    while(end != start) {
      if (get((start+end)/2).compareTo(s) >= 0) {
        end = (start+end)/2;
      } else {
        start = (start+end+1)/2; //+1 to round up
      }
    }
    return start;
  }


}
