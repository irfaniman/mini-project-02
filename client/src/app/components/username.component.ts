import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Username } from '../models';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-username',
  templateUrl: './username.component.html',
  styleUrls: ['./username.component.css']
})
export class UsernameComponent implements OnInit{
  
  @Output()
  onUsername = new Subject<Username>()
  
  searchForm!: FormGroup

  constructor(private router: Router, private http: HttpClient, private fb: FormBuilder) {}

  ngOnInit(): void {
      this.searchForm = this.createForm()
  }

  processForm() {
    const username: Username = this.searchForm.value
    console.info('username: ', username)
    this.onUsername.next(username);
    this.searchForm = this.createForm()
  }

  private createForm(): FormGroup {
    return this.fb.group({
      username: this.fb.control('')
    })
  }
}


// export class SearchComponent implements OnInit {

//   @Output()
//   onSearch = new Subject<SearchCriteria>()

//   searchForm!: FormGroup

//   constructor(private fb: FormBuilder) { }

//   ngOnInit(): void {
//     this.searchForm = this.createForm()
//   }

//   processForm() {
//     const searchCriterial: SearchCriteria = this.searchForm.value
//     searchCriterial.count = parseInt(this.searchForm.value.count)
//     this.onSearch.next(searchCriterial)
//     this.searchForm = this.createForm()
//   }

//   private createForm(): FormGroup {
//     return this.fb.group({
//       text: this.fb.control<string>('', [ Validators.required ]),
//       count: this.fb.control<number>(5)
//     })
//   }


