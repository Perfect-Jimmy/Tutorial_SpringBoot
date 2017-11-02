package com.tutorial.test.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.domain.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by jimmy on 2017/11/1.
 * http://blog.csdn.net/liuchuanhong1/article/details/53495004
 * http://blog.csdn.net/chinrui/article/details/71036544
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@WebAppConfiguration
public class AccountMockTest extends MockMvcResultMatchers {

    //模拟mvc对象类.
    private MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void saveAccountTest() throws Exception {
        String url ="/account";
        Account account = new Account();
        account.setUserName("jimmy1");
        account.setPassword("123456");
        account.setEmail("55@qq.com");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("mapper:"+mapper.writeValueAsString(account));
        RequestBuilder request = MockMvcRequestBuilders.post(url)
                                .content(mapper.writeValueAsString(account))
                                .contentType(MediaType.APPLICATION_JSON_UTF8);

        MvcResult mvcResult = mockMvc.perform(request)
                //使用jsonPath解析返回值，判断具体的内容
              //  .andExpect(jsonPath("$.errorCode", is("301")))
                .andDo(print()) //打印出请求和响应的内容
                .andReturn();
        int statusCode = mvcResult.getResponse().getStatus();
        System.out.println(statusCode+"-=========");
        Assert.assertEquals(statusCode, 200);
        System.out.println(mvcResult.getResponse().getErrorMessage()+"--");
        System.out.println(mvcResult.getResponse().getContentAsString()+"++++");//将相应的数据转换为字符串
    }

    /*@Test
    public void queryAllStudents() throws Exception {
        String url ="/student/queryAll";
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())  //返回的状态是200
                .andDo(print())              //打印出请求和相应的内容
                .andReturn();
        //int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();//将相应的数据转换为字符串
        System.out.println(content);
    }*/


}
