import { FolderDTO } from "./folderdto";

export class DocumentDTO{
    id: number;
    text: string;
    folder: FolderDTO[];
}