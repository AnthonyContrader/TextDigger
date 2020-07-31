using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.DTO
{
	public class TagDto
	{
		public int? Id { get; set; }
		public string TagString { get; set; }

		public Tag ConvertTo()
		{
			return new Tag
			{
				Id = this.Id,
				TagString = this.TagString,
				
			};
		}
		public static TagDto ConvertFrom(Tag tag)
		{
			return new TagDto
			{
				Id = tag.Id,
				TagString = tag.TagString,
				
			};
		}

        internal static TagDto ConvertFrom(object tag)
        {
            throw new NotImplementedException();
        }
    }
}

