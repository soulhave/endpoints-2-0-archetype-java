package com.acme.cloudendpoints;

import com.acme.cloudendpoints.echo.Message;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;

@Api(name = "echo", version = "v1", namespace = @ApiNamespace(ownerDomain = "echo.acme.com", ownerName = "echo.acme.com", packagePath = ""))
public class MyApi {
  @ApiMethod(name = "echo")
  public Message echo(Message message, @Named("n") @Nullable Integer n) {
    return doEcho(message, n);
  }

  /**
   * Rerturn the number of characteres 
   * based on the number of the registers.
   * @param message
   * @param n
   * @return
   */
  private Message doEcho(Message message, Integer n) {
    if (n != null && n >= 0) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (i > 0) {
          sb.append(" ");
        }
        sb.append(message.getMessage());
      }
      message.setMessage(sb.toString());
    }
    return message;
  }

}
