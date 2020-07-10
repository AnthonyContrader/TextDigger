import { Component, OnInit } from '@angular/core';
import { LibraryDTO } from 'src/dto/librarydto';
import { LibraryService } from 'src/service/library.service';
import { DescriptionDTO } from 'src/dto/descriptiondto';
import { InterestDTO } from 'src/dto/interestdto';
import { DescriptionService } from 'src/service/description.service';
import { InterestService } from 'src/service/interest.service';

@Component({
  selector: 'app-libraries',
  templateUrl: './libraries.component.html',
  styleUrls: ['./libraries.component.css']
})
export class LibrariesComponent implements OnInit {

  libraries: LibraryDTO[];
  librarytoinsert: LibraryDTO = new LibraryDTO();
  descriptions: DescriptionDTO[];
  interests: InterestDTO[];

  constructor(private service: LibraryService, private service_description: DescriptionService, private service_interest: InterestService) { }

  ngOnInit() {
    this.getLibraries();
    this.getDescriptions();
    this.getInterests();
  }

  getLibraries(){
    this.service.getAll().subscribe(libraries => this.libraries = this.libraries);
  }

  getDescriptions(){
    this.service_description.getAll().subscribe(descriptions => this.descriptions = this.descriptions);
  }

  getInterests(){
    this.service_interest.getAll().subscribe(interests => this.interests = this.interests);
  }

  delete(library: LibraryDTO) {
    this.service.delete(library.id).subscribe(() => this.getLibraries());
  }

  update(library: LibraryDTO) {
    this.service.update(library).subscribe(() => this.getLibraries());
  }

  insert(library: LibraryDTO) {
    this.service.insert(library).subscribe(() => this.getLibraries());
  }

  clear(){
    this.librarytoinsert = new LibraryDTO();
  }

}
