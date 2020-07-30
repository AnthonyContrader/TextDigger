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
    public class TagController
    {

        private readonly Project1Context _context;

        public TagController(Project1Context context)
        {
            _context = context;
        }
        [Route("/api/v1/[controller]/create")]
        [HttpPost]
        public TagDto Create([FromBody] dynamic tag)
        {
            TagDto tagDto = JsonConvert.DeserializeObject<TagDto>(tag.ToString());

            Tag tags = tagDto.ConvertTo();
            TagRepository tagRepository = new TagRepository(_context);
            tags = tagRepository.Insert(tags);
            return TagDto.ConvertFrom(tags);
        }

        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/gettags")]
        [HttpGet]
        public List<TagDto> GetTag()
        {
            TagRepository tagRepository = new TagRepository(_context);
            var tags = tagRepository.GetAll().AsNoTracking();
            List<TagDto> tagDto = new List<TagDto>();
            foreach (var tag in tags)
            {
                tagDto.Add(TagDto.ConvertFrom(tag));
            }

            return tagDto;
        }

        [Route("/api/v1/[controller]/deleteTag")]
        [HttpDelete]
        public HttpResponseMessage DeleteTag(int id)
        {
            TagRepository tagRepository = new TagRepository(_context);
            tagRepository.Delete(id);

            return new HttpResponseMessage(System.Net.HttpStatusCode.OK);
        }

        //[Route("/api/v1/[controller]/getlocalitabylogin")]
        //[HttpPost]
        /*public LocalitaDto GetLocalitaById([FromBody] dynamic loginData)
        {
            dynamic data = loginData;

            string login = data.Login;
            string password = data.Password;

            UserRepository userRepository = new UserRepository(_context);
            UserItem user = userRepository.GetByLogin(login, password);

            UserDto userDto = null;
            if (user != null)
            {
                userDto = UserDto.ConvertFrom(user);
            }

            return userDto;
        }*/

    }
}

