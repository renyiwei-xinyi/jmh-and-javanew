package luozix.start.lambdas.exams.answers.chapter5;



import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import luozix.start.lambdas.exams.examples.chapter1.Artist;

public class LongestName {

	private static Comparator<Artist> byNameLength = comparing(artist -> artist.getName().length());

	public static Artist byReduce(List<Artist> artists) {
        return artists.stream()
                      .reduce((acc, artist) -> {
                          return (byNameLength.compare(acc, artist) >= 0) ? acc : artist;
                      })
                      .orElseThrow(RuntimeException::new);
    }

    public static Artist byCollecting(List<Artist> artists) {
        return artists.stream()
                      .collect(Collectors.maxBy(byNameLength))
                      .orElseThrow(RuntimeException::new);
    }

}
