package org.howard.edu.lsp.finals.problem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SongsDatabaseTest {

	@Test
	void testAddSong() {
		SongsDatabase db = new SongsDatabase();
		
		db.addSong("Rap", "Savage");
		db.addSong("Rap", "Gin and Juice");
		db.addSong("Jazz", "Always There");
		db.addSong("EDM", "USAO");
	}
	
	@Test
	void testGetSongs() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetGenreOfSong() {
		fail("Not yet implemented"); // TODO
	}


}
