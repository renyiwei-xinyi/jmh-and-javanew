package luozix.start.lambdas.exams.exercises.chapter9;

import java.util.function.Consumer;

// BEGIN class
public interface ArtistAnalyzer {

    public void isLargerGroup(String artistName,
                              String otherArtistName,
                              Consumer<Boolean> handler);
    
}
// END class
