using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace CodeCampCsharp
{
    [TestClass]
    public class HomePageSuite
    {
        private WebDriver driver;

        [TestInitialize]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Manage().Window.FullScreen();
            driver.Url = "https://d18u5zoaatmpxx.cloudfront.net/";
        }

        [TestMethod]
        public void TestSubmitButton()
        {
            driver.FindElement(By.Id("forename")).SendKeys("YB");
            driver.FindElement(By.Id("submit")).Click();

            var PopupElement = driver.FindElement(By.ClassName("popup-message"));
            new WebDriverWait(driver, TimeSpan.FromSeconds(15)).Until(d => d.FindElement(By.ClassName("popup-message")).Displayed);

            Assert.AreEqual(expected: "Hello YB", actual: PopupElement.Text);
        }
    }
}