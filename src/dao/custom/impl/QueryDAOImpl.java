package dao.custom.impl;

import dao.CrudUtil;
import dao.QueryDAO;
import java.sql.ResultSet;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public String getId() throws Exception {
        ResultSet set = CrudUtil.
                execute("SELECT stId FROM student ORDER BY stId DESC LIMIT 1");
        String stId="S001";
        if (set.next()){
            String temp=set.getString(1);
            String[] cs = temp.split("S");
            int selectedId=Integer.parseInt(cs[1]);
            if (selectedId>10){
                stId="S0"+(selectedId+1);
            }
        }
        return stId;
    }
}
