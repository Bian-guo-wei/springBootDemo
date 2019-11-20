package com.example.demo.website;

import com.dayainfo.lib.search.model.PageBean;
import com.example.demo.essay.manager.EssayInfoHistoryManager;
import com.example.demo.essay.manager.EssayInfoManager;
import com.example.demo.essay.model.po.EssayInfoHistoryPo;
import com.example.demo.reading.manager.BookClassificationManager;
import com.example.demo.reading.manager.GuideReadingManager;
import com.example.demo.reading.manager.HeadmasterMessageManager;
import com.example.demo.reading.model.bo.BookClassificationMapBo;
import com.example.demo.reading.model.po.ClassicBooks;
import com.example.demo.reading.model.po.GuideReadingPo;
import com.example.demo.reading.model.po.HeadmasterMessagePo;
import com.example.demo.reading.service.BookClassificationService;
import com.example.demo.reading.service.ClassicBooksService;
import com.example.demo.reading.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class FrontController {

    private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

    @Autowired
    private BookClassificationService bookClassificationService;
    @Autowired
    private ClassicBooksService classicBooksService;
    @Autowired
    private EssayInfoManager essayInfoManager;
    @Autowired
    private GuideReadingManager guideReadingManager;
    @Autowired
    private HeadmasterMessageManager headmasterMessageManager;
    @Autowired
    private BookClassificationManager bookClassificationManager;
    @Autowired
    private EssayInfoHistoryManager essayInfoHistoryManager;



    @RequestMapping(value = "/toIndex")
    public ModelAndView toIndex(ClassicBooks classicBooks) {
        ModelAndView view = new ModelAndView();
        List<ClassicBooks> booksList = classicBooksService.getdisplayEsaayBook("", 1);
        List<ClassicBooks> booksList2 = classicBooksService.getdisplayEsaayBook("", 2);
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
        view.addObject("map", bookClassificationMapBo.getBookClassifyMap());
        view.addObject("list1", booksList);
        view.addObject("list2", booksList2);
        view.setViewName("index");

        return view;
    }

    @RequestMapping(value = "/toExpertIntroduction")
    public ModelAndView toExpertIntroduction() {
        ModelAndView view = new ModelAndView();
        List<GuideReadingPo> list = guideReadingManager.getInfo();
        if (list.size() > 0) {
            view.addObject("guideReading", list.get(0));
        }
        view.setViewName("expertIntroduction");
        return view;
    }


    @RequestMapping(value = "/toTextBooks")
    public ModelAndView toTextBooks(@RequestParam(defaultValue = "") String classfiyId) {
        ModelAndView view = new ModelAndView();
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
//        List<ClassicBooks> booksList = classicBooksService.getdisplayEsaayBook("", 0);
        PageBean<ClassicBooks> classicBooksPageBean = new PageBean<>();
        classicBooksService.getClassicBooksByClassify(classicBooksPageBean, classfiyId);
        List<ClassicBooks> booksList = classicBooksPageBean.getList();
        view.addObject("list", booksList);
        view.addObject("map", bookClassificationMapBo.getBookClassifyMap());
        view.setViewName("textBooks");
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "/getBooks")
    public List<ClassicBooks> getBooks(@RequestParam String bookClassify, @RequestParam int book_classification) {

        List<ClassicBooks> booksList = classicBooksService.getdisplayEsaayBook(bookClassify, book_classification);

        return booksList;
    }

    @RequestMapping(value = "/toExpandedList")
    public ModelAndView toExpandedList(@RequestParam(required = false, defaultValue = "1") Integer currentPage,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        ModelAndView view = new ModelAndView();
        PageBean<EssayInfoHistoryPo> ExpandedPage = essayInfoHistoryManager.getHistoryEssayFront(currentPage, pageSize);
        view.addObject("pageBean", ExpandedPage);
        view.addObject("booksList", ExpandedPage.getList());
        view.setViewName("expandedList");
        return view;
    }

    @RequestMapping(value = "/toWeilcome")
    public ModelAndView toWeilcome() {
        ModelAndView view = new ModelAndView();
        List<HeadmasterMessagePo> list = headmasterMessageManager.getInfo();
        if(list.size() > 0){
            view.addObject("headmasterMessage",list.get(0));
        }
        view.setViewName("weilcome");
        return view;
    }

    @RequestMapping(value = "/getEssayDetail")
    public ModelAndView getEssayDetail(String uuid) {
        ModelAndView view = new ModelAndView();
        EssayInfoHistoryPo essayInfoHistoryPo = essayInfoHistoryManager.getEssayInfoHistoryByUuid(uuid);
        view.addObject("essayInfoHistoryPo", essayInfoHistoryPo);
        view.setViewName("expandedListDes");
        return view;
    }

    @RequestMapping(value = "/toBookDetail")
    public ModelAndView toBookDetail(int id, @RequestParam(defaultValue = "") String classfiyId) {
        ModelAndView view = new ModelAndView();
        BookClassificationMapBo bookClassificationMapBo = bookClassificationService.trendGetBookClassificationMap();
//        List<ClassicBooks> booksList = classicBooksService.getBooks("", 0);
        PageBean<ClassicBooks> classicBooksPageBean = new PageBean<>();
        classicBooksService.getClassicBooksByClassify(classicBooksPageBean, classfiyId);
        List<ClassicBooks> booksList = classicBooksPageBean.getList();
        String classfiyName = bookClassificationManager.getClassfiyNameByClassfiyId(classfiyId);
        view.addObject("classfiyName", classfiyName);
        view.addObject("list", booksList);
        view.addObject("map", bookClassificationMapBo.getBookClassifyMap());
        ClassicBooks classicBooks = classicBooksService.getClassicBookById(id);
        view.addObject("classicBooks", classicBooks);
        view.setViewName("bookContent");
        return view;
    }

    //下载文件
    @ResponseBody
    @RequestMapping("/fileDownload")
    public void testResponseEntity(HttpServletResponse response, String fileName) throws IOException {
      FileUtils.downLoad(response,fileName);
    }
}
