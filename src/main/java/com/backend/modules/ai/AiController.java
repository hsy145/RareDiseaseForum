package com.backend.modules.ai;

import com.backend.common.utils.R;
import com.backend.common.utils.RestTemplateUtil;
import com.backend.modules.entity.AIMessageList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Map;

@RequestMapping("/AI")
@RestController
public class AiController {
    public final String BASE_URL="https://aip.baidubce.com";

    @PostMapping("/getAccessToken")
    public String getAccessToken(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL+"/oauth/2.0/token")
                .queryParam("grant_type","client_credentials")
                .queryParam("client_id","1gJ5FxR4nz0dSfl5iWhMQtsA")
                .queryParam("client_secret","lkaPz8SF9yP3eGYLgfHVCfhnew5sPSBR");
        Map res = RestTemplateUtil.post(builder.toUriString(), null, Map.class);
        return res.get("access_token").toString();
    }
    @PostMapping("/chat")
    public R chat(@RequestBody AIMessageList messages){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL+"/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions")
                .queryParam("access_token",getAccessToken());
        Map res = RestTemplateUtil.post(builder.toUriString(), messages, Map.class);
        return R.ok().put("message",res.get("result"));
    }
}
