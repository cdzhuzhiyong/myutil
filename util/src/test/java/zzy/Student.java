package zzy;

import lombok.Data;

import java.io.Serializable;

public class Student implements Serializable {

    public Student(){}

    public Student(String name, String num, double score) {
        this.name = name;
        this.num = num;
        this.score = score;
    }
    private String name;
    private String num;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
