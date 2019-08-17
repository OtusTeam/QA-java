package com.otus.api.step4.api;

import com.otus.api.step4.AppConfig;
import com.otus.api.step4.model.SearchResult;
import com.otus.api.step4.service.SearchService;
import com.otus.api.step4.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEmptyString.emptyString;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class SearchTest {


    @Value("${basepath.login}")
    private String loginUri;

    @Value("${user.login}")
    private String userLogin;

    @Value("${user.pass}")
    private String userPass;

    @Autowired
    private UserService user;

    @Autowired
    private SearchService search;


    @Before
    public void setUp() {
        search.withCookies(user.getCookies(userLogin, userPass));
    }


    @Test
    public void asAuthorizedUserICanSearchImages() {
        SearchResult result = search.searchImage("log", 25, "image");
        assertThat(result.getNext(), emptyString());
        assertThat(result.getCount(), is(8));
        assertThat(result.getSummaries().size(), is(8));
    }

    @Test
    public void asAuthorizedUserICanSearchPlugins() {
        SearchResult result = search.searchPlugin("log", 25, "plugin", "logging");
        assertThat(result.getNext(), emptyString());
        assertThat(result.getCount(), is(3));
        assertThat(result.getSummaries().size(), is(3));
    }

}
