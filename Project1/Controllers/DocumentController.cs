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
    public class DocumentController
    {
        private readonly Project1Context _context;

        public DocumentController(Project1Context context)
        {
            _context = context;
        }
        [Route("/api/v1/[controller]/create")]
        [HttpPost]

        public DocumentDto Create([FromBody] dynamic document)
        {
            DocumentDto documentDto = JsonConvert.DeserializeObject<DocumentDto>(document.ToString());

            Document documents = documentDto.ConvertTo();
            DocumentRepository documentRepository = new DocumentRepository(_context);
            documents = documentRepository.Insert(documents);
            return DocumentDto.ConvertFrom(documents);
        }


        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getdocuments")]
        [HttpGet]
        public List<DocumentDto> GetDocuments()
        {
            DocumentRepository documentRepository = new DocumentRepository(_context);
            var documents = documentRepository.GetAll().AsNoTracking();
            List<DocumentDto> documentDtos = new List<DocumentDto>();
            foreach (var document in documents)
            {
                documentDtos.Add(DocumentDto.ConvertFrom(document));
            }

            return documentDtos;
        }

        [Route("/api/v1/[controller]/deleteDocument")]
        [HttpDelete]
        public HttpResponseMessage DeleteDocument(int id)
        {
            DocumentRepository documentRepository = new DocumentRepository(_context);
            documentRepository.Delete(id);

            return new HttpResponseMessage(System.Net.HttpStatusCode.OK);
        }
    }
}
