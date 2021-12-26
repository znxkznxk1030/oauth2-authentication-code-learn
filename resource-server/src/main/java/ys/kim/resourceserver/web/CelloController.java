package ys.kim.resourceserver.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CelloController {

  @GetMapping("/cello")
  public String[] getCelloData() {
    return new String[] { "T100", "310A", "311A" };
  }
  
}
