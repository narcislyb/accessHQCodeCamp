using CodeCampCsharp.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeCampCsharp.Strategyies
{
    public class RediusMatchingStrategy : MatchingStrategy
    {
        private double number;
        public RediusMatchingStrategy(double number)
        {
            this.number = number;
        }

        public bool Match(Planet planet)
        {
            return planet.GetRadius().Equals(number);
            throw new NotImplementedException();
        }
    }
}
