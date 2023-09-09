import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Cine {

	public HashMap<Integer, MovieData[]> salas = new HashMap<Integer, MovieData[]>();
	public String[] nameMovies = { "El tiburon Blanco", "La anaconda", "El coco", "Que paso ayer parte 96",
			"Mi tia es un peligro", "Loco pero feliz", "Infeliz pero inteligente", "Megalodon", "La sirena 96",
			"Tupac  el regreso del guero", "Jaime", "Mejia", "Avila", "Probando ando", "EMOTEE" };

	public void setData() {

		for (int i = 0; i < 7; i++) {
			MovieData[] movie = new MovieData[15];

			for (int j = 0; j < 15; j++) {
				movie[j] = new MovieData(nameMovies[j], randomNumber());
			}

			salas.put(i, movie);
		}
	}

	public void showData() {
		for (Integer i : salas.keySet()) {
			System.out.println("----------------");
			System.out.println("Sala " + (i + 1));
			System.out.println("----------------");
			System.out.println();

			for (int j = 0; j < nameMovies.length; j++) {
				System.out.println("Pelicula: '" + salas.get(i)[j].getMovie() + "' Personas Asistentes: "
						+ salas.get(i)[j].getVies() + " ");
				System.out.println("----------------------------");
				System.out.println();
			}
		}
	}

	private int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(201);

		return number;
	}

	public String showTotalViews() {
		int viewsForSala = 0;

		for (Integer i : salas.keySet()) {
			for (int j = 0; j < nameMovies.length; j++) {
				viewsForSala += salas.get(i)[j].getVies();
			}
		}
		
		return String.valueOf(viewsForSala);
	}

	public String showTotalViewsForSala(int sala) {
		int[] viewsForMovie = new int[nameMovies.length];
		int totalViews = 0;

		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("RESULTADOS SALA " + (sala + 1));
		System.out.println("-----------------------------------------");
		System.out.println();

		for (int i = 0; i < nameMovies.length; i++) {
			viewsForMovie[i] += salas.get(sala)[i].getVies();
			totalViews += salas.get(sala)[i].getVies();
		}

		for (int i = 0; i < viewsForMovie.length; i++) {
			System.out.println("Pelicula '" + salas.get(sala)[i].getMovie() + "': " + viewsForMovie[i]);
		}

		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("Total de espectadores: " + totalViews);
		System.out.println("-----------------------------------------");
		System.out.println();
		
		return String.valueOf(totalViews);
	}

	public String mostVisitedRoom() {
		int[] viewsForSala = new int[7];
		
		int salaMax = 0;

		for (Integer salaId : salas.keySet()) {
			for (int j = 0; j < nameMovies.length; j++) {
				viewsForSala[salaId] += salas.get(salaId)[j].getVies();
			}
		}

		for (int i = 0; i < viewsForSala.length; i++) {
			if (viewsForSala[i] > viewsForSala[salaMax]) {
				salaMax = i;
			}
		} 
		
		System.out.println(); //		
		System.out.println();
		System.out.println("Sala mas visitada: " + (salaMax + 1));
		
		return String.valueOf(salaMax + 1);
	}

	public String mostViewedMovieInTheCinema() {
		String movie = "";

		int[] viewsForMovie = new int[nameMovies.length];
		int movieMax = 0;

		for (Integer salaId : salas.keySet()) {
			for (int j = 0; j < nameMovies.length; j++) {
				viewsForMovie[j] += salas.get(salaId)[j].getVies();
			}
		}

		for (int i = 0; i < viewsForMovie.length; i++) {
			if (viewsForMovie[i] > viewsForMovie[movieMax]) {
				movieMax = i;
			}
		}

		movie = nameMovies[movieMax];

		System.out.println("Pelicula mas vista en el cine: '" + (nameMovies[movieMax]) + "'");

		return movie;
	}

	public String mostViewedMovieInTheRoom(int salaId) {
		String movie = "";
		int[] viewsForMovie = new int[nameMovies.length];
		int movieMax = 0;

		for (int j = 0; j < nameMovies.length; j++) {
			viewsForMovie[j] += salas.get(salaId)[j].getVies();
		}

		for (int i = 0; i < viewsForMovie.length; i++) {
			if (viewsForMovie[i] > viewsForMovie[movieMax]) {
				movieMax = i;
			}
		}

		movie = nameMovies[movieMax];

		System.out.println("Pelicula mas vista en la sala " + (salaId + 1) + ": '" + (nameMovies[movieMax]) + "'");

		return movie;
	}

	public static void main(String[] args) {
		Cine bogota = new Cine();

		bogota.setData();
		// bogota.showData();
		// bogota.showTotalViews();
		bogota.showTotalViewsForSala(0);
		bogota.mostVisitedRoom();
	}
}
