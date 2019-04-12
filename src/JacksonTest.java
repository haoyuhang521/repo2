import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JacksonTest {
    @Test
    public void test() throws IOException {
        Person p1 =new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("E://a.txt"),p1);
    }
    @Test
    public void test2() throws JsonProcessingException {
        Person p2 =new Person();
        p2.setName("李四");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());

        Person p3 =new Person();
        p3.setName("李四");
        p3.setAge(23);
        p3.setGender("男");
        p3.setBirthday(new Date());

        Person p1 =new Person();
        p1.setName("李四");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        List<Person> list =new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(list);
        System.out.println(string);
    }
    @Test
    public void Test4() throws JsonProcessingException {
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("name","张三");
        map.put("gender","男");
        map.put("age",23);
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(map);
        System.out.println(str);
    }
    @Test
    public void test5() throws IOException {
            String json="{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }
    @Test
    public void test6() throws IOException{
        Jedis jedis = new Jedis();
        jedis.hset("1","haha","java");
        jedis.hset("1","hehe","php");
        jedis.hset("3","meme","c");
        Map<String, String> key = jedis.hgetAll("1");
        Set<String> strings = key.keySet();
        for (String a:strings){
            System.out.println(a+":"+key.get(a));
        }
    }
}
