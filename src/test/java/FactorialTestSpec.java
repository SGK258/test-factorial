import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class FactorialTestSpec {
    public String baseUrl = "http://qainterview.pythonanywhere.com/";
    public WebDriver driver;
    public FactorialPage factorialPage;

    @BeforeTest
    public void setBaseUrl(){
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @AfterTest
    public void cleanup(){
        driver.close();
    }

    /*
    * Feature : Verify Page title
    * Given :  You are on Factorial Home Page
    * When: you do nothing
    * Then: Verify the Title equals "Factorial"
    *
    * */
    @Test(priority = 1)
    public void verifyHomePageTitle(){
        String expectedTitle = "Factorial";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test(priority = 1)
    public void verifyFactorialPageContent(){
        FactorialPage factorialPage = new FactorialPage();
        factorialPage.verifyFactorialPageElements(driver);
    }

    /*
    * NOTE: This test has been written as per the implementation
    * TODO: Error to be updated to 'Please enter an integer' when bug is fixed
    * */
    @Test(priority = 2)
    public void verifyBoundaryConditions(){

        int[] boundaryArray = {-1, 0, 1, 169,170,171};
        FactorialPage factorialPage = new FactorialPage();

        for (int i : boundaryArray) {

            factorialPage.enterValue(driver,i);
            factorialPage.clickSubmitButton(driver);

            if(i < 0 ){
                Assert.assertTrue(factorialPage.verifyMessageForEmpty(driver));
            }
            else{

                if ( i > 170) {
                    Assert.assertTrue(factorialPage.verifyMessageForInfinite(driver));
                }
                else{
                    Assert.assertTrue(factorialPage.verifySuccessResultIsDisplayed(driver));
                }
            }
        }

     }

    @Test(priority = 3)
    public void verifyFactorialSuccessful(){
        int num;
        Random r = new Random();
        int min = 0, max= 170;
        FactorialPage factorialPage = new FactorialPage();

        for(int i =0; i<10; i++) {
            num = r.nextInt((max - min) + 1) + min;;
            factorialPage.enterValue(driver, num);
            factorialPage.clickSubmitButton(driver);
            factorialPage.verifySuccessResultIsDisplayed(driver);

        }
    }

    /*
    * NOTE: Below is written to test for only  0 -10 integers
    * */
    @Test(priority = 4)
    public void verifyFactorialFunctionality(){

        FactorialPage factorialPage = new FactorialPage();
        for(int i = 0; i<10; i++) {
            factorialPage.enterValue(driver, i);
            factorialPage.clickSubmitButton(driver);
            factorialPage.verifyExpectedMatchActualFactorial(driver, i);

        }
    }

    @Test(priority = 4)
    public void verifyInvalidError(){

        String[] invalidNum = {"1.25", "text"}; //Include as many invalid inputs you want to test

        FactorialPage factorialPage = new FactorialPage();

        for(String tempText : invalidNum) {

            factorialPage.enterValueAsText(driver, tempText);
            factorialPage.clickSubmitButton(driver);

            Assert.assertTrue(factorialPage.verifyErrorMessage(driver));
        }
    }

    @Test(priority = 5)
    public void verifyPrivacyLink(){
        FactorialPage factorialPage = new FactorialPage();

        factorialPage.clickPrivacyLink(driver);
        Assert.assertTrue(factorialPage.verifyPrivacyPage(driver));

    }

    @Test(priority = 6)
    public void verifyTermsAndConditionLink(){

        driver.navigate().to(baseUrl);

        FactorialPage factorialPage = new FactorialPage();
        factorialPage.clickTermsAndConditionLink(driver);
        Assert.assertTrue(factorialPage.verifyTermsAndConditionPage(driver));

    }

    @Test(priority = 7)
    public void verifyCopyrightLink(){

        driver.navigate().to(baseUrl);

        FactorialPage factorialPage = new FactorialPage();
        factorialPage.clickCopyrightLink(driver);
        Assert.assertTrue(factorialPage.verifyCopyrightPage(driver));

    }

}
