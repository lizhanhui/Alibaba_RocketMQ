package com.ndpmedia.rocketmq.cockpit.controller.service;

import com.ndpmedia.rocketmq.nameserver.NameServerKVService;
import com.ndpmedia.rocketmq.nameserver.model.KV;
import com.ndpmedia.rocketmq.nameserver.model.KVStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/ajax/name-server/kv")
public class NameServerKVServiceController {

    @Autowired
    @Qualifier("nameServerKVService")
    private NameServerKVService nameServerKVService;

    @RequestMapping
    @ResponseBody
    public List<KV> list(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        return nameServerKVService.list();
    }


    @RequestMapping(value = "/{status}", method = RequestMethod.GET)
    @ResponseBody
    public List<KV> list(@PathVariable(value = "status") String status, HttpServletRequest request,
                         HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        return nameServerKVService.list(KVStatus.valueOf(status));
    }

}
