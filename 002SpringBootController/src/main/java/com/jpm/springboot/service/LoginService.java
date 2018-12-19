package com.jpm.springboot.service;
import org.springframework.stereotype.Service;
/*@author Smita
 * 
 */
@Service
public class LoginService implements ILoginService{
	@Override
    public boolean validateUser(String userid, String password) {
        return userid.equalsIgnoreCase("smita")
                && password.equalsIgnoreCase("smita@123");
    }
}
