package INF100_17H;
import java.util.*;
import java.util.Collections;

public class User implements Comparable<User>{
private String name;
private ArrayList<User> friends;
private static ArrayList<User> users = new ArrayList<User>();


public User(String name) {
this.name = name;
this.friends = new ArrayList<User>();
users.add(this);
}

  public String toString() {
    String toString = this.name + ": {";
    for(User user : friends){
    toString = toString + user.name + " ";}
    toString = toString + "}";
    return toString;
  } 
  
public void addFriend(User friend) {
 friends.add(friend);
}

public static void connect(User user1, User user2) {
user1.addFriend(user2);
user2.addFriend(user1);
}

public static ArrayList<User> getUsers() {
  return users;
}

public int compareTo(User otherUser) {
 int n = 0;
 n= this.friends.size()-otherUser.friends.size();
  return n; 
}

}