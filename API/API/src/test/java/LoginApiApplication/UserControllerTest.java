package LoginApiApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void testValidUserData() throws Exception {
    UserRequest user = new UserRequest();
    user.setName("Lokesh Yadav");
    user.setAge(25);
    user.setGender("Male");
    user.setEmail("lokesh@example.com");

    mockMvc.perform(post("/api/login")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isOk());
  }

  @Test
  void testInvalidUserData_MissingFields() throws Exception {
    UserRequest user = new UserRequest(); // Empty

    mockMvc.perform(post("/api/login")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isBadRequest());
  }

  @Test
  void testInvalidUserData_InvalidEmail() throws Exception {
    UserRequest user = new UserRequest();
    user.setName("Lokesh");
    user.setAge(30);
    user.setGender("Male");
    user.setEmail("not-an-email");

    mockMvc.perform(post("/api/login")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isBadRequest());
  }

  @Test
  void testInvalidUserData_SpecialCharInName() throws Exception {
    UserRequest user = new UserRequest();
    user.setName("Lokesh@123");
    user.setAge(30);
    user.setGender("Male");
    user.setEmail("lokesh@example.com");

    mockMvc.perform(post("/api/login")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(user)))
        .andExpect(status().isBadRequest());
  }
}
