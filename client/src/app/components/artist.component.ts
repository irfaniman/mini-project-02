import { Component, Input, OnInit } from '@angular/core';
import { Artist } from '../models';
import { SongService } from '../song-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.css']
})
export class ArtistComponent {
  
  constructor(private service: SongService, private router: Router) {}

  @Input()
  artists: Artist[] = []
}
