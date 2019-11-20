package com.example.demo.essay.service.impl;

import com.dayainfo.common.intfce.api.ApiResponseDTO;
import com.dayainfo.common.util.EncodeUtils;
import com.dayainfo.common.util.JsonMapper;
import com.dayainfo.common.util.StringUtils;
import com.dayainfo.lib.search.model.PageBean;
import com.example.demo.essay.manager.EssayInfoManager;
import com.example.demo.essay.mapper.EssayInfoHistoryPoMapper;
import com.example.demo.essay.model.po.EssayInfoPo;
import com.example.demo.essay.model.vo.EssaysIndexVo;
import com.example.demo.essay.service.EssayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import static com.example.demo.essay.constant.EssayInfoConstant.UUID_TIMESTAMP_SEPARATOR;

@Service
public class EssayInfoServiceImpl implements EssayInfoService {
    @Autowired
    private EssayInfoManager essayInfoManager;
    @Autowired
    private EssayInfoHistoryPoMapper essayInfoHistoryPoMapper;


    @Override
    public String orderEssay(HttpServletRequest request, String essayInfoPoStr) {
        ApiResponseDTO apiResponseDTO = null;
        //AdministratorPo administratorPo = sessionService.getAdminSession(request);
        essayInfoPoStr = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(essayInfoPoStr));
        EssayInfoPo essayInfoPo = new JsonMapper().fromJson(essayInfoPoStr, EssayInfoPo.class);
        Long time = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString() + UUID_TIMESTAMP_SEPARATOR + time;
        essayInfoPo.setUuid(uuid);
        essayInfoPo.setGmtCreate(new Timestamp(time));
        essayInfoPo.setStatus(0);
        //essayInfoPo.setAdminId(administratorPo.getId());
        //essayInfoPo.setAdminName(administratorPo.getLoginName());
        //essayInfoPo.setAdminUnitId(administratorPo.getSchoolId());
        //essayInfoPo.setAdminName("测老师");
        //essayInfoPo.setAdminId(123);
        //essayInfoPo.setAdminUnitId(35578);
        if (essayInfoManager.order(essayInfoPo)) {
            apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_OK).msg("创建成功").build();
        } else {
            apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).msg("创建失败").build();
        }
        return new JsonMapper().toJson(apiResponseDTO);
    }

    @Override
    public String deleteEssay(HttpServletRequest request, String essayInfoPoStr) {
        essayInfoPoStr = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(essayInfoPoStr));
        EssayInfoPo essayInfoPo = new JsonMapper().fromJson(essayInfoPoStr, EssayInfoPo.class);
        ApiResponseDTO apiResponseDTO = null;
        if (StringUtils.isNotBlank(essayInfoPo.getUuid())) {
            //实际是隐藏
            if (essayInfoManager.hide(essayInfoPo)) {
                apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_OK).msg("删除成功").build();
            } else {
                apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).msg("删除失败").build();
            }
        } else {
            apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).msg("删除失败,uuid参数为空").build();
        }
        return new JsonMapper().toJson(apiResponseDTO);
    }

    @Override
    public String modifyEssay(String essayInfoPoStr) {
        ApiResponseDTO apiResponseDTO = null;
        essayInfoPoStr = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(essayInfoPoStr));
        EssayInfoPo essayInfoPo = new JsonMapper().fromJson(essayInfoPoStr, EssayInfoPo.class);
        if (essayInfoPo.getId() != null && essayInfoPo.getId() != 0) {
            if (essayInfoManager.modify(essayInfoPo)) {
                apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_OK).msg("修改成功").build();
            } else {
                apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).msg("修改失败").error("大赛信息有误").build();
            }
        } else {
            apiResponseDTO = new ApiResponseDTO.Builder(HttpServletResponse.SC_BAD_REQUEST).msg("修改失败").error("大赛信息获取失败").build();
        }
        return new JsonMapper().toJson(apiResponseDTO);
    }

    @Override
    public EssaysIndexVo getMobileIndex() {
        EssaysIndexVo essaysIndexVo = new EssaysIndexVo();
        PageBean essayInfoPageBean = new PageBean();
        essayInfoPageBean.setPagesize(4);
        essayInfoPageBean.setBeginPage(1);
        List<EssayInfoPo> limit3 = essayInfoManager.listCanDisplayEssay(essayInfoPageBean);

        essaysIndexVo.setEssayInfoPoList(limit3);
        return essaysIndexVo;
    }

    @Override
    public String getEssayByResourceId(String resourceId) {
        List<EssayInfoPo> list = essayInfoManager.getEssaysByResourceId(resourceId);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            EssayInfoPo essayInfoPo = list.get(i);
            stringBuffer.append(essayInfoPo.getTitle() + "，");
        }
        return stringBuffer.toString();
    }


    @Override
    public Boolean setShow(String essayInfoHistoryPoStr, int id){
//        ApiResponseDTO dto = null;
//        essayInfoHistoryPoStr = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(essayInfoHistoryPoStr));
//        EssayInfoHistoryPo essayInfoHistoryPo = new JsonMapper().fromJson(essayInfoHistoryPoStr, EssayInfoHistoryPo.class);
//        Long time = System.currentTimeMillis();
//        essayInfoHistoryPo.setGmtCreate(new Timestamp(time));
//        essayInfoHistoryPo.setStatus(0);
//        try {
//            if (essayInfoManager.setShow(id)) {
////                if (essayInfoHistoryPoMapper.insert(essayInfoHistoryPo) == 1) {
////                    dto = new ApiResponseDTO.Builder(HttpServletResponse.SC_OK).msg("设置成功").build();
////                } else {
////                   throw new AffairesException("历史活动记录表插入数据失败");
////                }
//                dto = new ApiResponseDTO.Builder(HttpServletResponse.SC_OK).msg("设置成功").build();
//            } else {
//                throw new AffairesException("设置前台展示失败");
//            }
//        } catch (AffairesException e) {
//            dto = new ApiResponseDTO.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).msg("设置失败").build();
//            e.printStackTrace();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
        return essayInfoManager.setShow(id);
    }

}
