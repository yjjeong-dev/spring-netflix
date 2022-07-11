package yjjeong.sevice.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@PropertySource(value = {"application.yml"})
@RequestMapping("/v1/home")
public class HomeController {

  private static final Logger logger = LogManager.getLogger(HomeController.class);

  @Value("${server.port}")
  int serverPort;

  @GetMapping()
  public ResponseEntity<String> encryptPcaSession(HttpServletRequest httpServletRequest,
      @RequestParam(required = false) Map<String, Object> requestParam,
      @RequestBody(required = false) Map<String, Object> requestBody) {

     String message = String.format("server port - %s", serverPort);

    return ResponseEntity.status(HttpStatus.OK).body(message);
  }
}
