package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


// Cтраницы оформления заказа, элементы:
public class OrderPage {
    private final WebDriver driver;

// Локатор поля Имя
    private final By FirstName = By.xpath(".//input[@placeholder='* Имя']");

// Локатор поля Фамилия
    private final By LastName = By.xpath(".//input[@placeholder='* Фамилия']");

// Локатор поля Адрес
    private final By Address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

// Локатор поля Станция метро
    private final By deliveryMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

// Локатор поля Телефон
    private final By deliveryClientPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

// Локатор кнопки Далее
    private final By NextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

//Конструктор класса
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы:
//Ввод имени
    public OrderPage sendClientFirstName(String firstName) {
        driver.findElement(FirstName).sendKeys(firstName);
        return this;
    }
//Ввод фамилии
    public OrderPage sendClientLastName(String lastName) {
        driver.findElement(LastName).sendKeys(lastName);
        return this;
    }

//Ввод адреса
    public OrderPage sendDeliveryAddress(String address) {
        driver.findElement(Address).sendKeys(address);
        return this;
    }

//Выбор станции метро
    public OrderPage selectMetroStation(String metroStationFromOrder) {
        driver.findElement(deliveryMetroStation).click();
        driver.findElement(deliveryMetroStation).sendKeys(metroStationFromOrder);
        driver.findElement(deliveryMetroStation).sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }

//Ввод телефона
    public OrderPage sendDeliveryClientPhoneNumber(String phoneNumber) {
        driver.findElement(deliveryClientPhoneNumber).sendKeys(phoneNumber);
        return this;
    }

//Клик по кнопке Далее
    public OrderPage clickNextButton() {
        driver.findElement(NextButton).click();
        return this;
    }

}