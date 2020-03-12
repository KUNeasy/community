package com.mrkun.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by liukun
 * @date 2020/3/12
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questionDTOS;
    private Boolean showPrevious;
    private Boolean showFirstPage;
    private Boolean showNext;
    private Boolean showEndPage;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount,Integer page,Integer size){
        this.page = page;
        //总页数
        int totalPage = (int) Math.ceil((double)totalCount/(double)size);
        this.totalPage = totalPage;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page-i >= 1){
                pages.add(0,page-i);
            }
            if (page+i <= totalPage){
                pages.add(page+i);
            }
        }

        showPrevious = (page > 1) ? true : false;
        showFirstPage = (page - 3 > 0) ? true : false;
        showNext = (page < totalPage) ? true : false;
        showEndPage = (page + 3 < totalPage) ? true : false;

    }
}
