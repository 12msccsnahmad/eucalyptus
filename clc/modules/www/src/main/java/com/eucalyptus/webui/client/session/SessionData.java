package com.eucalyptus.webui.client.session;

import java.util.HashMap;
import com.eucalyptus.webui.client.service.LoginUserProfile;

public class SessionData {
  
  public static final String VERSION = "version";
  public static final String SEARCH_RESULT_PAGE_SIZE = "search-result-page-size";
  public static final String LOGO_TITLE = "logo-title";
  public static final String LOGO_SUBTITLE = "logo-subtitle";
  public static final String RIGHTSCALE_REGISTRATION_BASE_URL = "rightscale-registration-base-url";
  
  private LoginUserProfile user;
  private HashMap<String, String> props = new HashMap<String, String>( );
  
  public SessionData( ) {
  }
  
  public LoginUserProfile getLoginUser( ) {
    return user;
  }
  
  public void setLoginUser( LoginUserProfile user ) {
    this.user = user;
  }

  public String getProperty( String name ) {
    return this.props.get( name );
  }

  public void setProperties( HashMap<String, String> input ) {
    this.props.putAll( input );
  }
  
  public int getIntProperty( String name, int def ) {
    try {
      String value = getProperty( name );
      if ( value == null ) {
        return def;
      }
      return Integer.parseInt( getProperty( name ) );
    } catch ( Exception e ) {
      return def;
    }
  }
  
  public String getStringProperty( String name, String def ) {
    String val = getProperty( name );
    return ( val == null ? def : val );
  }
  
}