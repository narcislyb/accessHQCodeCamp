using CodeCampCsharp.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeCampCsharp.Strategyies
{
    public interface MatchingStrategy
    {
        public Boolean Match(Planet planet);
    }
}
