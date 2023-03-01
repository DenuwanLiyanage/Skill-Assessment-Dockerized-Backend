package com.skill_assessment.distribution_service.order_constants;

public enum OrderStatus {

    NEW("NEW"),
    DISPATCHED("DISPATCHED"),
    CANCELLED("CANCELLED");

    private final String text;

    OrderStatus(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
