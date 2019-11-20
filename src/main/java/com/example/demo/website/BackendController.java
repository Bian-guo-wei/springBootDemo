package com.example.demo.website;

import com.dayainfo.common.util.EncodeUtils;
import com.dayainfo.common.util.JsonMapper;
import com.dayainfo.common.util.StringUtils;
import com.dayainfo.lib.search.model.PageBean;
import com.example.demo.essay.manager.EssayInfoHistoryManager;
import com.example.demo.essay.manager.EssayInfoManager;
import com.example.demo.essay.model.po.EssayInfoHistoryPo;
import com.example.demo.essay.model.po.EssayInfoPo;
import com.example.demo.essay.service.CloudDiskService;
import com.example.demo.essay.service.EssayInfoService;
import com.example.demo.website.contast.SessionConstant;
import com.example.demo.website.manager.MobilePassportUserInfoManager;
import com.example.demo.website.service.EssayAndBookService;
import com.example.demo.website.util.Base64Util;
import com.example.demo.reading.constant.ClassicBooksConstant;
import com.example.demo.reading.manager.*;
import com.example.demo.reading.model.bo.BookClassificationBo;
import com.example.demo.reading.model.bo.BookClassificationMapBo;
import com.example.demo.reading.model.po.*;
import com.example.demo.reading.service.BookClassificationService;
import com.example.demo.reading.service.ClassicBooksImportService;
import com.example.demo.reading.service.ClassicBooksService;
import com.example.demo.reading.service.DocumentUnzipHandleService;
import com.example.demo.reading.util.BookClassificationHandleUtil;
import com.example.demo.reading.util.FileUtils;
import com.duxiu.cxds.api.client.utils.Md5Utils;
import com.github.pagehelper.util.StringUtil;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping(value = "/backendAdminController")
public class BackendController {
    @Autowired
    EssayInfoManager essayInfoManager;
    @Autowired
    EssayInfoService essayInfoService;
    @Autowired
    private ClassicBooksService classicBooksService;
    @Autowired
    private BookClassificationService bookClassificationService;
    @Autowired
    private ClassicBooksImportService classicBooksImportService;
    @Autowired
    private DocumentUnzipHandleService documentUnzipHandleService;
    @Autowired
    private CloudDiskService cloudDiskService;
    @Autowired
    private BookEssayInfoMapperManager bookEssayInfoMapperManager;
    @Autowired
    private GuideReadingManager guideReadingManager;
    @Autowired
    private HeadmasterMessageManager headmasterMessageManager;
    @Autowired
    private ClassicBooksManager classicBooksManager;
    @Autowired
    private EssayInfoHistoryManager essayInfoHistoryManager;
    @Autowired
    private EssayAndBookService essayAndBookService;

    @Autowired
    private MobilePassportUserInfoManager mobilePassportUserInfoManager;
    @Autowired
    private AdministratorManger administratorManger;

    private static final Logger logger = LoggerFactory.getLogger(BackendController.class);

    private static int time = 0;   //初始化登录次数

//    @RequestMapping(value = "/toLoginBackend")
//    public ModelAndView toLoginBackend() {
//        ModelAndView view = new ModelAndView();
//        view.setViewName("login/sspLogin");
//        return view;
//    }

