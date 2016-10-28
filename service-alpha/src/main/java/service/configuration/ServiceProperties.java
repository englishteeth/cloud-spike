/* ****************************************************************************
 * $Revision: 18656 $
 * $Date: 2016-02-15 15:40:37 +0000 (Mon, 15 Feb 2016) $
 * $Author: grant.flintoff $
 * ****************************************************************************
 * Copyright (C) 2011 - 2016 HD Insurance Ltd. All Rights Reserved.
 * ****************************************************************************
 */
package service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "alpha")
public class ServiceProperties
{
  public String description;

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

}
