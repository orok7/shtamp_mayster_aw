package eins.entity;

import eins.service.interfaces.DbService;

import java.util.Map;

public interface Mapable<T> {
    public T parseFromMap(Map<String, String> map, DbService dbService) throws Exception;
}
