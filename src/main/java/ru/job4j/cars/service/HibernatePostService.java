package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.PostRepository;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 13.05.2023.
 */
@Service
@AllArgsConstructor
public class HibernatePostService implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public Optional<Post> add(Post post) {
        return postRepository.add(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findAllForLastDay() {
        return postRepository.findAllForLastDay();
    }

    @Override
    public List<Post> findAllWithPhoto() {
        return postRepository.findAllWithPhoto();
    }

    @Override
    public List<Post> findAllByBrand(String brand) {
        return postRepository.findAllByBrand(brand);
    }

    @Override
    public boolean setPostStatusSold(Long postId, int userId) {
        boolean result = false;
        Optional<User> optionalUser = userService.findById(userId);
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (isUserEqualsPostUser(optionalUser, optionalPost)) {
            result = postRepository.setPostStatusSold(postId, userId);
        }
        return result;
    }

    private static boolean isUserEqualsPostUser(Optional<User> optionalUser, Optional<Post> optionalPost) {
        boolean result = false;
        if (optionalPost.isPresent() && optionalUser.isPresent()) {
            Post post = optionalPost.get();
            User user = optionalUser.get();
            User postUser = post.getUser();
            result = user.equals(postUser);
        }
        return result;
    }
}
