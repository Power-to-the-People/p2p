package nz.org.p2p.security.hibernate;

import org.hibernate.metamodel.binding.EntityBinding;
import org.hibernate.tuple.Instantiator;
import org.hibernate.tuple.entity.EntityMetamodel;
import org.hibernate.tuple.entity.PojoEntityTuplizer;

public class SIDTuplizer extends PojoEntityTuplizer {

	public SIDTuplizer(EntityMetamodel entityMetamodel,
			EntityBinding mappedEntity) {
		super(entityMetamodel, mappedEntity);
	}

	@Override
	protected Instantiator buildInstantiator(EntityBinding entityBinding) {
		return new SIDPojoIntstanciator(entityBinding, null);
	}
}
