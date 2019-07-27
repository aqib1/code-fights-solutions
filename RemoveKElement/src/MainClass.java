
class ListNode<T> {
	ListNode(T x) {
		value = x;
	}

	T value;
	ListNode<T> next;

	@Override
	public String toString() {
		return value + " " + next;
	}
}

public class MainClass {
	static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
		if (l == null)
			return null;
		ListNode<Integer> last = null;
		ListNode<Integer> returnNode = null;
		do {
			if (l.value != k) {
				if (last == null) {
					last = new ListNode<>(l.value);
					returnNode = last;
				} else {
					last.next = new ListNode<>(l.value);
					last = last.next;
				}
			}

			l = l.next;

		} while (l != null);

		return returnNode;
	}

	public static void main(String[] args) {
		ListNode<Integer> ln = new ListNode<>(3);
		ln.next = new ListNode<>(1);
		ln.next.next = new ListNode<>(2);
		ln.next.next.next = new ListNode<>(3);
		ln.next.next.next.next = new ListNode<>(4);
		ln.next.next.next.next.next = new ListNode<>(5);

		System.out.println(ln);
		System.out.println(removeKFromList(ln, 3));

	}

}
