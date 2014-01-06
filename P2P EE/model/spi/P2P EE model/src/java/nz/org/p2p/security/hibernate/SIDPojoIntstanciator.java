package nz.org.p2p.security.hibernate;

import java.io.Serializable;

import nz.org.p2p.security.model.SID;

import org.hibernate.bytecode.spi.ReflectionOptimizer.InstantiationOptimizer;
import org.hibernate.metamodel.binding.EntityBinding;
import org.hibernate.tuple.PojoInstantiator;

public class SIDPojoIntstanciator extends PojoInstantiator {
	public SIDPojoIntstanciator(EntityBinding entityBinding,
			InstantiationOptimizer optimizer) {
		super(entityBinding, optimizer);
	}

	@Override
	public Object instantiate(Serializable id) {
		return  SID.get((String)id);
	}
}
