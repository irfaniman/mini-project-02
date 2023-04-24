// package vttp2022.nus.iss.server.services;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import vttp2022.nus.iss.server.models.Albums;
// import vttp2022.nus.iss.server.repositories.AlbumRepository;

// @Service
// public class SaveService {
    
//     @Autowired
// 	private AlbumRepository albumsRepo;

// 	public void save(List<Albums> toSave) {
// 		albumsRepo.save(toSave);
// 	}

// 	public Optional<Albums> get(String idAlbum) {
// 		return albumsRepo.get(idAlbum);
// 	}

// }