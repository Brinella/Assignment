package domain;
import java.io.Serializable;
/**
 * Created by rodrique on 8/7/2017.
 */

public class WinterSchool implements Serializable
{
    private String subject;
    private int numOfStud;
    private int numOfLect;
    private String location;

    public String getSubject()
    { return subject;}

    public int getNumOfStud()
    {
        return numOfStud;
    }

    public int getNumOfLect()
    {
        return numOfLect;
    }

    public String getlocation()
    { return location;}

    public WinterSchool()
    {}

    public WinterSchool(Builder builder)
    {
        this.subject = builder.subject;
        this.numOfStud = builder.numOfStud;
        this.numOfLect = builder.numOfLect;
        this.location = builder.location;
    }

    public static class Builder
    {
        private String subject;
        private int numOfStud;
        private int numOfLect;
        private String location;

        public Builder subject(String value)
        { this.subject = value;
            return this;}

        public Builder numOfStud(int value)
        { this.numOfStud = value;
            return this;}

        public Builder numOfLect(int value)
        {this.numOfLect = value;
            return this;}

        public Builder location(String value)
        {this.location = value;
            return this;}

        public WinterSchool build()
        {return new WinterSchool(this);}
    }

   /* @Override
    public boolean equals(Object obj) {
        if(this == o) return true;
        if(o = null || getClass() != o.getClass() )return false;
        WinterSchool winterSchool = (WinterSchool) o;
        return location.equals(winterSchool.location);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }*/

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}


