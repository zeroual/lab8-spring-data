package com.polytech.pnet.repositories;

import com.polytech.pnet.models.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JpaPostRepository implements PostRepository {

    @PersistenceContext
    private EntityManager em;


    public Post save(Post post) {
        em.persist(post);
        return post;
    }

    public List<Post> findAll() {
        Query query = em.createQuery("SELECT p FROM Post p");
        return query.getResultList();
    }

    public Post findOne(Long id) {
        return em.find(Post.class, id);

    }
}
