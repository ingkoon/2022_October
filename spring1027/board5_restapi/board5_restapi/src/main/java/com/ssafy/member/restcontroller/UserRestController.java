package com.ssafy.member.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.controller.ExceptionControllerAdvice;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

import lombok.Builder;

@RestController // -> restController로 만들면 @Controller+@ResponseBody를 자동으로 해준다. Controller
@RequestMapping("/user")
public class UserRestController {

	private MemberService memberService;
	private final Logger logger = LoggerFactory.getLogger(UserRestController.class);


	public UserRestController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("/users")
	public  ResponseEntity<?> userList() {
		try {
			List<MemberDto> list = memberService.listMember(null);
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			}
			else{
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}			 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}			
	}
	
	@PostMapping("/user")
	public  ResponseEntity<?> userJoin(@RequestBody MemberDto memberDto) {
		logger.debug("123123    {}", memberDto);
		try {
			memberService.joinMember(memberDto);
			List<MemberDto> list = memberService.listMember(null);
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			}
			else{
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}			
	}
	
	@PutMapping("/user")
	public  ResponseEntity<?> userModify(@RequestBody MemberDto memberDto) {
		try {
			memberService.modifyMember(memberDto);
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}			
	}
	
	@DeleteMapping("/user/{userid}")
	public ResponseEntity<?> userDelete(@PathVariable("userid") String userId ) {
		try {
			memberService.deleteMember(userId);		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<?> userView(@PathVariable("userid") String userId ) {
		try {
			MemberDto member = memberService.getMember(userId);
			if(member != null) {
				return new ResponseEntity<MemberDto>(member, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}			
	}
	
}
