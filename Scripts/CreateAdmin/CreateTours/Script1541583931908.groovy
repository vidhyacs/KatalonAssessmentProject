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

WebUI.click(findTestObject('Tours/a_Tours'))

WebUI.click(findTestObject('Tours/a_Tours (1)'))

WebUI.click(findTestObject('Tours/button_Add'))

WebUI.delay(10)

// Tour details from Intenal Data
def tourdata = findTestData('TourDetails/TourData')

int i = 1

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'tourname']), tourdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'maxadult']), tourdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'adultprice']), tourdata.getValue(i++, 1))

WebUI.click(findTestObject('Tours/clickEnable'))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'maxchild']), tourdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'childprice']), tourdata.getValue(i++, 1))

WebUI.click(findTestObject('Tours/clickStar'))

WebUI.click(findTestObject('Tours/select_star'))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'tourdays']), tourdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fieldData', [('commondata') : 'tournights']), tourdata.getValue(i++, 1))

WebUI.delay(2)

WebUI.click(findTestObject('Tours/tour_type_select'))

WebUI.delay(1)

WebUI.click(findTestObject('Tours/tour_type_insert', [('type') : tourdata.getValue(i++, 1)]))

WebUI.click(findTestObject('Tours/tour_location_click'))

WebUI.setText(findTestObject('Tours/insert_location'), 'Paris')

WebUI.click(findTestObject('Tours/location_click_france'))

WebUI.click(findTestObject('Tours/Inclusion/click_inclusion'))

WebUI.click(findTestObject('Tours/Inclusion/select_all'))

WebUI.delay(2)

WebUI.click(findTestObject('Tours/Inclusion/select_all'))

WebUI.delay(2)

//Inclusion tab data selection
def tourpermission = findTestData('TourPermission/TourPermissionData')

for (def index : (1..tourpermission.getRowNumbers())) {
    WebUI.click(findTestObject('Tours/Inclusion/Select_Inclusion/select_inclusion', [('facility') : tourpermission.getValue(
                    1, index)]))
}

//Exclusion tab data selection
WebUI.click(findTestObject('Tours/Exclusion/click_exclusion'))

WebUI.click(findTestObject('Tours/Exclusion/Selectall_Exclusion'))

WebUI.delay(2)

WebUI.click(findTestObject('Tours/Exclusion/Selectall_Exclusion'))

def tourpermissionexclude = findTestData('ExclusionData/Exclusion_Data')

for (def indexe : (1..tourpermissionexclude.getRowNumbers())) {
    WebUI.click(findTestObject('Tours/Exclusion/Select_Exclusion', [('exclude') : tourpermissionexclude.getValue(1, indexe)]))
}

//Tour Submit
WebUI.click(findTestObject('Tours/Tour_Submit'))

WebUI.callTestCase(findTestCase('CreateAdmin/CreateSupplier'), [:], FailureHandling.STOP_ON_FAILURE)

