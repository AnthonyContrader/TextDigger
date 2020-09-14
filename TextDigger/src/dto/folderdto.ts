import { LibraryDTO } from "./librarydto";

export class FolderDTO{
    id: number;
    folderName: string;
    library: LibraryDTO[];
}