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
		public string InterestGroup { get; set; }
        public int InterestId { get; set; }
        public Interest Interest { get; set; }

        public InterestGroup ConvertTo()
        {
            return new InterestGroup
            {
                Id = this.Id,
                InterestGroup = this.InterestGroup,
                InterestId = this.InterestId,
                Interest = this.Interest
            };
        }
        public static InterestGroupDto ConvertFrom(InterestGroup interestGroup)
        {
            return new InterestGroupDto
            {
                Id = interestGroup.Id,
                InterestGroup = interestGroup.InterestGroup,
                InterestId = localita.InterestId,
                Interest = localita.Interest,
            };
        }
    }
}
