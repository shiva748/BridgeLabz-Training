public class SocialMediaConnections {

	// starting of linked list
	private User head;

	// add a new user
	public void addUser(User user) {
		user.setNext(head);
		head = user;
	}

	// search user by user id
	public User searchById(int userId) {
		User temp = head;
		while (temp != null) {
			if (temp.getUserId() == userId) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

	// search user by name
	public User searchByName(String name) {
		User temp = head;
		while (temp != null) {
			if (temp.getName().equals(name)) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

	// add friend connection between two users
	public void addFriendConnection(int userId1, int userId2) {
		User u1 = searchById(userId1);
		User u2 = searchById(userId2);

		if (u1 == null || u2 == null) {
			return;
		}

		u1.addFriend(userId2);
		u2.addFriend(userId1);
	}

	// remove friend connection
	public void removeFriendConnection(int userId1, int userId2) {
		User u1 = searchById(userId1);
		User u2 = searchById(userId2);

		if (u1 == null || u2 == null) {
			return;
		}

		u1.removeFriend(userId2);
		u2.removeFriend(userId1);
	}

	// display all friends of a user
	public void displayFriends(int userId) {
		User user = searchById(userId);
		if (user == null) {
			return;
		}

		System.out.println("Friends of " + user.getName() + ":");
		user.displayFriends();
	}

	// find mutual friends between two users
	public void findMutualFriends(int userId1, int userId2) {
		User u1 = searchById(userId1);
		User u2 = searchById(userId2);

		if (u1 == null || u2 == null) {
			return;
		}

		System.out.println("Mutual friends between " + u1.getName() + " and " + u2.getName() + ":");

		Friend f1 = u1.getFriendHead();
		while (f1 != null) {
			if (u2.hasFriend(f1.getFriendId())) {
				System.out.println("User ID: " + f1.getFriendId());
			}
			f1 = f1.getNext();
		}
	}

	// count number of friends for each user
	public void countFriendsForAllUsers() {
		User temp = head;
		while (temp != null) {
			System.out.println("User: " + temp.getName() + ", Friends Count: " + temp.countFriends());
			temp = temp.getNext();
		}
	}

	// main method (same style as earlier programs)
	public static void main(String[] args) {

		SocialMediaConnections sm = new SocialMediaConnections();

		sm.addUser(new User(1, "Aman", 21));
		sm.addUser(new User(2, "Riya", 22));
		sm.addUser(new User(3, "Kunal", 23));
		sm.addUser(new User(4, "Neha", 21));

		sm.addFriendConnection(1, 2);
		sm.addFriendConnection(1, 3);
		sm.addFriendConnection(2, 3);
		sm.addFriendConnection(3, 4);

		sm.displayFriends(1);
		System.out.println();

		sm.findMutualFriends(1, 2);
		System.out.println();

		sm.removeFriendConnection(1, 3);
		sm.displayFriends(1);
		System.out.println();

		sm.countFriendsForAllUsers();
	}
}

class User {
	private int userId;
	private String name;
	private int age;
	private Friend friendHead;
	private User next;

	public User(int userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
	}

	public void addFriend(int friendId) {
		if (hasFriend(friendId)) {
			return;
		}
		Friend friend = new Friend(friendId);
		friend.setNext(friendHead);
		friendHead = friend;
	}

	public void removeFriend(int friendId) {
		if (friendHead == null) {
			return;
		}

		if (friendHead.getFriendId() == friendId) {
			friendHead = friendHead.getNext();
			return;
		}

		Friend prev = friendHead;
		Friend curr = friendHead.getNext();

		while (curr != null) {
			if (curr.getFriendId() == friendId) {
				prev.setNext(curr.getNext());
				return;
			}
			prev = curr;
			curr = curr.getNext();
		}
	}

	public boolean hasFriend(int friendId) {
		Friend temp = friendHead;
		while (temp != null) {
			if (temp.getFriendId() == friendId) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	public void displayFriends() {
		Friend temp = friendHead;
		while (temp != null) {
			System.out.println("Friend ID: " + temp.getFriendId());
			temp = temp.getNext();
		}
	}

	public int countFriends() {
		int count = 0;
		Friend temp = friendHead;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	public int getUserId() {
		return this.userId;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public Friend getFriendHead() {
		return this.friendHead;
	}

	public void setNext(User next) {
		this.next = next;
	}

	public User getNext() {
		return this.next;
	}
}

class Friend {
	private int friendId;
	private Friend next;

	public Friend(int friendId) {
		this.friendId = friendId;
	}

	public int getFriendId() {
		return this.friendId;
	}

	public void setNext(Friend next) {
		this.next = next;
	}

	public Friend getNext() {
		return this.next;
	}
}
