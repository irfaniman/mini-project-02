// package vttp2022.nus.iss.server.repositories;

// import java.time.Duration;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.stereotype.Repository;

// import vttp2022.nus.iss.server.models.Albums;

// public class AlbumRepository {

//     @Autowired
// 	private RedisTemplate<String, String> redisTemplate;

// 	public void save(Albums album) {
// 		redisTemplate.opsForValue().set(album.getIdAlbum(), album.toJson().toString());
// 		redisTemplate.expire(album.getIdAlbum(), Duration.ofMinutes(5));
// 	}

// 	public void save(List<Albums> albums) {
// 		Map<String, String> map = new HashMap<>();
// 		for (Albums alb: albums)
// 			map.put(alb.getIdAlbum(), alb.toJson().toString());
// 		redisTemplate.opsForValue().multiSet(map);

// 		for (String id: map.keySet())
// 			redisTemplate.expire(id, Duration.ofMinutes(5));
// 	}

// 	public Optional<Albums> get(String id) {
// 		if (!redisTemplate.hasKey(id))
// 			return Optional.empty();
// 		String data = redisTemplate.opsForValue().get(id);
// 		return Optional.of(Albums.create(data));
// 	}
// }
