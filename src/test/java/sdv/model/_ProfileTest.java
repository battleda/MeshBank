package sdv.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _ProfileTest {

	@Test
	void calculationLogic() {
		Profile profile = new Profile();
		Float cash = 100.0f;
		Float maxCash = 207.0f;
		
		profile.setCash(cash);
		profile.calculateMaxCash();
		
		assertEquals("Check calculateMaxCash method", maxCash, profile.getMaxCashSumm(), 0.009f);
		
		for(int i = 0; i < 15; i++) {
			cash = cash * 1.1f;
			if(cash > maxCash) {
				cash = maxCash;
			}
			
			profile.increaseCashFor10Percent();
			
			assertEquals("Check increaseCashFor10Percent method", cash, profile.getCash());
			
		}
	}

}
