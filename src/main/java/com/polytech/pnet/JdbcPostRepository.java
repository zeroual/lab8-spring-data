package com.polytech.pnet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPostRepository implements PostRepository {

    private final Connection connection;

    public JdbcPostRepository(Connection connection) {
        this.connection = connection;
    }

    public Post save(Post post) {

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO POST (content) VALUES  (?)");
            statement.setString(1, post.getContent());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Ooops npet can't create connection statement", e);
        }
        return post;
    }

    public List<Post> findAll() {
        List<Post> postList = new ArrayList<Post>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID,CONTENT FROM POST");
            while (resultSet.next()) {
                Post post = new Post(resultSet.getString("CONTENT"));
                postList.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ooops npet can't create connection statement", e);
        }
        return postList;
    }
}
