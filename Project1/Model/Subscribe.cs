using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Subscribe : BaseModel
    {

        public int UserId { get; set; }
        public UserItem User { get; set; }

        public int InterestGroupId { get; set; }
        public InterestGroup InterestGroup { get; set; }
		
    }
}
