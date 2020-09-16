package com.banulp.toy.junit5test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GreetingService {

    @Autowired
    private Environment env;

    @Value("${banulp.toy.desc}")
    private String toyDesc;

    @Autowired
    private FamilyService familyService;

    @Autowired
    private ServerProperties serverProperties;

    public int countOfServer(){
        return serverProperties.getUsers().size();
    }
    
    public String getToyName(){
        return env.getProperty("banulp.toy.name");
    }

    public String getToyDesc(){
        return toyDesc;
    }

    public String greetingToFriend(int bestOrder) {
        return "hello " + getFriendName(bestOrder);
    }

    public String greetingToFamily (int bestOrder) {
        return "hello " + familyService.getFamilyName(bestOrder);
    }

    private String getFriendName (int bestOrder ){
        String name = "noOne";

        switch ( bestOrder ){
            case 1 :
                name = "jisu";
                break;
            case 2 :
                name = "seyo";
                break;
            case 3 :
                name = "bose";
                break;
            case 4 :
                name = "suju";
                break;
            default:
                break;
        }
        return name;
    }

}
