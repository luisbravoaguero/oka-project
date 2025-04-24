package Page;


import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage extends PageObject {

    @Managed
    protected WebDriver driver;
    protected Actions actions;

    //Constructor inicializado
    public BasePage(WebDriver driver){
        this.actions = new Actions(driver);
        this.driver = driver;
    }

    //Accion click
    public void click(By locator) throws Exception
    {
        try
        {
            WebElement element = waitElementToBeClickable(locator,10);
            element.click();
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No se pudo dar click sobre el elemento: " + locator);
        }
    }

    public void clear(By element) throws Exception
    {
        try
        {
            driver.findElement(element).clear();
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No se pudo limpiar el elemento: " + element);
        }
    }

    //Accion de devolver un booleano si el elemento esta Visible
    public boolean isDisplayed(By element) throws Exception
    {
        try
        {
            return driver.findElement(element).isDisplayed();
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : Elemento no visible " + element);
        }
    }

    //Accion de devolver un boolean si el elemento esta Habilitado
    public boolean isEnabled(By element) throws Exception
    {
        try
        {
            return driver.findElement(element).isEnabled();
        }
        catch (Exception e)
        {
            return false;
            //throw new Exception("FAIL : No se pudo devolver el valor del elemento: " + element);
        }
    }

    public boolean isEnabledBoolean(By element) throws Exception
    {
        try
        {
            return driver.findElement(element).isEnabled();
        }
        catch (Exception e)
        {
            return false;
        }
    }

    //Accion obtener texto
    public String getText(By element) throws Exception
    {
        try
        {
            return driver.findElement(element).getText();
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No se puedo obtener el texto del elemento: " + element);
        }
    }

    //Accion escribir caja de texto
    public void sendKey(By locator, String textoCaja) throws Exception
    {
        try
        {
            WebElement element = waitElementToBeClickable(locator,10);
            element.sendKeys(textoCaja);
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No se puede escribir dentro del elemento: " + locator);
        }
    }

    public void sendFormattedDate(By locator, String date) throws Exception {
        try {
            // Locate the input field
            WebElement dateInput = driver.findElement(locator);

            // Use JavaScript to remove the readonly attribute
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].removeAttribute('readonly')", dateInput);
            waitForSeconds(1);
            // Add the type="text" attribute to the input field
            jsExecutor.executeScript("arguments[0].setAttribute('type', 'text')", dateInput);
            waitForSeconds(1);
            // Format the date if necessary (e.g., removing slashes)
            String formattedDate = date.replace("/", ""); // Removes slashes (optional based on field requirements)
            waitForSeconds(1);
            clearInputTextDeeply(locator);
            waitForSeconds(1);
            // Send the formatted date to the input field
            dateInput.sendKeys(formattedDate);
            /*
            actions.click(dateInput)
                   .sendKeys(date)
                   .perform();
            * */

        } catch (Exception e) {
            throw new Exception("FAIL: Error al ingresar la fecha en el inputDataPicker: " + locator);
        }
    }

    public void clearInputTextDeeply(By locator) throws Exception {
        try {
            WebElement element = waitElementToBeClickable(locator,10);
            element.click();
            JavascriptExecutor js  = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value = '';",element);
            waitForSeconds(1);
            actions.click(element).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
            element.clear();
        } catch (Exception e) {
            throw new Exception("No se pudo dar click sobre el elemento: " + locator);
        }
    }

    //Accion Tab
    public void sendKeyTab(By element) throws Exception
    {
        try
        {
            driver.findElement(element).sendKeys(Keys.TAB);
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No se puede dar Tab en el elemento: " + element);
        }
    }

    //Accion Escape
    public void sendKeyScape(By element) throws Exception
    {
        try
        {
            driver.findElement(element).sendKeys(Keys.ESCAPE);
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No Realiza el Teclado Escape: " + element);
        }
    }

    //Accion obtiene el titulo de la pagina
    public String getTitle() {
        return driver.getTitle();
    }

    //Accion de seleccion Lista - Combo Box
    public void selectValue(By locator, String visibleText) throws Exception
    {
        try
        {
            WebElement element = waitElementToBeClickable(locator,10);
            Select select = new Select(element);
            List<WebElement> options = select.getOptions();
            for(WebElement option: options){
                if(option.getText().trim().equalsIgnoreCase(visibleText.trim())){
                    String valueAtribute = option.getAttribute("value");
                    select.selectByValue(valueAtribute);
                    waitForSeconds(1);
                    //clickOutSide(2);
                    element.sendKeys(Keys.TAB);
                    return;
                }
            }
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No se pudo seleccionar el elemento" + locator);
        }
    }
    public WebElement waitElementToBeClickable(By locator, int timeoutInSeconds){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(driver ->{
                WebElement element = driver.findElement(locator);
                if(element.isDisplayed() && element.isEnabled()){
                    return element;
                }else{
                    throw new RuntimeException("Element is not displayed or enabled: "+locator.toString());
                }
            });
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public WebElement selectValueGetFirst(By element) throws Exception
    {
        try
        {
            //return driver.findElement(element).getText();
            Select se = new Select(driver.findElement(element));
            return se.getFirstSelectedOption();
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No se pudo seleccionar el elemento" + element);
        }
    }

    //Esperar elemento sea Visible
    public void waitVisible(By element) throws Exception
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No se pudo esperar el elemento " + e);
        }
    }

    //ESPERAR QUE EL ELEMENTO SEA CLICLEABLE
    public void waitClicleable(By element) throws Exception
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No se pudo esperar el elemento " + e);
        }
    }

    //ESPERA QUE LA ALERTA ESTE PRESENTE
    public void waitPresent() throws Exception
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
            wait.until(ExpectedConditions.alertIsPresent());
        }
        catch (Exception e)
        {
            throw new Exception("FAIL : No se pudo esperar el elemento " + e);
        }
    }

    //USAR RL EQUALS PARA COMPARAR UN OBJETO CON UN TEXTO - BOOLEAN
    public boolean equals(By element, String textObjeto) throws Exception
    {
        try
        {
            return  driver.findElement(element).equals(textObjeto);

        }
        catch (Exception e)
        {
            throw new Exception("FAIL : El Texto es diferente al Elemento: " + element);
        }
    }
    public void checked(By element){


    }

    public void waitForSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La espera fue interrumpida: "+e);
        }
    }

    public void scrollToBottom(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public void scrollToTop(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0,0)");
    }

    public void scrollToMiddle(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        long pageHeight = (long) javascriptExecutor.executeScript("return document.body.scrollHeight");

        javascriptExecutor.executeScript("window.scrollTo(0,arguments[0]);",pageHeight/2);
    }

    public void scrollToY(int yValue){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,"+yValue+");");
    }

    public void scrollToElement(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",element);
    }

    public boolean waitBooleanVisibleByTime(By element, int timeout) throws Exception
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void waitInvisibleByTime(By element, int timeout) {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
            System.out.println("SUCCESS: Elemento HMTL ahora es invisible: "+element.toString());
        }
        catch (Exception e)
        {
            System.out.println("WARNING: No se pudo esperar al elemento pero no es un stoper para detener la prueba: "+e);
        }
    }

    public String getInputValueJS(By locator) throws Exception {
        try {
            WebElement element = waitForVisibility(locator,10);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            return (String) javascriptExecutor.executeScript("return arguments[0].value;", element);
        }
        catch (Exception e) {
            throw new Exception("FAIL : No se pudo obtener el valor del atributo value usando JavaScript: " + locator);
        }
    }
    public WebElement waitForVisibility(By locator, int timeoutInSeconds) throws Exception {
        try {
            FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    public String getValidSelectedOption(By locator) throws Exception {
        try {
            WebElement element = waitForVisibility(locator, 10);
            Select select = new Select(element);

            if (select.getAllSelectedOptions().isEmpty()) {
                return ""; // No option is selected
            }
            String selectedValue = select.getFirstSelectedOption().getText().trim();
            //System.out.println("selectedValue valor: "+select.getAllSelectedOptions());
            //System.out.println("selectedValue valor: "+selectedValue);
            List<String> defaultValues = Arrays.asList("seleccione", "select","tipo", "via", "seleccionar", "tipos");
            String selectedValueLower = selectedValue.toLowerCase();
            //System.out.println("selectedValue toLowerCase valor: "+selectedValue);

            for(String defaultValue: defaultValues){
                //System.out.println("value: "+selectedValueLower.contains(defaultValue.toLowerCase()));
                if (selectedValueLower.contains(defaultValue.toLowerCase())){
                    return "";
                }
            }
            return selectedValue;
        } catch (NoSuchElementException e) {
            throw new Exception("FAIL : No se pudo obtener la opcion seleccionada del combobox: " + locator);
        }
    }
    public void selectAutoCompleteOption(By locator, String value) throws Exception {
        try{
            sendKeyAutoComplete(locator, value);
            waitForSeconds(2);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        }catch (Exception e){
            throw new Exception("FAIL : No se pudo seleccionar el valor usando el teclado: " + locator);
        }
    }
    public void sendKeyAutoComplete(By locator, String value) throws Exception {
        try {
            WebElement element = waitForClickability(locator,10);
            element.click();
            waitForMilliSeconds(6);
            element.clear();
            //sendKeyUsingJS(locator,dateFormatted);
            waitForMilliSeconds(6);
            element.sendKeys(value);
            element.sendKeys(Keys.BACK_SPACE);
            char lastCharacter = getLastCharacterFromString(value);
            element.sendKeys(String.valueOf(lastCharacter));
        }catch (Exception e) {
            throw new Exception("FAIL : No se pudo ingresar el valor en el campo: " + locator);

        }
    }
    public WebElement waitForClickability(By locator, int timeoutInSeconds) throws Exception {
        try {
            FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            return fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void waitForMilliSeconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds * 100L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La espera fue interrumpida: "+e);
        }
    }
    public char getLastCharacterFromString(String inputText){
        waitForMilliSeconds(5);
        return inputText.charAt(inputText.length()-1);
    }
    public boolean isElementDisabled(By by){
        try {
            WebElement element = driver.findElement(by);
            String disabledAttr = element.getAttribute("disabled");
            return disabledAttr !=null && (disabledAttr.equals("true")||disabledAttr.equals("disabled"));
        }catch (Exception e){
            System.out.println("Elemento no encontrado or error mientras revisaba el atributo 'disabled' en: "+e.getMessage());
            return false;
        }
    }
    public void waitVisibleByTime(By element, int timeout) throws Exception
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
        catch (Exception e)
        {
            System.out.println("FAIL: No se pudo esperar al elemento pero no es un stoper para detener la prueba: "+e);
        }
    }
    public void clickWhenReady(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean clicked = false;

        for (int i = 0; i < 5; i++) {  // Retry clicking 5 times if a stale element or other issue is encountered
            try {
                System.out.println("Waiting for element visibility...");  // Track step
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                System.out.println("Element is visible.");  // Track step

                System.out.println("Waiting for element to be clickable...");  // Track step
                wait.until(ExpectedConditions.elementToBeClickable(by));

                System.out.println("Clicking the element...");  // Track step
                try {
                    Actions actions = new Actions(driver);
                    actions.moveToElement(element).click().perform();
                    clicked = true;
                    System.out.println("Clicked successfully with Actions.");  // Track step
                    break;
                } catch (Exception e) {
                    System.out.println("Actions click failed, trying JS click...");  // Track step
                    // If Actions class click fails, try JS click
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", element);
                    clicked = true;
                    System.out.println("Clicked successfully with JS.");  // Track step
                    break;
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element encountered. Retrying... Attempt " + (i + 1));
            } catch (ElementClickInterceptedException e) {
                System.out.println("Element click was intercepted. Retrying... Attempt " + (i + 1));
            } catch (Exception e) {
                System.out.println("Failed to click the element: " + e.getMessage());
                break;  // Exit the loop on other exceptions
            }

            // Optional: wait a short period between retries to allow the page to stabilize
            try {
                Thread.sleep(1000);  // 1-second wait before retrying
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!clicked) {
            System.out.println("Element could not be clicked after retries.");
        }
    }
    public void clickUsingJS(By locator) throws Exception {
        try {

            WebElement element = waitElementToBeClickable(locator,10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            System.out.println("Clicked successfully with JS.");  // Track step
        } catch (Exception e) {
            throw new Exception("FAIL : No se pudo dar click usando JavaScript sobre el elemento: " + locator);
        }
    }
    public void waitForPageToLoad(){
        if(!(driver instanceof JavascriptExecutor)){
            throw new IllegalStateException("This driver does not support javascript execution");
        }
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String readySate = (String) jsExecutor.executeScript("return document.readyState");
        //System.out.println("Page load state: "+readySate);

        //System.out.println("Driver is : "+driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
        wait.until(webDriver -> jsExecutor.executeScript("return document.readyState").equals("complete"));
        String finalSate = (String) jsExecutor.executeScript("return document.readyState");
        System.out.println("Page load final state: "+finalSate);
    }
    public void clickUsingActions(By locator) throws Exception {
        try {
            WebElement element = waitForVisibility(locator, 10);
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            throw new Exception("FAIL : No se pudo dar click usando Actions sobre el elemento: " + locator);
        }
    }

    public boolean waitVisibleBooleanByTime(By element, int timeout)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            System.out.println("SUCCESS: Elemento HMTL encontrado: "+element.toString());
            return true;
        }
        catch (Exception e)
        {
            System.out.println("WARNING: No se pudo esperar al elemento pero no es un stoper para detener la prueba: "+e);
            return false;
        }
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

}

