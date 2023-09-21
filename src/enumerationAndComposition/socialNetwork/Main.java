package enumerationAndComposition.socialNetwork;

import enumerationAndComposition.socialNetwork.entities.Comment;
import enumerationAndComposition.socialNetwork.entities.Post;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Comment c1 = new Comment("Have a nice trip");
        Comment c2 = new Comment("Wow that's awesome!");

        Post p1 = new Post(
                LocalDateTime.parse("2018-06-21T13:05:44"),
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        p1.addComment(c1);
        p1.addComment(c2);

        System.out.println(p1.toString());
    }
}
