package domain;

import java.io.Serializable;

/**
 * Created by rodrique on 8/7/2017.
 */
public class Lecturer implements Serializable
{
    private int empNo;
    private String lectName;
    private int yearsExper;


    public int empNo()
    {
        return empNo;
    }

    public String lectName()
    {
        return lectName;
    }

    public int getYearsExp()
    {
        return yearsExper;
    }



    private Lecturer()
    {}

    public Lecturer(Lecturer.Builder builder)
    {
        this.empNo = builder.empNo;
        this.lectName = builder.lectName;
        this.yearsExper = builder.yearsExper;
    }

    public static class Builder
    {
        private int empNo;
        private String lectName;
        private int yearsExper;


        public Lecturer.Builder empNo(int value)
        { this.empNo = value;
            return this;}

        public Lecturer.Builder lectName(String value)
        { this.lectName = value;
            return this;}

        public Lecturer.Builder yearsExper(int value)
        {this.yearsExper = value;
            return this;}


        public Lecturer build()
        {return new Lecturer(this);}
    }

   /* @Override
    public boolean equals(Object obj) {
        if(this == o) return true;
        if(o = null || getClass() != o.getClass() )return false;
        Lecturer lecturer = (Lecturer) o;
        return lectName.equals(lecturer.lectName);
    }

    @Override
    public int hashCode() {
        return lectName.hashCode();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecturer lecturer = (Lecturer) o;

        if (empNo != lecturer.empNo) return false;
        if (yearsExper != lecturer.yearsExper) return false;
        return lectName != null ? lectName.equals(lecturer.lectName) : lecturer.lectName == null;
    }

    @Override
    public int hashCode() {
        int result = empNo;
        result = 31 * result + (lectName != null ? lectName.hashCode() : 0);
        result = 31 * result + yearsExper;
        return result;
    }
}
