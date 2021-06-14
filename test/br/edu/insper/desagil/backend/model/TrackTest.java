package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
	
	@BeforeEach
	void setUp() {
		
	}

	@Test
	void testZeroSeconds() {
		Artist olivia = new Artist("Olivia Rodrigo");
		Track traitor = new Track(olivia, "traitor", 0);
		assertEquals("0:00", traitor.getDurationString());
	}

	@Test
	void testFiveSeconds() {
		Artist olivia = new Artist("Olivia Rodrigo");
		Track traitor = new Track(olivia, "traitor", 5);
		assertEquals("0:05", traitor.getDurationString());
	}

	@Test
	void testTwentyFiveSeconds() {
		Artist olivia = new Artist("Olivia Rodrigo");
		Track traitor = new Track(olivia, "traitor", 25);
		assertEquals("0:25", traitor.getDurationString());
	}

	@Test
	void testOneMinuteZeroSeconds() {
		Artist olivia = new Artist("Olivia Rodrigo");
		Track traitor = new Track(olivia, "traitor", 60);
		assertEquals("1:00", traitor.getDurationString());
	}

	@Test
	void testOneMinuteFiveSeconds() {
		Artist olivia = new Artist("Olivia Rodrigo");
		Track traitor = new Track(olivia, "traitor", 65);
		assertEquals("1:05", traitor.getDurationString());
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() {
		Artist olivia = new Artist("Olivia Rodrigo");
		Track traitor = new Track(olivia, "traitor", 85);
		assertEquals("1:25", traitor.getDurationString());
	}

	@Test
	void testTwoMinutesZeroSeconds() {
		Artist olivia = new Artist("Olivia Rodrigo");
		Track traitor = new Track(olivia, "traitor", 120);
		assertEquals("2:00", traitor.getDurationString());
	}

	@Test
	void testTwoMinutesFiveSeconds() {
		Artist olivia = new Artist("Olivia Rodrigo");
		Track traitor = new Track(olivia, "traitor", 125);
		assertEquals("2:05", traitor.getDurationString());
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() {
		Artist olivia = new Artist("Olivia Rodrigo");
		Track traitor = new Track(olivia, "traitor", 145);
		assertEquals("2:25", traitor.getDurationString());
	}

	@Test
	void testOneCollaborator() {
		Artist anitta = new Artist("Anitta");
		Artist becky = new Artist("Becky G");
		Track track = new Track(anitta, "track", 120);
		List<Artist> collaborators = new ArrayList<>();
		collaborators.add(becky);
		CollaborationTrack colab = new CollaborationTrack (track.getArtist(),track.getName(), track.getDuration(),collaborators);
		assertEquals("Anitta (feat. Becky G)", colab.getFullArtistName());
	}

	@Test
	void testTwoCollaborators() {
		Artist anitta = new Artist("Anitta");
		Artist ludmila = new Artist("Ludmilla");
		Artist snoop = new Artist("Snoop Dog");
		Track track = new Track(anitta, "track", 120);
		List<Artist> collaborators = new ArrayList<>();
		collaborators.add(ludmila);
		collaborators.add(snoop);
		CollaborationTrack colab = new CollaborationTrack (track.getArtist(),track.getName(), track.getDuration(),collaborators);
		assertEquals("Anitta (feat. Ludmilla, Snoop Dog)", colab.getFullArtistName());
	}

}
