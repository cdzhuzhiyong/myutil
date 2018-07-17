package zzy;

import lombok.Data;

@Data
public class Student {

    public Student(){}

    public Student(String name, String num, double score) {
        this.name = name;
        this.num = num;
        this.score = score;
    }

    private String name;
    private String num;
    private double score;
}
