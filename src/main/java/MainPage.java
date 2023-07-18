package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.time.Duration;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //локатор списка вопросов
    private By dropQuestionMenu = By.className("accordion");
    // локатор кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");



    //метод закрывает плашку куки
    public void clickCookie() {

        driver.findElement(cookieButton).click();
    }

    //скролл до списка с вопросами
    public void scrollToDropDown() {
        WebElement element = driver.findElement(dropQuestionMenu);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
    }

    //нажатие на список
    public void clickDropDownMenu(int index) {
        driver.findElement(By.cssSelector("#accordion__heading-"+index)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
    }


    // возвращает ответ на вопрос
    public String getAnswer(int index) {
        return driver.findElement(By.cssSelector("#accordion__panel-"+index)).getText();
    }


}
