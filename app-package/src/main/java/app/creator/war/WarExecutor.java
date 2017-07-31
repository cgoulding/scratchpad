package app.creator.war;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class WarExecutor {
	
	public static void main(String[] args) {
		QueuedThreadPool threadPool = new QueuedThreadPool();
		threadPool.setMinThreads(Integer.valueOf(System.getProperty("app.server.threads.min", "10")));
		threadPool.setMaxThreads(Integer.valueOf(System.getProperty("app.server.threads.max", "50")));
		
		Server server = new Server(threadPool);
		ServerConnector connector = new ServerConnector(server);
		connector.setPort(Integer.valueOf(System.getProperty("app.server.port", "8080")));
		
	    server.setConnectors(new Connector[]{connector});
	    
	    WebAppContext context = new WebAppContext();
	    context.setServer(server);
	    context.setWar(System.getProperty("app.war.file", "webapps/app.war"));
	    context.setContextPath(System.getProperty("app.context", "/app"));
	    
	    System.out.println(context.getWar());
	    System.out.println(context.getContextPath());
	    
	    ContextHandlerCollection contexts = new ContextHandlerCollection();
	    contexts.setHandlers(new Handler[]{context});
	    
	    HandlerCollection handlers = new HandlerCollection();
	    handlers.setHandlers(new Handler[]{contexts, new DefaultHandler()});
	    
	    server.setHandler(handlers);
	    
	    try {
	        server.start();
	        System.in.read();
	        server.stop();
	        server.join();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.exit(100);
	    }
	}
}
