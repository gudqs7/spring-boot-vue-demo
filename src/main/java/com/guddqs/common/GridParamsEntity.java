package com.guddqs.common;

import com.guddqs.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2018/5/8
 */
public class GridParamsEntity {


    private int start = 0;
    private int limit;
    private int page;
    private String sort;
    private String filter;
    private List<FilterEntity> filterList = new ArrayList<FilterEntity>();
    private List<SortEntity> sortList = new ArrayList<SortEntity>();

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) throws Exception {
        this.sort = sort;

        if (this.sort != null && this.sort.length() > 0) {
            List<SortEntity> sortList = getSortList();
            sortList.clear();
            List<MapBean> ja = JsonUtils.getEntityList(this.sort);
            for (int i = 0; i < ja.size(); i++) {
                MapBean jo = ja.get(i);
                SortEntity entity = new SortEntity();
                entity.setDirection(jo.getString("direction"));
                entity.setField(jo.getString("property"));
                if (jo.containsKey("cast") && jo.getString("caste") != null) {
                    entity.setCast(jo.getString("cast").toUpperCase());
                }
                sortList.add(entity);
            }
            setSortList(sortList);
        }
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) throws Exception {
        this.filter = filter;

        if (this.filter != null && this.filter.length() > 0) {
            List<FilterEntity> filterList = getFilterList();
            filterList.clear();
            List<MapBean> ja = JsonUtils.getEntityList(this.filter);
            for (int i = 0; i < ja.size(); i++) {
                MapBean jo = ja.get(i);

                if (!jo.has("type") || !jo.has("type") || !jo.has("field")) {
                    continue;
                }

                String type = jo.getString("type");
                Object value = jo.get("value");

                FilterEntity entity = new FilterEntity();
                entity.setField(jo.getString("field"));
                entity.setValue(value);
                entity.setOperator(" = ");
                entity.setType(type);

                if ("string".equals(type)) {
                    entity.setOperator(" like ");
                    entity.setValue("'%" + value + "%'");
                }
                if ("numeric".equals(type) || "date".equals(type)) {
                    String comparison = jo.getString("comparison");
                    if ("lt".equals(comparison)) {
                        entity.setOperator(" < ");
                    }
                    if ("gt".equals(comparison)) {
                        entity.setOperator(" > ");
                    }
                    if ("eq".equals(comparison)) {
                        entity.setOperator(" = ");
                    }
                }
                if ("date".equals(type)) {
                    entity.setValue("'" + value + "'");
                }
                if ("list".equals(type)) {
                    entity.setOperator(" in ");
                    StringBuilder sbValue = new StringBuilder();
                    sbValue.append(" ( ");

                    Object[] objArray = JsonUtils.getObjectArray(value.toString()).toArray();
                    for (int j = 0; j < objArray.length; j++) {
                        Object obj = objArray[j];
                        if (obj instanceof Integer) {
                            sbValue.append(obj);
                        }
                        if (obj instanceof String) {
                            sbValue.append("'");
                            sbValue.append(obj);
                            sbValue.append("'");
                        }
                        if (j < objArray.length - 1) {
                            sbValue.append(",");
                        }
                    }
                    sbValue.append(" ) ");
                    entity.setValue(sbValue.toString());
                }
                if (type.equals("boolean")) {
                    entity.setValue(Boolean.valueOf(value.toString()) ? 1 : 0);
                }
                filterList.add(entity);
            }
            setFilterList(filterList);
        }
    }

    public List<SortEntity> getSortList() {
        return sortList;
    }

    public void setSortList(List<SortEntity> sortList) {
        this.sortList = sortList;
    }

    public List<FilterEntity> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<FilterEntity> filterList) {
        this.filterList = filterList;
    }

    public GridParamsEntity addSort(String property, String direction) {
        boolean bExists = false;
        for (SortEntity sortEntity : this.sortList) {
            if (sortEntity.getField().trim().toLowerCase().equals(property.trim().toLowerCase())) {
                bExists = true;
                break;
            }
        }
        if (!bExists) {
            SortEntity e = new SortEntity();
            e.setField(property);
            e.setDirection(direction);
            this.sortList.add(e);
        }
        return this;
    }

    public GridParamsEntity addSort(String property) {
        return addSort(property, " ASC ");
    }

    public GridParamsEntity replaceField(String oldField, String newField) {
        for (FilterEntity e : this.getFilterList()) {
            if (e.getField().equals(oldField)) {
                if (newField == null || "".equals(newField)) {
                    this.getFilterList().remove(e);
                } else {
                    e.setField(newField);
                }
                break;
            }
        }
        for (SortEntity e : this.getSortList()) {
            if (e.getField().equals(oldField)) {
                if (newField == null || "".equals(newField)) {
                    this.getSortList().remove(e);
                } else {
                    e.setField(newField);
                }
                break;
            }
        }
        return this;
    }
}
