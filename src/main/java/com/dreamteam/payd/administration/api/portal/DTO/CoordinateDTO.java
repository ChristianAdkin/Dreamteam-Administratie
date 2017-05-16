package com.dreamteam.payd.administration.api.portal.DTO;

/**
 * Created by Christian Adkin on 16/05/2017.
 */
public class CoordinateDTO {
    private Long lat;
    private Long lng;

    public CoordinateDTO(Long lat, Long lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Long getLng() {
        return lng;
    }

    public void setLng(Long lng) {
        this.lng = lng;
    }
}
