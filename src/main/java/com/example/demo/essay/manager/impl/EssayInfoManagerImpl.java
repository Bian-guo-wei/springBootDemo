package com.example.demo.essay.manager.impl;

import com.dayainfo.common.util.StringUtils;
import com.dayainfo.lib.search.model.PageBean;
import com.dayainfo.lib.search.util.PageHelperUtil;
import com.example.demo.essay.manager.EssayInfoManager;
import com.example.demo.essay.mapper.CustomMapper;
import com.example.demo.essay.mapper.EssayInfoPoMapper;
import com.example.demo.essay.model.po.EssayInfoPo;
import com.example.demo.essay.model.po.EssayInfoPoExample;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 前端征文大赛信息通用业务处理层实现类
 *
 * @author ayne
 * @date 2018-07-20 09:41:58
 */
@Service
public class EssayInfoManagerImpl implements EssayInfoManager {

    private static final Logger logger = LoggerFactory.getLogger(EssayInfoManagerImpl.class);

    @Autowired
    private EssayInfoPoMapper essayInfoDao;
    @Autowired
    private CustomMapper customMapper;

    @Override
    public boolean order(EssayInfoPo essayInfoPo) {
        return createEssayInfo(essayInfoPo);
    }

    @Override
    public PageBean<EssayInfoPo> listBackEndEssay(String kw, int currentPage, int pageSize) {
        EssayInfoPoExample example = new EssayInfoPoExample();
        PageBean<EssayInfoPo> pageBean = new PageBean<>();
        example.createCriteria().andTitleLike("%"+kw+"%").andIsDisplayEqualTo(true);
        example.setOrderByClause("status desc , id desc");
        pageBean.setCurrentPage(currentPage);
        pageBean.setPagesize(pageSize);
        pageBean.setTotalData(essayInfoDao.countByExample(example));
        PageHelperUtil.startPage(pageBean);
        List<EssayInfoPo> list = essayInfoDao.selectByExample(example);
        pageBean.setList(list);
        pageBean.initbeginPageAndEndPage();
        return pageBean;
    }

    @Override
    public Boolean setShow(int id) {


//        ApiResponseDTO dto = null;

        if(disShowOther(id)){
//            dto = new ApiResponseDTO.Builder(HttpServletResponse.SC_OK).msg("设置成功").build();
            return true;
        }else{
//            dto = new ApiResponseDTO.Builder(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).msg("设置失败").build();
            return false;
        }
//        return dto;
    }
    private Boolean disShowOther(int id){
        Boolean r = true;
        try{
            EssayInfoPoExample filter = new EssayInfoPoExample();
            filter.createCriteria().andStatusEqualTo(1);
            EssayInfoPo result = new EssayInfoPo();
            result.setStatus(0);
            essayInfoDao.updateByExampleSelective(result, filter);

            EssayInfoPoExample filter1 = new EssayInfoPoExample();
            filter1.createCriteria().andIdEqualTo(id);
            EssayInfoPo result1 = new EssayInfoPo();
            result1.setStatus(1);
            essayInfoDao.updateByExampleSelective(result1, filter1);
        }catch (Exception e){
            r = false;
            logger.error("-------------EssayInfoManagerImpl---hideOther>:"+e);
        }
        return  r;
    }
    @Override
    public PageBean<EssayInfoPo> listFrontEssay(PageBean pageBean1) {
        EssayInfoPoExample example = new EssayInfoPoExample();
        PageBean<EssayInfoPo> pageBean = new PageBean<>();
        example.createCriteria().andIsDisplayEqualTo(true);
        example.setOrderByClause("id desc");
        pageBean.setCurrentPage(pageBean1.getCurrentPage());
        pageBean.setPagesize(pageBean1.getPagesize());
        pageBean.setTotalData(essayInfoDao.countByExample(example));
        PageHelperUtil.startPage(pageBean);
        List<EssayInfoPo> list = essayInfoDao.selectByExample(example);
        pageBean.setList(list);
        pageBean.initbeginPageAndEndPage();
        return pageBean;
    }

    @Override
    public boolean modify(EssayInfoPo essayInfoPo) {
        return updateEssayInfo(essayInfoPo);
    }

