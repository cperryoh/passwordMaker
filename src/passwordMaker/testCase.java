package passwordMaker;

import java.util.ArrayList;

public class testCase {
	public static void main(String[] args) {
		Integer.parseInt("s");
		ArrayList<CharType> types = new ArrayList<CharType>() {
			{
				add(CharType.lowercase);
				add(CharType.uppercase);
				add(CharType.symbols);
				add(CharType.numbers);
			}
		};
		System.out.println(PassWordGen.MakePassWord(types, 10));
	}
}
