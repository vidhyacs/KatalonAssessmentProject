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

WebUI.delay(5)

WebUI.click(findTestObject('SupplierCreation/a_Accounts'))

WebUI.delay(2)

WebUI.click(findTestObject('SupplierCreation/a_Suppliers'))

WebUI.click(findTestObject('SupplierCreation/button_Add'))

WebUI.delay(2)

def supplierdata = findTestData('Supplier_Details/supplier_details')

int i = 1

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'fname']), supplierdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'lname']), supplierdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'email']), supplierdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'password']), supplierdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'mobile']), supplierdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'address1']), supplierdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'address2']), supplierdata.getValue(i++, 1))

WebUI.click(findTestObject('Login/click_Country'))

WebUI.click(findTestObject('Login/input_Country'))

WebUI.setText(findTestObject('Login/input_Country', [('commoncountry') : 'text']), supplierdata.getValue(i, 1))

WebUI.click(findTestObject('Login/select_Country'))

WebUI.click(findTestObject('SupplierCreation/Assign_Hotel'))

WebUI.click(findTestObject('SupplierCreation/Select_Hotel'))

def dbdata1 = findTestData('Permission/permissiondata')

for (int q = 1; q < 4; q++) {
    for (def index : (1..dbdata1.getRowNumbers())) {
        WebUI.click(findTestObject('Common/Checkbox', [('value') : dbdata1.getValue(q, index)]))
    }
}

WebUI.click(findTestObject('SupplierCreation/Supplier_Submit'))

WebUI.click(findTestObject('Logout/logout'))

