
package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track{
	
	private List <Artist> collaborators;

	public CollaborationTrack(Artist artist, String name, int duration, List<Artist> collaborators) {
		super(artist, name, duration);
		this.collaborators = collaborators;
	}

	@Override
	
	public String getFullArtistName () {
		List<String> nomes = new ArrayList<>();
		for (Artist artist: this.collaborators) {
			nomes.add(artist.getName());
		}
		String inicio = this.getArtist().getName() + " (feat. ";
		String meio = String.join(", ", nomes);
		String tudo = inicio+meio + ")";
		return tudo;
		
	}
	
	


}