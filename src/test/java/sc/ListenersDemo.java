package sc;
import listeners.TestNG_Listeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNG_Listeners.class)
public class ListenersDemo {


    @Test
    public void t1() {

        System.out.println("inside test 1");
        Assert.fail();
    }

    @Test
    public void t2() {

        System.out.println("inside test 2");
    }

    @Test
    public void t3() {

        System.out.println("inside test 3");
        Assert.fail();
    }

    @Test
    public void t4() {

        System.out.println("inside test 4");
    }


}
