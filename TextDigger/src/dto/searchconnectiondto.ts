import { DocumentDTO } from "./documentdto";
import { TagDTO } from "./tagdto";

export class SearchConnectionDTO{
    id:number;
    tag: TagDTO[];
    document: DocumentDTO[];
}