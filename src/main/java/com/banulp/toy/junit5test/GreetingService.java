package com.banulp.toy.junit5test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private FamilyService familyService;

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
