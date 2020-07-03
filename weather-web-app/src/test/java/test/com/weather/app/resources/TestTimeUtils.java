package test.com.weather.app.resources;

import org.junit.Assert;
import org.junit.Test;

import com.weather.app.resources.TimeUtils;

public class TestTimeUtils {

	@Test
	public void testConvertUnixTimeToSimpleDateFormat() {
	    Assert.assertEquals("02/07/2020 12:30", TimeUtils.convertUnixTimeToSimpleDateFormat("1593707400", "America/New_York"));
	}

}
