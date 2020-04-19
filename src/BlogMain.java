import interfaces.Commands;
import model.Post;
import model.User;
import storage.PostStorage;
import storage.UserStorage;

import java.util.Date;
import java.util.Scanner;

public class BlogMain implements Commands {

    public static Scanner scanner = new Scanner(System.in);
    public static PostStorage postStorage = new PostStorage();
    public static UserStorage userStorage = new UserStorage();
    public static User currentUser = null;

    public static void main(String[] args) {
        boolean isRun = true;
        int command;
        while (isRun) {
            Commands.command();
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    loginUser();
                    break;
                case REGISTER:
                    registerUser();
                    break;
                case POST_BY_KEYWORD:
                    postBykeyword();
                    break;
                case POST_BY_CATEGORY:
                    postByCategory();
                    break;
                case ALL_POSTS:
                    postStorage.printAllPost();
                    break;
                default:
                    System.out.println("Wrong command please try again");
            }
        }
    }


    private static void postByCategory() {
        if (postStorage.isEmpty()) {
            System.out.println("posts list is empty");
        } else {
            System.out.println("please input category for search post");
            postStorage.printPostByCategory(scanner.nextLine());
        }
    }


    private static void postBykeyword() {
        if (postStorage.isEmpty()) {
            System.out.println("posts list is empty");
        } else {
            System.out.println("please input ceyword for search post");
            postStorage.searchPostByKeyword(scanner.nextLine());
        }
    }


    private static void loginUser() {
        System.out.println("please input email and password for login");
        try {
            String str = scanner.nextLine();
            String[] strings = str.split(",");
            currentUser = userStorage.getUserByEmailAndPassword(strings[0], strings[1]);
            login();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        }
    }

    private static void registerUser() {
        System.out.println("please input name, surname, email, password");
        try {

            String userStr = scanner.nextLine();
            String[] users = userStr.split(",");
            User user = new User();
            user.setName(users[0]);
            user.setSurname(users[1]);
            user.setEmail(users[2]);
            user.setPassword(users[3]);
            userStorage.add(user);
            System.out.println("registration completed successfully");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("please input valid data");
            registerUser();
        }
    }

    private static void login() {
        boolean isRun = true;
        while (isRun) {
            Commands.commandUser();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_POST:
                    addPost();
                    break;
                case DELETE_POST:
                    deletePost();
                    break;
                default:
                    System.out.println("wrong comand please try again");

            }
        }
    }

    private static void addPost() {
        System.out.println("please input title, text, category");
        String str = scanner.nextLine();
        String[] posts = str.split(",");
        Post post = new Post();
        Date date = new Date();
        post.setTitle(posts[0]);
        post.setText(posts[1]);
        post.setCategory(posts[2]);
        post.setDate(date);
        post.setUser(currentUser);
        postStorage.add(post);
        System.out.println("thank you post was added");
    }

    private static void deletePost() {
        System.out.println("please input post title for delete post");
        postStorage.deletePost(scanner.nextLine());
    }
}
