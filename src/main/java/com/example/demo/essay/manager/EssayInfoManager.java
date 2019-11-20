package com.example.demo.essay.manager;

import com.dayainfo.lib.search.model.PageBean;
import com.example.demo.essay.model.po.EssayInfoPo;

import java.util.List;


/**
 * 前端征文大赛信息通用业务处理层
 *
 * @author ayne
 * @date 2018-07-20 09:16:09
 */
public interface EssayInfoManager {

    /**
     * 订单大赛信息
     *
     * @param essayInfoPo 要创建大赛的内容
     * @return true / false
     */
    boolean order(EssayInfoPo essayInfoPo);

    /**
     * 后台大赛列表页
     * @param kw 搜索关键字
     * @param currentPage 分页
     * @param pageSize 分页
     * @return
     */
    PageBean<EssayInfoPo> listBackEndEssay(String kw, int currentPage, int pageSize);
    PageBean<EssayInfoPo> listFrontEssay(PageBean pageBean);
    Boolean setShow(int id);
    /**
     * 修改大赛信息
     *
     * @param essayInfoPo 大赛信息
     * @return true / false
     */
    boolean modify(EssayInfoPo essayInfoPo);

    /**
     * 查询大赛信息
     *
     * @param essayInfoPo 机构信息
     * @return 大赛信息
     */
    EssayInfoPo selectOneEssayinfoByUuid(EssayInfoPo essayInfoPo);
//
    EssayInfoPo selectOneEssayinfoByUuid(String uuid);
//
//    /**
//     * 删除大赛信息
//     *
//     * @param essayInfoPo 过滤条件
//     * @return true / false
//     */
//    default boolean delete(EssayInfoPo essayInfoPo) {
//        throw new UnsupportedOperationException();
//    }
//
    /**
     * 隐藏大赛信息
     */
    boolean hide(EssayInfoPo essayInfoPo);
//
//    /**
//     * 分页查询全部
//     *
//     * @param pageBean 页面信息
//     * @return 页面信息
//     */
//    List<EssayInfoPo> listAll(PageBean pageBean);
//
    /**
     * 分页查询可显示的大赛
     *
     * @param pageBean 页面信息
     * @return 页面信息
     */
    List<EssayInfoPo> listCanDisplayEssay(PageBean pageBean);
//
//    /**
//     * 分页计数
//     *
//     * @return 跳湖
//     */
//    int countlistCanDisplayEssay();
    PageBean<EssayInfoPo> listCanDisplayEssay4Mobile(int currentPage, int pageSize);


    /**
     * 获取所有活动
     * @return
     */
    List<EssayInfoPo> getEssays();

    /**
     * 根据书本resourceId获取对应活动
     * @param ResourceId
     * @return
     */
    List<EssayInfoPo> getEssaysByResourceId(String ResourceId);

    PageBean<EssayInfoPo> getEssaysByStatus(int currentPage, int pageSize);

    List<EssayInfoPo> getEssayByName(String EssayName);

//    /**
//     * 分页查询可显示的大赛连同大赛状态名
//     *
//     * @param pageBean 页面信息
//     * @return 页面信息
//     */
//    List<EssayInfoBo> listCanDisplayEssayWithStatusName(PageBean pageBean);
//
//    /**
//     * 分页查询可显示的大赛连同大赛状态名
//     *
//     * @param pageBean 页面信息
//     * @return 页面信息
//     */
//    List<EssayInfoBo> listCanDisplayEssayWithStatusNameAndKw(PageBean pageBean, String kw);
//    /**
//     * 根据uuid和创建者id查询指定一条记录
//     *
//     * @param pageBean 分页参数
//     * @param uuid     唯一识别id
//     * @param adminId  创建者id
//     * @return 大赛信息
//     */
//    List<EssayInfoBo> listCanDisplayEssayByUuidAndAdminid(PageBean pageBean, String uuid, int adminId);
//    /**
//     * 根据关键字查询曾文大赛信息
//     *
//     * @param kw       关键字
//     * @param pageBean 分页的参数
//     * @return 大赛信息
//     */
//    PageBean<EssayInfoPo> listEssayInfoWithStatusByKw(String kw, PageBean pageBean);
//
//    /**
//     * 根据关键字和状态信息查询条数
//     *
//     * @param kw 关键字
//     * @return 条数
//     */
//    int countEssayByKwWithStatusName(String kw);
//
//    /**
//     * 根据状态值查询条数
//     *
//     * @return 条数
//     */
//    int countAllEssayWithStatusName();
//
//    /**
//     * 通过大赛名模糊查询
//     *
//     * @param schoolId 机构 id
//     * @param essayName 大赛名称
//     * @return list
//     */
//    List<EssayInfoPo> listByEssayNameLike(int schoolId, String essayName);
//
//    /**
//     * 大赛是否打开，而未被关闭
//     * @param essayId 大赛 id
//     * @return true / false
//     */
//    boolean isEssayInfoOpen(String essayId);
//
//    /**
//     * 开始活动
//     * @param essayId 活动 id
//     * @return true / false
//     */
//    boolean updateStatusToOpen(String essayId);
//
//    /**
//     * 关闭活动
//     * @param essayId 活动 id
//     * @return true / false
//     */
//    boolean updateStatusToClosed(String essayId);
//
//    /**
//     * 查询点击量
//     * @return
//     * @param essayId
//     */
//    Integer getEssayClickCount(String essayId);
//
//    /**
//     * 更新点击量
//     * @param count
//     * @param essayId
//     */
//    void updateEssayClickCount(Integer count, String essayId);
//
//    /**
//     * 查询是否有改论文的点击记录
//     * @param essayId
//     * @return
//     */
//    Boolean selectEssayByEssayId(String essayId);
//
//    /**
//     * 插入新的点击记录
//     * @param essayId
//     */
//    void insertNewClickCount(String essayId);
}
