using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
	public class InterestDto
	{
		public int? Id { get; set; }
        public string Interest { get; set; }

        public Interest ConvertTo()
        {
            return new Interest
            {
                Id = this.Id,
                Interest = this.Interest,
            };
        }
        public static InterestDto ConvertFrom(Interest interest)
        {
            return new InterestDto
            {
                Id = interest.Id,
                Interest = interest.Interest,
            };
        }

    }
}
