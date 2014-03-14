package sortAlgorithms;
/**
 * Reverse String block AB to BA with constant space 
 * http://www.cnblogs.com/solidblog/archive/2012/07/24/2605838.html
 * @author CT61557
 *
 */
public class StringReverse {
	private String reverse(String str, int cut){
		StringBuilder strb=new StringBuilder(str);
		reverse(strb,0,cut);
		reverse(strb,cut,str.length());
		reverse(strb,0,str.length());
		return strb.toString();
	}
	private void reverse(StringBuilder str, int start, int end){
		int offset = end-start;
		for(int i = 0;i<offset/2;i++){
			char c = str.charAt(start+i);
			str.setCharAt(start+i, str.charAt(start+offset-i-1));
			str.setCharAt(start+offset-i-1, c);
		}
	}
	
	public static void main(String[] argvs){
		StringReverse instance = new StringReverse();
		String str = "abcdefghijk";
		String res = instance.reverse(str, 2);
		System.out.println(res);
	}
	
}
