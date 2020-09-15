import { Component, OnInit } from '@angular/core';
import { InterestGroupDTO } from 'src/dto/interestgroupdto';
import { InterestgroupService } from 'src/service/interestgroup.service';
import { InterestDTO } from 'src/dto/interestdto';
import { InterestService } from 'src/service/interest.service';

@Component({
  selector: 'app-interestgroups',
  templateUrl: './interestgroups.component.html',
  styleUrls: ['./interestgroups.component.css']
})
export class InterestgroupsComponent implements OnInit {

  interestgroups: InterestGroupDTO[];
  interestgrouptoinsert: InterestGroupDTO = new InterestGroupDTO();
  interests: InterestDTO[];

  constructor(private service: InterestgroupService, private service_interest: InterestService) { }

  ngOnInit() {
    this.getInterestGroups();
    this.getInterests();
  }

  getInterestGroups(){
    this.service.getAll().subscribe(interestgroups => this.interestgroups = interestgroups);
  }

  getInterests(){
    this.service_interest.getAll().subscribe(interests => this.interests = interests);
  }

  delete(interestgroup: InterestGroupDTO) {
    this.service.delete(interestgroup.id).subscribe(() => this.getInterestGroups());
  }

  update(interestgroup: InterestGroupDTO) {
    this.service.update(interestgroup).subscribe(() => this.getInterestGroups());
  }

  insert(interestgroup: InterestGroupDTO) {
    this.service.insert(interestgroup).subscribe(() => this.getInterestGroups());
  }

  clear(){
    this.interestgrouptoinsert = new InterestGroupDTO();
  }

}