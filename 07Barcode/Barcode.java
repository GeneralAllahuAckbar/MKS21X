import java.util.*;
public class Barcode implements Comparable<Barcode>{
    private String zip;
    private static String[] array= {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    private static ArrayList<String> key = new ArrayList<>(Arrays.asList(array));

    public Barcode(String zip) {
      this.zip = toZip(toCode(zip));
    }

    public static String toCode(String zip) {
	     String s = "|";
       if (zip.length() != 5) {
         throw new IllegalArgumentException();
       }
       try {
         for (int i = 0; i < zip.length();i++) {
           s += key.get(Integer.parseInt(zip.substring(i,i+1)));
         }
       }catch(ArrayIndexOutOfBoundsException|NumberFormatException e) {
         throw new IllegalArgumentException();
       }
       return s + key.get(Integer.parseInt(calcCheck(zip)))+ "|";
    }

    private static String calcCheck(String zip) {
      int sum = 0;
      for (int i = 0; i < zip.length(); i++) {
        sum += Integer.parseInt(zip.substring(i,i+1));
      }
      return ""+(sum%10);

    }

    public static String toZip(String code) {
      String s = "";
      if (code.charAt(0) != '|' || code.charAt(code.length()-1) != '|' || code.length() != 32) {
        throw new IllegalArgumentException();
      }
      String current = "";
      for(int i = 1; i < 32; i++) {
        current += code.charAt(i);
        if (current.length() == 5) {
          if (key.indexOf(current) == -1) {
            throw new IllegalArgumentException();
          }
          s += key.indexOf(current);
          current = "";
        }
      }
      int got = Integer.parseInt(calcCheck(s.substring(0,5)));
      int had = Integer.parseInt(s.substring(5));
      if (got != had) {
        throw new IllegalArgumentException();
      }
      return s.substring(0,5);
    }
    public String getCode() {
      return toCode(zip);
    }
    public String getZip() {
      return zip;
    }
    public int compareTo(Barcode other) {
      return zip.compareTo(other.zip);
    }
    public String toString() {
      return getCode() + "(" + zip + ")";
    }
    /*public static void main(String[] args) {
      Barcode a = new Barcode("10213");
      System.out.println(Barcode.toZip("|:::||||:::::|:|:::||::||:|:::||"));
      System.out.println(a);
    }*/


}