    /**
     * 处理后台登录
     *
     * @return 页面
     */
//    @ResponseBody
//    @RequestMapping(value = "/loginBackend")
//    public String loginBackend(HttpServletRequest request ,  String userName, String password,String randomCode) {
//        Properties properties = new Properties();
//        HttpSession session = request.getSession();
//
//        if (session.getAttribute("time") == null){
//            session.setAttribute("time",time);
//        }
//        if((int)session.getAttribute("time")>2){
//            return "1004";  //错误次数达到上限，等到session失效重新登录。
//        }
//        try {
////            BufferedReader bufferedReader = new BufferedReader(new FileReader("/config/login.properties"));
//            FileInputStream fileInputStream = new FileInputStream(new File(BackendController.class.getResource(
//                    "/config/login.properties").toURI()));
//            InputStreamReader inputStrReader = new InputStreamReader(fileInputStream, "UTF-8");
//            properties.load(inputStrReader);
//            String name = properties.getProperty("USERNAME");
//            String secret = properties.getProperty("PASSWORD");
//            if(!userName.equals(name)){
//                int n = (int)session.getAttribute("time");
//                n++;
//                session.setAttribute("time",n);
//                return "1001";   //用户名密码输入错误
//            }else if (!password.equals(secret)){
//                int n = (int)session.getAttribute("time");
//                n++;
//                session.setAttribute("time",n);
//                return "1001";
//            }else if (StringUtil.isEmpty(randomCode) || !(getSessionAttribute(request, "randomCode").toString().toLowerCase()).equals(randomCode.toLowerCase())){
//                return "1002"; //验证码输入错误
//            }
//            inputStrReader.close();
//            fileInputStream.close();
//        } catch (Exception e) {
//            logger.error("error", e);
//            throw new IllegalArgumentException(e);
//        }
//
//
//        AdministratorPo administratorPo = new AdministratorPo();
//        administratorPo.setPhone(userName);
//        administratorPo.setPpPwd(password);
//        session.setAttribute(SessionConstant.ADMIN_LOGIN_SESSION_KEY, administratorPo);
//
//        return "1003";  //登录成功
//    }
    @ResponseBody
    @RequestMapping(value = "/loginBackend")
    public String loginBackend(HttpServletRequest request, String userName, String password, String randomCode) {
        HttpSession session = request.getSession();
        String pwd_md5 = Md5Utils.md5(password);
        if (session.getAttribute("time") == null) {
            session.setAttribute("time", time);
        }
        if ((int) session.getAttribute("time") > 2) {
            return "1004";  //错误次数达到上限，等到session失效重新登录。
        }
        try {
            AdministratorPo administratorPo1 = administratorManger.queryAdminByIdAndPwd(userName, pwd_md5);
            if (administratorPo1 == null) {
                int n = (int) session.getAttribute("time");
                n++;
                session.setAttribute("time", n);
                return "1001";   //用户名密码输入错误
            } else if (StringUtil.isEmpty(randomCode) || !(getSessionAttribute(request, "randomCode").toString().toLowerCase()).equals(randomCode.toLowerCase())) {
                return "1002"; //验证码输入错误
            }
        } catch (Exception e) {
            logger.error("error", e);
            throw new IllegalArgumentException(e);
        }
        AdministratorPo administratorPo = new AdministratorPo();
        administratorPo.setPhone(userName);
        administratorPo.setPpPwd(pwd_md5);
        session.setAttribute(SessionConstant.ADMIN_LOGIN_SESSION_KEY, administratorPo);

        return "1003";  //登录成功
    }


    protected Object getSessionAttribute(HttpServletRequest request, String name) {
        return request.getSession().getAttribute(name);
    }

    @RequestMapping(value = "/toManageEssay")
    public ModelAndView toManageEssay(@RequestParam(required = false, defaultValue = "1") Integer currentPage,
                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                      @RequestParam(required = false, defaultValue = "") String kw) {
        ModelAndView modelAndView = new ModelAndView();
        //TODO:征文大赛状态应该自动监测，例如在创建后，状态为已创建，到开始或结束时间，状态应为进行中或已结束
        PageBean<EssayInfoPo> pageBean = essayInfoManager.listBackEndEssay(kw, currentPage, pageSize);
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.addObject("kw", kw);
        modelAndView.setViewName("readingthoughts/essayContest");
        return modelAndView;
    }

