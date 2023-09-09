package AddressFuncionalityTest;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddressFunctionalityTest extends BaseDriver {
    @Test(priority = 1)
    public void addAddressTest(){
        login();

        WebElement addressButton = driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Address Book']"));
        addressButton.click();

        WebElement newAdButton = driver.findElement(By.xpath("//a[text()='New Address']"));
        newAdButton.click();

        WebElement firstNameInbox = driver.findElement(By.cssSelector("input[id='input-firstname']"));
        firstNameInbox.sendKeys("Matt");

        WebElement lastNameInbox = driver.findElement(By.cssSelector("input[id='input-lastname']"));
        lastNameInbox.sendKeys("Alan");

        WebElement addresInbox = driver.findElement(By.cssSelector("input[id='input-address-1']"));
        addresInbox.sendKeys("293 Time St");

        WebElement cityInbox = driver.findElement(By.cssSelector("input[id='input-city']"));
        cityInbox.sendKeys("New York");

        WebElement postInbox = driver.findElement(By.cssSelector("input[id='input-postcode']"));
        postInbox.sendKeys("10015");

        WebElement selectBox = driver.findElement(By.cssSelector("select[id='input-country']"));
        Select select = new Select(selectBox);
        select.selectByIndex(2);

        WebElement selectRegionBox = driver.findElement(By.cssSelector("select[id='input-zone']"));
        Select select2 = new Select(selectRegionBox);
        select2.selectByValue("2");

        WebElement yesCheck = driver.findElement(By.cssSelector("input[value='1']"));
        yesCheck.click();

        WebElement conButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        conButton.click();
    }

    @Test(priority = 2)
    public void editAddressTest(){
        WebElement editButton = driver.findElement(By.xpath("//a[text()='Edit']"));
        editButton.click();

        WebElement postInbox = driver.findElement(By.cssSelector("input[id='input-postcode']"));
        postInbox.clear();
        postInbox.sendKeys("10011");

        WebElement conButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        conButton.click();
    }

    @Test(priority = 3)
    public void deleteAddressTest(){
        WebElement delButton = driver.findElement(By.xpath("//a[text()='Delete']"));
        delButton.click();

        MyMethods.successMessageValidation();
    }

}
