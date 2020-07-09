import { DescriptionDTO } from './descriptiondto';
import { LibraryDTO } from './librarydto';

export class FolderDTO {

    id: number;

    name: string;

    library : LibraryDTO;

    description : DescriptionDTO;
}