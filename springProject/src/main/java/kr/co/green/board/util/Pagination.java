package kr.co.green.board.util;

import org.springframework.stereotype.Component;

import kr.co.green.board.dto.PageInfoDTO;

@Component
public class Pagination {
	
	public PageInfoDTO getPageInfoDTO(int totalCount, int currentPage,
									  int pageLimit, int boardLimit) {
		
		// <전체 페이지 수>
		// 상황) totalCount:301, boardLimit:5
		// - 301.0/5 = 60.2
		// - Math.ceil에 의해서 소수점 올림처리 = 61.0
		// - 마지막으로 int로 강제 형변환해서 정수로 변경 = 61
		int maxPage = (int)(Math.ceil((double)totalCount/boardLimit));
		
		// <현재 페이지가 속한 범위의 시작 페이지>
		// 상황) currentPage:23, pageLimit:10
		// - (currentPage-1) = 22
		// - (currentPage-1) / pageLimit = 2 
		//         22             10    
		// - (currentPage-1) / pageLimit * pageLimit = 20 
		//                        2            10   
		// - (currentPage-1) / pageLimit * pageLimit+1 = 21
		int startPage = (currentPage-1) / pageLimit * pageLimit+1;
		
		// <현재 페이지가 속한 범위의 끝 페이지>
		// 상황) startPage:21, pageLimit:10
		// - 21+10 = 31
		// - 31-1 = 30
		int endPage = startPage+pageLimit-1;
		
		// <뷰에서 사용할 글번호>
		// 상황) totalCount=301, currentPage:23, boardLimit:10
		// - (currentPage-1) = 22
		// - (currentPage-1) * boardLimit = 220
		//          22             10
		// - totalCount - (currentPage-1) * boardLimit = 81
		//         301            220
		int row = totalCount - (currentPage-1) * boardLimit;
		
		// <DB에서 꺼내올 행의 시작 번호>
		// 상황) currentPage:23, boardLimit:10
		// - (currentPage-1) = 22
		// - (currentPage-1) * boardLimit : 220
		//          22             10
		int offset = (currentPage-1) * boardLimit+1;
		
		// <DB에서 꺼내올 행의 끝 번호>
		// 상황) offset:221, boardLmit:10
		// - 230
		int limit = offset+boardLimit-1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		return new PageInfoDTO(totalCount, currentPage, pageLimit, boardLimit,
							   maxPage, startPage, endPage, row, offset, limit);
	}
}






