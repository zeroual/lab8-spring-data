package com.polytech.pnet.repositories;

import com.polytech.pnet.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcPostRepository implements PostRepository {

    private static final String SELECT_POSTS_QUERY = "SELECT ID,CONTENT FROM POST";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPostRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Post save(Post post) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("content", post.getContent());
        namedParameterJdbcTemplate.update("INSERT INTO POST (content) VALUES  (:content)", params);
        return post;
    }

    public List<Post> findAll() {

        return jdbcTemplate.query(SELECT_POSTS_QUERY, new RowMapper<Post>() {
            public Post mapRow(ResultSet resultSet, int i) throws SQLException {
                Post post = new Post(resultSet.getString("CONTENT"));
                return post;
            }
        });
    }

    public Post findOne(Long id) {

        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);

        return namedParameterJdbcTemplate.queryForObject("SELECT id,content FROM POST WHERE id=?", params,
                new RowMapper<Post>() {
                    public Post mapRow(ResultSet resultSet, int i) throws SQLException {
                        Post post = new Post(resultSet.getString("CONTENT"));
                        return post;
                    }
                });

    }
}
