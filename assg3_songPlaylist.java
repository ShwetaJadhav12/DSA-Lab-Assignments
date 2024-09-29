// Functions in Playlist Class
// add Song At Start
// add Song At End
// add Song After Title
// add song after id
// remove Song By Title
// remove Song At Start
// remove Song At End
// remove Alternate Songs
// delete Songs By Artist
// display Playlist
// play specific Song
// search Song
// increment Duration
// print Reverse
// modify Song
// count Songs
// delete Whole Playlist
// copy Playlist
public class assg3_songPlaylist {
    static class Song {

        private String title;
        private String artist;
        private int duration;
        private int songId; // New member for song ID

        public Song next;

        public Song(String title, String artist, int duration, int songId) {
            this.title = title;
            this.artist = artist;
            this.duration = duration;
            this.songId = songId;
            this.next = null;
        }

        // using getters and setters because class members are private
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getSongId() {
            return songId;
        }

        public void setSongId(int songId) {
            this.songId = songId;
        }

        // Display info
        public void displaySong() {
            String f = "%-10d %-20s %-20s %-5ds"; // Adjust widths as needed
            System.out.println(String.format(f, songId, title, artist, duration));
            // System.out.println("Title: " + title + ", Artist: " + artist + ", Duration: " + duration + "s");
        }
    }

    static class Playlist {
        private Song head;
        private int nextId = 1; // To generate unique song IDs

        public Playlist() {
            head = null;
        }

        // Add song at the beginning
        public void addSongAtStart(String title, String artist, int duration) {
            Song newSong = new Song(title, artist, duration, nextId++);
            newSong.next = head;
            head = newSong;
            return;
        }

        // Add song at the end
        public void addSongAtEnd(String title, String artist, int duration) {
            Song newSong = new Song(title, artist, duration, nextId++);
            if (head == null) {
                head = newSong;
                return;
            }
            Song current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong;
            return;
        }

        // Function to add a song after a specific title
        public void addSongAfterTitle(String title, String newTitle, String newArtist, int newDuration) {
            
            if (head == null) {
                System.out.println("Playlist is empty.");
                return;
            }

            Song current = head;

            
            while (current != null && !current.getTitle().equals(title)) {
                current = current.next;
            }

            
            if (current == null) {
                System.out.println("Song with title '" + title + "' not found.");
                return;
            }

            
            Song newSong = new Song(newTitle, newArtist, newDuration, nextId++);

            
            newSong.next = current.next;
            current.next = newSong;

            System.out.println("Song '" + newTitle + "' added after '" + title + "'.");
            return;
        }

        // Function to add a song after a specific song ID
        public void addSongAfterId(int songId, String newTitle, String newArtist, int newDuration) {
            
            if (head == null) {
                System.out.println("Playlist is empty.");
                return;
            }

            Song current = head;

            while (current != null && current.getSongId() != songId) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("Song with ID '" + songId + "' not found.");
                return;
            }

            Song newSong = new Song(newTitle, newArtist, newDuration, nextId++);

            newSong.next = current.next;
            current.next = newSong;

            System.out.println("Song '" + newTitle + "' added after song with ID '" + songId + "'.");
            return;
        }

