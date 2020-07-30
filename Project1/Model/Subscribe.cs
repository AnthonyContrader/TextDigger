using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Subscribe : BaseModel
    {
        public User User { get; set; }
        public InterestGroup InterestGroup { get; set; }
		
    }
}
