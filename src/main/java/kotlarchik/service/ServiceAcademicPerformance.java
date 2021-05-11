package kotlarchik.service;

import kotlarchik.dao.DAO;
import kotlarchik.model.AcademicPerformance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceAcademicPerformance implements DAO<AcademicPerformance, Integer> {
    private SessionFactory factory;

    public ServiceAcademicPerformance(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(AcademicPerformance academicPerformance) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(academicPerformance);
            session.getTransaction().commit();
        }
    }

    @Override
    public AcademicPerformance read(Integer id) {
        try(Session session = factory.openSession()){
            AcademicPerformance academicPerformance = session.get(AcademicPerformance.class, id);
            return academicPerformance;
        }
    }

    @Override
    public List<AcademicPerformance> readAll() {
        try(Session session = factory.openSession()){
            Query<AcademicPerformance> query = session.createQuery("from AcademicPerformance");
            return query.list();
        }
    }

    @Override
    public void update(AcademicPerformance academicPerformance) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(academicPerformance);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(AcademicPerformance academicPerformance) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(academicPerformance);
            session.getTransaction().commit();
        }
    }
}
