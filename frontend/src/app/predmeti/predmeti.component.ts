import { Component, OnInit } from '@angular/core';
import { PredmetService} from '../service/predmet/predmet.service';
import { PredmetInfo1 } from '../model/predmet/predmet';

@Component({
  selector: 'app-predmeti',
  templateUrl: './predmeti.component.html',
  styleUrls: ['./predmeti.component.css']
})
export class PredmetiComponent implements OnInit {
  predmeti: PredmetInfo1[]=[];
  constructor(private predmetService: PredmetService) { }

  ngOnInit(): void {
    this.predmetService.getAll().subscribe((r) => (this.predmeti = r));
  }

}
