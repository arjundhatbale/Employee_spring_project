package net.javaguides.sms.Categories;

public class ApiResponse {

	private final String message;
	
	public ApiResponse(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
