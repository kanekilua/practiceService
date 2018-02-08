package com.miduodai.loanService.service.Impl;

import com.miduodai.loanService.beans.entity.User;
import com.miduodai.loanService.beans.entity.UserLoan;
import com.miduodai.loanService.dao.UserLoanMapper;
import com.miduodai.loanService.service.IUserLoanService;
import com.miduodai.loanService.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 上午11:28 18-2-6
 */
@Service
public class UserLoanService implements IUserLoanService{

    @Autowired
    private UserLoanMapper userLoanMapper;

    @Autowired
    private IUserService iUserService;

    @Override
    public int insertUserLoan(UserLoan userLoan) {
        int result;

        Date date = new Date();
        userLoan.setLoanDate(date);

        int userId = userLoan.getUsersId();
        List<UserLoan> userLoanList = userLoanMapper.selectByUserId(userId);
        UserLoan lastLoan = userLoanList.get(userLoanList.size() - 1);
        int times = 1;
        if(lastLoan != null) {
            times = lastLoan.getTimes() + 1;
        }
        userLoan.setTimes(times);

        int insertFlag = userLoanMapper.insertSelective(userLoan);
        if (insertFlag <= 0) {
            return -1;
        }

        int funds = userLoan.getFunds();
        User user = iUserService.getUserById(userLoan.getUsersId());
        int quotaRemain = user.getQuotaRemain();
        if(quotaRemain < funds) {
            return -1;
        }else {
            user.setQuotaRemain(quotaRemain - funds);
            int updateFlag = iUserService.updateUser(user);
            if (updateFlag <= 0) {
                return  -1;
            }else {
                result = 1;
            }
        }
        return result;
    }
}
