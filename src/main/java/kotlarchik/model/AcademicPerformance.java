package kotlarchik.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.ls.LSProgressEvent;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class AcademicPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numberSim")
    private int numberSim;

    @Column(name = "score")
    private int score;

    @Column(name = "dateExam")
    private Date dateExam;

    @Column(name = "teachers")
    private String teachers;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @Override
    public String toString() {
        return "AcademicPerformance{" +
                "id=" + id +
                ", numberSim=" + numberSim +
                ", score=" + score +
                ", dateExam=" + dateExam +
                ", teachers='" + teachers + '\'' +
                ", student=" + student +
                ", discipline=" + discipline +
                '}';
    }
}
