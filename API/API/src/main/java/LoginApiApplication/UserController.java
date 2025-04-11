package LoginApiApplication;

import LoginApiApplication.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@Validated
public class UserController {

  @PostMapping
  public ResponseEntity<String> loginUser(@Valid @RequestBody UserRequest userRequest) {
    return ResponseEntity.ok("✅ Registered successfully");
  }
}
