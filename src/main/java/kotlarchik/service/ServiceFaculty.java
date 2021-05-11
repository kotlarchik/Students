package kotlarchik.service;

import kotlarchik.dao.DAO;
import kotlarchik.model.AcademicPerformance;
import kotlarchik.model.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceFaculty implements DAO<Faculty, Integer> {
    private SessionFactory factory;

    public ServiceFaculty(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Faculty faculty) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(faculty);
            session.getTransaction().commit();
        }
    }

    @Override
    public Faculty read(Integer id) {
        try(Session session = factory.openSession()){
            Faculty faculty = session.get(Faculty.class, id);
            return faculty;
        }
    }

    @Override
    public List<Faculty> readAll() {
        try(Session session = factory.openSession()){
            Query<Faculty> query = session.createQuery("from Faculty");
            return query.list();
        }
    }

    @Override
    public void update(Faculty faculty) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(faculty);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Faculty faculty) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(faculty);
            session.getTransaction().commit();
        }
    }
}
