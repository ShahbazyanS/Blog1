package interfaces;

public interface Commands {
    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;
    int POST_BY_CATEGORY = 3;
    int POST_BY_KEYWORD = 4;
    int ALL_POSTS = 5;


    int LOGOUT = 0;
    int ADD_POST =1;


    static void command(){
        System.out.println("please input " + EXIT + " for exit");
        System.out.println("please input " + LOGIN + " for login");
        System.out.println("please input " + REGISTER + " for register");
        System.out.println("please input " + POST_BY_CATEGORY + " for print post by category");
        System.out.println("please input " + POST_BY_KEYWORD + " for print post by keyword");
        System.out.println("please input " + ALL_POSTS + " for print all posts");
    }

    static void commandUser(){
        System.out.println("please input " + LOGOUT + " for logaut");
        System.out.println("please input " + ADD_POST + " for add post");
    }


}
