import java.util.Arrays;
public class Sorts{
  public static String name(){
    return "09.Chen.Jiayang"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){
      for (int i = 0; i < data.length; i++) {
	  int min = 0;
	  int a;
	  for (a=i; a < data.length; a++) {
	      if (data[min] > data[a]) {
		  min = a;
	      }
	  }
	  int holder = data[min];
	  data[min] = data[i];
	  data[i] = holder;
      }


  }


    public static void main(String[] args) {
	int[] a = {3,41,21,2,1,6};
	selectionSort(a);
	System.out.println(Arrays.toString(a));

    }

}
