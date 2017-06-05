package com.dreamteam.payd.administration.dao.rest;

import com.dreamteam.payd.administration.dao.RegionDao;
import com.dreamteam.payd.administration.dao.qualifier.REST;
import com.dreamteam.payd.administration.model.Region;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hein on 6/5/17.
 */
@Stateless
@REST
public class RegionDaoREST implements RegionDao {

    @Override
    public void create(Region entity) {
        Gson gson = new Gson();


    }

    @Override
    public Region update(Region entity) {
        return null;
    }

    @Override
    public void remove(Region entity) {

    }

    @Override
    public void flush() {
        throw new NotImplementedException();
    }

    @Override
    public Region findById(Long id) {
        return null;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        HttpResponse<JsonNode> request = null;
        try {
            request = Unirest.get("http://192.168.24.31:8080/movement-registration/api/regions")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        JSONArray regionsJson = request.getBody().getArray();
        for (int i = 0; i < regionsJson.length(); i++) {
            JSONObject jsonObject = regionsJson.getJSONObject(i);
            Region region = new Region();
            region.setId(jsonObject.getLong("id"));
            region.setName(jsonObject.getString("name"));
            region.setAreaCode(jsonObject.getString("areaCode"));
            regions.add(region);
        }
        return regions;
    }
}
