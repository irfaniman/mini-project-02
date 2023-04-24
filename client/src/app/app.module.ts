import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

//import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SongService } from './song-service';
import { ArtistComponent } from './components/artist.component';
import { UsernameComponent } from './components/username.component';
import { AlbumsComponent } from './components/albums.component';
import { LogoutComponent } from './components/logout.component';
import { MatToolbarModule } from '@angular/material/toolbar'
import {MatButtonModule} from '@angular/material/button'

const appRoute: Routes = [
  {path: '', component: UsernameComponent},
  {path: 'username', component: UsernameComponent},
  {path: 'logout', component: LogoutComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    ArtistComponent,
    UsernameComponent,
    AlbumsComponent,
    LogoutComponent,

  ],
  imports: [
    BrowserModule,
    //AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoute),
    MatToolbarModule,
    MatButtonModule
  
  ],
  providers: [SongService],
  bootstrap: [AppComponent]
})
export class AppModule { }
