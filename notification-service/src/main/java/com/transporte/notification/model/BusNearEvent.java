package com.transporte.notification.model;





public class BusNearEvent {
    private Long busId;
    private Long routeId;


    
    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
    
}
