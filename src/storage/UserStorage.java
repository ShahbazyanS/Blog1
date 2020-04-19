package storage;

import model.User;

public class UserStorage {
    private User[] users = new User[16];
    private int size = 0;

    public void add(User user) {
        if (size == users.length - 1) {
            extendUsers();
        } else {
            users[size++] = user;
        }
    }

    private void extendUsers() {
        User tmp[] = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }

    public User getUserByEmailAndPassword(String email, String password) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < size; i++) {
            User user = users[i];
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new ArrayIndexOutOfBoundsException("please try again");
    }

}
