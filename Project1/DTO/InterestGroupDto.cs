using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
	public class InterestGroupDto
	{
		public int? Id { get; set; }
		public string InterestGroupString { get; set; }
        public int InterestId { get; set; }
        public Interest Interest { get; set; }

        public InterestGroup ConvertTo()
        {
            return new InterestGroup
            {
                Id = this.Id,
                InterestGroupString = this.InterestGroupString,
                InterestId = this.InterestId,
                Interest = this.Interest
            };
        }
        public static InterestGroupDto ConvertFrom(InterestGroup interestGroup)
        {
            return new InterestGroupDto
            {
                Id = interestGroup.Id,
                InterestGroupString = interestGroup.InterestGroupString,
                InterestId = interestGroup.InterestId,
                Interest = interestGroup.Interest,
            };
        }
    }
}
