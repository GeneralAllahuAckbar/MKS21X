public class ReverseCharSequence implements CharSequence{
    private String data = "";
    public ReverseCharSequence(String s) {
	for (int i = 0; i < s.length(); i++) {
	    data = s.charAt(i) + data;
	}
    }
    public char charAt(int index){
	return data.charAt(index);
    }
    public int length(){
	return data.length();
    }
    public String toString(){
	return data;
    }
    public ReverseCharSequence subSequence(int start, int end) {
	return new ReverseCharSequence(data.substring(start,end));
    }
}
