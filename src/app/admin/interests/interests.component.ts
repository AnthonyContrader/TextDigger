import { Component, OnInit } from '@angular/core';
import { InterestDTO } from 'src/dto/interestdto';
import { InterestService } from 'src/service/interest.service';

@Component({
  selector: 'app-interests',
  templateUrl: './interests.component.html',
  styleUrls: ['./interests.component.css']
})
export class InterestsComponent implements OnInit {

  interests: InterestDTO[];
  interesttoinsert: InterestDTO = new InterestDTO();

  constructor(private service: InterestService) { }

  ngOnInit() {
    this.getInterests();
  }

  getInterests(){
    this.service.getAll().subscribe(interests => this.interests = this.interests);
  }

  delete(interest: InterestDTO) {
    this.service.delete(interest.id).subscribe(() => this.getInterests());
  }

  update(interest: InterestDTO) {
    this.service.update(interest).subscribe(() => this.getInterests());
  }

  insert(interest: InterestDTO) {
    this.service.insert(interest).subscribe(() => this.getInterests());
  }

  clear(){
    this.interesttoinsert = new InterestDTO();
  }

}
