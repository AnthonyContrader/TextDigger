import { Component, OnInit } from '@angular/core';
import { InterestGroupDTO } from 'src/dto/interestgroupdto';
import { InterestGroupService } from 'src/service/interestgroup.service';

@Component({
  selector: 'app-interestgroups',
  templateUrl: './interestgroups.component.html',
  styleUrls: ['./interestgroups.component.css']
})
export class InterestgroupsComponent implements OnInit {

  interestgroups: InterestGroupDTO[];
  interestgrouptoinsert: InterestGroupDTO = new InterestGroupDTO();

  constructor(private service: InterestGroupService) { }

  ngOnInit() {
    this.getInterestGroups();
  }

  getInterestGroups(){
    this.service.getAll().subscribe(interestgroups => this.interestgroups = this.interestgroups);
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
