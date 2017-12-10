import java.util.Arrays;
public class Sorts{
  public static String name(){
    return "09.Chen.Jiayang";
  }

    public static void swap(int[] array, int a, int b) {
	int supercool = array[a];
	array[a] = array[b];
	array[b] = supercool;
    }
  public static void selectionSort(int[] data){
      for (int i = 0; i < data.length; i++) {
	  int min = i;
	  for (int a=i; a < data.length; a++) {
	      if (data[min] > data[a]) {
		  min = a;
	      }
	  }
	  swap(data, min, i);
      }
  }

    public static void insertionSort(int[] data) {
	for (int i = 1; i < data.length; i++) {
	    int j = i;
	    while (j > 0 && data[j] < data[j-1]) {
	        swap(data, j ,j-1);
		j--;
	    }
	}
    }

    public static void bubbleSort(int[] data) {
      boolean worked = true;
      int j = data.length;
      while (j > 0 && worked) {
        worked = false;
        for (int i = 0; i < j-1; i++) {
          if (data[i] > data[i+1]) {
            swap(data, i, i+1);
            worked = true;
          }
        }
        j--;
      }
    }

    public static void main(String[] args) {
      int[] thing = {1,213,2,412,21,321,532,543,1,32521,13,5,6342,123,1,124,3,54,2};
    	     int[] a = thing.clone();
    	     selectionSort(a);
    	     System.out.println(Arrays.toString(a));
    	     int[] b = thing.clone();
    	     insertionSort(b);
    	     System.out.println(Arrays.toString(b));
           int[] c = thing.clone();
           bubbleSort(c);
           System.out.println(Arrays.toString(c));
    }

}
