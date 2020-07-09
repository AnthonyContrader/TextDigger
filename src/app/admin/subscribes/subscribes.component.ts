import { Component, OnInit } from '@angular/core';
import { SubscribeDTO } from 'src/dto/subscribedto';
import { SubscribeService } from 'src/service/subscribe.service';

@Component({
  selector: 'app-subscribes',
  templateUrl: './subscribes.component.html',
  styleUrls: ['./subscribes.component.css']
})
export class SubscribesComponent implements OnInit {

  subscribes: SubscribeDTO[];
  subscribetoinsert: SubscribeDTO = new SubscribeDTO();

  constructor(private service: SubscribeService) { }

  ngOnInit() {
    this.getSubscribes();
  }

  getSubscribes(){
    this.service.getAll().subscribe(subscribes => this.subscribes = this.subscribes);
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
