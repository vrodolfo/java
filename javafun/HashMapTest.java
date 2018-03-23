import java.util.*;

public class HashMapTest{

	public static void main(String[] args){

		HashMap<String, String> trackList = new HashMap<>();

		trackList.put("Song1", "Lyric1");
		trackList.put("Song2", "Lyric2");
		trackList.put("Song3", "Lyric3");
		trackList.put("Song4", "Lyric4");


		String song = trackList.get("Song1");

		System.out.println(song);

		System.out.println("All::::::::");

		trackList.forEach((key, value) -> System.out.println(key + " : " + value));


	}



}