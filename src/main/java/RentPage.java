package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    WebDriver driver;

    //Локаторы данных страницы аренды
//Локатор поля даты начала аренды
    private final By rentalDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

//Локатор поля срок аренды
    private final By rentalTimeField = By.className("Dropdown-placeholder");
//Локатор списка срока аренды
    private final By rentalTime = By.xpath(".//*[(@role ='option' and text()='трое суток')]");
//Локатор пункта цвета Черный жемчуг
    private final By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");
//Локатор пункта цвета Серая безысходность
    private final By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");
//Локатор поля комментария
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
//Локатор кнопки Заказать
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
//Локатор кнопки "Да" подтверждения заказа
    private final By orderButtonYes = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
//Локатор модального окна
    private final By modalOrderWindow = By.xpath(".//div[contains(@class, 'Order_ModalHeader')]");
//Окно Заказ Оформлен
    public boolean isModalOrderWindowDisplayed() {
        return driver.findElement(modalOrderWindow).isDisplayed();
    }

//Конструктор класса
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы страницы аренды
//Ввод даты доставки
    public RentPage sendRentalDate(String date) {
        driver.findElement(rentalDateField).sendKeys(date);
        driver.findElement(rentalDateField).sendKeys(Keys.ENTER);
        return this;
    }

//Ввод в сроку аренды
    public RentPage setRentalTime() {
        driver.findElement(rentalTimeField).click();
        driver.findElement(rentalTime).click();
        return this;
    }

//Выбор цвета Черный жемчуг
    public RentPage clickCheckBoxColourBlackPearl() {
        driver.findElement(checkBoxColourBlackPearl).click();
        return this;
    }

//Выбор цвета Серая безысходность
    public RentPage clickCheckBoxColourGreyDespair() {
        driver.findElement(checkBoxColourGreyDespair).click();
        return this;
    }

//Ввод комментария
    public RentPage sendComment(String userComment) {
        driver.findElement(commentField).sendKeys(userComment);
        return this;
    }

//Клик по кнопке Заказать
    public RentPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

//Клик по кнопке оформления заказа, Да
    public RentPage clickOrderButtonYes() {
        driver.findElement(orderButtonYes).click();
        return this;
    }
}
