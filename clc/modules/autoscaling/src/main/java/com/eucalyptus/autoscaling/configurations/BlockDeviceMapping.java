/*************************************************************************
 * Copyright 2009-2013 Eucalyptus Systems, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you need
 * additional information or have any questions.
 ************************************************************************/
package com.eucalyptus.autoscaling.configurations;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 *
 */
@Embeddable
public class BlockDeviceMapping {
  
  @Column( name = "metadata_device_name", nullable = false )
  private String deviceName;

  @Column( name = "metadata_virtual_name" )
  private String virtualName;

  @Embedded
  private EbsParameters ebsParameters;
  
  protected BlockDeviceMapping() {    
  }

  protected BlockDeviceMapping( final String deviceName ) {
    setDeviceName( deviceName );
  }

  protected BlockDeviceMapping( final String deviceName,
                                final String virtualName,
                                final String snapshotId,
                                final Integer volumeSize ) {
    setDeviceName( deviceName );
    setVirtualName( virtualName );
    setEbsParameters( new EbsParameters( snapshotId, volumeSize ) );
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName( final String deviceName ) {
    this.deviceName = deviceName;
  }

  @Nullable
  public String getVirtualName() {
    return virtualName;
  }

  public void setVirtualName( final String virtualName ) {
    this.virtualName = virtualName;
  }

  @Nullable
  public EbsParameters getEbsParameters() {
    return ebsParameters;
  }

  public void setEbsParameters( final EbsParameters ebsParameters ) {
    this.ebsParameters = ebsParameters;
  }

  @SuppressWarnings( "RedundantIfStatement" )
  @Override
  public boolean equals( final Object o ) {
    if ( this == o ) return true;
    if ( o == null || getClass() != o.getClass() ) return false;

    final BlockDeviceMapping that = (BlockDeviceMapping) o;

    if ( !deviceName.equals( that.deviceName ) ) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return deviceName.hashCode();
  }

}
