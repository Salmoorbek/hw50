package com.example.hw50.util;

import com.example.hw50.dao.*;
import com.example.hw50.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class InitDatabase {

    private static final Random r = new Random();

    @Bean
    CommandLineRunner init(UserDao userDao, PublicationDao publicationDao, CommentDao commentDao, LikeDao likeDao, SubscriptionDao subscriptionDao) {
        return (args) -> {
            userDao.createTable();
            publicationDao.createTable();
            commentDao.createTable();
            likeDao.createTable();
            subscriptionDao.createTable();

            publicationDao.deleteAll();
            commentDao.deleteAll();
            likeDao.deleteAll();
            subscriptionDao.deleteAll();
            userDao.deleteAll();

            userDao.alertSequenceUser();
            publicationDao.alertSequencePublication();
            commentDao.alterSequenceComment();
            likeDao.alterSequenceLike();
            subscriptionDao.alterSequenceSubs();

            userDao.saveAll(createUsers());
            publicationDao.saveAll(createPublications());
            commentDao.saveAll(createComments());
            likeDao.saveAll(createLikes());
            subscriptionDao.saveAll(createSubscription());
        };
    }
    private List<User> createUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"salmor","ss@mail.ru","salmorSS","qwerty",7,0,0));
        users.add(new User(2, "sam", "sss@mail.com", "samS", "qwerty", 0,0,6));
        users.add(new User(3, "samuel", "s@gmail.com", "samuelSS", "qwerty", 3,6,0));
        users.add(new User(4, "sasha", "sasha@gmail.com", "sashka", "qwerty", 0,4,0));
        users.add(new User(5, "serdar", "serdar@gmail.com", "sergei", "qwerty", 4,0,0));
        return users;
    }

    private List<Publication> createPublications(){
        List<Publication> publications = new ArrayList<>();
        publications.add(new Publication(1,"","qwertyuiop", LocalDateTime.now(),1));
        publications.add(new Publication(2,"","123456789",LocalDateTime.now(),1));
        publications.add(new Publication(3,"","cmithlulg",LocalDateTime.now(),2));
        publications.add(new Publication(3,"","qwert",LocalDateTime.now(),3));
        publications.add(new Publication(3,"","asdasda",LocalDateTime.now(),4));
        return publications;
    }
    private List<Comment> createComments(){
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(1,"Cool", LocalDateTime.now()));
        comments.add(new Comment(2,"Красава", LocalDateTime.now()));
        comments.add(new Comment(3,"ты чорт", LocalDateTime.now()));
        comments.add(new Comment(4,"ты!", LocalDateTime.now()));
        comments.add(new Comment(5,"чорт!!!", LocalDateTime.now()));
        return comments;
    }
    private List<Like> createLikes(){
        List<Like> likes = new ArrayList<>();
        likes.add(new Like(1,1,LocalDateTime.now(),2));
        likes.add(new Like(2,2,LocalDateTime.now(),1));
        likes.add(new Like(3,3,LocalDateTime.now(),1));
        likes.add(new Like(4,2,LocalDateTime.now(),4));
        likes.add(new Like(5,2,LocalDateTime.now(),3));
        return likes;
    }
    private List<Subscription> createSubscription(){
        List<Subscription> subscriptions = new ArrayList<>();
        subscriptions.add(new Subscription(2,1,2,LocalDateTime.now()));
        subscriptions.add(new Subscription(1,2,1,LocalDateTime.now()));
        subscriptions.add(new Subscription(3,2,2,LocalDateTime.now()));
        subscriptions.add(new Subscription(4,4,1,LocalDateTime.now()));
        return subscriptions;
    }
}
