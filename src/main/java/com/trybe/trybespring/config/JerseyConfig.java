package com.trybe.trybespring.config;

import com.trybe.trybespring.application.BookController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(BookController.class);
  }

}

// para que o Spring reconheça o Jersey (JAX-RS).
