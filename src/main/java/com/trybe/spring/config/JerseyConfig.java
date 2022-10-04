package com.trybe.spring.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import com.trybe.spring.application.BookController;

@Component
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(BookController.class);
  }

}

// para que o Spring reconheça o Jersey (JAX-RS).
