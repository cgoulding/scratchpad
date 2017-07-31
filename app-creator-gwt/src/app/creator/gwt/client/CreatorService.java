package app.creator.gwt.client;

import app.creator.gwt.model.Application;
import app.creator.gwt.model.Artifact;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("creator")
public interface CreatorService extends RemoteService {
	Artifact create(Application application) throws IllegalArgumentException;
}
