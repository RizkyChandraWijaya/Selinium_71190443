import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisterTest {
    String email;
    String password;
    ChromeDriver driver;
    @Given("browser terbuka")
    public void browser_terbuka() {
        System.out.println("Inside Step - Browser dibuka");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader().getResource("chromeDriver/chromedriver.exe").getFile()));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
//        throw new io.cucumber.java.PendingException();
    }
    @Given("user berada di page register")
    public void user_berada_di_page_register() {
        System.out.println("Inside Step - user ada di halaman login");
        driver.navigate().to("https://demo.guru99.com/insurance/v1/register.php");

        List list = new ArrayList<>();
        List <WebElement> element = driver.findElements(By.tagName("input"));
        for(WebElement e : element) {
            if (e.getAttribute("value").equals("Reset") || e.getAttribute("value").equals("Create")) {
                list.add(e.getText());
            }
        }
        Assertions.assertTrue(list.size() > 1,"Button create atau reset tidak ada");
    }

    @When("^user memasukan (.*) dan (.*)$")
    public void user_memasukan_email_dan_password(String inp_email, String inp_password) {
        System.out.println("Inside Step - Memasukan email dan password");
        email = inp_email;
        password = inp_password;
        driver.findElement(By.name("email")).sendKeys(inp_email);
        driver.findElement(By.name("password")).sendKeys(inp_password);
        driver.findElement(By.name("c_password")).sendKeys(inp_password);

    }

    @When("button create diklik")
    public void button_create_diklik() {
        System.out.println("Inside Step - klik tombol create");
        driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/input[2]")).click();

    }
    @Then("user diarahkan ke login page")
    public void user_diarahkan_ke_login_page() {
        List<WebElement> btnLogin = driver.findElements(By.xpath("/html/body/div[3]/form/div[3]/input"));
        System.out.println("Step 5 - User diarahkan ke halaman login");
        Assertions.assertTrue(password.matches("^[a-zA-Z0-9]*$") && password.length() >= 8 && password.length() <= 13 && !email.equalsIgnoreCase(""),"Input Tidak Valid");
        driver.close();
        driver.quit();
    }
}
