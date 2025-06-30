import { Component, ElementRef, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent {
  @ViewChild('formRef') ref: NgForm;
  submit: boolean = false;
  canExit() {
    if (this.ref.dirty && !this.submit) {
      return confirm('Do you want to leave?');
    } else {
      return true;
    }
  }
  onSubmit() {
    this.submit = true;
  }
}
