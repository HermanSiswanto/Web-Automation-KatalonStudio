package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.testng.Assert

class InventoryPage {
	private static final int DEFAULT_TIMEOUT_SECONDS = 10
	private static final String INVENTORY_TITLE = 'Products'

	// --- Object Locators ---
	private TestObject lblTitle = findTestObject('Object Repository/Inventory/lbl_Title')
	private TestObject dropdownSort = findTestObject('Object Repository/Inventory/dropdown_Sort')
	private TestObject listProductNames = findTestObject('Object Repository/Inventory/lbl_ProductName_All')
	private TestObject listProductPrices = findTestObject('Object Repository/Inventory/lbl_ProductPrice_All')
	private TestObject btnCart = findTestObject('Object Repository/Common/btn_Cart')

	// --- Dynamic Helper Methods ---

	private TestObject getDynamicObject(String objectPath, String itemName) {
		return findTestObject(objectPath, [('item_name') : itemName])
	}

	private boolean isElementPresent(TestObject testObject) {
		return WebUI.findWebElements(testObject, 1).any { WebElement element -> element.isDisplayed() }
	}

	// --- Private Internal Helper Methods ---
	private List<String> getAllProductNames() {
		WebUI.waitForElementVisible(listProductNames, DEFAULT_TIMEOUT_SECONDS)
		return WebUI.findWebElements(listProductNames, DEFAULT_TIMEOUT_SECONDS)
			.collect { WebElement element -> element.getText().trim() }
	}

	private List<BigDecimal> getAllProductPrices() {
		WebUI.waitForElementVisible(listProductPrices, DEFAULT_TIMEOUT_SECONDS)
		return WebUI.findWebElements(listProductPrices, DEFAULT_TIMEOUT_SECONDS)
			.collect { WebElement element -> new BigDecimal(element.getText().replaceAll('[^0-9.]', '')) }
	}

	private void assertSorted(List values, Comparator comparator, String sortDescription) {
		List expectedOrder = new ArrayList(values)
		expectedOrder.sort(comparator)
		Assert.assertEquals(values, expectedOrder,
				"Products are not sorted by ${sortDescription}. Actual order: ${values}")
	}

	// --- Page Actions & Verifications ---

	@Keyword
	void verifyOnInventoryPage() {
		WebUI.waitForElementVisible(lblTitle, DEFAULT_TIMEOUT_SECONDS)
		String actualTitle = WebUI.getText(lblTitle)
		Assert.assertEquals(actualTitle, INVENTORY_TITLE, "Inventory page title does not match expected value!")
	}

	@Keyword
	void addMultipleItemsToCart(List<String> itemNames) {
		itemNames.each { String itemName -> addItemToCartSafely(itemName) }
	}
	
	@Keyword
	void addItemToCartSafely(String itemName) {
		itemName = itemName.trim()
		
		TestObject btnAddToCart = getDynamicObject(
				'Object Repository/Inventory/btn_AddToCart_Dynamic',
				itemName)
	
		TestObject btnRemove = getDynamicObject(
				'Object Repository/Inventory/btn_Remove_Dynamic',
				itemName)
	
		WebUI.waitForElementClickable(btnAddToCart, DEFAULT_TIMEOUT_SECONDS)
		WebUI.click(btnAddToCart)
	
		Assert.assertTrue(
			WebUI.waitForElementVisible(btnRemove, DEFAULT_TIMEOUT_SECONDS),
			"Remove button for '${itemName}' did not appear after adding the product to the cart."
		)
	}

	@Keyword
	void removeItemFromCart(String itemName) {
		itemName = itemName.trim()
		
		TestObject btnRemove = getDynamicObject(
				'Object Repository/Inventory/btn_Remove_Dynamic',
				itemName)

		WebUI.waitForElementClickable(btnRemove, DEFAULT_TIMEOUT_SECONDS)
		WebUI.click(btnRemove)
		Assert.assertFalse(isElementPresent(btnRemove),
				"Product '${itemName}' is still in the cart after removal.")
	}
	
	@Keyword
	void clickCartButton() {
		WebUI.waitForElementClickable(btnCart, DEFAULT_TIMEOUT_SECONDS)
		WebUI.click(btnCart)
		WebUI.waitForElementVisible(
			findTestObject("Object Repository/Cart/lbl_Title"),
			DEFAULT_TIMEOUT_SECONDS
		)
	}
	

	@Keyword
	void verifyProductDetails(String itemName, String expectedPrice, String expectedDesc) {
		TestObject lblPrice = getDynamicObject('Object Repository/Inventory/lbl_ProductPrice_Dynamic', itemName)
		TestObject lblDesc = getDynamicObject('Object Repository/Inventory/lbl_ProductDesc_Dynamic', itemName)

		WebUI.waitForElementVisible(lblPrice, DEFAULT_TIMEOUT_SECONDS)
		WebUI.waitForElementVisible(lblDesc, DEFAULT_TIMEOUT_SECONDS)
		String actualPrice = WebUI.getText(lblPrice)
		String actualDesc = WebUI.getText(lblDesc)

		Assert.assertEquals(actualPrice, expectedPrice, "Price for product '${itemName}' in catalog does not match!")
		Assert.assertEquals(actualDesc, expectedDesc, "Description for product '${itemName}' in catalog does not match!")
	}

	@Keyword
	void verifyProductImageNotBroken(String itemName) {
		TestObject imgObject = getDynamicObject('Object Repository/Inventory/img_Product_Dynamic', itemName)

		WebUI.waitForElementVisible(imgObject, DEFAULT_TIMEOUT_SECONDS)

		Boolean isLoaded = (Boolean) WebUI.executeJavaScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0;",
				[WebUI.findWebElement(imgObject, DEFAULT_TIMEOUT_SECONDS)]
				)

		Assert.assertTrue(isLoaded, "Product image for '${itemName}' in catalog is broken or failed to load!")
	}

	@Keyword
	void selectSortOption(String optionText) {
		WebUI.waitForElementClickable(dropdownSort, DEFAULT_TIMEOUT_SECONDS)
		WebUI.selectOptionByLabel(dropdownSort, optionText, false)
	}

	@Keyword
	void verifyProductsSortedBy(String sortDescription) {
		switch (sortDescription) {
			case 'Name A to Z':
				assertSorted(getAllProductNames(), String.CASE_INSENSITIVE_ORDER, 'name (A-Z)')
				break
			case 'Name Z to A':
				assertSorted(getAllProductNames(), String.CASE_INSENSITIVE_ORDER.reversed(), 'name (Z-A)')
				break
			case 'Price low to high':
				assertSorted(getAllProductPrices(), Comparator.naturalOrder(), 'price (low to high)')
				break
			case 'Price high to low':
				assertSorted(getAllProductPrices(), Comparator.reverseOrder(), 'price (high to low)')
				break
			default:
				Assert.fail("Unsupported sorting verification: '${sortDescription}'")
		}
	}

	@Keyword
	void verifyTotalProductsCount(int expectedCount) {
		WebUI.waitForElementVisible(listProductNames, DEFAULT_TIMEOUT_SECONDS)
		int actualCount = WebUI.findWebElements(listProductNames, DEFAULT_TIMEOUT_SECONDS).size()
		Assert.assertEquals(actualCount, expectedCount, "Total products count in catalog does not match expected value!")
	}
}
