package domain;

import java.io.Serializable;


public class Subject implements Serializable
{
    private String subjectName;
    private int studNo;
    private String studName;
    private String lectName;


    public String getSubjectName()
    { return subjectName;}

    public int getStudNo()
    {
        return studNo;
    }

    public String getstudName()
    {
        return studName;
    }

    public String getLectName()
    {
        return lectName;
    }



    private Subject()
    {}

    public Subject(Builder builder)
    {
        this.subjectName = builder.subjectName;
        this.studNo = builder.studNo;
        this.studName = builder.studName;
        this.lectName = builder.lectName;
    }

    public static class Builder
    {
        private String subjectName;
        private int studNo;
        private String studName;
        private String lectName;


        public Builder subjectName(String value)
        { this.subjectName = value;
            return this;}

        public Builder studNo(int value)
        { this.studNo = value;
            return this;}

        public Builder studName(String value)
        {this.studName = value;
            return this;}

        public Builder lectName(String value)
        {this.lectName = value;
            return this;}

        public Subject build()
        {return new Subject(this);}
    }

    /*@Override
    public boolean equals(Object obj) {
        if(this == o) return true;
        if(o = null || getClass() != o.getClass() )return false;
        Subject subject = (Subject) o;
        return subjectName.equals(subject.subjectName);
    }

    @Override
    public int hashCode() {
        return subjectName.hashCode();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (studNo != subject.studNo) return false;
        if (subjectName != null ? !subjectName.equals(subject.subjectName) : subject.subjectName != null) return false;
        if (studName != null ? !studName.equals(subject.studName) : subject.studName != null) return false;
        return lectName != null ? lectName.equals(subject.lectName) : subject.lectName == null;
    }

    @Override
    public int hashCode() {
        int result = subjectName != null ? subjectName.hashCode() : 0;
        result = 31 * result + studNo;
        result = 31 * result + (studName != null ? studName.hashCode() : 0);
        result = 31 * result + (lectName != null ? lectName.hashCode() : 0);
        return result;
    }
}
