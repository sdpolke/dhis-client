package com.ezest.dhis2.portal.adapter;

import java.util.List;

import org.hisp.dhis.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ezest.dhis2.portal.config.PortalConfig;
import com.ezest.dhis2.portal.model.UserGroup;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserGroupAdapter {
    private static final String USER_DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss.SSS";
    @Autowired
    PortalConfig config;

    public List<UserGroup> getUserGroups() {

        /*String userGroupResponse = config.restTemplate().getForObject(config.userGroupEndpoint(), String.class);

      UserGroup[] userGroups = null;
        try {
            Gson gson = new GsonBuilder().setDateFormat(USER_DATE_FORMAT).create();
            gson.fromJson(userGroupResponse, UserGroup[].class);
            userGroups = gson.fromJson(userGroupResponse, UserGroup[].class);
            return Arrays.asList(userGroups);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

       // System.out.println(Objects.toString(userGroupResponse));
       // System.out.println(Objects.toString(userGroups));

        return config.getPortalDhis2().getUserGroups(Query.instance());
    }
}
