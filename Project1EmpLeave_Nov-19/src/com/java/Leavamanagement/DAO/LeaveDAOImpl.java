package com.java.Leavamanagement.DAO;


import com.java.Leavamanagement.model.EmpLeaveDetails;
import com.java.Leavamanagement.DAO.LeaveDAOImpl;

import java.util.*;

public class LeaveDAOImpl implements LeaveDAO{

   private static final List<EmpLeaveDetails> leaveList = new ArrayList<>();
    @Override
    public String addLeave(EmpLeaveDetails leave) {
        leaveList.add(leave);
        return "Added Leave....";

    }

    @Override
    public List<EmpLeaveDetails> showLeaves() {

        return new ArrayList<>(leaveList);
    }

    @Override
    public EmpLeaveDetails searchLeave(int leaveId) {
        return leaveList.stream()
                .filter(x->x.getLeaveId()==leaveId).findFirst().orElse(null);
    }

    @Override
    public String updateLeave(EmpLeaveDetails leaveUpdate) {
        EmpLeaveDetails found = searchLeave(leaveUpdate.getLeaveId());
        if (found != null) {

            found.setEmpId(leaveUpdate.getEmpId());
            found.setLeaveStartDate(leaveUpdate.getLeaveStartDate());
            found.setLeaveEndDate(leaveUpdate.getLeaveEndDate());
            found.setNoOfDays(leaveUpdate.getNoOfDays());
            found.setAppliedOn(leaveUpdate.getAppliedOn());
            found.setLeaveReason(leaveUpdate.getLeaveReason());

            return "Leave Record Updated Successfully...";
        }
        return "Leave Record Not Found...";


    }

    @Override
    public String deleteLeave(int leaveId) {
        EmpLeaveDetails ld = searchLeave(leaveId);
        if (ld != null) {
            leaveList.remove(ld);
            return "Leave Record Deleted";

        }
        return "Leave Record Not Found";

    }



}
