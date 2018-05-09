package com.guddqs.web;

import com.guddqs.base.BaseController;
import com.guddqs.common.MapBean;
import com.guddqs.common.PageEntity;
import com.guddqs.common.PageParams;
import com.guddqs.entity.UserModel;
import com.guddqs.service.IUserService;
import com.guddqs.utils.UUIDUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wq
 * @date 2018/5/8
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private IUserService userService;

    @GetMapping("/findAll")
    public MapBean findAll() throws Exception {
        List<UserModel> userModelList = userService.findAll();
        return success(userModelList);
    }

    @PostMapping("/findAll")
    public MapBean findAll(@RequestBody Map<String, Object> filter) throws Exception {
        PageParams pageParams = getPageParams(filter);
        if (filter.containsKey("nameLike")) {
            filter.put("nameLike", "%" + filter.get("nameLike") + "%");
        }
        PageEntity<UserModel> pageEntity = userService.findAll(pageParams, filter);
        return success(pageEntity);
    }


    @GetMapping("/find/{name}")
    public MapBean findById(@PathVariable("name") String id) throws Exception {
        UserModel userModel = userService.findById(id);
        if (userModel == null) {
            return error("Data Not Exists");
        }
        return success(userModel);
    }

    @PostMapping("/add")
    public MapBean add(@RequestBody UserModel userModel) throws Exception {
        if (userModel.getUserId() == null) {
            userModel.setUserId(UUIDUtils.newID());
        }
        userService.add(userModel);
        return success(userModel);
    }

    @PostMapping("/modify")
    public MapBean modify(@RequestBody UserModel userModel) throws Exception {
        userService.modify(userModel);
        return success(userModel);
    }

    @PostMapping("/remove")
    public MapBean remove(@RequestBody Object[] ids) throws Exception {
        userService.remove(ids);
        return success(ids);
    }

}
