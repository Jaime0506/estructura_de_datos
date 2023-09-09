public class MovieData { 
	
	int views = 0;
	String movie = "";
	
	public MovieData(String nameMovie, int views) {
		this.movie = nameMovie;
		this.views = views; 
	} 
	
	public int getVies() {
		return views;
	}
	
	public String getMovie() {
		return movie;
	}
}
