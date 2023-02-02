package ru.job4j.cars.model.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.job4j.cars.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserRepository {
    private final SessionFactory sf;

    /**
     * Сохранить в базе.
     *
     * @param user пользователь.
     * @return пользователь с id.
     */
    public User create(User user) {
        final Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return user;
    }

    /**
     * Обновить в базе пользователя.
     *
     * @param user пользователь.
     */
    public void update(User user) {
        final Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    /**
     * Удалить пользователя по id.
     *
     * @param userId ID
     */
    public void delete(int userId) {
        final Session session = sf.openSession();
        try {
            session.beginTransaction();
            User user = new User();
            user.setId(userId);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    /**
     * Список пользователь отсортированных по id.
     *
     * @return список пользователей.
     */
    public List<User> findAllOrderById() {
        final Session session = sf.openSession();
        List<User> list = List.of();
        try {
            session.beginTransaction();
            list = session.createQuery("from User as u order by u.id", User.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return list;
    }

    /**
     * Найти пользователя по ID
     *
     * @return пользователь.
     */
    public Optional<User> findById(int id) {
        final Session session = sf.openSession();
        Optional<User> optional = Optional.empty();
        try {
            session.beginTransaction();
            optional = Optional.of(session.get(User.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return optional;
    }

    /**
     * Список пользователей по login LIKE %key%
     *
     * @param key key
     * @return список пользователей.
     */
    public List<User> findByLikeLogin(String key) {
        final Session session = sf.openSession();
        List<User> list = List.of();
        try {
            session.beginTransaction();
            final Query<User> query = session.createQuery("from User as u where u.login like :fkey", User.class)
                    .setParameter("fkey", key);
            list = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return list;
    }


    /**
     * Найти пользователя по login.
     *
     * @param login login.
     * @return Optional or user.
     */
    public Optional<User> findByLogin(String login) {
        final Session session = sf.openSession();
        Optional<User> optional = Optional.empty();
        try {
            session.beginTransaction();
            optional = Optional.of(session.get(User.class, login));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return optional;
    }
}