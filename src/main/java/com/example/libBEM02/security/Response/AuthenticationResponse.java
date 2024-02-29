	package com.example.libBEM02.security.Response;

	import com.fasterxml.jackson.annotation.JsonProperty;
	import lombok.AllArgsConstructor;
	import lombok.Builder;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

	@JsonProperty("token")
    private String token;
	
	private String message;
}
