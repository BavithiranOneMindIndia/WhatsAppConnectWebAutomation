package actiondefs;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.json.Json;
import javax.json.JsonObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;

public class MainActionFlow {

	public WebDriver driver;
	String title;
	String expectedWebsiteName = "Price Mesh";
	String BaseUrlWhatsapp = "https://web.whatsapp.com/";
	String clusterUrl;
	String cluserId;
	String templateUrl;
	String templateString;
	String getGroups;
	String getGroupString;
	FileSourceViewModel file;
	String groupNameEnter = "Palani";
	String path = System.getProperty("user.dir");
	String fileUploadexePath = path + "\\FileUploadAutoIt\\FileUpload.exe\\";
	String OpenexePath = path + "\\FileUploadAutoIt\\Open.exe";
	String downloadsPath = path + "\\Downloads";

	ApiAccessing ApiAccessing_obj = new ApiAccessing();
	Gson gson = new Gson();
	FileDownloadFlow FileDownload = new FileDownloadFlow();

	List<String> getlistTextValueinGraphPage = new ArrayList<String>();
	List<String> getlistTextValueinMainLabel = new ArrayList<String>();
	List<GroupTemplateViewModel> ListOfGroups;
	List<TemplateViewModel> listOfTemplates;

	List<WebElement> selectedSingleSizeList = new ArrayList<WebElement>();
	List<WebElement> selectedSizeList = new ArrayList<WebElement>();

	List<FileSourceViewModel> allFilesOfFileSource = new ArrayList<FileSourceViewModel>();
	List<TemplateViewModel> allFilesOfTemplate = new ArrayList<TemplateViewModel>();

	boolean isEqual;

	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	public WebElement UserNamePath;

	@FindBy(xpath = "//*[@id=\"submit-btn\"]")
	public WebElement Mc_Next;
	@FindBy(xpath = "//*[@id=\"password\"]")
	public WebElement PasswordPath;
	@FindBy(xpath = "//*[@id=\"submit-btn\"]")
	public WebElement LoginPath;

	By MultipleSelectingVerifyElement = By
			.xpath("//div[@class='ls-wrap']//ul[@class='indicators']//..//ul[@class='selected']");

	By pricemeshSelectedcommodityList = By.xpath("//ul[@class=\"selected\"]//li");
	By graphMultipleValueGetter = By.xpath("//div[@class=\"graph-wrap\"]//ul//li");
	By multipleLableSelectedTextGetter = By
			.xpath("//div[@class='ls-wrap']//ul[@class='indicators']//..//ul[@class='selected']//li");
	By englishClick = By.xpath("//div[@class='left']");
	By tamilClick = By.xpath("//div[@class='right']");
	By submitButton = By.cssSelector(
			"app-time-series:nth-child(2) div.comp-wrap:nth-child(1) div.filter button.submit:nth-child(4) > svg:nth-child(1)");
	By searchForCommodity = By.xpath("//app-limit-select[1]//button[@class=\"search\"]//*[local-name()='svg']");
	By searchForCities = By.xpath("//app-limit-select[2]//button[@class=\"search\"]//*[local-name()='svg']");
	By searchForCompany = By.xpath("//app-limit-select[3]//button[@class=\"search\"]//*[local-name()='svg']");
	By searchTextField = By.xpath("//input[@type='text']");
	By searchClearField = By.cssSelector("button[class='clear']");
	By alertValue = By.xpath("//div[@class='alert']");
	By secondMainItemChangeContext = By.xpath(
			"//body/app-root/app-time-series/div[@class='comp-wrap']/div[@class='filter']/app-limit-select[2]/div[1]/ul[1]");
	By elementForValidationRefreshForSelected = By.xpath("//ul[@class='selected']//li");
	By elementForValidationRefreshForSelectedSingle = By.xpath("//ul[@class='selected single']//li");
	By chatName = By.xpath(
			"//div[@aria-label=\"Chat list. Press right arrow key on a chat to open chat context menu.\"]//div//div//div//div[1]//div[2]//div[1]//div//span[@title]");
	By groupName = By
			.xpath("//div[@aria-label=\"Search results.\"]//div//div//div//div//div[2]//div[1]//div//span[@dir]");

