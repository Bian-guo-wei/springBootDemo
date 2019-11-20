package com.example.demo.reading.constant;

/**
 * @author admin
 */
public class ClassicBooksConstant {
    public static final String CLASSICBOOKS_REDIS_KEY_ALL = "classicBooksList";
    public static final String CLASSICBOOKS_PARAM_SEARCH = "all";
    public static final String CLASSICBOOKS_CLASSIFY_NOEXIST = "部分分类不存在";
    public static final String CLASSICBOOKS_DADA_REPEAT = "部分数据曾导入";
    public static final int CLASSICBOOKS_IS_DISPLAY = 0;
    public static final int CLASSICBOOKS_NO_DISPLAY = 1;
    public static final int CLASSICBOOKS_PAGESIZE = 15;

    public static final String UUID_TIMESTAMP_SEPARATOR = "_";

    public enum BooksSearchClassifyEnum {

        /**
         * 默认
         */
        SEARCHBYTITLE(1, "title"),
        SEARCHBYCREATOR(1, "creator"),
        SEARCHBYKEYWORD(1, "keyword");
        private int key;
        private String value;


        BooksSearchClassifyEnum(int key, String value) {
            this.key = key;
            this.value = value;
        }


        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "BooksSearchClassifyEnum{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
