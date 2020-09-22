import { Component, OnInit } from '@angular/core';
import {FakultetInfo1} from '../model/fakultet/fakultet';
import {FakultetService} from '../service/fakultet/fakultet.service';

@Component({
  selector: 'app-fakulteti',
  templateUrl: './fakulteti.component.html',
  styleUrls: ['./fakulteti.component.css']
})
export class FakultetiComponent implements OnInit {
  fakulteti: FakultetInfo1[] = [];
  constructor(private fakultetService: FakultetService) { }

  ngOnInit(): void {
    this.fakultetService.getAll().subscribe((r) => (this.fakulteti = r));
  }

}
