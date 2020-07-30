using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class SearchConnection
    {

        public int? Id { get; set; }

        public int TagId { get; set; }

        public Tag Tag { get; set; }

        public int DocumentId { get; set; }

        public Document Document { get; set; }
    }
}
