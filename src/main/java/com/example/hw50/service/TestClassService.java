package com.example.hw50.service;

import com.example.hw50.entity.*;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestClassService {
    private Connection conn;

    public TestClassService(){
        try {
            init();
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=qwerty";
        return DriverManager.getConnection(url);
    }
    private void init() throws SQLException {
        conn = getConnection();
    }
    private int executeUpdate(String query) throws SQLException{
        Statement statement = conn.createStatement();
        int result = statement.executeUpdate(query);
        return result;
    }

    public String createTables(){
        try {
            createUsersTable();
            createPublicationsTable();
            createCommentsTable();
            createLikesTable();
            createSubscriptionsTable();
            conn.createStatement().execute("select * from users");
            conn.createStatement().execute("select * from publications");
            conn.createStatement().execute("select * from comments");
            conn.createStatement().execute("select * from likes");
            conn.createStatement().execute("select * from subscriptions");
            return "All its OK";
        } catch (SQLException exception){
            return exception.getMessage();
        }
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
    private void createUsersTable() throws SQLException {
        String usersTableQuery = "CREATE TABLE users " +
                "(userId SERIAL PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "accName TEXT NOT NULL," +
                "password TEXT NOT NULL, " +
                "subscribers INTEGER, " +
                "publications INTEGER, " +
                "subscriptions INTEGER)";
        executeUpdate(usersTableQuery);
        List<User> users = createUsers();
        for (User user : users){
            String query = "INSERT INTO users (name, email, accName, password, subscribers, publications, subscriptions ) " +
                    "VALUES (" +
                    "'" + user.getName() + "', " +
                    "'" + user.getEmail() + "', " +
                    "'" + user.getAccName() + "', " +
                    "'" + user.getPassword() + "', " +
                    user.getCountFollower() + ", " +
                    user.getCountPublication() + ", " +
                    user.getCountSubscription() +  ")";
            executeUpdate(query);
        }
    }
    private void createCommentsTable() throws SQLException {
        String commentsTableQuery = "CREATE TABLE comments (" +
                "commentId SERIAL PRIMARY KEY, " +
                "commentText TEXT, " +
                "commentDate TEXT)";
        executeUpdate(commentsTableQuery);

        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(1,"Cool", LocalDateTime.now()));
        comments.add(new Comment(2,"Красава", LocalDateTime.now()));
        comments.add(new Comment(3,"ты чорт", LocalDateTime.now()));
        comments.add(new Comment(4,"ты!", LocalDateTime.now()));
        comments.add(new Comment(5,"чорт!!!", LocalDateTime.now()));

        for (Comment comment : comments){
            String query = "INSERT INTO comments (commentText, commentDate) " +
                    "VALUES (" + "'" + comment.getCommentText() + "', " +
                    "'" + comment.getTimeOfComment() + "')";
            executeUpdate(query);
        }
    }
    private void createPublicationsTable() throws SQLException{
        String publicationsTableQuery = "CREATE TABLE publications (" +
                "publicationId SERIAL PRIMARY KEY, " +
                "userId INTEGER, " +
                "image TEXT, " +
                "description TEXT, " +
                "publicationDate TEXT, " +
                "FOREIGN KEY (userId) REFERENCES users(userId))";
        executeUpdate(publicationsTableQuery);

        List<Publication> publications = new ArrayList<>();
        publications.add(new Publication(1,"","qwertyuiop", LocalDateTime.now(),1));
        publications.add(new Publication(2,"","123456789",LocalDateTime.now(),1));
        publications.add(new Publication(3,"","cmithlulg",LocalDateTime.now(),2));
        publications.add(new Publication(3,"","qwert",LocalDateTime.now(),3));
        publications.add(new Publication(3,"","asdasda",LocalDateTime.now(),4));

        for (Publication publication : publications){
            String query = "INSERT INTO publications (userId, image, description, publicationDate)" +
                    "VALUES ( " +
                    publication.getUserID() + ", " +
                    "'" + publication.getImg() + "', " +
                    "'" + publication.getDescription() + "', " +
                    "'" + publication.getTimeOfPublication() + "')";
            executeUpdate(query);
        }
    }
    private void createLikesTable() throws SQLException {
        String likesTableQuery = "CREATE TABLE likes (" +
                "likeId SERIAL PRIMARY KEY, " +
                "userId INTEGER NOT NULL, " +
                "publicationId INTEGER NOT NULL, " +
                "likeDate TEXT, " +
                "FOREIGN KEY (userId) REFERENCES users(userId))";
        executeUpdate(likesTableQuery);

        List<Like> likes = new ArrayList<>();
        likes.add(new Like(1,1,LocalDateTime.now(),2));
        likes.add(new Like(2,2,LocalDateTime.now(),1));
        likes.add(new Like(3,3,LocalDateTime.now(),1));
        likes.add(new Like(4,2,LocalDateTime.now(),4));
        likes.add(new Like(5,2,LocalDateTime.now(),3));

        for (Like like : likes){
            String query = "INSERT INTO likes (userId, publicationId, likeDate)" +
                    "VALUES (" +
                    like.getUserId() + ", " +
                    "'" + like.getLikedPublicationId() + "', " +
                    "'" + like.getLickedTime() + "')";
            executeUpdate(query);
        }
    }
    private void createSubscriptionsTable() throws SQLException {
        String subscribersTableQuery = "CREATE TABLE subscriptions (" +
                "subscribes INTEGER, " +
                "subscribedTo INTEGER, " +
                "subscriptionDate TEXT," +
                "FOREIGN KEY (subscribes) REFERENCES users(userId), " +
                "FOREIGN KEY (subscribedTo) REFERENCES users(userId))";
        executeUpdate(subscribersTableQuery);

        List<SubscriptionsPerUser> subscriptions = new ArrayList<>();
        subscriptions.add(new SubscriptionsPerUser(2,1,2,LocalDateTime.now()));
        subscriptions.add(new SubscriptionsPerUser(1,2,1,LocalDateTime.now()));
        subscriptions.add(new SubscriptionsPerUser(3,2,2,LocalDateTime.now()));
        subscriptions.add(new SubscriptionsPerUser(4,4,1,LocalDateTime.now()));

        for (SubscriptionsPerUser subscription : subscriptions){
            String query = "INSERT INTO subscriptions (subscribes, subscribedTo, subscriptionDate) " +
                    "VALUES ( " +
                    subscription.getSubscribes() + ", " +
                    subscription.getSubscribedTo() + ", " +
                    "'" + subscription.getSubscribeTime() + "')";
            executeUpdate(query);
        }
    }
}
