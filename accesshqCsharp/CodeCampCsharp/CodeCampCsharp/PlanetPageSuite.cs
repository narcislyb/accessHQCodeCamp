using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CodeCampCsharp.model;
using CodeCampCsharp.Strategyies;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace CodeCampCsharp
{
    [TestClass]
    public class PlanetPageSuite
    {
        public WebDriver driver;

        [TestInitialize]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Manage().Window.FullScreen();
            driver.Url = "https://d18u5zoaatmpxx.cloudfront.net/";
        }

        [TestMethod]
        public void VerifyExploringSaturnByMatching()
        {
            driver.FindElement(By.CssSelector("[aria-label=planets]")).Click();

            var planetPage = new PlanetPage(driver);

            planetPage.ClickExploreByMatching(new RediusMatchingStrategy(58232));
/*            PlanetPage.ClickExplore("Earth");*/

            Assert.AreEqual(expected: "Exploring Saturn", actual: planetPage.GetPopupText());
        }
    }
}
