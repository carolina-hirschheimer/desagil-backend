package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private static double DELTA = 0.000001;
	private Playlist sertanejo;

	@BeforeEach
	void setUp() {
		Track amor = new Track(new Artist("Anitta"), "amor", 120);
		Track vida = new Track(new Artist("Ludmila"), "vida", 150);
		List<Track> tracks = new ArrayList<>();
		tracks.add(amor);
		tracks.add(vida);
		Playlist sertanejo = new Playlist(13242, tracks);
	}

	@Test
	void testRoundDownToZero() {
		sertanejo.putRating("user1234", 1);
		sertanejo.putRating("user1244", 2);
		sertanejo.putRating("user1247", 3);
		sertanejo.putRating("user1434", 3);
		assertEquals(2.0, sertanejo.averageRatings());
	}

	@Test
	void testRoundUpToHalf() {
		sertanejo.putRating("user1234", 1);
		sertanejo.putRating("user1244", 2);
		sertanejo.putRating("user1247", 1);
		assertEquals(1.5, sertanejo.averageRatings());
	}

	@Test
	void testRoundDownToHalf() {
		sertanejo.putRating("user1234", 1);
		sertanejo.putRating("user1244", 2);
		sertanejo.putRating("user1247", 2);
		assertEquals(1.5, sertanejo.averageRatings());
	}

	@Test
	void testRoundUpToOne() {
		sertanejo.putRating("user1234", 1);
		sertanejo.putRating("user1244", 1);
		sertanejo.putRating("user1247", 2);
		sertanejo.putRating("user1297", 3);
		assertEquals(2.0, sertanejo.averageRatings());
	}
}
