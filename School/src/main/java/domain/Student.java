package domain;

import java.io.Serializable;

/**
 * Created by rodrique on 8/7/2017.
 */
public class Student implements Serializable
{

    private int studNo;
    private String studName;



    public int getStudNo()
    {
        return studNo;
    }

    public String getstudName()
    {
        return studName;
    }

    private Student()
    {}

    public Student(Student.Builder builder)
    {

        this.studNo = builder.studNo;
        this.studName = builder.studName;

    }

    public static class Builder
    {

        private int studNo;
        private String studName;


        public Student.Builder studNo(int value)
        { this.studNo = value;
            return this;}

        public Student.Builder studName(String value)
        {this.studName = value;
            return this;}



        public Student build()
        {return new Student(this);}
    }

    /*@Override
    public boolean equals(Object obj) {
        if(this == o) return true;
        if(o = null || getClass() != o.getClass() )return false;
        Student student = (Student) o;
        return studName.equals(student.studName);
    }

    @Override
    public int hashCode() {
        return student.hashCode();
    }*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studNo != student.studNo) return false;
        return studName != null ? studName.equals(student.studName) : student.studName == null;
    }

    @Override
    public int hashCode() {
        int result = studNo;
        result = 31 * result + (studName != null ? studName.hashCode() : 0);
        return result;
    }
}
