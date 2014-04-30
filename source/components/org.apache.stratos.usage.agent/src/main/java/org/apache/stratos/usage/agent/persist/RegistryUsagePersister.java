/*
 *Licensed to the Apache Software Foundation (ASF) under one
 *or more contributor license agreements.  See the NOTICE file
 *distributed with this work for additional information
 *regarding copyright ownership.  The ASF licenses this file
 *to you under the Apache License, Version 2.0 (the
 *"License"); you may not use this file except in compliance
 *with the License.  You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing,
 *software distributed under the License is distributed on an
 *"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *KIND, either express or implied.  See the License for the
 *specific language governing permissions and limitations
 *under the License.
 */
package org.apache.stratos.usage.agent.persist;

import org.apache.stratos.common.constants.UsageConstants;
import org.apache.stratos.usage.agent.beans.BandwidthUsage;
import org.apache.stratos.usage.agent.util.Util;
import org.wso2.carbon.utils.multitenancy.MultitenantConstants;

import java.lang.System;

/**
 * this class is used to store incoming and outgoing bandwidth
 */

public class RegistryUsagePersister {

    /**
     * method to store incoming bandwidth
     * @param tenantId tenant id
     * @param size value of the incoming bandwidth
     */

    public static void storeIncomingBandwidth(int tenantId, long size) {
        if ((MultitenantConstants.SUPER_TENANT_ID!=tenantId) && (size > 0)) {
            BandwidthUsage usage = new BandwidthUsage(
                    tenantId, UsageConstants.REGISTRY_INCOMING_BW, size);
            Util.addToPersistingControllerQueue(usage);
        }
    }
    //=============================================================

    public static void storeAddContent(int tenantId, long size) {
        if ((MultitenantConstants.SUPER_TENANT_ID!=tenantId) && (size > 0)) {
            BandwidthUsage usage = new BandwidthUsage(
                    tenantId, "ContentBandwidth-In", size);
            Util.addToPersistingControllerQueue(usage);
        }
    }
    public static void storeDeleteContent(int tenantId, long size) {
        if ((MultitenantConstants.SUPER_TENANT_ID!=tenantId) && (size > 0)) {
            BandwidthUsage usage = new BandwidthUsage(
                    tenantId, "ContentBandwidth-Out", size);
            Util.addToPersistingControllerQueue(usage);
        }
    }
   //=============================================================
    /**
     * method to store outgoingBandwidth
     * @param tenantId tenant id
     * @param size value of the outgoing bandwidth
     */
    public static void storeOutgoingBandwidth(int tenantId, long size) {
        if ((MultitenantConstants.SUPER_TENANT_ID!=tenantId) && (size > 0)) {
            BandwidthUsage usage = new BandwidthUsage(
                    tenantId, UsageConstants.REGISTRY_OUTGOING_BW, size);
            Util.addToPersistingControllerQueue(usage);
        }
    }
}
