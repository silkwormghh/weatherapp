package test.com.weather.app.resources;

import org.junit.Assert;
import org.junit.Test;

import com.weather.app.resources.TimeUtils;

public class TestTimeUtils {

	@Test
	public void testConvertUnixTimeToSimpleDateFormat() {
	    Assert.assertEquals("02/07/2020 12:30", TimeUtils.convertUnixTimeToSimpleDateTimeFormat("1593707400", "America/New_York"));
	    Assert.assertNull(TimeUtils.convertUnixTimeToSimpleDateTimeFormat(null, "America/New_York"));
	    Assert.assertNull(TimeUtils.convertUnixTimeToSimpleDateTimeFormat("1593707400", null));
	    Assert.assertNull(TimeUtils.convertUnixTimeToSimpleDateTimeFormat(null, null));
	}
	
	
	@Test
	public void testGetTimeFromUnixTime() {
	    Assert.assertEquals("12:30", TimeUtils.getTimeFromUnixTime("1593707400", "America/New_York"));
	    Assert.assertNull(TimeUtils.getTimeFromUnixTime(null, "America/New_York"));
	    Assert.assertNull(TimeUtils.getTimeFromUnixTime("1593707400", null));
	    Assert.assertNull(TimeUtils.getTimeFromUnixTime(null, null));
	}
	
	@Test
	public void testGetDateFromUnixTime() {
	    Assert.assertEquals("02/07/2020", TimeUtils.getDateFromUnixTime("1593707400", "America/New_York"));
	    Assert.assertNull(TimeUtils.getDateFromUnixTime(null, "America/New_York"));
	    Assert.assertNull(TimeUtils.getDateFromUnixTime("1593707400", null));
	    Assert.assertNull(TimeUtils.getDateFromUnixTime(null, null));
	}

}
