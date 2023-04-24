package vttp2022.nus.iss.server.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import vttp2022.nus.iss.server.models.Albums;
import vttp2022.nus.iss.server.models.Artist;
// import vttp2022.nus.iss.server.services.SaveService;
import vttp2022.nus.iss.server.services.SongService;


@RestController
@CrossOrigin
@RequestMapping
public class SongController {

	@Autowired 
	private SongService songSvc;

	// @Autowired
	// private SaveService saveSvc;

	@GetMapping(path={"/artist"})
	public List<Artist> getArtist(@RequestParam String artistInput) {
	
		List<Artist> artist = songSvc.getArtist(artistInput);
		return artist;
	
	}
	
	
	@GetMapping(path={"/albums"})
	public List<Albums> getAlbums(@RequestParam String artistID) {
		   
		List<Albums> albums = songSvc.getAlbums(artistID);
		return albums;
	}
}

