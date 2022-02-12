import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class JUnitTest {

	@Test
	void test_date09() throws Exception {
		most_active_cookie cookie = new most_active_cookie("C:\\Users\\preeb\\Computer Science\\workspace\\QuantCast\\src\\cookie_log.csv", "2018-12-09");
		assertEquals("AtY0laUfhglK3lC7", cookie.Jtests.get(0));
	}
	
	@Test
	void test_date08() throws Exception {
		most_active_cookie cookie = new most_active_cookie("C:\\Users\\preeb\\Computer Science\\workspace\\QuantCast\\src\\cookie_log.csv", "2018-12-08");
		assertEquals("SAZuXPGUrfbcn5UA", cookie.Jtests.get(0));
		assertEquals("4sMM2LxV07bPJzwf", cookie.Jtests.get(1));
		assertEquals("fbcn5UAVanZf6UtG", cookie.Jtests.get(2));
		
	}
	
	@Test
	void test_date07() throws Exception {
		most_active_cookie cookie = new most_active_cookie("C:\\Users\\preeb\\Computer Science\\workspace\\QuantCast\\src\\cookie_log.csv", "2018-12-07");
		assertEquals("4sMM2LxV07bPJzwf", cookie.Jtests.get(0));
	}
	
	@Test
	void test_date06() throws Exception {
		most_active_cookie cookie = new most_active_cookie("C:\\Users\\preeb\\Computer Science\\workspace\\QuantCast\\src\\cookie_log.csv", "2018-12-06");
		assertTrue(cookie.Jtests.isEmpty());
	}
	
	@Test
	void test_incorrectFilePath() throws Exception {
		try {
			most_active_cookie cookie = new most_active_cookie("C:\\Users\\preeb\\Computer Science\\workspace\\QuantCast\\src\\cookie_log12.csv", "2018-12-06");
		} catch (Exception e) {
			assertTrue(e.toString().contains("Invalid file path. Please make the necessary changes and re-run!"));
		}
	}
	
	@Test
	void test_incorrectFileType() throws Exception {
		try {
			most_active_cookie cookie = new most_active_cookie("C:\\Users\\preeb\\Computer Science\\workspace\\QuantCast\\src\\cookie_log.tsv", "2018-12-06");
		} catch (Exception e) {
			assertTrue(e.toString().contains("Invalid date or file type. Please make the necessary changes and re-run!"));
		}
	}
	
	@Test
	void test_incorrectDateSize() throws Exception {
		try {
			most_active_cookie cookie = new most_active_cookie("C:\\Users\\preeb\\Computer Science\\workspace\\QuantCast\\src\\cookie_log.csv", "2018-12");
		} catch (Exception e) {
			assertTrue(e.toString().contains("Invalid date or file type. Please make the necessary changes and re-run!"));
		}
	}
}
