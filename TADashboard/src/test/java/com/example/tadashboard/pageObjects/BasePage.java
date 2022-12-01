package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.dataObjects.GlobalSettingSubMenu;
import com.example.tadashboard.dataObjects.HeadMenuTab;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    private final By header = By.id("header");
    private final By mnuMainMenu = By.id("main-menu");
    private final By mnuGlobalSettingMenu = By.xpath("//li[@class='mn-setting']");
    private final By btnChoosePanel = By.id("btnChoosepanel");
    private final By divChoosePanels = By.cssSelector(".ccpanels");
    private final By btnCreateNewPanel = By.xpath("//div[@class='cpbutton']//span[.='Create new panel']");
    private final By tabOverview = By.xpath("//a[.='Overview']");
    private final By tabExecutionDashboard = By.xpath("//a[.='Execution Dashboard']");
    private final By popupPage = By.id("div_popup");
    private final By popupPanel = By.xpath("//div[@class='ui-dialog editpanelDlg']");
    private final By txtPopupPanelDisplayName = By.id("txtDisplayName");
    private final By ddlPopupPanelChartType = By.id("cbbChartType");
    private final By ddlPopupPanelCategory = By.id("cbbCategoryField");
    private final By ddlPopupPanelSeries = By.id("cbbSeriesField");
    private final By txtPopupPanelCaptionCategory = By.id("txtCategoryXAxis");
    private final By txtPopupPanelCaptionValue = By.id("txtValueYAxis");
    private final By btnPopupPanelOk = By.id("OK");
    private final By btnPopupPanelCancel = By.id("Cancel");
    private final By txtPopupPageName = By.id("name");
    private final By ddlPopupPageParentPage = By.id("parent");
    private final By ddlPopupPageNumOfCol = By.id("columnnumber");
    private final By ddlPopupPageAfterPage = By.id("afterpage");
    private final By chkPopupPagePublic = By.id("ispublic");
    private final By btnPopupPageOk = By.id("OK");
    private final By btnPopupPageCancel = By.id("Cancel");
    private final String headMenuTabXPath = "//ul[@class='head-menu']//a[contains(text(), '%s')]";
    private final String subMnuAdministerXPath = "//..//a[.='%s']";
    private final String pageXPath = "//a[contains(text(),'%s')]";
    private final String globalSettingMenuTabXPath = " //a[.='%s']";

    protected WebElement getHeader() {
        return DriverManager.findElement(header);
    }

    protected WebElement getMnuMainMenu() {
        return DriverManager.findElement(mnuMainMenu);
    }

    protected WebElement getMnuGlobalSettingMenu() {
        return getMnuMainMenu().findElement(mnuGlobalSettingMenu);
    }

    protected WebElement getTabOverview() {
        return getMnuMainMenu().findElement(tabOverview);
    }

    protected WebElement getTabExecutionDashboard() {
        return getMnuMainMenu().findElement(tabExecutionDashboard);
    }

    protected WebElement getHeadMenuTab(HeadMenuTab tab) {
        return getHeader().findElement(By.xpath(String.format(headMenuTabXPath, tab.getTab())));
    }

    protected WebElement getSubMnuAdminister(HeadMenuTab subTab) {
        return getHeadMenuTab(HeadMenuTab.ADMINISTER).findElement(By.xpath(String.format(subMnuAdministerXPath, subTab.getTab())));
    }

    protected WebElement getPopupPanel() {
        return DriverManager.findElement(popupPanel);
    }

    protected WebElement getTxtPopupPanelDisplayName() {
        return getPopupPanel().findElement(txtPopupPanelDisplayName);
    }

    protected Select getDdlPopupPanelChartType() {
        return new Select(getPopupPanel().findElement(ddlPopupPanelChartType));
    }

    protected Select getDdlPopupPanelCategory() {
        return new Select(getPopupPanel().findElement(ddlPopupPanelCategory));
    }

    protected Select getDdlPopupPanelSeries() {
        return new Select(getPopupPanel().findElement(ddlPopupPanelSeries));
    }

    protected WebElement getTxtPopupPanelCaptionCategory() {
        return getPopupPanel().findElement(txtPopupPanelCaptionCategory);
    }

    protected WebElement getTxtPopupPanelCaptionValue() {
        return getPopupPanel().findElement(txtPopupPanelCaptionValue);
    }

    protected WebElement getBtnPopupPanelOk() {
        return getPopupPanel().findElement(btnPopupPanelOk);
    }

    protected WebElement getBtnPopupPanelCancel() {
        return getPopupPanel().findElement(btnPopupPanelCancel);
    }

    public void sendKeyTxtPopupPanelDisplayName(String name) {
        getTxtPopupPanelDisplayName().sendKeys(name);
    }

    public void selectOptDdlPopupPanelChartType(String option) {
        getDdlPopupPanelChartType().selectByValue(option);
    }

    public void selectOtpPopupPanelSeries(String option) {
        getDdlPopupPanelSeries().selectByValue(option);
    }

    public Boolean isDdlPopupPanelCategoryEnabled() {
        return getDdlPopupPanelCategory().getWrappedElement().isEnabled();
    }

    public Boolean isDdlPopupPanelSeriesEnabled() {
        return getDdlPopupPanelSeries().getWrappedElement().isEnabled();
    }

    public Boolean isTxtPopupPanelCaptionCategoryEnabled() {
        return getTxtPopupPanelCaptionCategory().isEnabled();
    }

    public Boolean isTxtPopupPanelCaptionValueEnabled() {
        return getTxtPopupPanelCaptionValue().isEnabled();
    }

    public void clickBtnPopupPanelOk() {
        getBtnPopupPanelOk().click();
    }

    public void clickTabOverview() {
        getTabOverview().click();
    }

    public Boolean isTabOverviewClickable() {
        try {
            clickTabOverview();
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }

    public void clickTabExecutionDashboard() {
        getTabExecutionDashboard().click();
    }

    public Boolean isTabExecutionDashboardClickable() {
        try {
            clickTabExecutionDashboard();
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }


    public Boolean isHeadMenuTabClickable(HeadMenuTab tab) {
        try {
            clickHeadMenuTab(tab);
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }


    public void clickSubMnuAdminister(HeadMenuTab subTab) {
        hoverHeadMenuTab(HeadMenuTab.ADMINISTER);
        getSubMnuAdminister(subTab).click();
    }

    protected WebElement getPageTab(String page) {
        page = page.replaceAll("\\s+", " ");
        return getMnuMainMenu().findElement(By.xpath(String.format(pageXPath, page)));
    }

    protected WebElement getChildPage(String parentPage, String childPage) {
        hoverPageTab(parentPage);
        childPage = childPage.replaceAll("\\s+", " ");
        return getPageTab(parentPage).findElement(By.xpath("//.." + String.format(pageXPath, childPage)));
    }

    protected WebElement getFirstChildPage(String parentPage) {
        hoverPageTab(parentPage);
        return getPageTab(parentPage).findElement(By.xpath("//..//li/a"));
    }

    public Boolean isChildPageAdded(String parentPage, String childPage) {
        try {
            hoverPageTab(parentPage);
            getChildPage(parentPage, childPage);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void hoverPageTab(String page) {
        DriverManager.moveToElement(getPageTab(page));
    }

    public void clickPageTab(String page) {
        getPageTab(page).click();
    }

    protected WebElement getPopupPage() {
        return DriverManager.findElement(popupPage);
    }

    protected WebElement getTxtPopupPageName() {
        return getPopupPage().findElement(txtPopupPageName);
    }

    protected Select getDdlPopupPageParentPage() {
        return new Select(getPopupPage().findElement(ddlPopupPageParentPage));
    }

    protected Select getDdlPopupPageNumOfCol() {
        return new Select(getPopupPage().findElement(ddlPopupPageNumOfCol));
    }

    protected Select getDdlPopupPageAfterPage() {
        return new Select(getPopupPage().findElement(ddlPopupPageAfterPage));
    }

    protected WebElement getChkPopupPagePublic() {
        return getPopupPage().findElement(chkPopupPagePublic);
    }

    protected WebElement getBtnPopupPageOk() {
        return getPopupPage().findElement(btnPopupPageOk);
    }

    protected WebElement getBtnPopupPageCancel() {
        return getPopupPage().findElement(btnPopupPageCancel);
    }

    public void clickHeadMenuTab(HeadMenuTab tab) {
        hoverHeadMenuTab(tab);
        getHeadMenuTab(tab).click();
    }

    public void hoverHeadMenuTab(HeadMenuTab tab) {
        DriverManager.moveToElement(getHeadMenuTab(tab));
    }

    protected WebElement getGlobalSettingMenuTab(GlobalSettingSubMenu tab) {
        return getMnuGlobalSettingMenu().findElement(By.xpath(String.format(globalSettingMenuTabXPath, tab.getTab())));
    }

    public void clickGlobalSettingMenuTab(GlobalSettingSubMenu tab) {
        hoverMnuGlobalSettingMenu();
        getGlobalSettingMenuTab(tab).click();
    }

    public void hoverMnuGlobalSettingMenu() {
        DriverManager.moveToElement(getMnuGlobalSettingMenu());
    }

    public void addNewPage(String name, String parentPage, int numOfCol, String displayAfterPage, boolean isPublic) throws InterruptedException {
        sendKeyToTxtPopupPageName(name);
        selectForDdlPopupPageParentPage(parentPage);
        getDdlPopupPageNumOfCol().selectByVisibleText(String.valueOf(numOfCol));
        selectForDdlPopupPageAfterPage(displayAfterPage);
        if(getChkPopupPagePublic().isSelected() != isPublic)
            getChkPopupPagePublic().click();
        clickBtnPopupPageOk();
    }

    public void sendKeyToTxtPopupPageName(String name) {
        getTxtPopupPageName().sendKeys(name);
    }

    public void selectForDdlPopupPageParentPage(String parentPage) {
        getDdlPopupPageParentPage().selectByVisibleText(parentPage);
    }

    public void selectForDdlPopupPageAfterPage(String displayAfterPage) {
        getDdlPopupPageAfterPage().selectByVisibleText(displayAfterPage);
    }

    public void clickBtnPopupPageOk() throws InterruptedException {
        getBtnPopupPageOk().click();
        Thread.sleep(500);
    }

    public void clickBtnPopupPageCancel() {
        getBtnPopupPageCancel().click();
    }

    public void deletePage(String page) throws InterruptedException {
        Thread.sleep(500);
        clickPageTab(page);
        clickGlobalSettingMenuTab(GlobalSettingSubMenu.DELETE);
        DriverManager.acceptAlert();
    }

    public void deleteChildPage(String parentPage, String childPage) throws InterruptedException {
        Thread.sleep(500);
        getChildPage(parentPage, childPage).click();
        clickGlobalSettingMenuTab(GlobalSettingSubMenu.DELETE);
        DriverManager.acceptAlert();
    }
}
