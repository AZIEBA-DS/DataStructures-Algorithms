package aRecursion;

public class StringRecursion {
	
	public String replace(String s, char oldChar, char newChar) {
		int stringLength = s.length();
		
		if (stringLength < 1) {
			return "No characters were replaced because there are no characters in this string.";
		}
		else {
			for (int i = 0; i < stringLength; i++) {
				if (s.charAt(i) == oldChar || Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(oldChar)) {
					s = s.substring(0, i) + newChar + s.substring(++i);
					return replace(s, oldChar, newChar);	
				}
			}
		}
		return s;
	}
}
