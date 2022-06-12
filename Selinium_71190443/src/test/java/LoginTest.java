import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class LoginTest {
    ChromeDriver driver;
    @Given("browser opened")
    public void browser_opened() {
        System.out.println("Inside Step - Browser dibuka");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader().getResource("chromeDriver/chromedriver.exe").getFile()));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
//        throw new io.cucumber.java.PendingException();
    }
    @Given("user in login page")
    public void user_in_login_page() {
        System.out.println("Inside Step - user ada di halaman login");
        driver.navigate().to("https://demo.guru99.com/insurance/v1/index.php");
//        throw new io.cucumber.java.PendingException();
    }

    @When("^user insert (.*) and (.*)$")
    public void user_insert_email_and_password(String email, String password) {
        System.out.println("Inside Step - Memasukan email dan password");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
//        throw new io.cucumber.java.PendingException();
    }
    @When("login button clicked")
    public void login_button_clicked() {
        System.out.println("Inside Step - klik tombol login");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/input")).click();
//        throw new io.cucumber.java.PendingException();
    }
    @Then("user redirect to main screen")
    public void user_redirect_to_main_screen() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - Redirect to main screen");
        List<WebElement> btnLogout = driver.findElements(By.xpath("/html/body/div[3]/form/input"));
        Assertions.assertTrue(btnLogout.size() > 0,"Login Berhasil");
    }

}
