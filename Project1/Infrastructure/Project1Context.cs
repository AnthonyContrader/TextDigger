using Microsoft.EntityFrameworkCore;
using Project1.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Project1.Infrastructure
{
    public class Project1Context : DbContext
    {
        private DbContextOptions<Project1Context> _optionsBuilder;

        public DbSet<UserItem> Users { get; set; }

        public Project1Context(DbContextOptions<Project1Context> options)
            : base(options)
        {
            _optionsBuilder = options;
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Server=sqldata;Database=Project1Demo;User ID=sa;Password=Contrader2020;MultipleActiveResultSets=true",
          sqlServerOptionsAction: sqlOptions =>
          {
                    /*sqlOptions.MigrationsAssembly(
                        typeof(Startup).GetTypeInfo().Assembly.GetName().Name);*/

                    //Configuring Connection Resiliency:
                    sqlOptions.
                  EnableRetryOnFailure(maxRetryCount: 5,
                  maxRetryDelay: TimeSpan.FromSeconds(30),
                  errorNumbersToAdd: null);

          });
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<UserItem>(entity =>
            {
                entity.ToTable("User");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Name).HasMaxLength(50);
                entity.Property(e => e.Surname).HasMaxLength(50);
                entity.Property(e => e.Login).HasMaxLength(50).IsRequired();
                entity.Property(e => e.Password).HasMaxLength(50).IsRequired();
                entity.Property(e => e.Age);
                entity.Property(e => e.Email).HasMaxLength(50);
                entity.Property(e => e.Address).HasMaxLength(200);
                entity.Property(e => e.IsAdmin).HasDefaultValue(false);
                entity.HasMany(c => c.Subscribes).WithOne(e => e.User).HasForeignKey(e => e.UserId);
            });

            modelBuilder.Entity<Interest>(entity =>
            {
                entity.ToTable("Interest");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Interest).HasMaxLength(50).IsRequired();
                entity.HasMany(l => l.InterestGroupPerInterest).WithOne(e => e.Interest).HasForeignKey(e => e.InterestId);
            });

            modelBuilder.Entity<InterestGroup>(entity =>
            {
                entity.ToTable("InterestGroup");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.InterestGroup).HasMaxLength(50).IsRequired();
				entity.Property(e => e.Interest).IsRequired();
                entity.HasMany(d => d.SubscribePerInterestGroup).WithOne(e => e.InterestGroup).HasForeignKey(e => e.InterestGroupId);
            });

            modelBuilder.Entity<Subscribe>(entity =>
            {
                entity.ToTable("Subscribe");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.User).IsRequired();
                entity.Property(e => e.InterestGroup).IsRequired();
            });

            modelBuilder.Entity<Tag>(entity =>
            {
                entity.ToTable("Tag");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Tag).HasMaxLength(50).IsRequired();
                entity.HasMany(d => d.SearchConnectionPerTag).WithOne(e => e.Tag).HasForeignKey(e => e.TagId);
            });

            modelBuilder.Entity<Document>(entity =>
            {
                entity.ToTable("Document");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Text).HasMaxLength(100).IsRequired();
                entity.HasOne(u => u.User).WithMany(e => e.Documents).HasForeignKey(e => e.UserItemId);
                entity.HasOne(f => f.Folder).WithMany(e => e.Documents).HasForeignKey(e => e.FolderId);
            });

            modelBuilder.Entity<Folder>(entity =>
            {
                entity.ToTable("Folder");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Name).HasMaxLength(100).IsRequired();
                entity.HasOne(l => l.Library).WithMany(e => e.Folders).HasForeignKey(e => e.LibraryId);
            });

            modelBuilder.Entity<Library>(entity =>
            {
                entity.ToTable("Library");
                entity.HasKey(e => e.Id);
                entity.Property(e => e.Name).HasMaxLength(100).IsRequired();
                entity.HasOne(i => i.Interest).WithMany(e => e.Libraries).HasForeignKey(e => e.InterestId);
            });

            modelBuilder.Entity<SearchConnection>(entity =>
            {
                entity.ToTable("SearchConnection");
                entity.HasKey(e => e.Id);
                entity.HasOne(d => d.Document).WithMany(e => e.SearchConnections).HasForeignKey(e => e.DocumentId);
                entity.HasOne(t => t.Tag).WithMany(e => e.SearchConnectionPerTag).HasForeignKey(e => e.TagId);
            });
        }
    }
}
