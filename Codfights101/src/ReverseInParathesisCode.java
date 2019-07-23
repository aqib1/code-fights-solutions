
public class ReverseInParathesisCode {

	static String reverseInParanthesis(String normal) {
		if (!normal.contains("("))
			return normal;

		return reverseInParanthesis(
				normal.substring(0, normal.lastIndexOf("("))
						+ new StringBuffer(normal.substring(normal.lastIndexOf("(") + 1,
								normal.indexOf(")", normal.lastIndexOf("(")))).reverse()
						+ normal.substring(normal.indexOf(")", normal.lastIndexOf("(")) + 1));
	}

	public static void main(String[] args) {
		System.out.println(reverseInParanthesis("aq(a(ta)b)Aa"));
	}

}
