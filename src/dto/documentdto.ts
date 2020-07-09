import { UserDTO } from './userdto';
import { FolderDTO } from './folderdto';
import { DescriptionDTO } from './descriptiondto';

export class DocumentDTO {
    
    id: number;

    text: string;

    user : UserDTO;

    folder: FolderDTO;

    description: DescriptionDTO;
}