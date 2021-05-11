package kotlarchik.service;

import kotlarchik.dao.DAO;
import kotlarchik.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceUsers implements DAO<Users, Integer> {
    private SessionFactory factory;

    public ServiceUsers(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Users users) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(users);
            session.getTransaction().commit();
        }
    }

    @Override
    public Users read(Integer id) {
        try(Session session = factory.openSession()){
            Users users = session.get(Users.class, id);
            return users;
        }
    }

    @Override
    public List<Users> readAll() {
        try(Session session = factory.openSession()){
            Query<Users> query = session.createQuery("from Users");
            return query.list();
        }
    }

    @Override
    public void update(Users users) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(users);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Users users) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(users);
            session.getTransaction().commit();
        }
    }
}
