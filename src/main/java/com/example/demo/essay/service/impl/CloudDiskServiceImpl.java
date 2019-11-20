package com.example.demo.essay.service.impl;

import com.dayainfo.common.intfce.api.ApiResponseDTO;
import com.dayainfo.common.util.*;
import com.example.demo.essay.constant.CloudDiskConstant;
import com.example.demo.essay.model.CloudDiskApiReturnInfo;
import com.example.demo.essay.service.CloudDiskService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudDiskServiceImpl implements CloudDiskService {
    @Override
    public String uploadImg(String base64) {
        ApiResponseDTO apiResponseDTO = null;
        String apiInfo = "";
        base64 = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(base64));
        if (Base64Util.isBase64Image(base64)) {
            String url = CloudDiskConstant.IMG_UPLOAD_URL;
            String domain = "test.kid.chaoxing.com";
            Map<String, String> params = new HashMap<>();
            params.put("base64", base64);
            params.put("domain", domain);
            apiInfo = HttpUtil.sendHttpsRequestByPost(url, params);
            //{"objectId":"6cd7db62b772f0ab7312c621f25622fd","status":"1001"}
            if (StringUtils.isNotBlank(apiInfo)) {
                CloudDiskApiReturnInfo cloudDiskApiReturnInfo = new JsonMapper().fromJson(apiInfo, CloudDiskApiReturnInfo.class);
                String status = cloudDiskApiReturnInfo.getStatus();
                String objectId = cloudDiskApiReturnInfo.getObjectId();
                String successStatus = "1001";
                if (successStatus.equals(status)) {
                    apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_OK).msg("上传成功").data(objectId).build();
                } else {
                    apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_BAD_REQUEST).msg("上传失败").build();
                }
            } else {
                apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_BAD_REQUEST).msg("上传失败").build();
            }
        } else {
            apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_BAD_REQUEST).msg("上传失败,不是base64").build();
        }
        return new JsonMapper().toJson(apiResponseDTO);
    }
}
