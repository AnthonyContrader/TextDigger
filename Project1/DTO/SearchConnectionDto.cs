using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
    public class SearchConnectionDto
    {
        public int? Id { get; set; }

        public int TagId { get; set; }

        public Tag Tag { get; set; }

        public int DocumentId { get; set; }

        public Document Document { get; set; }

        public SearchConnection ConvertTo()
        {
            return new SearchConnection
            {
                Id = this.Id,
                TagId = this.TagId,
                Tag = this.Tag,
                DocumentId = this.DocumentId,
                Document = this.Document
            };
        }

        public static SearchConnectionDto ConvertFrom(SearchConnection searchConnection)
        {
            return new SearchConnectionDto
            {
                Id = searchConnection.Id,
                TagId = searchConnection.TagId,
                Tag = searchConnection.Tag,
                DocumentId = searchConnection.DocumentId,
                Document = searchConnection.Document
            };
        }
    }
}
