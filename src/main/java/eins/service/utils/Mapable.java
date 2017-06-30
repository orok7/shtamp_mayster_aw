package eins.service.utils;

import eins.service.interfaces.DbService;

import java.util.List;
import java.util.Map;

public interface Mapable<T> {
    public T parseFromMap(Map<String, String> map, DbService dbService);

    default int checkInt(String strInt){
        int Int;
        try { Int = Integer.valueOf(strInt); } catch (NumberFormatException e) {Int = 0;}
        return Int;
    }

    default Object checkObject(String strId, DbService dbService, Class<?> clazz){
        int id;
        try { id = Integer.valueOf(strId); } catch (NumberFormatException e) { id = -1;}
        if (id != -1) return dbService.findOne(id, clazz);
        return null;
    }

    default <TT> void checkObjects(String strIds, List<TT> list, DbService dbService, Class<?> clazz){
        if (strIds != null && !strIds.isEmpty()){
            for (String s :strIds.split("@&")){
                int depId;
                try {
                    depId = Integer.valueOf(s);
                    list.add((TT)dbService.findOne(depId, clazz));
                }
                catch (NumberFormatException e) {  }
            }
        }
    }
}
