using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Library : BaseModel
    {

        public string Name { get; set; }

        public int InterestId { get; set; }

        public Interest Interest { get; set; }

        public IList<Folder> Folders { get; set; }
    }
}