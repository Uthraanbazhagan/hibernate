package com.lti.service;

import java.util.List;

import com.lti.entity.Album;
import com.lti.entity.MusicDao;
import com.lti.entity.Song;

public class MusicService {
public void addAlbum(Album al) {
	MusicDao dao=new MusicDao();
	dao.save(al);
}
public void addSong(Song s) {
	MusicDao dao=new MusicDao();
	dao.save(s);
}
public List<Song> RetrieveSongs(double  alid) {
	MusicDao dao=new MusicDao();
//	Album al=(Album)dao.fetchById(Album.class,alid);
	 List<Song> list= dao.fetchSongs(alid);
	return list;
}

}
