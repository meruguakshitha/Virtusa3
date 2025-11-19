package com.java.Leavamanagement.bal;
import com.java.Leavamanagement.DAO.LeaveDAO;
import com.java.Leavamanagement.DAO.LeaveDAOImpl;
import com.java.Leavamanagement.exceptions.ExceptionEmpClass;
import com.java.Leavamanagement.model.EmpLeaveDetails;
import java.util.*;



public class LeaveBal {
    static StringBuilder sb;
    static LeaveDAO LeaveDao;
    static{
        sb = new StringBuilder();
        LeaveDao = new LeaveDAOImpl();

    }
    private final LeaveDAO dao = new LeaveDAOImpl();

    public List<EmpLeaveDetails> showLeaves() {
        return LeaveDao.showLeaves();
    }


    public String addLeave(EmpLeaveDetails leave) throws ExceptionEmpClass {

        if (validateLeave(leave) == true) {

            calculateNoOfDays(leave);
            leave.setAppliedOn(new Date());

            return dao.addLeave(leave);
        }
        throw new ExceptionEmpClass(sb.toString());
    }

    public String updateLeaveBal(EmpLeaveDetails leave) throws ExceptionEmpClass {

        if (validateLeave(leave) == true) {

            calculateNoOfDays(leave);
            leave.setAppliedOn(new Date());

            return dao.updateLeave(leave);
        }
        throw new ExceptionEmpClass(sb.toString());
    }

    public EmpLeaveDetails searchLeaveBal(int leaveId) {
        return dao.searchLeave(leaveId);
    }

    public String deleteLeaveBal(int leaveId) {
        return dao.deleteLeave(leaveId);
    }

    // ---------------- VALIDATION ----------------

    public boolean validateLeave(EmpLeaveDetails leave) {
        boolean isValid = true;
        sb = new StringBuilder();

        Date today = new Date();

        if (leave.getLeaveStartDate().before(today)) {
            sb.append("Leave Start Date cannot be yesterday or past...\n");
            isValid = false;
        }

        if (leave.getLeaveEndDate().before(today)) {
            sb.append("Leave End Date cannot be yesterday or past...\n");
            isValid = false;
        }

        if (leave.getLeaveStartDate().after(leave.getLeaveEndDate())) {
            sb.append("Leave Start Date cannot be > End Date...\n");
            isValid = false;
        }

        if (leave.getLeaveReason().length() < 3) {
            sb.append("Leave Reason must be at least 3 chars...\n");
            isValid = false;
        }

        return isValid;
    }

    // --------------- CALCULATE DAYS ----------------

    private void calculateNoOfDays(EmpLeaveDetails leave) {
        long diff = leave.getLeaveEndDate().getTime() - leave.getLeaveStartDate().getTime();
        int days = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
        leave.setNoOfDays(days);
    }





}
