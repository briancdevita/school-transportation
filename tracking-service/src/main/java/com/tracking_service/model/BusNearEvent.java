package com.tracking_service.model;




public class BusNearEvent {
    private Long busId;
    private Long routeId;
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
    private String message;

    public BusNearEvent() {
    }

    public BusNearEvent(Long busId, String message) {
        this.busId = busId;
        this.message = message;
    }

    public Long getBusId() {
        return busId;
    }
    public void setBusId(Long busId) {
        this.busId = busId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
}
