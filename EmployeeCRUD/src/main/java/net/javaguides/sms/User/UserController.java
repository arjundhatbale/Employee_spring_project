package net.javaguides.sms.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/allUser")
	public ResponseEntity<List<UserEntity>> getAllUser(){
		List<UserEntity> alluser = userService.getAllUser();
		return new ResponseEntity<>(alluser,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserEntity> getUser(@Valid @PathVariable("userId") Integer userId){
		Optional<UserEntity> getuserById = userService.getUser(userId);
		return new ResponseEntity<>(getuserById.get(),HttpStatus.ACCEPTED);
	}
	
//	@PostMapping("/saveUser")
//	public ResponseEntity<UserEntity> saveUser(@Valid   @RequestBody UserEntity userEntity){
// 		ResponseEntity<UserEntity> user = userService.saveUser(userEntity);
// 		return user;
// 	}
	@PostMapping("/saveUser")
	public UserEntity saveUser(@Valid @RequestBody UserEntity userEntity) {
		return userService.saveUserEntity(userEntity);
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable("userId") Integer userId){
 		userService.deleteUser(userId);
 		return new ResponseEntity("Empoyee Deleted successfully with id of : " + userId, HttpStatus.OK);
	}
}
