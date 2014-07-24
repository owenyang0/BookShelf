package yang;

import com.yang.model.Book;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DBCPManagerTest {

    @Test
    public void show_select_all_items_with_asterisk_sign() throws Exception {
        List<Book> books = DBCPManager.select("*");
        System.out.println(books);
        assertThat(books.size(), is(3));
    }
}