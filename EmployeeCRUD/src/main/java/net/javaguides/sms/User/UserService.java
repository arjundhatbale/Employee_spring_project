package net.javaguides.sms.User;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<UserEntity> getAllUser(){
		return userRepository.findAll();
	}
	
	public Optional<UserEntity> getUser(Integer id) {
		return userRepository.findById(id);
	}
	
//	public ResponseEntity<UserEntity> saveUser(UserEntity entity){
//		UserEntity entity2 = userRepository.save(entity);
//		return new ResponseEntity< >(entity2,HttpStatus.CREATED);
//	}
	
	public UserEntity saveUserEntity(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
	public ResponseEntity<String> deleteUser(Integer id){
		Optional<UserEntity> user =  getUser(id);
		if(user.isPresent()) {
			userRepository.deleteById(id);
 			return new ResponseEntity("Employee with id : \" + id + \" is deleted successfully.", HttpStatus.ACCEPTED);
		}else {
			System.out.println();
 			return new ResponseEntity("Employee with id " + id + " is not found.", HttpStatus.NOT_FOUND);
		}
	}
	
	public UserEntity dtoToUser(UserDto userDTO ) {
		UserEntity userEntity = this.modelMapper.map(userDTO, UserEntity.class);
		return userEntity;
	}
	
	public UserDto userDTOToUserEntity(UserEntity userEntity) {
		UserDto userDTO = modelMapper.map(userEntity, UserDto.class);
		return userDTO;
	}
}
