using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
    public class LibraryDto
    {

        public int? Id { get; set; }

        public string Name { get; set; }

        public int InterestId { get; set; }

        public Interest Interest { get; set; }


        public Library ConvertTo()
        {
            return new Library
            {
                Id = this.Id,
                Name = this.Name,
                InterestId = this.InterestId
            };
        }

        public static LibraryDto ConvertFrom(Library library)
        {
            return new LibraryDto
            {
                Id = library.Id,
                Name = library.Name,
                InterestId = library.InterestId,
                Interest = library.Interest
            };
        }
    }
}
