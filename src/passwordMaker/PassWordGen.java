package passwordMaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PassWordGen {
	public static char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	static Random rnd;
	public static char[] numbers = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
	public static char[] symbols = { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '-', '=', '/', ',',
			'*', '`', '~' };

	public static String MakePassWord(ArrayList<CharType> types, int length) {

		rnd = new Random();
		String out = "";
		rnd.setSeed(System.currentTimeMillis());
		for (int i = 0; i < length; i++) {
			if(i>=types.size()) {
				out+=getRandomChar(types);
			}else {
				out+=getChar(types.get(i));
			}
		}
		return shuffleStr(out);
	}
	public static String shuffleStr(String str) {
		StringBuilder out = new StringBuilder(str);
		for(int i = 0;i<str.length();i++) {
			int index = rnd.nextInt(str.length());
			out.setCharAt(i,str.charAt(index));
			out.setCharAt(index,str.charAt(i));
		}
		return out.toString();
	}
	public static char getChar(CharType type) {
		char out;
		char[] arr= {};
		switch (type) {
		case uppercase: {
			arr = letters;
			out = Character.toUpperCase(getRandom(arr));
			return out;
		}
		case lowercase: {
			arr = letters;
			break;
		}
		case symbols: {
			arr = symbols;
			break;
		}
		case numbers: {
			arr=numbers;
			break;
		}
		}
		char c = getRandom(arr);
		return c;
	}
	public static char getRandomChar(ArrayList<CharType> types) {
		CharType type = types.get(rnd.nextInt(types.size()));
		char out;
		char[] arr= {};
		switch (type) {
		case uppercase: {
			arr = letters;
			out = Character.toUpperCase(getRandom(arr));
			return out;
		}
		case lowercase: {
			arr = letters;
			break;
		}
		case symbols: {
			arr = symbols;
			break;
		}
		case numbers: {
			arr=numbers;
			break;
		}
		}
		return getRandom(arr);

	}

	public static char getRandom(char[] arr) {
		return arr[rnd.nextInt(arr.length)];
	}
}
