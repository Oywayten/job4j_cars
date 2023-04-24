package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.util.List;

/**
 * Oywayten 01.04.2023.
 */
@Slf4j
@Repository
@AllArgsConstructor
public class PostRepository {

    private final SessionFactory sf;

    public List<Post> getAllFromToday() {
        Session session = sf.openSession();
        Transaction transaction = null;
        List<Post> postList = List.of();
        try {
            transaction = session.beginTransaction();
            postList = session.createQuery("from Post WHERE created = current_date", Post.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.info(e.getMessage());
        } finally {
            session.close();
        }
        return postList;
    }

    public List<Post> getAllWithPhoto() {
        Session session = sf.openSession();
        Transaction transaction = null;
        List<Post> postList = List.of();
        try {
            transaction = session.beginTransaction();
            postList = session.createQuery("from Post WHERE photo IS NOT NULL", Post.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.info(e.getMessage());
        } finally {
            session.close();
        }
        return postList;
    }

    public List<Post> getAllByMake(String make) {
        Session session = sf.openSession();
        Transaction transaction = null;
        List<Post> postList = List.of();
        try {
            transaction = session.beginTransaction();
            postList = session.createQuery(String.format("from Post p join p.car c WHERE c.name like %s%%", make), Post.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.info(e.getMessage());
        } finally {
            session.close();
        }
        return postList;
    }

}
