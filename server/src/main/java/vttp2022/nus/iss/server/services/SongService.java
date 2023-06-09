package vttp2022.nus.iss.server.services;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp2022.nus.iss.server.models.Albums;
import vttp2022.nus.iss.server.models.Artist;



@Service
public class SongService {

    private static final String ARTISTSEARCH_URL = "https://www.theaudiodb.com/api/v1/json/2/search.php";
    private static final String ALBUMSEARCH_URL = "https://theaudiodb.com/api/v1/json/2/album.php";

    public List<Artist> getArtist(String artistInput) {

        String payload;

        System.out.println("Getting information from theAudioDB");

        // Creating url with query string
        String url = UriComponentsBuilder.fromUriString(ARTISTSEARCH_URL)
                .queryParam("s", artistInput)
                .toUriString();

            // Create the GET request, get URL
            RequestEntity<Void> req = RequestEntity.get(url).build();

            // Make the call to cryptoCompare
            RestTemplate template = new RestTemplate();
            ResponseEntity<String> resp;
    
            try {
                //Throws an exception if status code not in between 200-399
                resp = template.exchange(req, String.class);
            } catch(Exception ex) {
                System.err.printf("Error: %s\n", ex.getMessage());
                return Collections.emptyList();
            } 
         
            // Get the payload and do something with it
            payload = resp.getBody();
            System.out.println("payload: " + payload);

            Reader strReader = new StringReader(payload);
            // Create a JsonReader from reader
            JsonReader jsonReader = Json.createReader(strReader);
            // Read the payload as Json Object
            JsonObject ProfileResult = jsonReader.readObject();

            JsonArray data = ProfileResult.getJsonArray("artists");
            List<Artist> list = new LinkedList<>();
            for (int i = 0; i <data.size(); i++ ) {
                JsonObject jo = data.getJsonObject(i);
                list.add(Artist.create(jo));
                
            }

        return list;
        
    }

    public List<Albums> getAlbums(String artistID) {

        String payload;

        System.out.println("Getting information from theSongDB");

        // Creating url with query string
        String url = UriComponentsBuilder.fromUriString(ALBUMSEARCH_URL)
                .queryParam("i", artistID)
                .toUriString();

            // Create the GET request, get URL
            RequestEntity<Void> req = RequestEntity.get(url).build();

            // Make the call to cryptoCompare
            RestTemplate template = new RestTemplate();
            ResponseEntity<String> resp;
    
            try {
                //Throws an exception if status code not in between 200-399
                resp = template.exchange(req, String.class);
            } catch(Exception ex) {
                System.err.printf("Error: %s\n", ex.getMessage());
                return Collections.emptyList();
            } 
         
            // Get the payload and do something with it
            payload = resp.getBody();
            System.out.println("payload: " + payload);

            Reader strReader = new StringReader(payload);
            // Create a JsonReader from reader
            JsonReader jsonReader = Json.createReader(strReader);
            // Read the payload as Json Object
            JsonObject ProfileResult = jsonReader.readObject();

            JsonArray data = ProfileResult.getJsonArray("album");
            List<Albums> list = new LinkedList<>();
            for (int i = 0; i <data.size(); i++ ) {
                JsonObject jo = data.getJsonObject(i);
                list.add(Albums.create(jo));
                
            }

        return list;
        
    }

 }
