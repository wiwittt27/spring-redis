package com.alawiya.springredis.delivery;

import com.alawiya.springredis.model.User;
import com.alawiya.springredis.model.rs.ResponseInfo;
import com.alawiya.springredis.services.RedisListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/list")
public class ListController {
    private final RedisListService listService;

    public ListController(RedisListService listService) {
        this.listService = listService;
    }

    @PostMapping("/leftPush")
    public ResponseEntity<?> leftPush(@RequestParam String key, @RequestBody User user) {
        listService.pushLeft(key, user);
        return ResponseEntity.ok("added");
    }
    @PostMapping("/rightPush")
    public ResponseEntity<?> rightPush(@RequestParam String key, @RequestBody User user) {
       ResponseInfo rs = listService.pushRight(key, user);
        return new  ResponseEntity<>(rs.getBody(),rs.getHttpHeaders(),rs.getHttpStatus());
    }

    @GetMapping("/getAllList")
    public ResponseEntity<?> getDataListByKey(@RequestParam String key){
        ResponseInfo rs  =  listService.getAllDataKey(key);
        return new ResponseEntity<>(rs.getBody(),rs.getHttpHeaders(),rs.getHttpStatus());
    }

}
