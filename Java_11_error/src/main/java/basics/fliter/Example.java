/**
 *
 */
package basics.fliter;

import com.github.mgunlogson.cuckoofilter4j.CuckooFilter;
import com.google.common.hash.Funnels;

/**
 * @author Office
 *
 */
public class Example {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// create
	CuckooFilter<Integer> filter = new CuckooFilter.Builder<>(Funnels.integerFunnel(), 2000000).build();
	// insert
	if (filter.put(42)) {
	    System.out.println("Insert Success!");
	}
	// contains
	if (filter.mightContain(42)) {
	    System.out.println("Found 42!");
	}
	// count
	System.out.println("Filter has " + filter.getCount() + " items");

	// count
	System.out.println("42 has been inserted approximately " + filter.approximateCount(42) + " times");

	// % loaded
	System.out.println("Filter is " + String.format("%.0f%%", filter.getLoadFactor() * 100) + " loaded");

	// delete
	if (filter.delete(42)) {
	    System.out.println("Delete Success!");
	}
    }


}
