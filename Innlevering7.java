package INF100_17H;
import java.util.Collections;

class Innlevering7{
public static void main(String args[]) {
// create users
User bob = new User("Bob");
User alice = new User("Alice");
User charlie = new User("Charlie");
// setup friend connections
User.connect(alice, bob);
User.connect(alice, charlie);

// sort users by their number of friends
Collections.sort(User.getUsers());
// print all registered users
System.out.println(User.getUsers());
}
}

