using CodeCampCsharp.Strategyies;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeCampCsharp.model
{
    public class PlanetPage
    {
        private WebDriver driver;

        public PlanetPage(WebDriver webDriver)
        {
            this.driver = webDriver;

        }

        public WebElement GetPopupMessage()
        {
            return (WebElement)driver.FindElement(By.ClassName("popup-message"));
        }

        public String GetPopupText()
        {
            return GetPopupMessage().Text;
        }
        public void ClickExploreByMatching(MatchingStrategy strategy)
        {
            foreach (Planet planet in GetPlanets())
            {
                if (strategy.Match(planet))
                {
                    planet.ClickExplore();
                    WaitForPopupMessage();
                    break;
                }
            }
        }

        public List<Planet> GetPlanets()
        {
            List<Planet> planets = new List<Planet>();
            foreach (WebElement planet in driver.FindElements(By.ClassName("planet")))
            {
                planets.Add(new Planet(planet));
            }
            return planets;
        }

        public void WaitForPopupMessage()
        {
            var popupElement = driver.FindElement(By.ClassName("popup-message"));
            new WebDriverWait(driver, TimeSpan.FromSeconds(15)).Until(d => d.FindElement(By.ClassName("popup-message")).Displayed);
        }
    }
}
