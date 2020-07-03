/**
 *
 */
package basics.guava;

/**
 * @author Office
 *
 */

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Ordering;

import java.util.*;

public class GuavaDemo {

    /**
     * http://en.wikipedia.org/wiki/List_of_The_Wire_characters
     */
    public static class TheWireCharacter {
	public final String name;
	public final ImmutableSet<Integer> seasons;

	public TheWireCharacter(final String name, final Integer... seasons) {
	    this.name = name;
	    this.seasons = ImmutableSet.copyOf(seasons);
	}

	public static final Function<TheWireCharacter, String> GET_NAME = new Function<TheWireCharacter, String>() {
	    @Override
	    public String apply(final TheWireCharacter input) {
		return input.name;
	    }
	};
    }

    public static final ImmutableList<TheWireCharacter> CHARACTERS = ImmutableList.of(
	    new TheWireCharacter("Jimmy McNulty", 1, 2, 3, 4, 5), new TheWireCharacter("Lester Freamon", 2, 3, 4, 5),
	    new TheWireCharacter("Stringer Bell", 1, 2, 3), new TheWireCharacter("Prez", 3, 4),
	    new TheWireCharacter("Omar Little", 3, 4, 5), new TheWireCharacter("Chris Partlow", 5),
	    new TheWireCharacter("Frank Sobotka", 2), new TheWireCharacter("D'Angelo Barksdale", 1, 2),
	    new TheWireCharacter("Avon Barksdale", 1, 2, 3));

    private static Predicate<TheWireCharacter> inSeasons(final Integer season) {
	return new Predicate<TheWireCharacter>() {
	    @Override
	    public boolean apply(final TheWireCharacter c) {
		return c.seasons.contains(season);
	    }
	};
    }

    private static final Ordering<TheWireCharacter> BY_SEASONS = Ordering.natural()
	    .onResultOf(new Function<TheWireCharacter, Integer>() {
		@Override
		public Integer apply(final TheWireCharacter c) {
		    return c.seasons.size();
		}
	    });

    public static void main(final String... args) {
	final ImmutableList<TheWireCharacter> secondSeasonCharacters = FluentIterable.from(CHARACTERS)
		.filter(inSeasons(2)).toSortedList(BY_SEASONS);

	final ImmutableList<String> docks = FluentIterable.from(secondSeasonCharacters)
		.transform(TheWireCharacter.GET_NAME).toList();

	System.out.println("Characters in the Baltimore docks-centered season: " + docks);
    }

}
