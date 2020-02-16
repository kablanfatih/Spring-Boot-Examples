package com.kablanfatih.tddexample.entitiy;

import lombok.Getter;

@Getter
public enum AccountStatus {

    OPEN("Acik"),
    IN_PROGRESS("Üzerinde Calisiliyor"),
    SUSPENDEND("Askıda"),
    CLOSED("Kapandi");

    private String label;

    AccountStatus(String label){
        this.label = label;
    }
}
