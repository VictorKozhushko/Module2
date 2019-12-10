package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinHomePage {

    private static final String HOMEPAGE_ULR = "http://www.pastebin.com";
    private static final String CODE = "git config --global user.name  \"New Sheriff in Town\" \n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String TITLE = "how to gain dominance among developers";
    private WebDriver driver;

    @FindBy(id = "paste_code")
    private WebElement insertCode;

    @FindBy(xpath = "//span[contains(@id,'select2-paste_expire_date')]")
    private WebElement expireDate;

    @FindBy(xpath = "//li[contains(@id,'10M')]")
    private WebElement expiration10Minutes;

    @FindBy(xpath = "//span[contains(@id,'select2-paste_format')]")
    private WebElement syntaxHilighting;

    @FindBy(xpath = "//li[contains(@id,'-8')]")
    private WebElement getSyntaxHilightingBash;

    @FindBy(xpath = "//input[@name='paste_name']")
    private WebElement nameTitle;

    public PasteBinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinHomePage openPage() {
        driver.get(HOMEPAGE_ULR);
        new WebDriverWait(driver, 10);
//                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public PasteBinHomePage fillOutForm() {
        insertCode.sendKeys(CODE);
        expireDate.click();
        expiration10Minutes.click();
        syntaxHilighting.click();
        getSyntaxHilightingBash.click();
        nameTitle.sendKeys(TITLE);
        return this;
    }

}
