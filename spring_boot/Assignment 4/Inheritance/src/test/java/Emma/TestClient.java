package Emma;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by rodrique on 3/12/2018.
 */
public class TestClient
{
    private Client fnbClient;
    private Account fnbAccount;
    @Before
    public void setUp() throws Exception {
        fnbClient = new Client();
        fnbAccount = new Account();
    }

    @Test
    public void testSetClientName() throws Exception {
        fnbClient.setClientName("Emma");
        Assert.assertEquals("Emma","Emma");
    }

    @Test
    public void testSetClientSurname() throws Exception {
        fnbClient.setClientSurname("Dina");
        Assert.assertEquals("Dina", "Dina");
    }

    @Test
    public void testSetClientAccount() throws Exception {
        boolean set = false;
        try{
            fnbClient.setClientAccount(fnbAccount);
            set = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(set);
    }

    @Test
    public void testGetClientName() throws Exception {
        fnbClient.setClientName("Emma");
        Assert.assertEquals("Emma", fnbClient.getClientName());
    }

    @Test
    public void testGetClientSurname() throws Exception {
        fnbClient.setClientSurname("Dina");
        Assert.assertEquals("Dina",fnbClient.getClientSurname());
    }

    @Test
    public void testGetClientAccount() throws Exception {
        boolean set = false;
        try{
            fnbClient.setClientAccount(fnbAccount);
            fnbClient.getClientAccount();
            set = true;
        }catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(set);
    }
}