        // Remove song by title
        public void removeSongByTitle(String title) {
            if (head == null)
                return;

            if (head.getTitle().equals(title)) {
                head = head.next;
                return;
            }

            Song current = head;
            while (current.next != null && !current.next.getTitle().equals(title)) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            } else {
                System.out.println("Song not found.");
            }
            return;
        }

        // Remove song at start
        public void removeSongAtStart() {
            if (head != null) {
                head = head.next;
            }
            return;
        }

        // Remove song at end
        public void removeSongAtEnd() {
            if (head == null || head.next == null) {
                head = null;
                return;
            }
            Song current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            return;
        }

        
        // Remove alternate songs
        public void removeAlternateSongs() {
            if (head == null || head.next == null)
                return;

            Song current = head;
            while (current != null && current.next != null) {
                current.next = current.next.next;
                current = current.next;
            }
            return;
        }

        // remove all songs by a specific artist 
        public void deleteSongsByArtist(String artist) {
            
            if (head == null) {
                System.out.println("Playlist is empty.");
                return;
            }

            // Delete songs at the beginning
            while (head != null && head.getArtist().equals(artist)) {
                head = head.next; 
                
            }

            // If the list becomes empty after removing all matching songs at the start
            if (head == null) {
                System.out.println("All songs by artist '" + artist + "' have been deleted.");
                return;
            }

            // For the rest of the nodes
            Song current = head;
            while (current != null && current.next != null) {
                if (current.next.getArtist().equals(artist)) {
                    current.next = current.next.next; 
                }
                 else {
                    current = current.next; 
                }
            }

            System.out.println("All songs by artist '" + artist + "' have been deleted.");
            return;
        }

        // Display the entire playlist
        public void displayPlaylist() {
            if (head == null) {
                System.out.println("Playlist is empty.");
                return;
            }
            Song current = head;
            while (current != null) {
                current.displaySong();
                current = current.next;
            }
            return;
        }

        // Play specific song
        public void playSong(String title) {
            Song current = head;
            while (current != null) {
                if (current.getTitle().equals(title)) {
                    current.displaySong();
                    return;
                }
                current = current.next;
            }
            System.out.println("oops!! Song not found.");
            return;
        }

        // Search for a song by title
        public boolean searchSong(String title) {
            Song current = head;
            while (current != null) {
                if (current.getTitle().equals(title)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        // Function to increment the duration of a song of a specific title
        public void incrementDuration(String title, int seconds) {
            Song current = head;

           
            while (current != null) {
                if (current.getTitle().equals(title)) {
                    current.setDuration(current.getDuration() + seconds);
                    System.out.println("Duration of song " + title + " incremented by " + seconds + " seconds.");
                    return;
                }
                current = current.next;

            }

            //  song is not found
            System.out.println("Song with title " + title + " not found.");
            return;
        }

        // Print the playlist in reverse order
        public void printReverse() {
            printReverseHelper(head);
            return;
        }

        private void printReverseHelper(Song node) {
            if (node == null)
                return;
            printReverseHelper(node.next);
            node.displaySong();
        }

        // Modify a particular song by title
        public void modifySong(String oldTitle, String newTitle, String newArtist, int newDuration) {
            Song current = head;
            while (current != null) {
                if (current.getTitle().equals(oldTitle)) {
                    current.setTitle(newTitle);
                    current.setArtist(newArtist);
                    current.setDuration(newDuration);
                    return;
                }
                current = current.next;
            }
            System.out.println("oops!! Song not found.");
            return;
        }

        // Count the total number of songs
        public int countSongs() {
            int count = 0;
            Song current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

        // Function to delete the entire playlist
        public void deleteWholePlaylist() {
            head = null;
            System.out.println("The playlist has been deleted.");
            return;
        }

        // Copy all songs to a new playlist
        public Playlist copyPlaylist() {
            Playlist newPlaylist = new Playlist();
            if (head == null)
                return newPlaylist;

            Song current = head;
            while (current != null) {
                newPlaylist.addSongAtEnd(current.getTitle(), current.getArtist(), current.getDuration());
                current = current.next;
            }
            return newPlaylist;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist();

        // Add some songs
        p.addSongAtStart("Barish se", "Arijit Singh", 300);
        p.addSongAtStart("Barsat", "KK", 300);
        p.addSongAtStart("Bdal Barsa re ", "Arijit Singh", 250);
        p.addSongAtStart("Tum Hi Ho", "Arijit Singh", 278);

        // adding at end
        p.addSongAtEnd("Shape of You", "Ed Sheeran", 263);
        p.addSongAtEnd("Channa Mereya", "Arijit Singh", 286);
        p.addSongAtEnd("Bohemian Rhapsody", "Queen", 354); // Add between "Tum Hi Ho" and "Shape of You"
        p.addSongAtEnd("Jai Ho", "A.R. Rahman", 255);
        p.addSongAtEnd("Hotel California", "Eagles", 391);
        p.addSongAtEnd("Someone Like You", "Adele", 286);
        p.addSongAtEnd("Bdal Barse", "Sonu Nigam", 400);

        // adding after a certain title
        p.addSongAfterTitle("Tum Hi Ho","Anjana" ,"Lata Mangeshkar", 250);
        p.addSongAfterTitle("Barish se","Chandani" ,"Mohit Chauhan", 275);
        p.addSongAfterTitle("Barsat", "disco", "Arijit Singh", 300);

        // Adding after a specific song ID
        p.addSongAfterId(1, "Mannat", "Darshan R", 328);

        // Display playlist
        p.displayPlaylist();

        // Play specific song
        p.playSong("Badal Barse");

        // Modify song
        p.modifySong("disco", "disco dancer", "KK", 390);
        p.displayPlaylist();

        // Search song
        System.out.println("Is 'Song xyz' in the playlist? " + p.searchSong("Song xyz"));
        System.out.println("Is 'disco dancer' in the playlist? " + p.searchSong("disco dancer"));

        // Count songs
        System.out.println("Total no of songs: " + p.countSongs());

        // Print in reverse
        System.out.println("Playlist in reverse order(Printing):");
        p.printReverse();

        // Change duration
        p.incrementDuration("disco dancer", 301);
        System.out.println("Playlist after incrementing duration of 'Song disco dancer':");
        p.displayPlaylist();

        // Removing song by title
        p.removeSongByTitle("Badal");
        System.out.println("Playlist after removing 'Badal':");
        p.displayPlaylist();

        // Remove song at starting
        p.removeSongAtStart();
        System.out.println("Playlist after removing song at start:");
        p.displayPlaylist();

        // Remove song at ending
        p.removeSongAtEnd();
        System.out.println("Playlist after removing song at end:");
        p.displayPlaylist();
        
        // Remove song by artist
        p.deleteSongsByArtist("Arijit Singh");
        System.out.println("Playlist after deleting all songs by 'Arijit Singh':");
        p.displayPlaylist();

        // Copy playlist
        Playlist newP = p.copyPlaylist();
        System.out.println("Copied playlist:");
        newP.displayPlaylist();
    }
}
 
    

