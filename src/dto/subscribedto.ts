import { UserDTO } from './userdto';
import { InterestGroupDTO } from './interestgroupdto';

export class SubscribeDTO{
    id: number;

    user: UserDTO;

    interestgroup: InterestGroupDTO;
}