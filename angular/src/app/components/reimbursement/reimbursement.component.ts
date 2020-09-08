import { Component, OnInit } from '@angular/core';
import { ReimbService } from 'src/app/_services/reimb.service';

@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.scss']
})
export class ReimbursementComponent implements OnInit {

  constructor(
    private service: ReimbService,
  ) { }

  ngOnInit(): void {

    let data = {
    }
    
  }

}
