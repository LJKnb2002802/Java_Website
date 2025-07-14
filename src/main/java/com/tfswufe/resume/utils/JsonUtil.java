package com.tfswufe.resume.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.Getter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class JsonUtil {
    /**
     * 默认日期时间格式
     */
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 默认日期格式
     */
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 默认时间格式
     */
    private static final String TIME_FORMAT = "HH:mm:ss";

    //饿汉模式
    @Getter
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /** Json序列化和反序列化转换器 */
    static {
        // java8日期 Local系列序列化和反序列化模块
        final JavaTimeModule javaTimeModule = new JavaTimeModule();
        // 序列化
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT)));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(TIME_FORMAT)));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
        // 反序列化
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_FORMAT)));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(TIME_FORMAT)));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));

        // 后台Long值传递给前端精度丢失问题（JS最大精度整数是Math.pow(2,53)）
        //SimpleModule simpleModule = new SimpleModule();
        //simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        //simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        //simpleModule.addSerializer(BigInteger.class, ToStringSerializer.instance);

        OBJECT_MAPPER.registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(javaTimeModule)
                //加上后，服务器端返回的long类型值会变成字符串
                //.registerModule(simpleModule)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                //取消默认转换timestamps形式
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
                // 忽略json字符串中存在，但在java对象中不存在对应属性的情况。防止错误
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                // 忽略空Bean转json的错误
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                //// PrettyPrinter 格式化输出
                // OBJECT_MAPPER.configure(SerializationFeature.INDENT_OUTPUT, true);
                // NULL不参与序列化
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                // 忽视为空的属性
                .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
                // 允许出现单引号
                .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
                // 指定时区
                .setTimeZone(TimeZone.getTimeZone("GMT+8:00"))
                // Date日期类型字符串全局处理, 默认格式为：yyyy-MM-dd HH:mm:ss 局部处理某个Date属性字段接收或返回日期格式yyyy-MM-dd,
                // 可采用@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")注解标注该属性
                //所有的日期格式都统一为以下的格式
                .setDateFormat(new SimpleDateFormat(DATE_TIME_FORMAT));
    }

    /**
     * 私有构造方法，防止实例化
     */
    private JsonUtil() {

    }

    /* ====================================Java对象转换成JSON字符串================================================*/

    /**
     * 将对象转换成字符串
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String obj2string(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof String res) {
                return res;
            }
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("将对象转换成字符串时发生异常");
        }
    }

    /**
     * 将对象转换成格式化后的字符串
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String obj2stringPretty(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof String res) {
                return res;
            }
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("将对象转换成格式化后的字符串时发生异常");
        }
    }
    /* ====================================Java对象转换成JSON字符串================================================*/

    /* ====================================JSON字符串转换成Java对象================================================*/

    /**
     * 字符串转对象
     *
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T string2obj(String str, Class<T> clazz) {
        if (str == null || str.length() == 0 || clazz == null) {
            return null;
        }
        try {
            if (clazz.equals(String.class)) {
                return clazz.cast(str);
            } else {
                return OBJECT_MAPPER.readValue(str, clazz);
            }
        } catch (IOException e) {
            throw new RuntimeException("Json字符串转换为Java对象时发生异常");
        }
    }

    /**
     * 在字符串与集合（List/Map）对象转换时使用
     *
     * @param str
     * @param typeReference
     * @param <T>           必须不能是内部类
     * @return
     */
    public static <T> T string2obj(String str, TypeReference<T> typeReference) {
        if (str == null || str.length() == 0 || typeReference == null) {
            return null;
        }
        try {
            if (typeReference.getType().equals(String.class)) {
                return (T) str;
            } else {
                return OBJECT_MAPPER.readValue(str, typeReference);
            }
        } catch (IOException e) {
            throw new RuntimeException("Json字符串转换为Java集合（List/Map）对象时发生异常");
        }
    }

    /**
     * 在字符串与集合对象转换时使用
     *
     * @param str
     * @param collectionClazz
     * @param elementClazzes
     * @param <T>
     * @return
     */
    public static <T> T string2obj(String str, Class<?> collectionClazz, Class<?>... elementClazzes) {
        final JavaType javaType = OBJECT_MAPPER.getTypeFactory()
                .constructParametricType(collectionClazz, elementClazzes);
        try {
            return OBJECT_MAPPER.readValue(str, javaType);
        } catch (IOException e) {
            throw new RuntimeException("Json字符串转换为Java对象时发生异常");
        }
    }

    /**
     * 将json数据转换成pojo对象list
     *
     * @param str   json格式字符串
     * @param clazz 对象类型
     * @return List对象
     */
    public static <T> List<T> string2list(String str, Class<T> clazz) {
        final JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
        try {
            return OBJECT_MAPPER.readValue(str, javaType);
        } catch (Exception e) {
            throw new RuntimeException("Json字符串转换为List对象时发生异常");
        }
    }

    /**
     * 将json数据转换成pojo对象Map
     *
     * @param str       json格式字符串
     * @param keyType   key对象类型
     * @param valueType value对象类型
     * @return List对象
     */
    public static <K, V> Map<K, V> string2map(String str, Class<K> keyType, Class<V> valueType) {
        final MapType mapType = OBJECT_MAPPER.getTypeFactory().constructMapType(Map.class, keyType, valueType);
        try {
            return OBJECT_MAPPER.readValue(str, mapType);
        } catch (Exception e) {
            throw new RuntimeException("Json字符串转换为Map对象时发生异常");
        }
    }

    /**
     * 判断参数是否是JSON字符串
     *
     * @param str
     * @return
     */
    public static boolean isJSONType(String str) {
        try {
            OBJECT_MAPPER.readTree(str);
            return true;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("判断参数是否是JSON字符串时发生异常");
        }
    }

    /* ====================================JSON字符串转换成Java对象================================================*/

    /**
     * 获取JSON字符串中指定key对应的Value
     * <p>
     * 支持查询二级/三级的key
     *
     * @param json
     * @param key
     * @return
     */
    public static String getValueByKey(String json, String key) {
        JsonNode jsonNode = null;
        try {
            jsonNode = OBJECT_MAPPER.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("将字符串转换成JSON对象时发生异常");
        }

        if (jsonNode != null) {
            final Iterator<Map.Entry<String, JsonNode>> iterator = jsonNode.fields();
            while (iterator.hasNext()) {
                final Map.Entry<String, JsonNode> entry = iterator.next();
                String value = entry.getValue().toString();
                if (entry.getKey().equals(key)) {
                    if (value.startsWith("\"") && value.endsWith("\"")) {
                        value = value.substring(1, value.length() - 1);
                    }
                    return value;
                } else if (value.contains("{") && value.contains("}")) {
                    return getValueByKey(value, key);
                }
            }
        }
        return null;
    }
}
