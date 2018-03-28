package hh.Harjotustyo.harjotustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Music, Long> {

	List<Music> findByArtist(String artist);


}
