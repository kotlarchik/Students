package kotlarchik.service;

import kotlarchik.dao.DAO;
import kotlarchik.model.Specialization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceSpecialization implements DAO<Specialization, Integer> {
    private SessionFactory factory;

    public ServiceSpecialization(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Specialization specialization) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(specialization);
            session.getTransaction().commit();
        }
    }

    @Override
    public Specialization read(Integer id) {
        try(Session session = factory.openSession()){
            Specialization specialization = session.get(Specialization.class, id);
            return specialization;
        }
    }

    @Override
    public List<Specialization> readAll() {
        try(Session session = factory.openSession()){
            Query<Specialization> query = session.createQuery("from Specialization");
            return query.list();
        }
    }

    @Override
    public void update(Specialization specialization) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(specialization);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Specialization specialization) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(specialization);
            session.getTransaction().commit();
        }
    }
}
