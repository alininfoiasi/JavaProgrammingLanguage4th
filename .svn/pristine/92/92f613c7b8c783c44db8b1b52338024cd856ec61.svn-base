
package extra.closure;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author alin
 */
interface Block<T> {

    void invoke(T arg);
}

class Utils {

    public static <T> void forEach(Iterable<T> seq, Block<T> fct) {
        for (T elm : seq) {
            fct.invoke(elm);
        }
    }
}

public class NoClosure {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        // create a custom Block object
        Block<Integer> print = new Block<Integer>() {
            @Override
            public void invoke(Integer arg) {
                System.out.println(arg);
            }
        };
        // apply the print block/object to each element in nums
        Utils.forEach(nums, print);
    }
}
