using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeCampCsharp.model
{
    public class Planet
    {
        private WebElement planetElement;

        public Planet(WebElement PlanetElement)
        {
            this.planetElement = PlanetElement;
        }

        public string GetName()
        {
            return planetElement.FindElement(By.ClassName("name")).Text;
        }

        public double GetRadius()
        {
            string text = planetElement.FindElement(By.ClassName("radius")).Text;
            string numberPart = text.Split().Last();
            double num;
            bool validNum = double.TryParse(numberPart, NumberStyles.Any, CultureInfo.InvariantCulture, out num);
            /*            double doubleValue = Convert.ToDouble(text);*/
            /*            return validNum;*/
            if (validNum)
                return num;
            else
                throw new TypeAccessException("wrong type");

        }

        public double GetDistance()
        {
            string Text = planetElement.FindElement(By.ClassName("distance")).Text;
            return double.Parse(Text);
        }

        public void ClickExplore()
        {
            planetElement.FindElement(By.TagName("button")).Click();
        }

    }
}
