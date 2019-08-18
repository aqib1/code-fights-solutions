import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class UserNameSystem {
	public static List<String> usernamesSystem(List<String> u) {
		// Write your code here
		if (Objects.isNull(u) || u.isEmpty())
			return new ArrayList<>();
		List<String> data = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (String user : u) {
			if (map.containsKey(user)) {
				map.put(user, map.get(user) + 1);
				data.add(user + (map.get(user) - 1));
			} else {
				map.put(user, 1);
				data.add(user);
			}
		}
		return data;

	}
public static void main(String[] args) {
	
}
}