	By panelSide = By.xpath("//div[@id=\'pane-side\']");
	By ScrollUpto = By.xpath("//span[@title=\'DMK4 Anna Nagar 4\']");
	By groupNameSelector = By.xpath("//*[@id=\"side\"]/div[1]/div/label/div/div[2]");
	By textmessageplace = By.xpath("//*[@id=\"main\"]/footer/div[1]/div[2]/div/div[2]");
	By send = By.xpath("//*[@id=\"main\"]/footer/div[1]/div[3]");
	By attachGallery = By.xpath("//span[@data-testid='attach-image']");
	By attach = By.xpath("//span[@data-testid='clip']");
	By gallerySend = By.xpath("//span[@data-testid='send']");
	By optionButton = By.xpath("//div[@id='main']//header//div//div//div//div[@title='Menu']");
	By clearMessage = By.xpath("//div[@title='Clear messages']");
	By groupinfo = By.xpath("//div[@title='Group info']");
	By participantCount = By.xpath(
			"//body/div[@id='app']/div/div/div/div/span/div/span/div/div/div/div[5]/div[1]/div[1]/div[1]/div[1]/span[1]");
	By clearButton = By.xpath("//div[contains(text(),'Clear')]");
	// By commonChatHeaderClick = By.xpath("//*[@id=\"main\"]/header/div[1]");

	public void Launch_Whatsapp_Web() throws InterruptedException {
		System.out.println("Launching Started .......... ");
		// SS.sendMail();

		System.setProperty("webdriver.chrome.driver", "C://ChromeDriver_test//chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(BaseUrlWhatsapp);
		title = driver.getTitle();
		TimeUnit.SECONDS.sleep(3);
		driver.manage().window().maximize();
		TimeUnit.SECONDS.sleep(2);
		System.out.println("Title Of the Website " + title);

		// driver.close();
		// System.out.println("Driver Closed");
	}

	public void enter_whatsappGroupName(String groupName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(groupNameSelector));
		driver.findElement((groupNameSelector)).clear();
		driver.findElement((groupNameSelector)).sendKeys(groupName);

	}

