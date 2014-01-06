package nz.org.p2p.model.hibernate;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import nz.org.p2p.model.event.api.EventManagerService;
import nz.org.p2p.model.member.api.MemberManagerService;

public class DataRepository {
	public static final String DEFAULT_ENTITY = "";
	static final int CONSTANT=Modifier.STATIC|Modifier.FINAL;
	DataSourceService dataSource;
	MemberManagerService members;
	EventManagerService events;

	void setDataAccessobjects(DataAccessObject[] daos){
		for(DataAccessObject dao:daos) {
			String eName=null;
			// try to identify the entity by annotation
			DataAccess dataAccess = dao.getClass().getAnnotation(DataAccess.class);
			if(dataAccess!=null) {
				eName=dataAccess.entity();
			}
			// try to identify the entity by constant
			if("".equals(eName)) {
				Field fEName=null;
				try {
					fEName = dao.getClass().getField("ENTITY_NAME");
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchFieldException e1) {
					throw new IllegalArgumentException("Objects of type "
							+dao.getClass().getName()
							+ " can not be used as DAOs becuase they have a "
							+ "@DataAccess annotaion or provide an ENTITY_NAME "
							+ "constant");
				}
				if(fEName.getType()==String.class
						&& (fEName.getModifiers()& CONSTANT)==CONSTANT){
					try {
						eName=(String) fEName.get(dao);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			String pName;
			StringBuilder sb=new StringBuilder(eName);
			if (DEFAULT_ENTITY.equals(eName)) {
				sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
				pName=dao.getClass().getSimpleName()+"Manager";
			}else {
				for (int x=sb.indexOf("_",1);x>=0;sb.indexOf("_",x)) {
					sb.delete(x, x+1);
					sb.setCharAt(x, Character.toUpperCase(sb.charAt(x)));
				}
				pName=sb.toString().replace('-','_')+"Manager";
			}



			Field pField;
			try {
				pField = this.getClass().getField(pName);
				if (pField.getType().isAssignableFrom(dao.getClass())) {
					pField.set(this, dao);
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
