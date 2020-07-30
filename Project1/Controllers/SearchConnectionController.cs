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
    public class SearchConnectionController
    {
        private readonly Project1Context _context;

        public SearchConnectionController(Project1Context context)
        {
            _context = context;
        }

        [Route("/api/v1/[controller]/create")]
        [HttpPost]

        public SearchConnectionDto Create([FromBody] dynamic searchconnection)
        {
            SearchConnectionDto searchConnectionDto = JsonConvert.DeserializeObject<LibraryDto>(searchconnection.ToString());

            SearchConnection searchConnections = searchConnectionDto.ConvertTo();
            SearchConnectionRepository searchConnectionRepository = new SearchConnectionRepository(_context);
            searchConnections = searchConnectionRepository.Insert(searchConnections);
            return SearchConnectionDto.ConvertFrom(searchConnections);
        }


        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getsearchconnection")]
        [HttpGet]
        public List<SearchConnectionDto> GetSearchConnections()
        {
            SearchConnectionRepository searchConnectionRepository = new SearchConnectionRepository(_context);
            var searchconnections = searchConnectionRepository.GetAll().AsNoTracking();
            List<SearchConnectionDto> searchConnectionDtos = new List<SearchConnectionDto>();
            foreach (var searchconnection in searchconnections)
            {
                searchConnectionDtos.Add(SearchConnectionDto.ConvertFrom(searchconnection));
            }

            return searchConnectionDtos;
        }

        [Route("/api/v1/[controller]/deleteSearchConnection")]
        [HttpDelete]
        public HttpResponseMessage DeleteSearchConnection(int id)
        {
            SearchConnectionRepository searchConnectionRepository = new SearchConnectionRepository(_context);
            searchConnectionRepository.Delete(id);

            return new HttpResponseMessage(System.Net.HttpStatusCode.OK);
        }
    }
}
