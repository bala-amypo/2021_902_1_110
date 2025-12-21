public interface UserService {
    User registerUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
}
