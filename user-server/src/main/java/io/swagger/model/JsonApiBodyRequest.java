package io.swagger.model;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * JsonApiBodyRequest
 */

public class JsonApiBodyRequest   {
  
  private String email;
  private String password;
  private List<RegUser> users;

  public JsonApiBodyRequest login(String email, String password) {
	    this.email = email;
	    this.password = password;
	    return this;
  }
  
  public JsonApiBodyRequest logout(String email) {
	    this.email = email;
	    return this;
}
  
  public JsonApiBodyRequest users(List<RegUser> users) {
    this.users = users;
    return this;
  }

  public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public JsonApiBodyRequest addUsersItem(RegUser usersItem) {
    this.users.add(usersItem);
    return this;
  }
  


  /**
   * Get users
   * @return users
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<RegUser> getUsers() {
    return users;
  }

  public void setUsers(List<RegUser> users) {
    this.users = users;
  }


  public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonApiBodyRequest jsonApiBodyRequest = (JsonApiBodyRequest) o;
    return Objects.equals(this.users, jsonApiBodyRequest.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonApiBodyRequest {\n");
    
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

