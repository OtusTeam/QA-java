package com.otus.api.step4.api;

import com.otus.api.step4.AppConfig;
import com.otus.api.step4.model.Repositories;
import com.otus.api.step4.service.RepoService;
import com.otus.api.step4.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class RepositoriesTest {
    @Value("${user.pass}")
    private String userPass;

    @Value("${user.nickname}")
    private String userName;

    @Value("${user.login}")
    private String userLogin;

    @Autowired
    private UserService user;

    @Autowired
    private RepoService repo;

    @Before
    public void setUp() {
        repo.withCookies(user.getCookies(userName, userPass));
    }


    @Test
    public void asAuthorizedUserICanGetRepositories() {
        Repositories reps = repo.getRepositories("last_updated", 1, userName);
        assertThat(reps.getCount(), is(9));
        assertThat(reps.getResults().size(), is(9));
    }

}
