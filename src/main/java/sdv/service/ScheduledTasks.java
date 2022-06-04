package sdv.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import sdv.model.Profile;
import sdv.model.User;

@Service
@Transactional
public class ScheduledTasks {
	
	@Autowired
	UserService userService;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 1000)
	public void profileProcessing() {
		
		
		ArrayList<Profile> profiles = (ArrayList<Profile>) userService.getAllProfiles();
				
		for(Profile profile: profiles) {
			GregorianCalendar now = new GregorianCalendar();
			if((now.getTimeInMillis() - profile.getDateChanged().getTimeInMillis()) / 1000 >= 20) {
				User user = userService.getUserById(profile.getUser().getId());
				Float currentCash = profile.getCash();
				profile.increaseCashFor10Percent();
				profile.setDateChanged(now);
				userService.updateProfile(profile);
				System.out.println(dateFormat.format(new Date()) 
						+ ". Account increased for " + user.getName() + " " + user.getEmail() 
						+ " prev cash: " + currentCash 
						+ " increased cash: " + profile.getCash());
			}
		}
		
		
		
	}
	
	
	
}
