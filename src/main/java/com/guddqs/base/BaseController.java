package com.guddqs.base;

import com.guddqs.common.MapBean;
import com.guddqs.common.PageEntity;
import com.guddqs.common.PageParams;
import com.guddqs.utils.JsonResultUtil;

import java.util.Map;

/**
 * @author wq
 * @date 2018/5/8
 */
public class BaseController {

    protected MapBean success() {
        return JsonResultUtil.successResult();
    }

    protected MapBean success(Object data) {
        if (data instanceof PageEntity) {
            return JsonResultUtil.successPageResult((PageEntity) data);
        }
        return JsonResultUtil.successResult(data);
    }

    protected MapBean error(String errDesc) {
        return JsonResultUtil.errorResult(errDesc);
    }

    protected PageParams getPageParams(Map<String, Object> filter) {
        PageParams pageParams = new PageParams();
        pageParams.setStart((Integer) filter.get("start"));
        pageParams.setLimit((Integer) filter.get("limit"));
        return pageParams;
    }
}
