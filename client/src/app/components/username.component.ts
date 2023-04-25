import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Username } from '../models';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { SongService } from '../song-service';
import { Artist, Albums } from '../models';

@Component({
  selector: 'app-username',
  templateUrl: './username.component.html',
  styleUrls: ['./username.component.css']
})
export class UsernameComponent implements OnInit{

  constructor(private router: Router, private http: HttpClient, private fb: FormBuilder, private songService: SongService) {}

  searchForm!: FormGroup


  ngOnInit(): void {
    
  }

  search() {

  }

}