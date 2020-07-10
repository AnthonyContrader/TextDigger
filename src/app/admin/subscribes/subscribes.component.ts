import { Component, OnInit } from '@angular/core';
import { SubscribeDTO } from 'src/dto/subscribedto';
import { SubscribeService } from 'src/service/subscribe.service';
import { UserDTO } from 'src/dto/userdto';
import { InterestGroupDTO } from 'src/dto/interestgroupdto';
import { UserService } from 'src/service/user.service';
import { InterestGroupService } from 'src/service/interestgroup.service';

@Component({
  selector: 'app-subscribes',
  templateUrl: './subscribes.component.html',
  styleUrls: ['./subscribes.component.css']
})
export class SubscribesComponent implements OnInit {

  subscribes: SubscribeDTO[];
  subscribetoinsert: SubscribeDTO = new SubscribeDTO();
  users: UserDTO[];
  interestgroups: InterestGroupDTO[];

  constructor(private service: SubscribeService, private service_user: UserService, private service_interestgroup: InterestGroupService) { }

  ngOnInit() {
    this.getSubscribes();
    this.getUsers();
    this.getInterestGroups();
  }

  getSubscribes(){
    this.service.getAll().subscribe(subscribes => this.subscribes = this.subscribes);
  }

  getUsers(){
    this.service_user.getAll().subscribe(users => this.users = this.users);
  }

  getInterestGroups(){
    this.service_interestgroup.getAll().subscribe(interestgroups => this.interestgroups = this.interestgroups);
  }

  delete(subscribe: SubscribeDTO) {
    this.service.delete(subscribe.id).subscribe(() => this.getSubscribes());
  }

  update(subscribe: SubscribeDTO) {
    this.service.update(subscribe).subscribe(() => this.getSubscribes());
  }

  insert(subscribe: SubscribeDTO) {
    this.service.insert(subscribe).subscribe(() => this.getSubscribes());
  }

  clear(){
    this.subscribetoinsert = new SubscribeDTO();
  }

}
