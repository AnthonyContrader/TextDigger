using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;
using Project1.DTO;
using Project1.Infrastructure;
using Project1.Model;
using Project1.Repository;


namespace Project1.Controllers
{
    public class FolderController
    {
        private readonly Project1Context _context;

        public FolderController(Project1Context context)
        {
            _context = context;
        }

        [Route("/api/v1/[controller]/create")]
        [HttpPost]

        public FolderDto Create([FromBody] dynamic folder)
        {
            FolderDto folderDto = JsonConvert.DeserializeObject<FolderDto>(folder.ToString());

            Folder folders = folderDto.ConvertTo();
            FolderRepository folderRepository = new FolderRepository(_context);
            folders = folderRepository.Insert(folders);
            return FolderDto.ConvertFrom(folders);
        }


        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getfolders")]
        [HttpGet]
        public List<FolderDto> GetFolders()
        {
            FolderRepository folderRepository = new FolderRepository(_context);
            var folders = folderRepository.GetAll().AsNoTracking();
            List<FolderDto> folderDtos = new List<FolderDto>();
            foreach (var folder in folders)
            {
                folderDtos.Add(FolderDto.ConvertFrom(folder));
            }

            return folderDtos;
        }

        [Route("/api/v1/[controller]/deleteFolder")]
        [HttpDelete]
        public HttpResponseMessage DeleteFolder(int id)
        {
            FolderRepository folderRepository = new FolderRepository(_context);
            folderRepository.Delete(id);

            return new HttpResponseMessage(System.Net.HttpStatusCode.OK);
        }
    }
}

