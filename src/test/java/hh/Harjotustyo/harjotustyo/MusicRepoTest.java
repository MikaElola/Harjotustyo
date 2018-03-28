package hh.Harjotustyo.harjotustyo;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.Harjotustyo.harjotustyo.domain.Music;
import hh.Harjotustyo.harjotustyo.domain.MusicRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MusicRepoTest {
	@Autowired
	private MusicRepository mrepo;
	
	@Test
	public void findByName(){
		List<Music> musics = mrepo.findByArtist("The Acacia Strain");
		assertThat(musics).hasSize(1);
		assertThat(musics.get(0).getName()).isEqualTo("Coma Witch");
	}
	
	@Test
	public void createNew(){
		Music music = new Music("Test", "Test", 2018, "Testia");
		mrepo.save(music);
		List<Music> musics = (List<Music>) mrepo.findAll();
		assertThat(musics).hasSize(3);
	}
	@Test
	public void delete(){
		List<Music> musics = mrepo.findByArtist("The Acacia Strain");
		Music music = musics.get(0);
		mrepo.delete(music);
		List<Music> musix = mrepo.findByArtist("The Acacia Strain");
		assertThat(musix).hasSize(0);
	}
	
}
