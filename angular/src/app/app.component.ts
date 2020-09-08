import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { logging } from 'protractor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'World Star Co.';
  loggedin = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit(): void {
    console.log(history.state);

    if (sessionStorage.getItem("loggedin")) {
      this.loggedin = true;
    } else {
      this.loggedin = false;
    }
  
  }

}
