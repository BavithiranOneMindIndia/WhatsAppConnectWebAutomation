package stepdefs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actiondefs.CommonActionFlow;
import actiondefs.ConfigPropertiesFileReader;
import actiondefs.MainActionFlow;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition extends MainActionFlow {

	public WebDriver driver;
	List<String> getlistTextValueinGraphPage;
	List<String> getlistTextValueinMainLabel;
	String SearchedItem;
	String mobileNumber;
	String BaseUrl;
	By graphMultipleValueGetter = By.xpath("//div[@class=\"graph-wrap\"]//ul//li");
	String filename = "Testing.png";
	MainActionFlow MNF = new MainActionFlow();
	CommonActionFlow C = new CommonActionFlow();

	@Given("^Launch chrome browser for Whatsapp web$")
	public void Launch_Chrome_Whatsapp() throws InterruptedException {
		System.out.println("Launching Browser to act whatsapp.............");
		MNF.Launch_Whatsapp_Web();
	}

	@Then("^Open mobile number panel$")
	public void open_Mobile_number_Panel() throws InterruptedException {
		mobileNumber = C.OptionPanel();
		System.out.println(mobileNumber);
		// C.OptionPanel();
	}

	@Then("^Accessing ConfigReaderFile$")
	public void accessing_configReaderFile() {
		ConfigPropertiesFileReader Properties = new ConfigPropertiesFileReader();
		BaseUrl = Properties.getBaseUrl();
		System.out.println(BaseUrl);
	}

	@Then("^Get ClusterId$")
	public void get_clusterId() {
		MNF.getClusterId(BaseUrl, mobileNumber);

	}

	@Then("^Get TemplateData and fileSource Download$")
	public void get_TemplateData() {

		MNF.getTemplateData(BaseUrl, mobileNumber);
	}

	@Then("^Get GroupsData$")
	public void get_GroupsData() {
		MNF.getGroupsData(BaseUrl, mobileNumber);
	}

	@Then("^Whatsappconnect Process$")
	public void Whatsappcpnnect_Process() throws InterruptedException, IOException {

		MNF.enter_whatsappGroupName();
		MNF.clickSearchedGroup();
		MNF.option_Button();
		MNF.clear_message();
		MNF.clear_button();
		MNF.option_Button();
		MNF.group_info_click();
		MNF.get_participantGroup();
		// MNF.text_message_typeSpace();
		// MNF.sendButton();
		MNF.click_Attach();
		MNF.attach_Gallery_Click();
		MNF.UploadFileUsingAutoIt(filename);
		MNF.gallery_image_send();
	}

	@Then("^Get Chat Names$")
	public void Get_Chat_Names() throws InterruptedException {
		MNF.getChatName();
	}

	@Given("^Launch chrome Browser for pricemesh Website$")
	public void i_want_to_write_a_step_with_precondition() throws Exception {

		System.out.println("Launching Browser.............");
		MNF.Launch_Browser();

	}

	@Then("^Assert tile of the website$")
	public void Asser_title_of_the_website() throws Exception {
		MNF.assertTitleOfWebsite();
	}

	@Then("^Check for Main Labels where only one should have multiple selector permission$")
	public void checking_Lable_permission_for_selecting_Option() {
		boolean resultforMultipleSelectorPermission = MNF.MainindicatorsCheck();

		if (resultforMultipleSelectorPermission == true)

		{
			System.out.print("Only one of the main label has multiple selecting permission");
			assertTrue(resultforMultipleSelectorPermission);
		} else {
			System.out.print("Multiple main label has multiple selecting permission");
			assertFalse(resultforMultipleSelectorPermission);
		}

	}

	@Then("^Check whether only the selected main lable items are displayed in graph view$")
	public void Check_whether_only_the_selected_main_lable_items_are_displayed_in_graph_view()
			throws InterruptedException {
		System.out.println("Check In");

		MNF.getMultipleValueViewList();

	}

	@Then("^Change language to \"([^\"]*)\" toggle$")
	public void Changing_Language(String Language) throws InterruptedException {
		if (Language.equalsIgnoreCase("English")) {
			MNF.changeLanguageFromFeatureToEnglish();
		} else if (Language.equalsIgnoreCase("Tamil")) {
			MNF.changeLanguageFromFeatureToTamil();
		}

	}

	@Given("^Click search of \"([^\"]*)\" button$")
	public void Click_Search_Button(String Item) {

		if (Item.equalsIgnoreCase("Commodity")) {
			MNF.ClicksearchCommodity();
		} else if (Item.equalsIgnoreCase("City")) {
			MNF.ClicksearchCity();
		} else if (Item.equalsIgnoreCase("Company")) {
			MNF.ClicksearchCompany();
		} else {

		}
	}

	@Then("^Enter \"([^\"]*)\" value in search field$")
	public void Enter_a_Value_in_the_SearchField(String searchValueText) {
		SearchedItem = searchValueText;
		MNF.searchingTextField(SearchedItem);
	}

	@Then("^Wait for \"([^\"]*)\" seconds$")
	public void Wait_for_n_seconds(int Seconds) throws InterruptedException {

		int ManipulatedSeconds = Seconds * 1000;
		Thread.sleep(ManipulatedSeconds);

	}

	@Then("^Choose searched value$")
	public void Choose_searched_value() {
		MNF.selectedItemClicked(SearchedItem);
	}

	@Then("^Click Submit button$")
	public void Click_Submit_button() throws InterruptedException {
		MNF.SubmitButton();
	}

	@Then("^Click searchField Clear button$")
	public void Click_searchField_Clear_button() throws InterruptedException {
		MNF.clearSearchField();
	}

	@Then("^Scroll to alert Element$")
	public void scroll_to_alert_Element() {
		MNF.getAlertValue();
	}

	@Then("^Changing Context to second position$")
	public void change_context_to_second_position() throws Exception {
		MNF.ChangingContentToSecond();
	}

	@Then("^verify whether all the selected items are deselected$")
	public void verify_Selected_Items_Are_Deselected() {
		MNF.verifyAlltheItemsAreClearedForSelected();

	}

	@Then("^verify whether all the selectedSingle items are deselected$")
	public void verify_SelectedSingle_Items_Are_Deselected() {
		MNF.verifyAlltheItemsAreClearedForSelectedSingle();

	}

	@Then("^Quit from the Website$")
	public void Quit_From_theWebsite() {
		System.out.println("Quitting the Browser..........");
		MNF.QuitBrowser();
	}

}
