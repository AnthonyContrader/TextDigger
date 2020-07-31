using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
	public class SubscribeDto
	{
		public int? Id { get; set; }
        public int UserId { get; set; }
        public UserItem User { get; set; }
        public int InterestGroupId { get; set; }
        public InterestGroup InterestGroup { get; set; }

        public Subscribe ConvertTo()
        {
            return new Subscribe
            {
                Id = this.Id,
                UserId = this.UserId,
                User = this.User,
                InterestGroupId = this.InterestGroupId,
                InterestGroup = this.InterestGroup
            };
        }
        public static SubscribeDto ConvertFrom(Subscribe subscribe)
        {
            return new SubscribeDto
            {
                Id = subscribe.Id,
                UserId = subscribe.UserId,
                User = subscribe.User,
                InterestGroupId = subscribe.InterestGroupId,
                InterestGroup = subscribe.InterestGroup
            };
        }
    }
}
