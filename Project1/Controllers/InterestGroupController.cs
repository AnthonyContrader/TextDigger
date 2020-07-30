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

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Project1.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class InterestGroupController : ControllerBase
    {
        // GET: api/<InterestGroupController>
        //[HttpGet]

        private readonly Project1Context _context;

        public InterestGroupController(Project1Context context)
        {
            _context = context;
        }
        [Route("/api/v1/[controller]/create")]
        [HttpPost]
        public InterestGroupDto Create([FromBody] dynamic interestGroup)
        {
            InterestGroupDto interestGroupDto = JsonConvert.DeserializeObject<InterestGroupDto>(interestGroup.ToString());

            InterestGroup interestGroups = interestGroupDto.ConvertTo();
            InterestGroupRepository interestGroupRepository = new InterestGroupRepository(_context);
            interestGroups = interestGroupRepository.Insert(interestGroups);
            return InterestGroupDto.ConvertFrom(interestGroups);
        }

        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getusers")]
        [HttpGet]
        public List<InterestGroupDto> GetInterestGroup()
        {
            InterestGroupRepository interestGroupRepository = new InterestGroupRepository(_context);
            var interestGroups = interestGroupRepository.GetAll().AsNoTracking();
            List<InterestGroupDto> interestGroupDto = new List<InterestGroupDto>();
            foreach (var interestGroup in interestGroups)
            {
                interestGroupDto.Add(InterestGroupDto.ConvertFrom(interestGroup));
            }

            return interestGroupDto;
        }

        [Route("/api/v1/[controller]/deleteUser")]
        [HttpDelete]
        public HttpResponseMessage DeleteInterestGroup(int id)
        {
            InterestGroupRepository interestGroupRepository = new InterestGroupRepository(_context);
            interestGroupRepository.Delete(id);

            return new HttpResponseMessage(System.Net.HttpStatusCode.OK);
        }

        //[Route("/api/v1/[controller]/getinterestGroupbylogin")]
        //[HttpPost]
        /*public InterestGroupDto GetInterestGroupById([FromBody] dynamic loginData)
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
