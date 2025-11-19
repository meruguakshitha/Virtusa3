package com.java.Leavamanagement.DAO;
import com.java.Leavamanagement.model.EmpLeaveDetails;
import java.util.*;

public interface LeaveDAO {


    String addLeave(EmpLeaveDetails leave);
    List<EmpLeaveDetails> showLeaves();
    EmpLeaveDetails searchLeave(int leaveId);
    String updateLeave(EmpLeaveDetails leave);
    String deleteLeave(int leaveId);


}
