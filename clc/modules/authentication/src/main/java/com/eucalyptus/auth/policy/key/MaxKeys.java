package com.eucalyptus.auth.policy.key;

import net.sf.json.JSONException;
import com.eucalyptus.auth.Contract;
import com.eucalyptus.auth.policy.PolicySpecConstants;
import com.eucalyptus.auth.policy.condition.ConditionOp;
import com.eucalyptus.auth.policy.condition.NumericLessThanEquals;

public class MaxKeys extends ContractKey {

  private static final String KEY = Keys.S3_MAX_KEYS;
  
  private static final String ACTION_LISTBUCKET = PolicySpecConstants.VENDOR_S3 + ":" + PolicySpecConstants.S3_LISTBUCKET;
  private static final String ACTION_LISTBUCKETVERSIONS = PolicySpecConstants.VENDOR_S3 + ":" + PolicySpecConstants.S3_LISTBUCKETVERSIONS;

  @Override
  public void validateConditionType( Class<? extends ConditionOp> conditionClass ) throws JSONException {
    if ( conditionClass != NumericLessThanEquals.class ) {
      throw new JSONException( KEY + " is not allowed in condition " + conditionClass.getName( ) + ". NumericLessThanEquals is required." );
    }
  }

  @Override
  public void validateValueType( String value ) throws JSONException {
    KeyUtils.validateIntegerValue( value, Keys.S3_MAX_KEYS );
  }

  @Override
  public Contract getContract( String[] values ) {
    return new SingleValueContract( this.getClass( ).getName( ), values[0] ) ;
  }

  @Override
  public boolean canApply( String action, String resourceType ) {
    return ( ACTION_LISTBUCKET.equals( action ) || ACTION_LISTBUCKETVERSIONS.equals( action ) );
  }

}
