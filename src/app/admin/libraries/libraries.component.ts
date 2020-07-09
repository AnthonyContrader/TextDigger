import { Component, OnInit } from '@angular/core';
import { LibraryDTO } from 'src/dto/librarydto';
import { LibraryService } from 'src/service/library.service';

@Component({
  selector: 'app-libraries',
  templateUrl: './libraries.component.html',
  styleUrls: ['./libraries.component.css']
})
export class LibrariesComponent implements OnInit {

  libraries: LibraryDTO[];
  librarytoinsert: LibraryDTO = new LibraryDTO();

  constructor(private service: LibraryService) { }

  ngOnInit() {
    this.getLibraries();
  }

  getLibraries(){
    this.service.getAll().subscribe(libraries => this.libraries = this.libraries);
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
