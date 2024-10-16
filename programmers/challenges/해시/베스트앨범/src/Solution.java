import java.util.*;

class Solution {
    public class Song {
        int idx;
        int playingTime;
        Genre genre;
        
        public Song(int idx, int playingTime, Genre genre) {
            this.idx = idx;
            this.playingTime = playingTime;
            this.genre = genre;
        }
    }
    
    public class Genre {
        String name;
        int playingTime;
        
        public Genre(String name,int playingTime) {
            this.name = name;
            this.playingTime = playingTime;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> genreSet = new HashMap<>();
        Song[] songs = new Song[plays.length];
        
        // 데이터 전처리
        for (int i=0; i<genres.length; i++) {
            String genreName = genres[i];
            int playingTime = plays[i];
            
            Genre genre;
            if (!genreSet.containsKey(genreName)) {
                genre = new Genre(genreName, playingTime);
                genreSet.put(genreName, genre);
            } else {
                genre = genreSet.get(genreName);
                genre.playingTime += playingTime;
            }
            
            songs[i] = new Song(i, playingTime, genre);
        }
        
        Arrays.sort(songs, (o1, o2) -> {
            if (o1.genre == o2.genre) {                
                if (o1.playingTime == o2.playingTime) {
                    // 고유 번호 순서 낮은순
                    return o1.idx - o2.idx;
                }
                // 많이 재생된
                return o2.playingTime - o1.playingTime;
            }
            // 장르 순서
            return o2.genre.playingTime - o1.genre.playingTime;
        });
        
        ArrayList<Integer> temp = new ArrayList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        for (int i=0; i<songs.length; i++) {
            Song song = songs[i];
            visited.put(song.genre.name, visited.getOrDefault(song.genre.name, 0) + 1);
            if (visited.get(song.genre.name) > 2) {
                continue;
            }
            
            temp.add(song.idx);
        }

        int[] ans = new int[temp.size()];
        for (int i=0; i<temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        
        return ans;
    }
}