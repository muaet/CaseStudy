package casestudy.step_def;

import casestudy.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

public class Hooks {


    @Before
    public void setup(){
        Driver.get().get("https://www.bestbuy.com/");
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.get().manage().window().maximize();
    }


    @After
    public void teardown(){

        Driver.closeDriver();
    }
}
