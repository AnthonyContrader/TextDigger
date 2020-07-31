using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Interest : BaseModel
    {
    public string InterestString { get; set; }
    public IList<InterestGroup> InterestGroupPerInterest { get; set; }
    
    public IList<Library> Libraries { get; set; }
    }
}
