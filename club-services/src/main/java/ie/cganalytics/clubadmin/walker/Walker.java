package ie.cganalytics.clubadmin.walker;

public class Walker <W extends Walkable>{

	private Class<W> contract;
	private W source;
	private W destination;
	
	public Walker(Class<W> contract, W source, W destination)  {
		this.contract = contract;
		this.source = source;
		this.destination = destination;
	}

	public Class<W> getContract() {
		return contract;
	}

	public W getSource() {
		return source;
	}

	public W getDestination() {
		return destination;
	}
}
