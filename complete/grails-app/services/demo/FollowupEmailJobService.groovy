package demo

import grails.config.Config
import grails.core.GrailsApplication
import grails.core.support.GrailsConfigurationAware
import grails.util.Holders

//import com.agileorbit.schwartz.SchwartzJob
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled

//import org.quartz.JobDataMap
//import org.quartz.JobExecutionContext
//import org.quartz.JobExecutionException

import java.text.SimpleDateFormat

@Slf4j
@CompileStatic
class FollowupEmailJobService { // implements SchwartzJob {


//	@Scheduled(fixedDelayString = "${FollowupEmailJobService.delay}")
//	def sendFollowup() {
//		log.info 'Sending followup email to: {} at {}', email, new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())
//	}


//    void execute(JobExecutionContext context) throws JobExecutionException {
//		JobDataMap jobDataMap = context.mergedJobDataMap
//		String email = jobDataMap.getString('email') // <1>
//		log.info 'Sending followup email to: {} at {}', email, new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())
//	}

//	@Override
//	void buildTriggers() {
//
//	}
}