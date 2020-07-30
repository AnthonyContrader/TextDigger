using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class Document : BaseModel
    {

        public string Text { get; set; }

        public int UserItemId { get; set; }
        public UserItem User { get; set; }

        public int FolderId { get; set; }
        public Folder Folder { get; set; }

        public IList<SearchConnection> SearchConnections { get; set; }



    }
}
