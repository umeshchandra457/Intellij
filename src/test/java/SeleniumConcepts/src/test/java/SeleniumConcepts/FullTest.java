package SeleniumConcepts;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Set;




public  class FullTest extends SetUpClass{


    static boolean result = false;

    public static void fillForm() throws InterruptedException {

        driver.findElement(By.id("name")).sendKeys("Automation Testing practice");
        driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("123456789");
        driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("Hi hello  This is Automation testing practice page");
        driver.findElement(By.id("male")).click();

        //Days
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        //forLoop
        for(int i = 0; i < list.size(); i++) {
            list.get(i).click();
        }
        //Advanced For loop
        for(WebElement days : list) {
            days.click();
        }

        //country
        WebElement countryEle = driver.findElement(By.xpath("//div//select[@id='country']"));
        Select country = new Select(countryEle);
        country.selectByValue("india");
        country.selectByIndex(5);
        country.selectByVisibleText("United States");

        //colors
        WebElement colors = driver.findElement(By.xpath("//select[@id='colors']"));
        Select color = new Select(colors);
        List<WebElement> text = color.getOptions();

        for (WebElement colorEle : text) {
            System.out.println(colorEle.getText());
            color.selectByIndex(2);
        }

        //Date
        //driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        //driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[7]")).click();
        selectionDate("March","2024", "25");

        //Wikipedia Tab
        //webSearch();

        //New Browser Window
        newWindow();
        alertWindow();
    }


    //Web Table Data
    public static void tableBody() {
        List<WebElement> tableData = driver.findElements(By.xpath("//div//table[@name='BookTable']/tbody"));
        for(int i = 0; i < tableData.size(); i++) {
            System.out.println(tableData.get(i).getText());
        }
    }

