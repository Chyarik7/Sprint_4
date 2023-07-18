package pageobject;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    // локатор для кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");
    //Кнопка "заказать" в хэдэре
    private By orderHButton = By.cssSelector(".Header_Nav__AGCXC > button:nth-child(1)");
    //Кнопка "заказать" в середене
    private By orderMButton = By.cssSelector(".Button_Middle__1CSJM");
    //Поле "Имя"
    private By nameField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");
    //Поле "Фамилия"
    private By surnameField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    private By adress = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");
    //Список станций метро
    private By metroList = By.className("select-search__input");
    //Поле "Телефон"
    private By phoneNumber = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private By nButton = By.cssSelector(".Button_Middle__1CSJM");
    //Поле "Когда привезти"
    private By Date = By.xpath(".//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']");
    //Поле "Срока аренды"
    private By period = By.className("Dropdown-placeholder");
    //Поле "Цвет самоката"
    private By Colour = By.className("Order_Checkboxes__3lWSI");
    //Поле "Комментарии"
    private By comment = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(4) > input:nth-child(1)");
    //Кнопка "Заказ"
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    //Кнопка подтверждения "Да"
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and (text() = 'Да')]");
    //Информация заказа
    private By info = By.className("Order_ModalHeader__3FDaJ");
    //Кнопка подтверждения
    private By conButton = By.cssSelector(".Order_Text__2broi");

    //Методы:
    // Нажатие кнопки закрытия плашки куки
    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }

    //Выбор кнопки для заказа
    public void clickOderButton(boolean upButton) {
        if (upButton)
            clickOrderUpButton();
        else clickOrderDownButton();
    }

    //Нажатие кнопки "заказать" в хэдэре
    public void clickOrderUpButton() {
        driver.findElement(orderHButton).click();
    }

    //Нажатие кнопки "заказать" в середине сайта
    public void clickOrderDownButton() {
        WebElement button = driver.findElement(orderMButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        driver.findElement(orderMButton).click();
    }

    //Ввод в поле "Имя"
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //Ввод в поле "Фамилия"
    public void setSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    //Ввод в поле Адрес
    public void setAdress(String adress) {
        driver.findElement(this.adress).sendKeys(adress);
    }

    //Выбор станции метро
    public void clickUndegroundList(String metro) {
        driver.findElement(metroList).click();
        driver.findElement(By.xpath(".//button[@value='" + metro + "']")).click();
    }

    //Ввод номера телефона
    public void setPhoneNumber(String number) {
        driver.findElement(phoneNumber).sendKeys(number);
    }

    //Заполнение полей имя, фамилия, адрес, номер
    public void login(String name, String surname, String adress, String numer) {
        setNameField(name);
        setSurnameField(surname);
        setAdress(adress);
        setPhoneNumber(numer);
    }

    //нажимает кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(nButton).click();
    }

    //Заполнение даты доставки
    public void setOrderDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
        Date date = new Date();
        driver.findElement(Date).click();
        driver.findElement(Date).sendKeys(formatter.format(date));
        driver.findElement(Date).sendKeys(Keys.ENTER);
    }

    //Заполнение срока аренды
    public void setPeriod(int rentTime) {
        driver.findElement(period).click();
        driver.findElement(period).findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[" + rentTime + "]")).click();
    }

    //Выбор цвета
    public void setColour(String colour) {
        driver.findElement(Colour);
        driver.findElement(By.xpath("//*[@id=\"" + colour + "\"]")).click();
    }

    //Заполнение комментария
    public void setComment(String comment) {
        driver.findElement(this.comment).sendKeys(comment);
    }

    //Нажатие кнопки "заказать", после заполнения полей
    public void clickOrderFormButton() {
        driver.findElement(orderButton).click();
    }

    //Нажатие кнопки "Да"
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    //Проверка уведомления о заказе
    public void setConfirmationButton() {
        driver.findElement(conButton).getText();
    }

    //вывод текста сообщения
    public String getConButton() {
        return driver.findElement(By.className("Order_Text__2broi")).getText();
    }

    //проверка текста сообщения
    public void getConfirmationInfo() {
        String text = driver.findElement(info).getText();
        String textPart = "Заказ оформлен";
        Assert.assertTrue(text.contains(textPart));
    }

}