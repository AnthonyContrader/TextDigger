import { Component, OnInit } from '@angular/core';
import { TagDTO } from 'src/dto/tagdto';
import { TagService } from 'src/service/tag.service';
import { DescriptionDTO } from 'src/dto/descriptiondto';
import { DescriptionService } from 'src/service/description.service';

@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent implements OnInit {

  tags: TagDTO[];
  tagtoinsert: TagDTO = new TagDTO();
  descriptions: DescriptionDTO[];

  constructor(private service: TagService, private service_description: DescriptionService) { }

  ngOnInit() {
    this.getTags();
    this.getDescriptions();
  }

  getTags(){
    this.service.getAll().subscribe(tags => this.tags = tags);
  }

  getDescriptions(){
    this.service_description.getAll().subscribe(descriptions => this.descriptions = descriptions);
  }

  delete(tag: TagDTO) {
    this.service.delete(tag.id).subscribe(() => this.getTags());
  }

  update(tag: TagDTO) {
    this.service.update(tag).subscribe(() => this.getTags());
  }

  insert(tag: TagDTO) {
    this.service.insert(tag).subscribe(() => this.getTags());
  }

  clear(){
    this.tagtoinsert = new TagDTO();
  }

}
