/* ****************************************************************************
 * $Revision: 18656 $
 * $Date: 2016-02-15 15:40:37 +0000 (Mon, 15 Feb 2016) $
 * $Author: grant.flintoff $
 * ****************************************************************************
 * Copyright (C) 2011 - 2016 HD Insurance Ltd. All Rights Reserved.
 * ****************************************************************************
 */
package service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.configuration.ServiceProperties;

@RestController
public class Controller
{
  @Autowired
  private ServiceProperties serviceProperties;

  @RefreshScope
  @RequestMapping("/")
  public String home()
  {
    return "Hello " + serviceProperties.description;
  }

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping("/service-instances/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName)
  {
    return discoveryClient.getInstances(applicationName);
  }

}