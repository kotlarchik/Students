package kotlarchik.service;

import kotlarchik.dao.DAO;
import kotlarchik.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceStudent implements DAO<Student, Integer> {
    private SessionFactory factory;

    public ServiceStudent(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Student student) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public Student read(Integer id) {
        try(Session session = factory.openSession()){
            Student student = session.get(Student.class, id);
            return student;
        }
    }

    @Override
    public List<Student> readAll() {
        try(Session session = factory.openSession()){
            Query<Student> query = session.createQuery("from Student");
            return query.list();
        }
    }

    @Override
    public void update(Student student) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Student student) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
    }
}
