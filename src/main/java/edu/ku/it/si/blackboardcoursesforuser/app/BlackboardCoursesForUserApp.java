package edu.ku.it.si.blackboardcoursesforuser.app;

import itemLoot.ItemController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import blackboard.persist.KeyNotFoundException;
import blackboard.persist.PersistenceException;

import edu.ku.it.si.blackboardcoursesforuser.controller.BlackboardCoursesForUserController;


/**
 * Application that will get Blackboard courses 
 * for a specific user.
 * Before running this
 * application you must run the 
 * RegisterProxyToolApp.  See the ReadMe.txt
 * for further information.
 * @author bphillips
 *
 */
public class BlackboardCoursesForUserApp {

	ApplicationContext ctx = new ClassPathXmlApplicationContext(
	   "../resources/applicationContext_BlackboardCoursesForUser.xml");
		
		BlackboardCoursesForUserController blackboardCoursesForUserController;

		public ItemController run() {			
			blackboardCoursesForUserController = (BlackboardCoursesForUserController) ctx.getBean("blackboardCoursesForUserController");
			
			try {
				return blackboardCoursesForUserController.getBlackboardCoursesForUser() ;
			} catch (KeyNotFoundException e) {
			} catch (PersistenceException e) {
			}
			
			return null;
			
		}


}
