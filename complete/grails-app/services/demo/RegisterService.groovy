package demo

import groovy.time.TimeCategory
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import java.text.SimpleDateFormat

@Slf4j
@CompileStatic
class RegisterService {

	ThreadPoolTaskSchedulerBean threadPoolTaskScheduler // <1>
	EmailService emailService // <2>

	void register(String email) {
		log.info 'saving {} at {}', email, new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())
		scheduleFollowupEmail(email)
	}

	@CompileDynamic
	Date startAtDate() { // <3>
		Date startAt = new Date()
		use(TimeCategory) {
			startAt = startAt + 1.minute
		}
		startAt
	}

	void scheduleFollowupEmail(String email) {
//		JobDataMap jobDataMap = new JobDataMap()
//		jobDataMap.put('email', email)
//		Trigger trigger = TriggerBuilder.newTrigger()
//				.forJob(JobKey.jobKey(FollowupEmailJobService.simpleName))
//				.startAt(startAtDate())
//				.usingJobData(jobDataMap)
//				.build()
//		quartzService.scheduleTrigger(trigger)

		threadPoolTaskScheduler
				.threadPoolTaskScheduler()
				.schedule(new FollowupTask(emailService, email), startAtDate()) // <4>
	}
}