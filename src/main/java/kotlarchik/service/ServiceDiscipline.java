package kotlarchik.service;

import kotlarchik.dao.DAO;
import kotlarchik.model.AcademicPerformance;
import kotlarchik.model.Discipline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceDiscipline implements DAO<Discipline, Integer> {
    private SessionFactory factory;

    public ServiceDiscipline(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Discipline discipline) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(discipline);
            session.getTransaction().commit();
        }
    }

    @Override
    public Discipline read(Integer id) {
        try(Session session = factory.openSession()){
            Discipline discipline = session.get(Discipline.class, id);
            return discipline;
        }
    }

    @Override
    public List<Discipline> readAll() {
        try(Session session = factory.openSession()){
            Query<Discipline> query = session.createQuery("from Discipline ");
            return query.list();
        }
    }

    @Override
    public void update(Discipline discipline) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(discipline);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Discipline discipline) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(discipline);
            session.getTransaction().commit();
        }
    }
}
