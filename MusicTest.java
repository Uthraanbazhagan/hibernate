package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Album;
import com.lti.entity.MusicDao;
import com.lti.entity.Song;
import com.lti.entity.Transaction;
import com.lti.service.MusicService;

public class MusicTest {

	@Test
	public void testAddAlbum() {
    MusicService ms=new MusicService();
    Album al=new Album();
    al.setName("Reputation");
    al.setCopyright("abc");
    al.setYear(2019);
    ms.addAlbum(al);
	}
	@Test
	public void testAddSong() {
		MusicService ms=new MusicService();
		MusicDao dao=new MusicDao();
		Song s=new Song();
		s.setTitle("Reputation");
		s.setSinger("TS");
		s.setDuration(60);
		Album album=(Album)dao.fetchById(Album.class,186);
		s.setAlbum(album);
		ms.addSong(s);
	}
	@Test
	public void testRetrieve(double id) {
		MusicService ms=new MusicService();
	    List<Song> list=ms.RetrieveSongs(181);
	 for(Song c:list) {
	    	System.out.println(c.getId()+" "+c.getSinger()+" "+c.getTitle()+" "+c.getAlbum()); 	
	    }
	
	}

}
