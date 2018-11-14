import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('CreateAdmin/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.click(findTestObject('Login/a_Accounts'))

WebUI.click(findTestObject('Login/a_Admins'))

WebUI.click(findTestObject('Login/button_Add'))

// Get new user creation data from DB

def dbdata = findTestData('UserDetails/UserData')

int i = 1

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'fname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'lname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'email']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'password']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'mobile']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'address1']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'address2']), dbdata.getValue(i++, 1))

WebUI.click(findTestObject('Login/click_Country'))

WebUI.click(findTestObject('Login/input_Country'))

WebUI.setText(findTestObject('Login/input_Country', [('commoncountry') : 'text']), dbdata.getValue(i, 1))

WebUI.click(findTestObject('Login/select_Country'))

def dbdata1 = findTestData('Permission/permissiondata')

for(int q=1;q<4;q++){
	
	for (def index : (1..dbdata1.getRowNumbers())) {
	
	WebUI.click(findTestObject('Common/Checkbox', [('value') : dbdata1.getValue(q,index)]))
	}
	}
	
WebUI.click(findTestObject('Login/submit_button'))

WebUI.click(findTestObject('Logout/logout'))

WebUI.delay(5)

//Login using new admin user credentials

WebUI.setText(findTestObject('Login/input_email'), 'asd@asd1.asd')

WebUI.setText(findTestObject('Login/input_password'), 'inapp2.0')

WebUI.delay(5)

WebUI.click(findTestObject('Login/span_Login'))

//Navigate to tour creation page

WebUI.callTestCase(findTestCase('CreateAdmin/CreateTours'), [:], FailureHandling.STOP_ON_FAILURE)

