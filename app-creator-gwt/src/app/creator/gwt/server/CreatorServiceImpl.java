package app.creator.gwt.server;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import app.creator.grails.ClassProperty;
import app.creator.grails.GrailsAppCreator;
import app.creator.grails.controller.ControllerClass;
import app.creator.grails.domain.DomainClass;
import app.creator.gwt.client.CreatorService;
import app.creator.gwt.model.Application;
import app.creator.gwt.model.Artifact;
import app.creator.pckg.PackageCreator;
import app.creator.pckg.launch.LaunchBat;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CreatorServiceImpl extends RemoteServiceServlet implements
CreatorService {

	
	public Artifact create(Application application) throws IllegalArgumentException {
		getThreadLocalRequest().getSession().setAttribute("application", application);
		
		ApplicationToCreatorTransformer transformer = new ApplicationToCreatorTransformer();
		
		GrailsAppCreator creator = transformer.transform(application);
		
		File war = creator.buildWar(creator.generate());
		System.out.println("Created war " + war.getAbsolutePath());

		LaunchBat launchBat = new LaunchBat();
		launchBat.setAppWarFile(war.getName());
		launchBat.setAppContext("collab-todo");
		launchBat.setAppServerPort(9999);
		launchBat.setAppServerThreadsMin(10);
		launchBat.setAppServerThreadsMax(50);

		PackageCreator packageCreator = new PackageCreator();
		packageCreator.getPackageObjects().add(launchBat);

		Path pckg = packageCreator.generate(war);
		System.out.println("Created package in " + pckg.toString());

		File compressed = packageCreator.compress(pckg, war.getName());
		System.out.println("Compressed package in " + compressed.getAbsolutePath());
		
		Map<String, String> fileNames = (Map<String, String>)
				getThreadLocalRequest().getSession().getAttribute("fileNames");
		
		if (fileNames == null) {
			fileNames = new HashMap<String, String>();
			getThreadLocalRequest().getSession().setAttribute("fileNames", fileNames);
		}
		
		String fileId = UUID.randomUUID().toString();
		fileNames.put(fileId, compressed.getAbsolutePath());
		
		Artifact artifact = new Artifact();
		artifact.setName(compressed.getName());
		artifact.setId(fileId);
		
		return artifact;
	}
}
