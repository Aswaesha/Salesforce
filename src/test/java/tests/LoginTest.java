package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test(description = "Login in system")
    public void login() {
        boolean isHomePageOpened = loginPage
                .open()
                .login("aleksa.bah-mpsm@force.com", "Q1w2e3r4t5y6u7")
                .isPageOpen();

        assertTrue(isHomePageOpened, "Страница HomePage не открылась");

    }


}
