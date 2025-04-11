package LoginApiApplication;

import jakarta.validation.constraints.*;

public class UserRequest {

  @NotBlank(message = "Name is required")
  @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must not contain special characters")
  private String name;

  @NotNull(message = "Age is required")
  @Max(value = 150, message = "Age must not be greater than 150")
  @Min(value = 0, message = "Age must be a positive number")
  private Integer age;

  @NotBlank(message = "Gender is required")
  @Pattern(regexp = "^(Male|Female)$", message = "Gender must be Male or Female")
  private String gender;

  @NotBlank(message = "Email is required")
  @Email(message = "Email should be valid")
  private String email;

  // Getters and Setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
