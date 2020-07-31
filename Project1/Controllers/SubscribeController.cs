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
    public class SubscribeController
    {
        private readonly Project1Context _context;

        public SubscribeController(Project1Context context)
        {
            _context = context;
        }
        [Route("/api/v1/[controller]/create")]
        [HttpPost]
        public SubscribeDto Create([FromBody] dynamic subscribe)
        {
            SubscribeDto subscribeDto = JsonConvert.DeserializeObject<SubscribeDto>(subscribe.ToString());

            Subscribe subscribes = subscribeDto.ConvertTo();
            SubscribeRepository subscribeRepository = new SubscribeRepository(_context);
            subscribes = subscribeRepository.Insert(subscribes);
            return SubscribeDto.ConvertFrom(subscribes);
        }

        //[Authorize(Roles ="Admin")]
        [Route("/api/v1/[controller]/getsubscribes")]
        [HttpGet]
        public List<SubscribeDto> GetSubscribe()
        {
            SubscribeRepository subscribeRepository = new SubscribeRepository(_context);
            var subscribes = subscribeRepository.GetAll().AsNoTracking();
            List<SubscribeDto> subscribeDto = new List<SubscribeDto>();
            foreach (var subscribe in subscribes)
            {
                subscribeDto.Add(SubscribeDto.ConvertFrom(subscribe));
            }

            return subscribeDto;
        }

        [Route("/api/v1/[controller]/deleteSubscribe")]
        [HttpDelete]
        public HttpResponseMessage DeleteSubscribe(int id)
        {
            SubscribeRepository subscribeRepository = new SubscribeRepository(_context);
            subscribeRepository.Delete(id);

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

