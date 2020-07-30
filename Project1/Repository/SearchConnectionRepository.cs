using Project1.Infrastructure;
using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Repository
{
    public class SearchConnectionRepository : BaseRepositoty<SearchConnection>
    {
        public SearchConnectionRepository(Project1Context context) : base(context)
        {

        }
    }
}
