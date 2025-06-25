package com.cs.cakeshop.Dto;

import java.util.List;

public class IngredientsDto {
    private List<String> cakeBase;
    private List<String> truffleFrosting;

    public IngredientsDto() {}

    public List<String> getCakeBase() {
        return cakeBase;
    }

    public void setCakeBase(List<String> cakeBase) {
        this.cakeBase = cakeBase;
    }

    public List<String> getTruffleFrosting() {
        return truffleFrosting;
    }

    public void setTruffleFrosting(List<String> truffleFrosting) {
        this.truffleFrosting = truffleFrosting;
    }
}

