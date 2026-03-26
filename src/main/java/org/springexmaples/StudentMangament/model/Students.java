package org.springexmaples.StudentMangament.model;

public class Students {
    private Long roll_no;
    private String name;
    private Integer marks;
    private String dept;

    public Students() {
    }

    public Long getRoll_no() {
        return roll_no;
    }

    public Students setRoll_no(Long roll_no) {
        this.roll_no = roll_no;
        return this;
    }

    public String getName() {
        return name;
    }

    public Students setName(String name) {
        this.name = this.name;
        return this;
    }

    public Integer getMarks() {
        return marks;
    }

    public Students setMarks(Integer marks) {
        this.marks = this.marks;
        return this;
    }

    public String getDept() {
        return dept;
    }

    public Students setDept(String dept) {
        this.dept = dept;
        return this;
    }

    public Students(Long roll_no, String dept, Integer marks, String name) {
        this.roll_no = roll_no;
        this.dept = dept;
        this.marks = marks;
        this.name = name;
    }
}
