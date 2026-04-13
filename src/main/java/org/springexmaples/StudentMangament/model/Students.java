package org.springexmaples.StudentMangament.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rollNo;
    @NotBlank(message = "Name should be contain")
    private String name;
    @NotNull(message = "Marks should not be Null")
    private Integer marks;

    @ManyToOne()
    @JoinColumn(name="dept_id")
    private Department department;
//
//    public Students() {
//    }
//
//    public Long getRoll_no() {
//        return this.roll_no;
//    }
//
//    public Students setRoll_no(Long roll_no) {
//        this.roll_no = roll_no;
//        return this;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Students setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public Integer getMarks() {
//        return marks;
//    }
//
//    public Students setMarks(Integer marks) {
//        this.marks = this.marks;
//        return this;
//    }
//
//
//
//
//
//    public Students(Long roll_no,Integer marks, String name) {
//        this.roll_no = roll_no;
//
//        this.marks = marks;
//        this.name = name;
//    }
}
