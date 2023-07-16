package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

// Главная страница сайта, элементы:
public class MainPage {
    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
    }

    private static WebDriver driver;

// Локатор кнопки закрытия куки
    private final By cookiesButton = By.id("rcc-confirm-button");

// Локатор Кнопки заказа в хэдере сайта
    private By hOrderButton = By.className("Button_Button__ra12g");

// Локатор кнопки заказа в середине сайта
    private By mOrderButton = By.className("Button_Middle__1CSJM");

// Массив локаторов кнопок с вопросами
    private static final String[] Questions = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

// Массив локаторов панелей с текстом ответов
    private static final String[] Answers = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

// Методы для главной страницы:
//Открыть сайт
    public final MainPage openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

// Клик по кнопке закрытия сообщения о куках
    public MainPage clickCookiesButton() {
        driver.findElement(cookiesButton).click();
        return this;
    }

// Клик по кнопке заказа в хэдере сайта
    public MainPage clickHOrderButton() {
        driver.findElement(hOrderButton).click();
        return this;
    }

// Клик по кнопке заказа в середине сайта
    public MainPage clickMOrderButton() {
        driver.findElement(mOrderButton).click();
        return this;
    }

// Прокрутка страницы до последнего элемента в списке
    public MainPage scrollPageToEndList() {
        WebElement lastQuestionArrow = driver.findElement(By.id(Questions[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }

// Клик по стрелке выпадающего списка
    public static void clickQuestion(int questionNumber) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id(Questions[questionNumber])));
        driver.findElement(By.id(Questions[questionNumber])).click();
    }

// Проверка текста в открытой панели
    public static void checkTextInPanel(String expectedText, int answerNumber) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(Answers[answerNumber])));
        String answerText = driver.findElement(By.id(Answers[answerNumber])).getText();
        assertEquals(expectedText, answerText);
    }

// Клик по кнопке вопроса
    public MainPage clickOnQuestion(String questionButtonLocator) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
        return this;
    }
}
