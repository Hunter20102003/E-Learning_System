package YoutobeDataAPI;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.regex.Matcher;
import java.util.regex.Pattern;
=======
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile

public class YouTubeDuration {

    private static final String API_KEY = "AIzaSyA1N_O81Qm5Hrf1evVwP3ymcyyJ2oVQ-lU";
    private static final String APPLICATION_NAME = "YouTubeDuration";
    private static final long MAX_RESULTS = 50L;

    public static void main(String[] args) {
//        try {
<<<<<<< HEAD
<<<<<<< HEAD
        //     YouTube youtubeService = getService();
=======
     //     YouTube youtubeService = getService();
>>>>>>> origin/front-end
=======
     //     YouTube youtubeService = getService();
>>>>>>> origin/profile
//
//            // Lấy thời lượng của video cụ thể
//            String videoId = "VrZoEKDwr6M";
//            long videoDuration = getVideoDuration(youtubeService, videoId);
//            System.out.println("Video Duration: " + videoDuration + " seconds");
//            System.out.println(convertToMinutesAndSeconds(videoDuration));
//
//            // Lấy tổng thời lượng của danh sách video
//            String playlistId = "PL8ApS86kTh2PkRyOJX0RfdxLlW4kjRPxn";
//            long playlistDuration = getPlaylistDuration(youtubeService, playlistId);
//            System.out.println("Playlist Duration: " + playlistDuration + " seconds");
//            System.out.println(convertToHoursAndMinutes(playlistDuration));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
<<<<<<< HEAD
<<<<<<< HEAD
        // System.out.println(getVideoDuration(youtubeService, API_KEY));
        //System.out.println(getListVideoDuration("PL8ApS86kTh2PkRyOJX0RfdxLlW4kjRPxns"));
        
        System.out.println(getYouTubeId("https://www.youtube.com/watch?v=7Ow0YVOIAuU&list=LL&index=4"));
        System.out.println(isValidYouTubeUrl("https://www.youtube.com/watch?v=7Ow0YVOIAuU&list=LL&index=4"));
    
=======
       // System.out.println(getVideoDuration(youtubeService, API_KEY));
        //System.out.println(getListVideoDuration("PL8ApS86kTh2PkRyOJX0RfdxLlW4kjRPxns"));
>>>>>>> origin/front-end
=======
       // System.out.println(getVideoDuration(youtubeService, API_KEY));
        //System.out.println(getListVideoDuration("PL8ApS86kTh2PkRyOJX0RfdxLlW4kjRPxns"));
>>>>>>> origin/profile
    }

//    public static String getListVideoDuration(String listId) {
//        long playlistDuration = 0;
//        try {
//            YouTube youtubeService = getService();
//
//            String playlistId = listId;
//            playlistDuration = getPlaylistDuration(youtubeService, playlistId);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return convertToHoursAndMinutes(playlistDuration);
//    }
<<<<<<< HEAD
<<<<<<< HEAD
    public static String getYouTubeId(String url) {
    String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?v%3D|^)[a-zA-Z0-9_-]{11}";
    Pattern compiledPattern = Pattern.compile(pattern);
    Matcher matcher = compiledPattern.matcher(url);
    if (matcher.find()) {
        return matcher.group();
    }
    return null;
}


       public static boolean isValidYouTubeUrl(String url) {
        // Regular expression to match valid YouTube video and playlist URLs
        String pattern = "(?i)^(?:(?:https?:)?\\/\\/)?(?:www\\.|m\\.)?(?:youtube\\.com\\/\\S*(?:\\/|\\b|\\s|))|(?:(?:https?:)?\\/\\/)?(?:www\\.|m\\.)?(?:youtu\\.be\\/\\S*(?:\\/|\\b|\\s|))";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(url);

        return matcher.find();
    }

    // Phương thức để chuyển đổi URL thành link nhúng
    public static String convertToEmbedLink(String url) {
        String videoId = getYouTubeId(url);
        if (videoId != null) {
            return "https://www.youtube.com/embed/" + videoId;
        }
        return null;
    }
=======
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile

    public static long getVideoDuration(String video) {
        long videoDuration = 0;
        try {
            YouTube youtubeService = getService();

            // Lấy thời lượng của video cụ thể
            String videoId = video;
            videoDuration = getVideoDuration(youtubeService, videoId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return videoDuration;
    }

    public static YouTube getService() throws GeneralSecurityException, IOException {
        return new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static long getVideoDuration(YouTube youtubeService, String videoId) throws IOException {
        YouTube.Videos.List request = youtubeService.videos()
                .list("contentDetails")
                .setId(videoId)
                .setKey(API_KEY);

        VideoListResponse response = request.execute();
        List<Video> videos = response.getItems();
        if (videos.isEmpty()) {
            throw new IllegalArgumentException("Video not found: " + videoId);
        }

        Video video = videos.get(0);
        String durationString = video.getContentDetails().getDuration();
        return parseDuration(durationString);
    }

    public static long getPlaylistDuration(YouTube youtubeService, String playlistId) throws IOException {
        long totalDuration = 0;
        String nextPageToken = null;

        do {
            YouTube.PlaylistItems.List request = youtubeService.playlistItems()
                    .list("contentDetails")
                    .setPlaylistId(playlistId)
                    .setMaxResults(MAX_RESULTS)
                    .setPageToken(nextPageToken)
                    .setKey(API_KEY);

            PlaylistItemListResponse response = request.execute();
            List<String> videoIds = response.getItems().stream()
                    .map(item -> item.getContentDetails().getVideoId())
                    .toList();

            YouTube.Videos.List videoRequest = youtubeService.videos()
                    .list("contentDetails")
                    .setId(String.join(",", videoIds))
                    .setKey(API_KEY);

            VideoListResponse videoResponse = videoRequest.execute();
            for (Video video : videoResponse.getItems()) {
                String duration = video.getContentDetails().getDuration();
                totalDuration += parseDuration(duration);
            }

            nextPageToken = response.getNextPageToken();
        } while (nextPageToken != null);

        return totalDuration;
    }

    public static long parseDuration(String duration) {
        java.time.Duration d = java.time.Duration.parse(duration);
        return d.getSeconds();
    }

    public static String convertToHoursAndMinutes(long totalSeconds) {
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        String strHours = (hours < 10) ? "0" + hours : String.valueOf(hours);
        String strMinutes = (minutes < 10) ? "0" + minutes : String.valueOf(minutes);
        return strHours + "h" + strMinutes + "m";
    }

    public static String convertToMinutesAndSeconds(long totalSeconds) {
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;
        String strMinutes = (minutes < 10) ? "0" + minutes : String.valueOf(minutes);
        String strSeconds = (seconds < 10) ? "0" + seconds : String.valueOf(seconds);
        return strMinutes + ":" + strSeconds;
    }

}
