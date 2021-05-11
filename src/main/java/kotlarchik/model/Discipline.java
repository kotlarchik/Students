package kotlarchik.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "discipline", fetch = FetchType.EAGER)
    private Set<AcademicPerformance> academicPerformanceSet;

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", academicPerformanceSet=" + academicPerformanceSet +
                '}';
    }
}
