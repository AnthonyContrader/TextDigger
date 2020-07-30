using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Tag : BaseModel
    {
        public string Tag { get; set; }
        public IList<SearchConnection> SearchConnectionPerTag { get; set; }

    }
}
