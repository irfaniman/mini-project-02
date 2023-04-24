import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom, Observable, ObservableNotification, Subject } from "rxjs";
import { Albums, Artist } from "./models";

@Injectable({
  providedIn: 'root'
})

export class SongService {

  constructor(private http: HttpClient) { }

  baseUrl = "localhost:8080/artist"
  baseUrl2 = "localhost:8080/albums"

  getArtist(data: any): Observable<any> {
    return this.http.get(`${this.baseUrl}?artist=${data}`)
  }

  getAlbums(data: any): Observable<any> {
    return this.http.get(`${this.baseUrl2}?artistID=${data}`)
  }

}
