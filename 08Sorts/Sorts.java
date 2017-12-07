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

    public static void main(String[] args) {
	int[] a = {3,41,21,2,1,6};
	selectionSort(a);
	System.out.println(Arrays.toString(a));
	int[] b = {3,41,21,2,1,6};
	insertionSort(b);
	System.out.println(Arrays.toString(b));

    }

}