    @Override
    public EssayInfoPo selectOneEssayinfoByUuid(EssayInfoPo essayInfoPo) {
        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
        essayInfoPoExample.createCriteria().andUuidEqualTo(essayInfoPo.getUuid());
        List<EssayInfoPo> list = essayInfoDao.selectByExample(essayInfoPoExample);
        EssayInfoPo result;
        if (list == null || list.isEmpty()) {
            result = null;
        } else {
            result = list.get(0);
        }
        return result;
    }

    @Override
    public EssayInfoPo selectOneEssayinfoByUuid(String uuid) {
        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
        essayInfoPoExample.createCriteria().andUuidEqualTo(uuid);
        List<EssayInfoPo> list = essayInfoDao.selectByExample(essayInfoPoExample);
        EssayInfoPo result;
        if (list == null || list.isEmpty()) {
            result = null;
        } else {
            result = list.get(0);
        }
        return result;
    }
//
//    /**
//     * 删除大赛信息
//     *
//     * @param essayInfoPo 过滤条件
//     * @return true / false
//     */
//    @Override
//    public boolean delete(EssayInfoPo essayInfoPo) {
//        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
//        essayInfoPoExample.createCriteria().andUuidEqualTo(essayInfoPo.getUuid());
//        logger.warn("delete ->  正在删除一条大赛信息 : " + essayInfoPo);
//        essayInfoDao.deleteByExample(essayInfoPoExample);
//        return Boolean.TRUE;
//    }
//
    @Override
    public boolean hide(EssayInfoPo essayInfoPo) {
        return hideEssayInfo(essayInfoPo);
    }
//
//    @Override
//    public List<EssayInfoPo> listAll(PageBean pageBean) {
//        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
//        PageHelperUtil.startPage(pageBean);
//        List<EssayInfoPo> list = essayInfoDao.selectByExample(essayInfoPoExample);
//        return list;
//    }
//
    /**
     * 分页查询可显示的大赛
     *
     * @param pageBean 页面信息
     * @return 页面信息
     */
    @Override
    public List<EssayInfoPo> listCanDisplayEssay(PageBean pageBean) {
        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
        essayInfoPoExample.createCriteria().andIsDisplayEqualTo(Boolean.TRUE);
        essayInfoPoExample.setOrderByClause("id desc");
        PageHelperUtil.startPage(pageBean);
        return essayInfoDao.selectByExample(essayInfoPoExample);
    }
//
//    @Override
//    public int countlistCanDisplayEssay() {
//        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
//        essayInfoPoExample.createCriteria().andIsDisplayEqualTo(Boolean.TRUE);
//        return essayInfoDao.countByExample(essayInfoPoExample);
//    }
//
//
//    private List<EssayInfoPo> listCanDisplayEssay4Mobile(PageBean pageBean) {
//        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
//        essayInfoPoExample.createCriteria().andIsDisplayEqualTo(Boolean.TRUE);
//        essayInfoPoExample.setOrderByClause("id desc");
//        PageHelperUtil.startPage(pageBean);
//        return essayInfoDao.selectByExample(essayInfoPoExample);
//    }

    @Override
    public PageBean<EssayInfoPo> listCanDisplayEssay4Mobile(int currentPage, int pageSize) {
        PageBean<EssayInfoPo> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPagesize(pageSize);
        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
        essayInfoPoExample.createCriteria().andIsDisplayEqualTo(Boolean.TRUE);
        essayInfoPoExample.setOrderByClause("id desc");
        Page page = new PageHelperUtil().startPageAndCount(pageBean);
        List <EssayInfoPo> list = essayInfoDao.selectByExample(essayInfoPoExample);
        pageBean.setList(list);
        pageBean.setTotalData((int)page.getTotal());
        pageBean.initbeginPageAndEndPage();
        return pageBean;
    }

