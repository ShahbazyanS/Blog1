package interfaces;

import exception.PostNotFoundException;
import model.Post;

public interface PostStorageInt {
    void add(Post post);

    Post getPostByTitle(String title) throws PostNotFoundException;

    void searchPostByKeyword(String keyword);

    void printAllPost();

    void printPostByCategory(String category);
}
