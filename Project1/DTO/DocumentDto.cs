using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
    public class DocumentDto
    {
        public int? Id { get; set; }
        public string Text { get; set; }

        public int UserItemId { get; set; }
        public UserItem User { get; set; }

        public int FolderId { get; set; }
        public Folder Folder { get; set; }


        public Document ConvertTo()
        {
            return new Document
            {
                Id = this.Id,
                Text = this.Text,
                UserItemId = this.UserItemId,
                User = this.User,
                FolderId = this.FolderId,
                Folder = this.Folder
            };
        }

        public static DocumentDto ConvertFrom(Document document)
        {
            return new DocumentDto
            {
                Id = document.Id,
                Text = document.Text,
                UserItemId = document.UserItemId,
                User = document.User,
                FolderId = document.FolderId,
                Folder = document.Folder
            };
        }
    }
}
