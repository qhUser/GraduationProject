package cn.gpmall.search.service;

import cn.gpmall.common.pojo.Page;

public interface SearchService {
   Page search(String keyword,Integer page,Integer rows)throws Exception;
}