    //BookTable
    public static void webTable() {

        // Get the number of rows (including the header if present)
        int row = driver.findElements(By.xpath("//table[@name='BookTable']//tbody/tr")).size();
        System.out.println(row);

        // Get the number of columns from the first row (header or data)
        int col = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();
        System.out.println(col);

        // Loop through each row and column to extract text
        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                System.out.println("Row Colunm Number....." + i + "," + j);
                String value = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.println(value + "--");
            }
        }
    }

    //Table Header Part
    public static void tableHead() {
        List<WebElement> tableHead = driver.findElements(By.xpath("//div//table[@name='BookTable']/tbody/tr/th"));
        for (WebElement data : tableHead) {
            String text = data.getText();
            System.out.println(text);
            if (text.contains("Subject")) {
                result = true;
                break;
            }
        }
        Assert.assertTrue(result, "Value not founded");
    }

    //Table data of specific records
    public static void records() {

        int tableRecord = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println(tableRecord);

        for (int i = 2; i <= tableRecord; i++) {
            String recordData = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + i + "]//td[2]")).getText();
            System.out.println("Value of the specific record " + recordData);
            if (recordData.contains("Animesh")) {
                System.out.println("Inside the loop");
                result = true;
                break;
            }
            result = false;
        }
    }

    //Product Table
    public static void productTable() {

        int col = driver.findElements(By.xpath("//table[@id='productTable']//tr//th")).size();
        System.out.println("Total Column ----------:" + col);

        int row = driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr")).size();
        System.out.println("Total Row ------------:" + col);

        //For-each or Enhanced for Loop.
        List<WebElement> data = driver.findElements(By.xpath("//table[@id='productTable']//tbody"));
        for (WebElement value : data) {
            String text = value.getText();
           // System.out.println(text);
        }

        //Normal loop
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                String text = driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr[" + i + "]/td[" + j + "]")).getText();
                //System.out.println("Table Data :" + text);
            }
        }

        //Loop for specific record value
        //for(int i = 1; i <= col; i++){
            String header = driver.findElement(By.xpath("//table[@id='productTable']//tr[1]//th[4]")).getText();
            if (header.equals("Select")) {
                for (int j = 1; j <= row; j++) {
                    WebElement checkBox = driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr[" + j + "]/td[4]/input"));
                    System.out.println(checkBox.getTagName());
                    checkBox.click();
                    System.out.println(header + ": Check box is clicked ");
                }
            }
    }

    //Web Search
    public static void webSearch() throws InterruptedException {

       driver.findElement(By.id ("Wikipedia1_wikipedia-search-input")).sendKeys("hello");
       driver.findElement(By.className("wikipedia-search-button")).click();
       Thread.sleep(3000);
       WebElement texts= driver.findElement(By.xpath("//*[@id='Wikipedia1_wikipedia-search-results']"));
       //String textt= texts.getText();
       if (texts.getText().equals("hello"))
           driver.findElement(By.linkText("Hello")).click();
       System.out.println(texts.getText()+"=======" );

    }

    //Date Picker
    public static void  selectionDate( String month,String year, String date){

        //Date Table
        WebElement yearMonth =driver.findElement(By.xpath("//input[@id='datepicker']"));
        yearMonth.click();

        //date and month of the table
        while(true){
            String monthPicker = driver.findElement(By.xpath("//span[@class='ui-datepicker-month'][1]")).getText();
            String yearPicker = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            if(monthPicker.equals(month) && yearPicker.equals(year)){
                break;
             }
            //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//future date
           driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//Previous Date
        }
        //Date Selection
        List<WebElement> datePicker = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
        for(WebElement dateText: datePicker){
            if(dateText.getText().equals(date)){
                dateText.click();
                break;
            }
        }
    }

    //New Window
    public static void newWindow() throws InterruptedException {
        Thread.sleep(3000);
        //javascript for opening new window
        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'New Browser Window')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);

        //Handling the multiple windows
        String parentW = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        int wincount = allWindows.size();
        System.out.println(wincount);

        for (String child :allWindows) {
            String title = driver.switchTo().window(child).getTitle();
            System.out.println(title);
            String url = driver.getCurrentUrl();
            System.out.println(url);
            //want close particular tab
            if(url.equals("https://demo.opencart.com/") || title.equals("Your Store")){
                String titlee= driver.getTitle();
                System.out.println("Child Tab Title "+titlee);
                WebElement ele =driver.findElement(By.xpath("//input[@name='search']"));
                ele.sendKeys("iphone");
                driver.findElement(By.xpath("//div[@id='search']//button")).click();
                Thread.sleep(3000);
                driver.close();
            }

            driver.switchTo().window(parentW);
          //Close all the child windows
//          if (!parentW.equals(child)) {
//               driver.switchTo().window(child);
//                String titlee = driver.getTitle();
//                System.out.println(title);
//          }
//
//            driver.close();
//
            }

    }

    //Alert PopUp
    public static void alertWindow() throws InterruptedException {
        WebElement alertEle = driver.findElement(By.xpath("//button[contains(text(),'Alert')]"));

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        Thread.sleep(3000);
        //Alert ConfrimBaox PopUp
        WebElement confrimBox = driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]"));
        JavScriptClass.click(confrimBox);
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();


        //Alert TextBox

        WebElement prompt =driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));
        JavScriptClass.click(prompt);
        Alert alert1 = driver.switchTo().alert();//different type of method to call Alert
        Thread.sleep(3000);
        alert1.sendKeys("Hello this a prompt Text Box");
        alert1.accept();
    }
    //Copy and Paste
    public static void copyAndPaste(){

     WebElement copyText =   driver.findElement(By.xpath("//div//div/input[@id='field1']"));
     copyText.clear();
     copyText.sendKeys("Selenium");

     WebElement pasteData =driver.findElement(By.xpath("//div//div/input[@id='field2']"));
        //Copy the Data
        Actions action = new Actions(driver);
        //action.keyDown(Keys.CONTROL).sendKeys("a").keyDown(Keys.CONTROL).perform();// press control and select text
        copyText.sendKeys(Keys.COMMAND,"a");
        //action.keyDown(Keys.CONTROL).sendKeys("c").keyDown(Keys.CONTROL).perform();// press control and copy text
        copyText.sendKeys(Keys.COMMAND,"c");
        //Paste the data
        //action.keyDown(Keys.CONTROL).sendKeys("a").keyDown(Keys.CONTROL).perform();// press control and paste text
        pasteData.sendKeys(Keys.COMMAND,"v");

        String pasteV = pasteData.getAttribute("value");
        System.out.println("Cpoy Pate data "+pasteV);
  }
  //Double Click
    public static void doubleClick(){

        WebElement copyText =   driver.findElement(By.xpath("//div//div/input[@id='field1']"));
        copyText.clear();
        copyText.sendKeys("Selenium");

        WebElement pasteData =driver.findElement(By.xpath("//div//div/input[@id='field2']"));
        WebElement copytab =driver.findElement(By.xpath("//div//div/button[contains(text(),'Copy Text')]"));
        Actions action = new Actions(driver);
        action.doubleClick(copytab).perform();

        String text ="Both texte are matching";
        System.out.println(text);
        Assert.assertEquals(copyText.getText(),pasteData.getText(), text);

    }

    //Drag And Drop Button
    public static void dragDrop(){
        WebElement dragBtn =driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropBtn =driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions action = new Actions(driver);   // will do actions on the webElements
        action.dragAndDrop(dragBtn,dropBtn).perform(); //Action is an inteface
    }

    //Slider action
    public static void slider() throws InterruptedException {

        WebElement slider =driver.findElement(By.xpath("//div[@id='slider']"));
        JavScriptClass.scrollIntoView(slider);
        System.out.println(slider.getLocation());

        Actions action = new Actions(driver);
        action.dragAndDropBy(slider,90,1089).build().perform();
        System.out.println(slider.getLocation());
        Thread.sleep(3000);

    }

}

