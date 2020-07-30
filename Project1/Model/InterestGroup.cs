using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class InterestGroup : BaseModel
    {
        public string InterestGroup { get; set; }
		public Interest Interest { get; set; }
        public IList<Subscribe> SubscribePerInterestGroup { get; set; }
    }
}
