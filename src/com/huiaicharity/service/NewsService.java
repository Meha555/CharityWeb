package com.huiaicharity.service;

import com.huiaicharity.entity.News;
import com.huiaicharity.mapper.NewsDao;

import java.util.ArrayList;

public class NewsService {
    private NewsDao newsDao = new NewsDao();

    public int sendNews(String title, String content, String author, String aid,String media) {//发送新闻
        News news = new News();
        news.setNid(newsDao.countAll() + 1);
        news.setTitle(title);
        news.setContent(content);
        news.setAuthor(author);
        news.setAid(aid);
        news.setTime();
        news.setMedia(media);
        return newsDao.insertNews(news);
    }

    public int deleteNews(int nid) {
        return newsDao.deleteNewsByNID(nid);
    }

    public ArrayList<News> getAll() {
        ArrayList<News> news = newsDao.selectAll();
        return news;
    }
    public News selectNewsByNID(int nid){
        return newsDao.selectByNID(nid);
    }
}
