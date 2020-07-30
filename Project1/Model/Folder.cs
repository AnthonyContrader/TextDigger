using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Folder : BaseModel
    {
        
        public string Name { get; set; }

        public int LibraryId { get; set; }
        public Library Library { get; set; }

        public IList<Document> Documents { get; set; }
    }
}
