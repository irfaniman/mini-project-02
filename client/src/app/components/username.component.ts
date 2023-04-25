import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Username } from '../models';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { SongService } from '../song-service';
import { Artist } from '../models';

@Component({
  selector: 'app-username',
  templateUrl: './username.component.html',
  styleUrls: ['./username.component.css']
})
export class UsernameComponent implements OnInit{
  
  searchForm!: FormGroup
  searchResult: any

  constructor(private router: Router, private http: HttpClient, private fb: FormBuilder, private songService: SongService) {}

  ngOnInit(): void {

  }

  search() {
    this.songService.get

  }

  private createForm(): FormGroup {
    return this.fb.group({
      username: this.fb.control<String>(''),
      artistInput: this.fb.control<String>('', [ Validators.required ])
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


