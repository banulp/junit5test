package com.banulp.toy.junit5test;

import org.springframework.stereotype.Service;

@Service
public class FamilyService {

    public String getFamilyName(int bestOrder ) {
        String name = "my Family";

        switch (bestOrder) {
            case 1:
                name = "ys";
                break;
            case 2:
                name = "hy";
                break;
            case 3:
                name = "ny";
                break;
            default:
                break;
        }
        return name;
    }
}
