package kotlarchik.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "dateReceipt")
    private Date dateReceipt;

    @Column(name = "course")
    private String course;

    @Column(name = "numberGroup")
    private String numberGroup;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<AcademicPerformance> academicPerformanceSet;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateReceipt=" + dateReceipt +
                ", course='" + course + '\'' +
                ", numberGroup='" + numberGroup + '\'' +
                ", academicPerformanceSet=" + academicPerformanceSet +
                ", faculty=" + faculty +
                ", specialization=" + specialization +
                '}';
    }
}
