
public class App {
	public static void main(String[] args) {
		char data[] = {'a', 'b', 'c'};
		char data1[] = {'a', 'b', 'c'};
		char[] dat1 = {'a', 'b', 'c'};
		String str = new String(data);
		String str1 = "abc";
		System.out.println(str == "abc");
		System.out.println(str1 == "abc");
		System.out.println(data[1]);
		System.out.println(dat1[1]);
		System.out.println(data == dat1);
		System.out.println(data == data1);
	}
}
