package com.ezest.dhis2.portal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hisp.dhis.model.Category;
import org.hisp.dhis.model.CategoryOptionGroupSet;
import org.hisp.dhis.model.IdentifiableObject;
import org.hisp.dhis.model.OrgUnit;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class User extends IdentifiableObject implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
    private UUID uuid;

   // @JsonProperty
   // private String id;

    /**
     * Required and unique.
     */
    @JsonProperty
    private String username;
    
    protected User createdBy;
    protected User lastUpdatedBy;

    /**
     * Indicates whether this user can only be authenticated externally, such as
     * through OpenID or LDAP.
     */
    @JsonProperty
    private boolean externalAuth;

    /**
     * Unique OpenID.
     */
    @JsonProperty
    private String openId;

    /**
     * Unique LDAP distinguished name.
     */
    @JsonProperty
    private String ldapId;

    /**
     * Required. Will be stored as a hash.
     */
    @JsonProperty
    private String password;

    /**
     * Required. Does this user have two factor authentication
     */
    @JsonProperty
    private boolean twoFA;

    /**
     * Required. Automatically set in constructor
     */
    @JsonProperty
    private String secret;

    /**
     * Date when password was changed.
     */
    @JsonProperty
    private Date passwordLastUpdated;

    /**
     * Set of user roles.
     */
    @JsonProperty
    private Set<UserRole> userRoles = new HashSet<>();


    /* Category option group set dimensions to constrain data analytics
     aggregation.
    */
    @JsonProperty
    private Set<CategoryOptionGroupSet> cogsDimensionConstraints = new HashSet<>();


    //  Category dimensions to constrain data analytics aggregation.

    @JsonProperty
    private Set<Category> catDimensionConstraints = new HashSet<>();


    // List of previously used passwords.

    @JsonProperty
    private List<String> previousPasswords = new ArrayList<>();


    //Date of the user's last login.

    @JsonProperty
    private Date lastLogin;


    //The token used for a user account restore. Will be stored as a hash.

    @JsonProperty
    private String restoreToken;


    //The token used for a user lookup when sending restore and invite emails.

    @JsonProperty
    private String idToken;


    // The timestamp representing when the restore window expires.

    @JsonProperty
    private Date restoreExpiry;

    // Indicates whether this user was originally self registered.

    @JsonProperty
    private boolean selfRegistered;

// Indicates whether this user is currently an invitation.

    @JsonProperty
    private boolean invitation;


 /*    Indicates whether this is user is disabled, which means the user cannot
     be authenticated.*/

    @JsonProperty
    private boolean disabled;
    @JsonProperty
    private boolean isCredentialsNonExpired;
    @JsonProperty
    private boolean isAccountNonLocked;



   /*  The timestamp representing when the user account expires. If not set the
     account does never expire.*/

    @JsonProperty
    private Date accountExpiry;
    @JsonProperty
    private String surname;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String email;
    @JsonProperty
    private String phoneNumber;
    @JsonProperty
    private String jobTitle;
    @JsonProperty
    private String introduction;
    @JsonProperty
    private String gender;
    @JsonProperty
    private Date birthday;
    @JsonProperty
    private String nationality;
    @JsonProperty
    private String employer;
    @JsonProperty
    private String education;
    @JsonProperty
    private String interests;
    @JsonProperty
    private String languages;
    @JsonProperty
    private String welcomeMessage;
    @JsonProperty
    private Date lastCheckedInterpretations;
    @JsonProperty
    private Set<UserGroup> userGroups = new HashSet<>();
    @JsonProperty
    private String whatsApp;
    @JsonProperty
    private String facebookMessenger;
    @JsonProperty
    private String skype;
    @JsonProperty
    private String telegram;
    @JsonProperty
    private String twitter;

    // private FileResource avatar;

    // Backward comp. field, will be removed when front-end has converted to new
    // User model
    private transient UserCredentialsDto userCredentials;


    // Organisation units for data input and data capture operations.

    @JsonProperty
    private Set<OrgUnit> organisationUnits = new HashSet<>();


// Organisation units for data output and data analysis operations.

    @JsonProperty
    private Set<OrgUnit> dataViewOrganisationUnits = new HashSet<>();

    // Organisation units for tracked entity instance search operations.
    @JsonProperty

    private Set<OrgUnit> teiSearchOrganisationUnits = new HashSet<>();


    /**
     * Max organisation unit level for data output and data analysis operations,
     * may be null.
     */
    @JsonProperty
    private Integer dataViewMaxOrganisationUnitLevel;

    /**
     * Ordered favorite apps.
     */
    @JsonProperty
    private List<String> apps = new ArrayList<>();

	public User() {
	}
}

