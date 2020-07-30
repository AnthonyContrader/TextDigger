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
    public class LibraryController
    {
        private readonly Project1Context _context;

        public LibraryController(Project1Context context)
        {
            _context = context;
        }

        [Route("/api/v1/[controller]/create")]
        [HttpPost]

        public LibraryDto Create([FromBody] dynamic library)
        {
            LibraryDto libraryDto = JsonConvert.DeserializeObject<LibraryDto>(library.ToString());

            Library libraries = libraryDto.ConvertTo();
            LibraryRepository libraryRepository = new LibraryRepository(_context);
            libraries = libraryRepository.Insert(libraries);
            return LibraryDto.ConvertFrom(libraries);
        }


        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getlibraries")]
        [HttpGet]
        public List<LibraryDto> GetLibraries()
        {
            LibraryRepository libraryRepository = new LibraryRepository(_context);
            var libraries = libraryRepository.GetAll().AsNoTracking();
            List<LibraryDto> libraryDtos = new List<LibraryDto>();
            foreach (var library in libraries)
            {
                libraryDtos.Add(LibraryDto.ConvertFrom(library));
            }

            return libraryDtos;
        }

        [Route("/api/v1/[controller]/deleteLibrary")]
        [HttpDelete]
        public HttpResponseMessage DeleteLibrary(int id)
        {
            LibraryRepository libraryRepository = new LibraryRepository(_context);
            libraryRepository.Delete(id);

            return new HttpResponseMessage(System.Net.HttpStatusCode.OK);
        }
    }
}
