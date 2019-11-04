import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FactorialPage {

    public WebDriver driver;

    public void verifyFactorialPageElements(WebDriver driver){
        Assert.assertTrue(driver.findElement(By.id("number")).isDisplayed());  //Text field
        Assert.assertTrue(driver.findElement(By.id("getFactorial")).isDisplayed()); //Submit button
        Assert.assertTrue(driver.findElement(By.linkText("Privacy")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Terms and Conditions")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Qxf2 Services")).isDisplayed());
    }

    public void enterValue(WebDriver driver, int num){

        WebElement textField = driver.findElement(By.id("number"));
        //Clear the field
        textField.sendKeys(Keys.CONTROL + "a");
        textField.sendKeys(Keys.DELETE);

        //Enter value
        textField.sendKeys(String.valueOf(num));
    }

    public void enterValueAsText(WebDriver driver, String valueText){

        WebElement textField = driver.findElement(By.id("number"));
        //Clear the field
        textField.sendKeys(Keys.CONTROL + "a");
        textField.sendKeys(Keys.DELETE);

        //Enter value
        textField.sendKeys(valueText);
    }

    public void clickSubmitButton(WebDriver driver){

        //Click button
        driver.findElement(By.id("getFactorial")).click();

        //Wait 1 sec
        try {
            Thread.sleep(1500);
        }catch(Exception e){

        }

    }

    public void clickPrivacyLink(WebDriver driver){

        //Click button
        driver.findElement(By.linkText("Privacy")).click();

        //Wait 1 sec
        try {
            Thread.sleep(1000);
        }catch(Exception e){

        }

    }

    public void clickTermsAndConditionLink(WebDriver driver){

        //Click button
        driver.findElement(By.linkText("Terms and Conditions")).click();

        //Wait 1 sec
        try {
            Thread.sleep(1000);
        }catch(Exception e){

        }

    }

    public void clickCopyrightLink(WebDriver driver){

        //Click button
        driver.findElement(By.linkText("Qxf2 Services")).click();

        //Wait 1 sec
        try {
            Thread.sleep(1000);
        }catch(Exception e){

        }

    }

    public boolean verifyMessageForInfinite(WebDriver driver){

        String resultText = driver.findElement(By.id("resultDiv")).getText();
        System.out.println(resultText);
        return resultText.toUpperCase().contains( "Infinity".toUpperCase());
    }

    public boolean verifyMessageForEmpty(WebDriver driver){
        System.out.println("Empty Response");   //("11"+driver.findElement(By.id("resultDiv")).getText().isEmpty()+"11");
        return driver.findElement(By.id("resultDiv")).getText().isEmpty();
    }

    public boolean verifyErrorMessage(WebDriver driver){
        String resultText = driver.findElement(By.id("resultDiv")).getText();
        System.out.println(resultText);
        return resultText.toUpperCase().contentEquals( "Please enter an integer".toUpperCase());
    }

    public boolean verifySuccessResultIsDisplayed(WebDriver driver){

            String resultText = driver.findElement(By.id("resultDiv")).getText();
            System.out.println(resultText);
            return resultText.toUpperCase().contains( "The factorial of".toUpperCase()) && !resultText.toUpperCase().contains( "infinity".toUpperCase());
    }

    public boolean verifyPrivacyPage(WebDriver driver){
        return driver.findElement(By.tagName("body")).getText().toUpperCase().contains("Privacy".toUpperCase());
    }

    public boolean verifyTermsAndConditionPage(WebDriver driver){
        return driver.findElement(By.tagName("body")).getText().toUpperCase().contains("Terms and Condition".toUpperCase());
    }

    public boolean verifyCopyrightPage(WebDriver driver){
        return driver.getTitle().toUpperCase().contains("Qxf2 Services".toUpperCase());
    }

    /*
    * Good for numbers without exponential
    * */
    public void verifyExpectedMatchActualFactorial(WebDriver driver, int num){

        String[] resultTextAsArray = driver.findElement(By.id("resultDiv")).getText().split( ":");
        String actualResult = resultTextAsArray[1].trim();

        int expectedResult = factorial(num);
        System.out.println(actualResult);
        System.out.println("--"+expectedResult);

        Assert.assertEquals(Integer.parseInt(actualResult), expectedResult);

    }

    private  final double TOLERANCE = 0.0001;

    public  boolean approxEqual(final double d1, final double d2) {
        return Math.abs(d1 - d2) < TOLERANCE;
    }

    public  double factorial(double d)
    {
        if (d == 0.0)
        {
            return 1.0;
        }

        double abs = Math.abs(d);
        double decimal = abs - Math.floor(abs);
        double result = 1.0;

        for (double i = Math.floor(abs); i > decimal; --i)
        {
            result *= (i + decimal);
        }
        if (d < 0.0)
        {
            result = -result;
        }

        return result;
    }

    public int factorial(int n)
    {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);

    }
}
