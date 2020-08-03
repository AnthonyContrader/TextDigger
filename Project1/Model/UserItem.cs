﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Model
{
    public class UserItem : BaseModel
    {
        public string Surname { get; set; }
        public string Name { get; set; }
        public string Login { get; set; }
        public string Password { get; set; }
        public int? Age { get; set; }
        public string Address { get; set; }
        public string Email { get; set; }
        public bool IsAdmin { get; set; } = false;

        public IList<Document> Documents { get; set; }

        public IList<Subscribe> Subscribes { get; set; }
    }
}
