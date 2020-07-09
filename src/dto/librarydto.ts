import { DescriptionDTO } from './descriptiondto';
import { InterestDTO } from './interestdto';

export class LibraryDTO {

    id: number;
    
    name: string;

    description: DescriptionDTO;

    interest: InterestDTO;
}