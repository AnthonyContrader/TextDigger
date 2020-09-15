  
import { Component, OnInit } from '@angular/core';
import { LibraryDTO } from 'src/dto/librarydto';
import { LibraryService } from 'src/service/library.service';
import { InterestDTO } from 'src/dto/interestdto';
import { InterestService } from 'src/service/interest.service';

@Component({
  selector: 'app-libraries',
  templateUrl: './libraries.component.html',
  styleUrls: ['./libraries.component.css']
})
export class LibrariesComponent implements OnInit {

  libraries: LibraryDTO[];
  librarytoinsert: LibraryDTO = new LibraryDTO();
  interests: InterestDTO[];

  constructor(private service: LibraryService, private service_interest: InterestService) { }

  ngOnInit() {
    this.getLibraries();
    this.getInterests();
  }

  getLibraries(){
    this.service.getAll().subscribe(libraries => this.libraries = libraries);
  }


  getInterests(){
    this.service_interest.getAll().subscribe(interests => this.interests = interests);
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