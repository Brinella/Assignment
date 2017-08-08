package factories;

import domain.WinterSchool;
import java.util.Map;
/**
 * Created by rodrique on 8/7/2017.
 */
public class WinterSchoolFactory
{
    public static WinterSchool getWinterSchool(Map<String,String> values, int numOfStud)
    {WinterSchool winterSchool = new WinterSchool().Builder()
            .subject(values.get("Subject Name:"))
            .numOfStud(numOfStud)
            .numOfLect(numOfStud)
            .location(values.get("Location: "))
            .build();
        return winterSchool;
    }
}
