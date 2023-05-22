package com.tikkeul.app.service.admin;

import com.tikkeul.app.dao.AdminDAO;
import com.tikkeul.app.dao.UserDAO;
import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.InquiryBoardDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.vo.AnswerVO;
import com.tikkeul.app.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("admin") @Primary
public class AdminServiceImpl implements AdminService {
    private final AdminDAO adminDAO;
//  회원
    @Override
    public List<UserVO> adminGetListUserAll() {
        return adminDAO.adminFindUserAll();
    }

    @Override
    public void adminRemoveUser(Long id) {
        adminDAO.adminDeleteUser(id);
    }

//    문의
    @Override
    public List<InquiryBoardDTO> adminGetListInquiryAll(Pagination pagination, Search search) {
        return adminDAO.adminFindInquiryAll(pagination, search);
    }

    @Override
    public Optional<InquiryBoardDTO> adminReadInquiry(Long id) {
        return adminDAO.adminFindInquiry(id);
    }

    @Override
    public int getInquiryTotal(Search search) {
        return adminDAO.findCountOfInquiry(search);
    }

    @Override
    public void adminWriteAnswer(AnswerVO answerVO) {
        adminDAO.adminSaveAnswer(answerVO);
    }

//    도란 게시판
    @Override
    public List<DoranBoardDTO> adminGetListDoranBoardAll(Pagination pagination, Search search) {
        return adminDAO.adminFindDoranBoardAll(pagination, search);
    }

    @Override
    public int getDoranBoardTotal(Search search) {
        return adminDAO.findCountOfDoranBoard(search);
    }

    @Override
    public Optional<DoranBoardDTO> adminReadDoranBoard(Long id) {
        return adminDAO.adminFindDoranBoardById(id);
    }


}