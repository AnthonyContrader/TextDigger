import { Component, OnInit } from '@angular/core';
import { TagDTO } from 'src/dto/tagdto';
import { TagService } from 'src/service/tag.service';

@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent implements OnInit {

  tags: TagDTO[];
  tagtoinsert: TagDTO = new TagDTO();

  constructor(private service: TagService) { }

  ngOnInit() {
    this.getTags();
  }

  getTags(){
    this.service.getAll().subscribe(tags => this.tags = tags);
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