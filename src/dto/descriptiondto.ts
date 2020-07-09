import { FolderDTO } from './folderdto';
import { LibraryDTO } from './librarydto';
import { DocumentDTO } from './documentdto';
import { InterestDTO } from './interestdto';

export class DescriptionDTO {

    id : number;

    description : string;

    folder : FolderDTO;

    library : LibraryDTO;

    document : DocumentDTO;

    interest : InterestDTO;
}