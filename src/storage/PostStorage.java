package storage;

import exception.PostNotFoundException;
import interfaces.PostStorageInt;
import model.Post;

public class PostStorage implements PostStorageInt {

    private Post[] posts;
    private int size;

    public PostStorage(int capacity) {
        posts = new Post[15];
    }

    public PostStorage() {
        posts = new Post[10];
    }

    public void add(Post post) {
        if (size == posts.length - 1) {
            extend();
        }
        posts[size++] = post;
    }

    private void extend() {
        Post[] tmp = new Post[posts.length + 10];
        System.arraycopy(posts, 0, tmp, 0, posts.length);
    }

    public Post getPostByTitle(String title) throws PostNotFoundException {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equals(title)) {
                return posts[i];
            }
        }
        throw new PostNotFoundException("the post with " + title + " title does not exist");
    }

    public void searchPostByKeyword(String keyword) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().contains(keyword) || posts[i].getText().contains(keyword)) {
                System.out.println(posts[i]);
            }
        }
    }

    public void printAllPost() {
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);
        }
    }

    public void printPostByCategory(String category) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getCategory().equals(category)) {
                System.out.println(posts[i]);
            }
        }
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void deletePost(String title) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equals(title)) {
                System.arraycopy(posts, i + 1, posts, i + 1 - 1, size - (i + 1));
                size--;
            } else {
                System.out.println(String.format("post with %s does not exist", title));
            }
        }

    }
}
