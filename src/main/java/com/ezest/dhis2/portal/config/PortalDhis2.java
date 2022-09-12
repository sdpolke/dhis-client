package com.ezest.dhis2.portal.config;

import java.util.List;

import org.hisp.dhis.Dhis2;
import org.hisp.dhis.Dhis2Config;
import org.hisp.dhis.model.IdentifiableObject;
import org.hisp.dhis.query.Query;
import org.hisp.dhis.response.object.ObjectResponse;

import com.ezest.dhis2.portal.model.DataSet;
import com.ezest.dhis2.portal.model.PortalObjects;
import com.ezest.dhis2.portal.model.User;
import com.ezest.dhis2.portal.model.UserGroup;
import com.ezest.dhis2.portal.model.UserRole;

public class PortalDhis2 extends Dhis2 {

	private static final String USER_ROLE_FIELDS = String.format("%1$s,authorities[%1$s]", NAME_FIELDS, NAME_FIELDS);
	
	private static final String USER_DTO_FIELDS = String.format("accountExpiry, surname, firstName, email,phoneNumber,"
			+ "jobTitle,introduction,gender, birthday,  nationality, employer,  education,interests,languages,"
			+ "welcomeMessage,lastCheckedInterpretations,whatsApp,facebookMessenger,skype,telegram,twitter");
	private static final String USER_AUTH_FIELDS = String.format("externalAuth, openId, ldapId, password,twoFA,"
			+ "secret,passwordLastUpdated");
	private static final String USER_FIELDS = String.format("%s,displayName, username, userRoles[%1$s], groups[%1$s]",
			USER_AUTH_FIELDS, USER_DTO_FIELDS, NAME_FIELDS, NAME_FIELDS);
	
	private static final String DATA_SET_FIELDS = String.format("%s,displayName",
			 NAME_FIELDS, NAME_FIELDS);
	
	private static final String USER_GROUP_FIELDS = String.format("%s,members",
			 NAME_FIELDS, NAME_FIELDS);
	
	public PortalDhis2(Dhis2Config config) {
		super(config);
	}

	public List<User> getUsers(Query query) {
		return getObject(
				config.getResolvedUriBuilder().appendPath("users").addParameter("fields", USER_FIELDS),
				query, PortalObjects.class).getUsers();
	}
	
	public List<UserRole> getUserRoles(Query query) {
		return getObject(
				config.getResolvedUriBuilder().appendPath("userRoles").addParameter("fields", USER_ROLE_FIELDS),
				query, PortalObjects.class).getUserRoles();
	}

	public List<DataSet> getDataSets(Query query) {
		return getObject(
				config.getResolvedUriBuilder().appendPath("dataSets").addParameter("fields", DATA_SET_FIELDS),
				query, PortalObjects.class).getDataSets();
	}
	
	public List<UserGroup> getUserGroups(Query query) {
		return getObject(
				config.getResolvedUriBuilder().appendPath("userGroups").addParameter("fields", USER_GROUP_FIELDS), query,
				PortalObjects.class).getUserGroups();
	}
	
	@Override
	public <T> T getObject(String path, String id, Class<T> type) {
		return super.getObject(path, id, type);
	}
	
	@Override
	public ObjectResponse saveMetadataObject(String path, IdentifiableObject object) {
		return super.saveMetadataObject(path, object);

	}

}