	public void clickSearchedGroup(String groupName) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@role='option']//div//div//div//div//span[@title='" + groupName + "']")));
			driver.findElement(By.xpath("//div[@role='option']//div//div//div//div//span[@title='" + groupName + "']"))
					.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void text_message_typeSpace(String textValue) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(send));
		driver.findElement(textmessageplace).clear();
		driver.findElement(textmessageplace).sendKeys(textValue);

	}

	public void click_Attach() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(attach));
		driver.findElement(attach).click();
	}

	public void attach_Gallery_Click() {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(attachGallery));
		driver.findElement(attachGallery).click();
	}

	public void sendButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(send));

		driver.findElement(send).click();
		TimeUnit.SECONDS.sleep(1);
	}

	public void UploadFileUsingAutoIt(String filename) throws InterruptedException, IOException {
		TimeUnit.SECONDS.sleep(1);
		Runtime.getRuntime().exec(fileUploadexePath + " " + filename);
		// TimeUnit.SECONDS.sleep(1);
		// Runtime.getRuntime().exec("D:\\FileUploadAutoIt\\FileUpload.exe\\" + " " +
		// "Add.png");

		TimeUnit.SECONDS.sleep(1);
		Runtime.getRuntime().exec(OpenexePath);

	}

	public void gallery_image_send() {
		WebDriverWait wait = new WebDriverWait(driver, 5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(gallerySend));

		driver.findElement(gallerySend).click();
	}

	public void option_Button() {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(optionButton));

		driver.findElement(optionButton).click();

	}

	public void clear_message() {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clearMessage));

		driver.findElement(clearMessage).click();
	}

	public void clear_button() {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clearButton));

		driver.findElement(clearButton).click();
	}

	public void group_info_click() {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(groupinfo));

		driver.findElement(groupinfo).click();
	}

	public void get_participantGroup() {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(participantCount));

		String ParticipantValue = driver.findElement(participantCount).getText();
		System.out.println(ParticipantValue);
	}

	public void getClusterId(String BaseUrl, String mobileNumber) {

		clusterUrl = BaseUrl + "/GroupAdmin/getClusterId/" + mobileNumber;
		cluserId = ApiAccessing_obj.apiGetProcessing(clusterUrl);
		System.out.println("ClusterId" + " = " + cluserId);

	}

	public void getTemplateData(String BaseUrl, String mobileNumber) {

		String templateUrl = BaseUrl + "/Template/getByMobileNumber/" + mobileNumber;
		String templateString = ApiAccessing_obj.apiGetProcessing(templateUrl);
		System.out.println("templateString" + " = " + templateString);

		listOfTemplates = gson.fromJson(templateString, new TypeToken<List<TemplateViewModel>>() {
		}.getType());

		for (TemplateViewModel templateViewModel : listOfTemplates) {

			allFilesOfTemplate.add(templateViewModel);
			for (FileSourceViewModel filesoruce : templateViewModel.fileSourceViewModels) {
				allFilesOfFileSource.add(filesoruce);
			}
		}

		for (int i = allFilesOfFileSource.size(); i > 0; i--) {
			file = allFilesOfFileSource.get(i - 1);

			try {
				FileDownload.downloadFile(file.blobUrl, downloadsPath);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}

	}

	public void getGroupsData(String BaseUrl, String mobileNumber) {
		String getGroups = BaseUrl + "/Group/getGroupsByMobileNumber/" + mobileNumber;
		String getGroupString = ApiAccessing_obj.apiGetProcessing(getGroups);
		System.out.println("getGroups" + " = " + getGroupString);

		ListOfGroups = gson.fromJson(getGroupString, new TypeToken<List<GroupTemplateViewModel>>() {
		}.getType());
	}

	public void sendMessage(String BaseUrlMain, String mobileNumber) throws InterruptedException, IOException {

		for (GroupTemplateViewModel groupModel : ListOfGroups) {

			try {
				System.out.println(groupModel.name);
				enter_whatsappGroupName(groupModel.name);

			} catch (Exception e) {
				enter_whatsappGroupName(groupModel.name);
			}
			clickSearchedGroup(groupModel.name);

			option_Button();
			clear_message();
			clear_button();
			option_Button();
			group_info_click();
			get_participantGroup();

			for (int templateId : groupModel.templates) {

				TemplateViewModel templateModel = GetTemplateById(listOfTemplates, templateId);
				// Text message send ...
				if (templateModel.messageType == 0) {
					text_message_typeSpace(templateModel.text);

					sendButton();

					Thread.sleep(1000);
					String payloadJsonString = jsonObject(groupModel.id, templateId, templateModel.clusterId,
							mobileNumber);
					System.out.println(payloadJsonString);
					ApiAccessing_obj.apiPostProcessing(BaseUrlMain, payloadJsonString);

					// SendingTextResource_obj.NavigateBackFormChat(driver);
					// Thread.sleep(1000);
					// Image and video send....
				}

				else {

					for (FileSourceViewModel fileSourceMain : templateModel.fileSourceViewModels) {
						// Audio File send ....
						System.out.println(fileSourceMain.fileType);

						System.out.println("Click_attach");
						click_Attach();
						System.out.println("Click_Gallery_attach");
						attach_Gallery_Click();

						for (FileSourceViewModel file : templateModel.fileSourceViewModels) {
							UploadFileUsingAutoIt(file.fileName);

							gallery_image_send();

							String payloadJsonString = jsonObject(groupModel.id, templateId, templateModel.clusterId,
									mobileNumber);
							System.out.println(payloadJsonString);
							ApiAccessing_obj.apiPostProcessing(BaseUrlMain, payloadJsonString);
							Thread.sleep(1000);

						}

					}

				}

			}

		}
	}

	private TemplateViewModel GetTemplateById(List<TemplateViewModel> listOfTemplates, int id) {

		for (TemplateViewModel temp : listOfTemplates) {

			if (temp.id == id) {
				return temp;
			}
		}
		return null;
	}

	public String jsonObject(int groupId, int templateMessageId, String clusterId, String mobileNumber) {
		JsonObject empJsonObject = Json.createObjectBuilder().add("groupId", groupId)
				.add("templateMessageId", templateMessageId).add("clusterId", clusterId)
				.add("mobileNumber", mobileNumber).build();
		return empJsonObject.toString();

	}

	// End

	public void getChatName() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", ScrollUpto);

		WebElement searchPoint = driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/label/div/div[2]"));
		searchPoint.click();
		TimeUnit.SECONDS.sleep(2);

		WebElement filter = driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/span/button"));
		filter.click();
		TimeUnit.SECONDS.sleep(2);

		WebElement groupOption = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[4]/div/ul/li[2]/div/div"));
		groupOption.click();
		TimeUnit.SECONDS.sleep(2);

		// This will scroll down the page by 1000 pixel vertical
		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		TimeUnit.SECONDS.sleep(20);
		List<WebElement> ChatNames = driver.findElements(groupName);
		// WebElement commonChatHeaderClickElement =
		// driver.findElement(commonChatHeaderClick);

		for (WebElement chat : ChatNames) {
			// chat.getText();
			// chat.click();
			// TimeUnit.SECONDS.sleep(2);
			// commonChatHeaderClickElement.click();
			// TimeUnit.SECONDS.sleep(2);
			System.out.println(chat.getText());
		}

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		// JavascriptExecutor js2 = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,350)", "");
	}

	public void Launch_Browser() throws InterruptedException {

		System.out.println("Launching Started .......... ");
		// SS.sendMail();

		System.setProperty("webdriver.chrome.driver", "C://ChromeDriver_test//chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(BaseUrlWhatsapp);
		title = driver.getTitle();
		TimeUnit.SECONDS.sleep(3);
		driver.manage().window().maximize();
		TimeUnit.SECONDS.sleep(5);

		System.out.println("Title Of the Website " + title);

		TimeUnit.SECONDS.sleep(5);
		// driver.close();
		// System.out.println("Driver Closed");

	}

	public void ChangingContentToSecond() throws Exception {
		driver.findElement(secondMainItemChangeContext).click();
		Thread.sleep(2000);
	}

	public void verifyAlltheItemsAreClearedForSelectedSingle() {

		selectedSingleSizeList = driver.findElements(elementForValidationRefreshForSelectedSingle);
		System.out.println(selectedSingleSizeList.size());

		assertEquals("Verifying SelectedSingle assertion", 0, selectedSingleSizeList.size());

	}

	public void verifyAlltheItemsAreClearedForSelected() {

		selectedSizeList = driver.findElements(elementForValidationRefreshForSelected);
		System.out.println(selectedSizeList.size());

		assertEquals("Verifying Selected assertion", 0, selectedSizeList.size());

	}

	public void assertTitleOfWebsite() {

		assertEquals("Verifying websites title", expectedWebsiteName, title);
	}

	public boolean MainindicatorsCheck() {

		List<WebElement> MultipleSelectorMainElementList = driver.findElements(MultipleSelectingVerifyElement);
		int sizeofMultipleElementSelector = MultipleSelectorMainElementList.size();

		if (sizeofMultipleElementSelector == 1) {
			System.out.println("Only one label has multiple selecting permission ");
			return true;
		} else {
			System.out.println("Multiple label has multiple selecting permission ");
			return false;
		}

	}

	public void getMultipleValueViewList() throws InterruptedException {

		System.out.println("Starting after CheckIN");
		// EnglishLangClick();
		List<WebElement> ListValueinMainLabel = driver.findElements(multipleLableSelectedTextGetter);
		System.out.println("List taken for MainLabel");
		System.out.println("ListValueinMainLabel" + " = " + ListValueinMainLabel.size());
		Iterator<WebElement> iter1 = ListValueinMainLabel.iterator();
		while (iter1.hasNext()) {

			String we1 = iter1.next().getText();
			System.out.println(we1);
			getlistTextValueinMainLabel.add(we1);

		}

		Thread.sleep(2000);

		List<WebElement> ListValueinGraph = driver.findElements(graphMultipleValueGetter);
		System.out.println("List taken for GraphView");
		System.out.println("ListValueinGraph" + " = " + ListValueinGraph.size());
		Iterator<WebElement> iter2 = ListValueinGraph.iterator();
		while (iter2.hasNext()) {

			String we2 = iter2.next().getText();
			System.out.println(we2);
			getlistTextValueinGraphPage.add(we2);

		}

		try {
			boolean isEqual = getlistTextValueinMainLabel.equals(getlistTextValueinGraphPage); // false
			System.out.println(isEqual);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void changeLanguageFromFeatureToEnglish() throws InterruptedException {
		System.out.println("Eng Click");
		EnglishLangClick();
		Thread.sleep(5000);
	}

	public void changeLanguageFromFeatureToTamil() throws InterruptedException {
		TamilLangClick();
		Thread.sleep(5000);
	}

	public void SubmitButton() throws InterruptedException {
		driver.findElement(submitButton).click();
		Thread.sleep(5000);

		WebElement svgObj = driver.findElement(submitButton);
		Actions actionBuilder = new Actions(driver);
		actionBuilder.click(svgObj).build().perform();
	}

	void EnglishLangClick() throws InterruptedException {
		driver.findElement(englishClick).click();
		Thread.sleep(5000);
	}

	void TamilLangClick() throws InterruptedException {
		driver.findElement(tamilClick).click();
		Thread.sleep(5000);
	}

	public void ClicksearchCommodity() {

		driver.findElement(searchForCommodity).click();

	}

	public void ClicksearchCity() {

		driver.findElement(searchForCities).click();
	}

	public void ClicksearchCompany() {

		driver.findElement(searchForCompany).click();

	}

	public void searchingTextField(String textFieldValue) {
		driver.findElement(searchTextField).sendKeys(textFieldValue);
	}

	public void selectedItemClicked(String searchedSelectedValue) {
		driver.findElement(By.xpath("//li[normalize-space()='" + searchedSelectedValue + "']")).click();
	}

	public void clearSearchField() throws InterruptedException {
		driver.findElement(searchClearField).click();
		Thread.sleep(1000);
	}

	public void getAlertValue() {

		Actions actions = new Actions(driver);

		actions.moveToElement(driver.findElement(alertValue));
		System.out.println("Scrolling");
		actions.perform();

		System.out.println(driver.findElement(alertValue).getText());
	}

	public void QuitBrowser() {
		driver.close();
	}

}
