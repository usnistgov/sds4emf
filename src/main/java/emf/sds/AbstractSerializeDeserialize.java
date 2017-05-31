package emf.sds;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSerializeDeserialize {

	static Logger log = LoggerFactory.getLogger(AbstractSerializeDeserialize.class);

	protected static final ResourceSet resourceSet = new ResourceSetImpl();
	protected static Resource resource;

	protected static void init() {
		log.trace("AbstractSerializeDeserialize==>" + resourceSet);
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory());
		log.trace("<==AbstractSerializeDeserialize");
	}
	
	public static ResourceSet getResourceSet() {
		return resourceSet;
	}

	public static Resource getResource() {
		return resource;
	}
}
