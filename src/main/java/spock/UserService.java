package spock;

@org.springframework.stereotype.Service
public class UserService {

    public User getUser(String userName) {
        return new User(userName);
    }
}
