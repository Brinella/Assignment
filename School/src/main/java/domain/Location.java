package domain;

import java.io.Serializable;
/**
 * Created by rodrique on 8/7/2017.
 */
public class Location implements Serializable
{
    private String address;
    private int areaCode;

    public String getAddress()
    { return address;}

    public int getAreaCode()
    {
        return areaCode;
    }


    private Location()
    {}

    public Location(Location.Builder builder)
    {
        this.address = builder.address;
        this.areaCode = builder.areaCode;
    }

    public static class Builder
    {
        private String address;
        private int areaCode;


        public Location.Builder address(String value)
        { this.address = value;
            return this;}

        public Location.Builder areaCode(int value)
        { this.areaCode = value;
            return this;}

        public Location build()
        {return new Location(this);}
    }

   /* @Override
    public boolean equals(Object obj) {
        if(this == o) return true;
        if(o = null || getClass() != o.getClass() )return false;
        Location location = (Location) o;
        return areaCode.equals(location.areaCode);
    }

    @Override
    public int hashCode() {
        return areaCode.hashCode();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (areaCode != location.areaCode) return false;
        return address != null ? address.equals(location.address) : location.address == null;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + areaCode;
        return result;
    }
}