    /**
     * 阅读管理
     *
     * @param book_classification
     * @return
     */
    @RequestMapping(value = "/readingRecommend")
    public ModelAndView readingRecommend(HttpServletRequest request, PageBean<ClassicBooks> classicBooksPageBean,
                                         @RequestParam(defaultValue = "0") Integer book_classification,
                                         @RequestParam(defaultValue = "") String book_name,
                                         @RequestParam(defaultValue = "") String uuid) {
        ModelAndView modelAndView = new ModelAndView();

        List<EssayInfoPo> essayList = essayInfoManager.getEssays();
        modelAndView.addObject("essayList", essayList);
        modelAndView.setViewName("readingthoughts/readingRecommend");

        if (!StringUtils.isBlank(book_name)) {
            classicBooksService.getByNameAndClassification(classicBooksPageBean, book_name, book_classification);
            classicBooksService.handleBookClasify(classicBooksPageBean);
            modelAndView.addObject("classicBooksPageBean", classicBooksPageBean);
            return modelAndView;
        }
        if (!StringUtils.isBlank(uuid)) {
            classicBooksManager.getBooksByUuid(classicBooksPageBean, uuid);
            classicBooksService.handleBookClasify(classicBooksPageBean);
            modelAndView.addObject("uuid", uuid);
            modelAndView.addObject("classicBooksPageBean", classicBooksPageBean);
            return modelAndView;
        }
        classicBooksService.getClassicBooks(classicBooksPageBean);
        classicBooksService.handleBookClasify(classicBooksPageBean);
        modelAndView.addObject("classicBooksPageBean", classicBooksPageBean);
        modelAndView.addObject("book_classification", book_classification);
        return modelAndView;
    }

    /**
     * 拓展阅读书目管理
     *
     * @param book_classification
     * @return
     */
    @RequestMapping(value = "/toExpandingReading")
    public ModelAndView toExpandingReading(HttpServletRequest request, PageBean<EssayInfoHistoryPo> EssayInfoHistoryPoPageBean,
                                           @RequestParam(defaultValue = "0") Integer book_classification,
                                           @RequestParam(defaultValue = "") String book_name,
                                           @RequestParam(defaultValue = "") String uuid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("readingthoughts/expandingReading");

//
        essayInfoHistoryManager.getHistoryEssayBack(EssayInfoHistoryPoPageBean);
        modelAndView.addObject("pageBean", EssayInfoHistoryPoPageBean);
        return modelAndView;
    }

    /**
     * 获取对应拓展活动的详细信息
     *
     * @param EssayInfoHistoryPoPageBean
     * @return
     */
    @RequestMapping(value = "/getExpandingReadingDetail")
    public ModelAndView getExpandingReadingDetail(PageBean<EssayInfoHistoryPo> EssayInfoHistoryPoPageBean, String Uuid) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("readingthoughts/expandingReading");

