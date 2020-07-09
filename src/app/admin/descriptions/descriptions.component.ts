import { Component, OnInit } from '@angular/core';
import { DescriptionDTO } from 'src/dto/descriptiondto';
import { DescriptionService } from 'src/service/description.service';

@Component({
  selector: 'app-descriptions',
  templateUrl: './descriptions.component.html',
  styleUrls: ['./descriptions.component.css']
})
export class DescriptionsComponent implements OnInit {

  descriptions: DescriptionDTO[];
  descriptiontoinsert: DescriptionDTO = new DescriptionDTO();

  constructor(private service: DescriptionService) { }

  ngOnInit() {
    this.getDescriptions();
  }

  getDescriptions() {
    this.service.getAll().subscribe(descriptions => this.descriptions = this.descriptions);
  }

  delete(description: DescriptionDTO) {
    this.service.delete(description.id).subscribe(() => this.getDescriptions());
  }

  update(description: DescriptionDTO) {
    this.service.update(description).subscribe(() => this.getDescriptions());
  }

  insert(description: DescriptionDTO) {
    this.service.insert(description).subscribe(() => this.getDescriptions());
  }

  clear(){
    this.descriptiontoinsert = new DescriptionDTO();
  }

}
