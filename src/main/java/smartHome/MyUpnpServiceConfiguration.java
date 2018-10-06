package smartHome;

import org.fourthline.cling.DefaultUpnpServiceConfiguration;
import org.fourthline.cling.model.Namespace;
import org.fourthline.cling.transport.impl.AsyncServletStreamServerConfigurationImpl;
import org.fourthline.cling.transport.spi.NetworkAddressFactory;
import org.fourthline.cling.transport.spi.StreamClient;
import org.fourthline.cling.transport.spi.StreamServer;

public class MyUpnpServiceConfiguration extends DefaultUpnpServiceConfiguration{

	@Override
	public StreamClient createStreamClient() {
		// TODO Auto-generated method stub
		return new org.fourthline.cling.transport.impl.jetty.StreamClientImpl(
				new org.fourthline.cling.transport.impl.jetty.StreamClientConfigurationImpl(
						getSyncProtocolExecutorService())
		);
	}

	@Override
	public StreamServer createStreamServer(NetworkAddressFactory networkAddressFactory) {
		// TODO Auto-generated method stub
		return new org.fourthline.cling.transport.impl.AsyncServletStreamServerImpl(
				new org.fourthline.cling.transport.impl.AsyncServletStreamServerConfigurationImpl(
						org.fourthline.cling.transport.impl.jetty.JettyServletContainer.INSTANCE,
						networkAddressFactory.getStreamListenPort())
				);
	}

	@Override
	protected Namespace createNamespace() {
		// TODO Auto-generated method stub
		return new Namespace("/upnp");
	}
	
}
