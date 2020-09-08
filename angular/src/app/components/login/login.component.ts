import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { LoginService } from "../../_services/login.service";
import { User } from 'src/app/_models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submit = false;
  returnUrl: string;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private loginService: LoginService
  ) {  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || 'dashboard';
  }

  username: string = '';
  password: string = '';
  get fields() { return this.loginForm.controls };

  onSubmit() {
    this.submit = true;
    if (this.loginForm.invalid) {
      return;
    }

    let user = new User(this.username, this.password);

    this.loading = true;
    this.loginService.login(user)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['dashboard']);
        }
      )
  }
}
