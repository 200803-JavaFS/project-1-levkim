import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/_services/login.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  constructor(private loginservice: LoginService) { }

  loggedin: boolean = false;

  ngOnInit(): void {

    if (sessionStorage.getItem("loggedin")) {
      this.loggedin = false;
    } else {
      this.loggedin = true;
    }

  }

  logout() {
    let button = document.getElementById("logout");
    return this.loginservice.logout();
  }

}