        essayInfoHistoryManager.getHistoryEssayBack(EssayInfoHistoryPoPageBean);
        EssayInfoHistoryPo essayInfoHistoryPo = essayInfoHistoryManager.getEssayInfoHistoryByUuid(Uuid);
        modelAndView.addObject("essayInfoHistoryPo", essayInfoHistoryPo);
        modelAndView.addObject("pageBean", EssayInfoHistoryPoPageBean);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteExpandingReading")
    public String deleteExpandingReading(String Uuid) {
        if (essayInfoHistoryManager.deleteEssayInfoHistory(Uuid) == 1) {
            return "200";
        } else {
            return "100";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateExpandingReadingDetail")
    public String updateExpandingReadingDetail(String essayInfoHistoryPoStr) {
        essayInfoHistoryPoStr = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(essayInfoHistoryPoStr));
        EssayInfoHistoryPo essayInfoHistoryPo = new JsonMapper().fromJson(essayInfoHistoryPoStr, EssayInfoHistoryPo.class);
        if (essayInfoHistoryManager.updateEssayInfoHistoryDetail(essayInfoHistoryPo) == 1) {
            return "200";
        } else {
            return "100";
        }
    }

    /**
     * 到图书信息页面
     *
     * @param request
     * @param classicBooks
     * @return
     */
    @RequestMapping(value = "/toUpdateClassiclBookPage")
    public ModelAndView toUpdateClassiclBookPage(HttpServletRequest request, ClassicBooks classicBooks) {
        ModelAndView modelAndView = new ModelAndView();
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
        ClassicBooks classicBook = classicBooksService.getClassicBookById(classicBooks.getId());
        String bookClassifyName = classicBooksService.getBookClassifyName(classicBook.getProcClassId());
        String EssayInfos = essayInfoService.getEssayByResourceId(classicBook.getResourceId());
        if (StringUtils.isNotBlank(classicBook.getProcClassId())) {
            String value = BookClassificationHandleUtil.keyAndValueInterconversion(classicBook.getProcClassId());
            modelAndView.addObject("value", value);
        }
        modelAndView.addObject("EssayInfos", EssayInfos);
        modelAndView.addObject("classicBook", classicBook);
        modelAndView.addObject("bookClassifyName", bookClassifyName);
        modelAndView.addObject("bookMap", bookClassificationMapBo.getBookClassifyMap());
        modelAndView.setViewName("readingthoughts/readingBooksChange");
        return modelAndView;
    }

    /**
     * 图书导入页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/importBooksPage")
    public ModelAndView importBooksPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
        modelAndView.addObject("map", bookClassificationMapBo.getBookClassifyMap());
        modelAndView.setViewName("readingthoughts/readingBooksImport");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/getEssays")
    public List<EssayInfoPo> getEssays() {
        List<EssayInfoPo> list = essayInfoManager.getEssays();
        JSONArray json = JSONArray.fromObject(list);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/getSecondClassify")
    public String getSecondClassify(BookClassificationPo bookClassificationPo) {
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
        List<BookClassificationPo> bookClassificationPos = bookClassificationService.getBookClassifyByParentId(bookClassificationMapBo.getSecondBookClassifyMap(), bookClassificationPo);
        return new JsonMapper().toJson(bookClassificationPos);
    }

    @ResponseBody
    @RequestMapping(value = "/getThirdClassify")
    public String getThirdClassify(BookClassificationPo bookClassificationPo) {
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
        List<BookClassificationPo> bookClassificationPos = bookClassificationService.getBookClassifyByParentId(bookClassificationMapBo.getThirdBookClassifyMap(), bookClassificationPo);
        return new JsonMapper().toJson(bookClassificationPos);
    }

    /**
     * 修改图书信息
     *
     * @param request
     * @param classicBooks
     * @return
     */
    @RequestMapping(value = "/updateClassiclBookInfo")
    public ModelAndView updateClassiclBookInfo(HttpServletRequest request, ClassicBooks classicBooks, String essayId, MultipartRequest merq, String base64) {

        String singlepdfPath = "";
        String materialfPath = "";
        String coursewarefPath = "";
        String ImgPath = "";
        MultipartFile image;
        MultipartFile singlepdf = merq.getFile("singlepdf");
        MultipartFile material = merq.getFile("material");
        MultipartFile courseware = merq.getFile("courseware");

        if (StringUtils.isNotBlank(base64)) {
            image = Base64Util.base64ToMultipart(base64);
            FileUtils.handleFiledelete(image, request, "4");
            ImgPath = FileUtils.handleFileUpload(image, "4", request);
            classicBooks.setScreenshot(ImgPath);
        }
        if (singlepdf.getSize() > 0) {
            FileUtils.handleFiledelete(singlepdf, request, "1");
            singlepdfPath = FileUtils.handleFileUpload(singlepdf, "1", request);
            classicBooks.setCnkiYycount(singlepdfPath);
        }
        if (material.getSize() > 0) {
            FileUtils.handleFiledelete(material, request, "2");
            materialfPath = FileUtils.handleFileUpload(material, "2", request);
            classicBooks.setWfYycount(materialfPath);
        }
        if (courseware.getSize() > 0) {
            FileUtils.handleFiledelete(courseware, request, "3");
            coursewarefPath = FileUtils.handleFileUpload(courseware, "3", request);
            classicBooks.setCqvipYycount(coursewarefPath);
        }

        ModelAndView modelAndView = new ModelAndView();
        ClassicBooks classicBooks1 = classicBooksService.getClassicBookById(classicBooks.getId());
        classicBooksService.modifyClassicBook(classicBooks);
        if (StringUtils.isNotBlank(essayId)) {
            bookEssayInfoMapperManager.deletByBookId(classicBooks1.getResourceId());
            bookEssayInfoMapperManager.insertByBookId(classicBooks1.getResourceId(), essayId);
        }

        modelAndView.setViewName("redirect:readingRecommend");
        return modelAndView;
    }

    @RequestMapping(value = "/uploadimg")
    @ResponseBody
    public String uploadimg(@RequestParam(value = "base64") String base64) {
        return cloudDiskService.uploadImg(base64);
    }

    /**
     * 图书导入页面
     *
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "/importExcelBooks")
//    public String importExcelBooks(HttpServletRequest request, MultipartRequest mreq) {
//        MultipartFile file = mreq.getFile("excel");
//        MultipartFile file1 = mreq.getFile("docu");
//        MultipartFile file2 = mreq.getFile("pdf");
//        Boolean excel = classicBooksImportService.checkExcel(file);
//        if (excel) {
//
//            List<ArrayList<String>> rowInfo = classicBooksImportService.handleExcelData(file);
//            List<ClassicBooks> classicBooks = classicBooksImportService.handleRowInfo2Po(rowInfo);
//            if (null != file1) {
//                //图书封面
//                List<MultipartFile> coverMultipartFiles = documentUnzipHandleService.unzipDocument(request, file1);
//                Map<String, String> coverStringMap = documentUnzipHandleService.uploadWebService(coverMultipartFiles, EssayUploadConstant.IMG_UPLOAD_YUNPAN_URL, null);
//                classicBooksService.bookChooseCover(coverStringMap, classicBooks);
//
//            }
//
//            if (null != file2) {
//                //图书pdf文件
//                List<MultipartFile> pdfMultipartFiles = documentUnzipHandleService.unzipDocument(request, file2);
//                Map<String, String> pdfStringMap = documentUnzipHandleService.uploadWebService(pdfMultipartFiles, EssayUploadConstant.DOCU_UPLOAD_YUNPAN_URL, null);
//                classicBooksService.bookNameChooseBook(pdfStringMap, classicBooks);
//            }
//            List<String> bookClassifys = classicBooksService.checkBookClassifyIsExist(classicBooks);
//            if (null != bookClassifys && bookClassifys.size() > 0) {
//                return ClassicBooksConstant.CLASSICBOOKS_CLASSIFY_NOEXIST;
//            }
//            List<ClassicBooks> repeatBooks = classicBooksService.checkIsRepeat(classicBooks);
//            if (repeatBooks.size() > 0) {
//                return ClassicBooksConstant.CLASSICBOOKS_DADA_REPEAT;
//            } else {
//                classicBooksService.importClassicBooks(classicBooks);
//            }
//        }
//        return "";
//    }

    /**
     * 图书导入页面
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/importExcelBooks", produces = {"application/text;charset=UTF-8"})
    public String importExcelBooks(HttpServletRequest request, MultipartRequest mreq) {
        MultipartFile file = mreq.getFile("excel");
        MultipartFile file1 = mreq.getFile("docu");
        MultipartFile file2 = mreq.getFile("pdf");
        MultipartFile material = mreq.getFile("material");
        MultipartFile courseware = mreq.getFile("courseware");
        Boolean excel = classicBooksImportService.checkExcel(file);
        if (excel) {

            List<ArrayList<String>> rowInfo = classicBooksImportService.handleExcelData(file);
            List<ClassicBooks> classicBooks = classicBooksImportService.handleRowInfo2Po(rowInfo);
            if (null != file1) {
                //图书封面
                List<MultipartFile> coverMultipartFiles = documentUnzipHandleService.unzipDocument(request, file1);
//                Map<String, String> coverStringMap = documentUnzipHandleService.uploadWebService(coverMultipartFiles, EssayUploadConstant.IMG_UPLOAD_YUNPAN_URL, null);
                Map<String, String> coverStringMap = documentUnzipHandleService.uploadService(coverMultipartFiles, "4", request);
                classicBooksService.setBookEnclosurePath(coverStringMap, classicBooks, "4");
            }

            if (null != file2) {
                //图书pdf附件
                List<MultipartFile> pdfMultipartFiles = documentUnzipHandleService.unzipDocument(request, file2);
                Map<String, String> pdfStringMap = documentUnzipHandleService.uploadService(pdfMultipartFiles, "1", request);
                classicBooksService.setBookEnclosurePath(pdfStringMap, classicBooks, "1");
            }

            if (null != material) {
                //讲解材料
                List<MultipartFile> materialFiles = documentUnzipHandleService.unzipDocument(request, material);
                Map<String, String> materialStringMap = documentUnzipHandleService.uploadService(materialFiles, "2", request);
                classicBooksService.setBookEnclosurePath(materialStringMap, classicBooks, "2");
            }

            if (null != courseware) {
                //导读课件
                List<MultipartFile> coursewareFiles = documentUnzipHandleService.unzipDocument(request, courseware);
                Map<String, String> coursewareStringMap = documentUnzipHandleService.uploadService(coursewareFiles, "3", request);
                classicBooksService.setBookEnclosurePath(coursewareStringMap, classicBooks, "3");
            }

            List<String> bookClassifys = classicBooksService.checkBookClassifyIsExist(classicBooks);
            if (null != bookClassifys && bookClassifys.size() > 0) {
                return ClassicBooksConstant.CLASSICBOOKS_CLASSIFY_NOEXIST;
            }
            List<ClassicBooks> repeatBooks = classicBooksService.checkIsRepeat(classicBooks);
            if (repeatBooks.size() > 0) {
                return ClassicBooksConstant.CLASSICBOOKS_DADA_REPEAT;
            } else {
                classicBooksService.importClassicBooks(classicBooks);
            }
        }
        return "";
    }

    /**
     * 单本图书导入
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/importSingleBook")
    public ModelAndView importSingleBook(HttpServletRequest request, ClassicBooks classicBooks, String essayId, MultipartRequest merq) {
        ModelAndView modelAndView = new ModelAndView();
        String singlepdfPath = "";
        String materialfPath = "";
        String coursewarefPath = "";
        String ImgPath = "";
        MultipartFile image;
        MultipartFile singlepdf = merq.getFile("singlepdf");
        MultipartFile material = merq.getFile("material");
        MultipartFile courseware = merq.getFile("courseware");

        if (StringUtils.isNotBlank(classicBooks.getScreenshot())) {
            image = Base64Util.base64ToMultipart(classicBooks.getScreenshot());
            FileUtils.handleFiledelete(image, request, "4");
            ImgPath = FileUtils.handleFileUpload(image, "4", request);
            classicBooks.setScreenshot(ImgPath);
        }

        if (singlepdf.getSize() > 0) {
            singlepdfPath = FileUtils.handleFileUpload(singlepdf, "1", request);
        }

        if (material.getSize() > 0) {
            materialfPath = FileUtils.handleFileUpload(material, "2", request);
        }

        if (courseware.getSize() > 0) {
            coursewarefPath = FileUtils.handleFileUpload(courseware, "3", request);
        }

        classicBooks.setCnkiYycount(singlepdfPath);
        classicBooks.setWfYycount(materialfPath);
        classicBooks.setCqvipYycount(coursewarefPath);

        if (StringUtils.isNotBlank(essayId)) {
            classicBooksService.addClassicBookInfo(classicBooks, essayId);
        } else {
            classicBooksService.addClassicBookInfo(classicBooks);
        }
        modelAndView.setViewName("redirect:readingRecommend");

        return modelAndView;
    }

    /**
     * 图书删除
     */
    @RequestMapping(value = "/delClassiclBookDisplay")
    public ModelAndView delClassiclBookDisplay(HttpServletRequest request, ClassicBooks classicBooks, Integer currentPage) {
        ModelAndView modelAndView = new ModelAndView();
        classicBooksService.delClassicBook(classicBooks);
        modelAndView.setViewName("redirect:readingRecommend?currentPage=" + currentPage);
        return modelAndView;
    }

    /**
     * 删除图书，将其不显示
     *
     * @param request
     * @param classicBooks
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modifyClassiclBookDisplay")
    public String modifyClassiclBookDisplay(HttpServletRequest request, ClassicBooks classicBooks) {
//        ModelAndView modelAndView = new ModelAndView();
        Boolean modify = classicBooksService.hideAndShowClassicBook(classicBooks);
//        modelAndView.setViewName("redirect:readingRecommend");
        if (modify) {
            return classicBooks.getIsDisplay() + "";
        }
        return null;
    }

    /**
     * 添加分类页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/addBookClassify")
    public ModelAndView addBookClassify(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<BookClassificationBo> bookClassificationBos = bookClassificationService.handleBookClassification();
        modelAndView.addObject("bookClassificationBos", bookClassificationBos);
        modelAndView.setViewName("readingthoughts/readingClassifySet");
        return modelAndView;
    }

    /**
     * 添加分类功能
     *
     * @param request
     * @param bookClassificationPo
     * @return
     */
    @RequestMapping(value = "/addBookClassifyTrend")
    public ModelAndView addBookClassify(HttpServletRequest request, BookClassificationPo bookClassificationPo) {
        ModelAndView modelAndView = new ModelAndView();
        bookClassificationService.addNewBookClassification(bookClassificationPo);
        modelAndView.setViewName("redirect:addBookClassify");
        return modelAndView;
    }

    /**
     * 修改属性值
     *
     * @param request
     * @param bookClassificationPo
     * @return
     */
    @RequestMapping(value = "/bookClassifyTrendModify")
    public ModelAndView bookClassifyTrendModify(HttpServletRequest request, BookClassificationPo bookClassificationPo) {
        ModelAndView modelAndView = new ModelAndView();
        bookClassificationService.modifyBookClassify(bookClassificationPo);
        modelAndView.setViewName("redirect:addBookClassify");
        return modelAndView;
    }

    /**
     * 删除分类，有时可能不是一个
     *
     * @param request
     * @param bookClassificationPo
     * @return
     */
    @RequestMapping(value = "/bookClassifyTrendDel")
    public ModelAndView bookClassifyTrendDel(HttpServletRequest request, PageBean<ClassicBooks> classicBooksPageBean, BookClassificationPo bookClassificationPo) {
        ModelAndView modelAndView = new ModelAndView();
        Boolean del = bookClassificationService.delBookClassify(bookClassificationPo);
        modelAndView.setViewName("redirect:addBookClassify");
        return modelAndView;
    }

    /**
     * 通过书目查找信息
     *
     * @param request
     * @param BookName
     * @return
     */
    @RequestMapping(value = "/getBookByName")
    public ModelAndView getBookByName(HttpServletRequest request, String BookName) {
        ModelAndView modelAndView = new ModelAndView();
        List BookList = classicBooksService.getClassicBooksLikeTitle(BookName);
        modelAndView.setViewName("readingthoughts/readingRecommend");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/setShow")
    public String setShow(String essayInfoHistoryPoStr, Integer id) {
        if (essayInfoService.setShow(essayInfoHistoryPoStr, id)) {
            essayAndBookService.insertEssayHistory(essayInfoHistoryPoStr);
            return "200";
        } else {
            return "100";
        }
    }

    @RequestMapping(value = "/toPublishPage")
    public ModelAndView toPublishPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("readingthoughts/essayMessagePublish");
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "/orderEssay", method = RequestMethod.POST)
    public String orderEssay(HttpServletRequest request, String essayInfoPoStr) {
        return essayInfoService.orderEssay(request, essayInfoPoStr);
    }

    @ResponseBody
    @RequestMapping(value = "/modifyEssay", method = RequestMethod.POST)
    public String modifyEssay(String essayInfoPoStr) {
        return essayInfoService.modifyEssay(essayInfoPoStr);
    }

    @RequestMapping(value = "/toGuideReading")
    public ModelAndView toGuideReading() {
        ModelAndView modelAndView = new ModelAndView();
        List<GuideReadingPo> list = guideReadingManager.getInfo();
        if (list.size() > 0) {
            modelAndView.addObject("guideReading", list.get(0));
        }
        modelAndView.setViewName("readingthoughts/guideReading");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/updateGuideReading")
    public String updateGuideReading(String guideReadingPoStr) {
        guideReadingPoStr = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(guideReadingPoStr));
        GuideReadingPo guideReadingPo = new JsonMapper().fromJson(guideReadingPoStr, GuideReadingPo.class);
        if(guideReadingManager.update(guideReadingPo)){
            return "200";
        }else {
            return "100";
        }
    }

    @RequestMapping(value = "/toSetHeadmasterMessage")
    public ModelAndView toSetHeadmasterMessage() {
        ModelAndView modelAndView = new ModelAndView();
        List<HeadmasterMessagePo> list = headmasterMessageManager.getInfo();
        if (list.size() > 0) {
            modelAndView.addObject("headmasterMessage", list.get(0));
        }
        modelAndView.setViewName("readingthoughts/setHeadmasterMessage");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/updateHeadmasterMessage")
    public String updateHeadmasterMessage(String headmasterMessageStr) {
        headmasterMessageStr = EncodeUtils.unescapeJS(EncodeUtils.unescapeJS(headmasterMessageStr));
        HeadmasterMessagePo headmasterMessagePo = new JsonMapper().fromJson(headmasterMessageStr, HeadmasterMessagePo.class);
        if(headmasterMessageManager.update(headmasterMessagePo)){
            return "200";
        }else {
            return "100";
        }

    }

    @RequestMapping(value = "/userManagePage")
    public ModelAndView userManagePage(){
        ModelAndView view = new ModelAndView();
        List<AdministratorPo> list = administratorManger.queryAllAdmin();
        view.addObject("adminList",list);
        view.setViewName("readingthoughts/userManger");
        return view;
    }


    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/readingthoughts/addUser");
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "/appendUser",method = RequestMethod.POST)
    public String appendUser(String userInfoStr){

        return administratorManger.addUser(userInfoStr);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public String deleteUser(int id){
        return administratorManger.deleteUser(id);
    }

    @RequestMapping(value = "/toUpdateUser")
    public ModelAndView toUpdateUser(int id){
        ModelAndView view = new ModelAndView();
        view.setViewName("/readingthoughts/updateUser");
        AdministratorPo administratorPo = administratorManger.getAdminById(id);
        view.addObject("administratorPo",administratorPo);
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser")
    public String updateUser(String userInfoStr){

        return administratorManger.updateUser(userInfoStr);
    }


    public static void main(String[] args) {
        String a = "Hgd_123456";
        String b = Md5Utils.md5(a);
        System.out.println(b);
    }
}
