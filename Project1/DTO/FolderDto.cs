using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
    public class FolderDto
    {
        public int? Id { get; set; }
        public string Name { get; set; }

        public int LibraryId { get; set; }
        public Library Library { get; set; }

        public Folder ConvertTo()
        {
            return new Folder
            {
                Id = this.Id,
                Name = this.Name,
                LibraryId = this.LibraryId,
                Library = this.Library
            };
        }

        public static FolderDto ConvertFrom(Folder folder)
        {
            return new FolderDto
            {
                Id = folder.Id,
                Name = folder.Name,
                LibraryId = folder.LibraryId,
                Library = folder.Library
            };
        }
    }
}