    //
//    @Override
//    public List<EssayInfoBo> listCanDisplayEssayWithStatusName(PageBean pageBean) {
//        List<EssayInfoPo> essayInfoPoList = listCanDisplayEssay(pageBean);
//        return setEssayStatusAndApprovalType(essayInfoPoList);
//    }
//
//    @Override
//    public List<EssayInfoBo> listCanDisplayEssayWithStatusNameAndKw(PageBean pageBean, String kw) {
//        List<EssayInfoPo> essayInfoPoList = listCanDisplayEssayWithKw(pageBean, kw);
//        return setEssayStatusAndApprovalType(essayInfoPoList);
//    }
//
//    private List<EssayInfoPo> listCanDisplayEssayWithKw(PageBean pageBean, String kw) {
//        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
//        essayInfoPoExample.createCriteria().andIsDisplayEqualTo(Boolean.TRUE).andTitleLike("%" + kw + "%");
//        essayInfoPoExample.setOrderByClause("id desc");
//        PageHelperUtil.startPage(pageBean);
//        List<EssayInfoPo> list = essayInfoDao.selectByExample(essayInfoPoExample);
//        return list;
//    }
//    public List<EssayInfoPo> listOneEssayByUuidAndAdminid(PageBean pageBean, String uuid, int adminId) {
//        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
//        essayInfoPoExample.createCriteria().andIsDisplayEqualTo(Boolean.TRUE).andUuidEqualTo(uuid).andAdminIdEqualTo(adminId);
//        PageHelperUtil.startPage(pageBean);
//        return essayInfoDao.selectByExample(essayInfoPoExample);
//    }
//
//    @Override
//    public List<EssayInfoBo> listCanDisplayEssayByUuidAndAdminid(PageBean pageBean, String uuid, int adminId) {
//        List<EssayInfoPo> essayInfoPoList = listOneEssayByUuidAndAdminid(pageBean, uuid, adminId);
//        return setEssayStatusAndApprovalType(essayInfoPoList);
//    }
//
//    /**
//     * 设置征文状态和评选类型名
//     *
//     * @param list polist
//     * @return bolist
//     */
//    private List<EssayInfoBo> setEssayStatusAndApprovalType(List<EssayInfoPo> list) {
//        if (list == null || list.isEmpty()) {
//            return Collections.emptyList();
//        }
//        List<EssayInfoBo> result = new ArrayList<>(list.size());
//        EssayInfoBo eachBo;
//        String statusName;
//        String approvalTypeName;
//        for (EssayInfoPo essayInfoPo : list
//                ) {
//            eachBo = new EssayInfoBo();
//            eachBo.setEssayInfoPo(essayInfoPo);
//            //大赛状态名
//            statusName = EssayInfoConstant.EssayInfoStatusEnum.getInfoByValue(essayInfoPo.getStatus());
//            //大赛评选类型
//            approvalTypeName = EssayInfoConstant.EssayInfoApprovalTypeEnum.getNameByValue(essayInfoPo.getApprovalType());
//            eachBo.setStatusName(statusName);
//            eachBo.setApprovalTypeName(approvalTypeName);
//            result.add(eachBo);
//        }
//        return result;
//    }
//
    private boolean createEssayInfo(EssayInfoPo essayInfoPo) {
        try {
            essayInfoPo.setGmtCreate(new Timestamp(System.currentTimeMillis()));
            essayInfoDao.insertSelective(essayInfoPo);
        } catch (Exception e) {
            logger.warn("createEssayInfo -> e : " + e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
//
    private boolean updateEssayInfo(EssayInfoPo essayInfoPo) {
        try {
            EssayInfoPoExample filter = new EssayInfoPoExample();
            filter.createCriteria().andIdEqualTo(essayInfoPo.getId());
            EssayInfoPo result = new EssayInfoPo();
            result.setClaim(essayInfoPo.getClaim());
            result.setTitle(essayInfoPo.getTitle());
            result.setGmtModified(new Timestamp(System.currentTimeMillis()));
            essayInfoDao.updateByExampleSelective(result, filter);
        } catch (Exception e) {
            logger.warn("updateEssayInfo -> e : " + e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private boolean hideEssayInfo(EssayInfoPo essayInfoPo) {
        try {
            EssayInfoPo setter = new EssayInfoPo();
            setter.setIsDisplay(Boolean.FALSE);
            setter.setGmtModified(new Timestamp(System.currentTimeMillis()));
            EssayInfoPoExample filter = new EssayInfoPoExample();
            filter.createCriteria().andUuidEqualTo(essayInfoPo.getUuid());
            essayInfoDao.updateByExampleSelective(setter, filter);
        } catch (Exception e) {
            logger.warn("deleteEssayInfo -> e : " + e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public List<EssayInfoPo> getEssays(){
        EssayInfoPoExample example = new EssayInfoPoExample();
        List<EssayInfoPo> list = essayInfoDao.selectByExample(example);
        return list;
    }

    @Override
    public List<EssayInfoPo> getEssaysByResourceId(String ResourceId) {
        if(StringUtils.isNotBlank(ResourceId)){
            return customMapper.selectByResourceId(ResourceId);
        }else {
            return null;
        }
    }

    @Override
    public PageBean<EssayInfoPo> getEssaysByStatus(int currentPage, int pageSize) {
        EssayInfoPoExample example = new EssayInfoPoExample();
        example.createCriteria().andStatusEqualTo(1);
        PageBean<EssayInfoPo> pageBean = new PageBean<>();
        List<EssayInfoPo> list = customMapper.selectByStatus();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPagesize(pageSize);
        PageHelperUtil.startPage(pageBean);
        pageBean.setTotalData(essayInfoDao.countByExample(example));
        pageBean.setList(list);
        pageBean.initbeginPageAndEndPage();
        return pageBean;
    }

    @Override
    public List<EssayInfoPo> getEssayByName(String EssayName) {

        return customMapper.selectByEssayName(EssayName);
    }


//    public PageBean<EssayInfoPo> listBackEndEssa(String kw, int currentPage, int pageSize) {
//        EssayInfoPoExample example = new EssayInfoPoExample();
//        PageBean<EssayInfoPo> pageBean = new PageBean<>();
//        example.createCriteria().andTitleLike("%"+kw+"%").andIsDisplayEqualTo(true);
//        example.setOrderByClause("status desc , id desc");
//        pageBean.setCurrentPage(currentPage);
//        pageBean.setPagesize(pageSize);
//        pageBean.setTotalData(essayInfoDao.countByExample(example));
//        PageHelperUtil.startPage(pageBean);
//        List<EssayInfoPo> list = essayInfoDao.selectByExample(example);
//        pageBean.setList(list);
//        pageBean.initbeginPageAndEndPage();
//        return pageBean;
//    }

//
//    @Override
//    public PageBean<EssayInfoPo> listEssayInfoWithStatusByKw(String kw, PageBean pageBean) {
//        PageBean<EssayInfoPo> bean = new PageBean<>();
//        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
//        essayInfoPoExample.createCriteria().andIsDisplayEqualTo(Boolean.TRUE).andTitleLike("%" + kw + "%");
//        List<EssayInfoPo> list = essayInfoDao.selectByExample(essayInfoPoExample);
//        List<EssayInfoPo> result = new ArrayList<>();
//
//        int cont = pageBean.getPagesize() * (pageBean.getCurrentPage() - 1);
//        for (int i = cont; i < (cont + pageBean.getPagesize()); i++) {
//            if (i < list.size()) {
//                result.add(list.get(i));
//            }
//        }
//        bean.setCurrentPage(pageBean.getCurrentPage());
//        bean.setPagesize(pageBean.getPagesize());
//        bean.setTotalData(list.size());
//        bean.setList(result);
//        return bean;
//    }
//
//    @Override
//    public int countEssayByKwWithStatusName(String kw) {
//        PageBean<EssayInfoPo> bean = new PageBean<>();
//        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
//        essayInfoPoExample.createCriteria().andIsDisplayEqualTo(Boolean.TRUE).andTitleLike("%" + kw + "%");
//        return essayInfoDao.countByExample(essayInfoPoExample);
//    }
//
//    @Override
//    public int countAllEssayWithStatusName() {
//        PageBean<EssayInfoPo> bean = new PageBean<>();
//        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
//        essayInfoPoExample.createCriteria().andIsDisplayEqualTo(Boolean.TRUE);
//        return essayInfoDao.countByExample(essayInfoPoExample);
//    }
//
//    @Override
//    public List<EssayInfoPo> listByEssayNameLike(int schoolId, String essayName) {
//        if (StringUtils.isBlank(essayName)) {
//            essayName = DEFAULT_STR;
//        }
//            essayName = "%" + essayName + "%";
//        EssayInfoPoExample essayInfoPoExample = new EssayInfoPoExample();
//        essayInfoPoExample.createCriteria().andAdminUnitIdEqualTo(schoolId).andTitleLike(essayName);
//        return essayInfoDao.selectByExample(essayInfoPoExample);
//    }
//
//    /**
//     * multipartfile 转成 File
//     * <br>过期原因，没试过，先留着，以后或许还用得上
//     * @param multipartFile spring 上传的文件
//     * @return file or null
//     */
//    @Deprecated
//    private File multipartfileToFile(MultipartFile multipartFile) {
//        if (multipartFile == null) {
//            return null;
//        }
//        //此处file 是你的MultipartFile
//        CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
//        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
//        //会在项目的根目录的临时文件夹下生成一个临时文件 *.tmp
//        File myfile = fi.getStoreLocation();
//        if (myfile == null) {
//            return null;
//        }
//        return myfile;
//    }
//
//    @Override
//    public boolean isEssayInfoOpen(String essayId) {
//        if (StringUtils.isBlank(essayId)) {
//            return Boolean.FALSE;
//        }
//        EssayInfoPo filter = new EssayInfoPo();
//        filter.setUuid(essayId);
//        EssayInfoPo essayInfoPo = selectOneEssayinfoByUuid(filter);
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//        return essayInfoPo.getDuration() != null
//                && essayInfoPo.getStart() != null
//                && essayInfoPo.getStart().before(now)
//                && essayInfoPo.getDuration().after(now);
//    }
//
//    @Override
//    public boolean updateStatusToOpen(String essayId) {
//        return updateStatus(essayId, EssayInfoConstant.EssayInfoStatusEnum.WORKING_1);
//    }
//
//    @Override
//    public boolean updateStatusToClosed(String essayId) {
//        return updateStatus(essayId, EssayInfoConstant.EssayInfoStatusEnum.ENDING_2);
//    }
//
//    @Override
//    public Integer getEssayClickCount(String essayId) {
//        ClickCountPoExample clickCountPoExample = new ClickCountPoExample();
//        clickCountPoExample.createCriteria().andEssayIdEqualTo(essayId);
//        List<ClickCountPo> clickCountPos = clickCountPoMapper.selectByExample(clickCountPoExample);
//        return clickCountPos.get(0).getClickCount();
//    }
//
//    @Override
//    public void updateEssayClickCount(Integer count, String essayId) {
//        ClickCountPoExample clickCountPoExample = new ClickCountPoExample();
//        clickCountPoExample.createCriteria().andEssayIdEqualTo(essayId);
//        ClickCountPo clickCountPo = new ClickCountPo();
//        clickCountPo.setClickCount(count);
//        clickCountPoMapper.updateByExampleSelective(clickCountPo,clickCountPoExample);
//    }
//
//    @Override
//    public Boolean selectEssayByEssayId(String essayId) {
//        ClickCountPoExample clickCountPoExample = new ClickCountPoExample();
//        clickCountPoExample.createCriteria().andEssayIdEqualTo(essayId);
//        List<ClickCountPo> clickCountPos = clickCountPoMapper.selectByExample(clickCountPoExample);
//        if(clickCountPos.size() > 0) {
//            return Boolean.TRUE;
//        }
//        return Boolean.FALSE;
//    }
//
//    @Override
//    public void insertNewClickCount(String essayId) {
//        ClickCountPoExample clickCountPoExample = new ClickCountPoExample();
//        clickCountPoExample.createCriteria();
//        ClickCountPo clickCountPo = new ClickCountPo();
//        clickCountPo.setEssayId(essayId);
//        clickCountPo.setClickCount(0);
//        clickCountPoMapper.insertSelective(clickCountPo);
//    }
//
//    /**
//     * 更新活动状态
//     * @param essayId 活动 id
//     * @param essayInfoStatusEnum 活动状态枚举类
//     * @return true / false
//     */
//    private boolean updateStatus(String essayId, EssayInfoConstant.EssayInfoStatusEnum essayInfoStatusEnum) {
//        if (StringUtils.isBlank(essayId)) {
//            return Boolean.FALSE;
//        }
//        EssayInfoPo result = new EssayInfoPo();
//        result.setStatus(essayInfoStatusEnum.getStatus());
//        EssayInfoPoExample filter = new EssayInfoPoExample();
//        filter.createCriteria().andUuidEqualTo(essayId);
//        return essayInfoDao.updateByExampleSelective(result, filter) > 0;
//    }
}
