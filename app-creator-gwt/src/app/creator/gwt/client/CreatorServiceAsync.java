package app.creator.gwt.client;

import app.creator.gwt.model.Application;
import app.creator.gwt.model.Artifact;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface CreatorServiceAsync {
	void create(Application application, AsyncCallback<Artifact> callback)
			throws IllegalArgumentException;
}
