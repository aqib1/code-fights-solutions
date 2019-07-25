
public class IPV4AddressValidator {

	static boolean isIPv4Address(String inputString) {
		if (inputString == null || inputString.isEmpty())
			return false;
		if (!inputString.contains("."))
			return false;
		String[] components = inputString.split("\\.");
		if (components.length != 4)
			return false;
		for (String sub : components) {
			try {
				int val = Integer.parseInt(sub);
				if (val < 0 || val > 255)
					return false;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIPv4Address("0.254.255.0"));

	}

}
