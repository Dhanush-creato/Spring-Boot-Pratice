package org.springexmaples.StudentMangament.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dept_id;
    private String deptName;

    @OneToMany(mappedBy = "department")
    private List<Students> students = new ArrayList<>();
}
