package sdv.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTasks {

	public static int secondsPast = 30;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 1000)
	public void profileProcessing() {
		if(this.secondsPast > 20) {
			System.out.println("The time is now " + dateFormat.format(new Date()) + ". It is increase time!");
			this.secondsPast = 0;
		}
		
		this.secondsPast++;
		
	}
	
	
	
}
