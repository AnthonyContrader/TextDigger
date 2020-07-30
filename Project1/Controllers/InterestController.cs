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
    public class InterestController
    {

        private readonly Project1Context _context;

        public InterestController(Project1Context context)
        {
            _context = context;
        }
        [Route("/api/v1/[controller]/create")]
        [HttpPost]
        public InterestDto Create([FromBody] dynamic interest)
        {
            InterestDto interestDto = JsonConvert.DeserializeObject<InterestDto>(interest.ToString());

            Interest interests = interestDto.ConvertTo();
            InterestRepository interestRepository = new InterestRepository(_context);
            interests = interestRepository.Insert(interests);
            return InterestDto.ConvertFrom(interests);
        }

        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getinterests")]
        [HttpGet]
        public List<InterestDto> GetInterest()
        {
            InterestRepository interestRepository = new InterestRepository(_context);
            var interests = interestRepository.GetAll().AsNoTracking();
            List<InterestDto> interestDto = new List<InterestDto>();
            foreach (var interest in interests)
            {
                interestDto.Add(InterestDto.ConvertFrom(interest));
            }

            return interestDto;
        }

        [Route("/api/v1/[controller]/deleteInterest")]
        [HttpDelete]
        public HttpResponseMessage DeleteInterest(int id)
        {
            InterestRepository interestRepository = new InterestRepository(_context);
            interestRepository.Delete(id);

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

