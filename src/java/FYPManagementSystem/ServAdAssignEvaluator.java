/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FYPManagementSystem;
import FYPManagementSys_Bean.DB;
import FYPManagementSys_Bean.Common;
import FYPManagementSys_Bean.Semester;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author rou
 */
public class ServAdAssignEvaluator extends HttpServlet {
   
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String UserSession = (String)session.getAttribute("user");
        String UserType = (String)session.getAttribute("userType");
        String Option = request.getParameter("Option");
        String metric = request.getParameter("metricNo");
        String address = "";
        try {
            if ((!(UserSession==null))&&(UserType.equals("3"))) {
                if(Option.equals("AssignEx1")){
                    String idEX1  = request.getParameter("assignEX1");
                    String queryassignevaluator1= "update evaluator set examiner1No='"+idEX1+"',flag_examiner1='N' where metricNo='"+metric+"'";
                    DB objDB= new DB();
                    objDB.connect();
                    objDB.query(queryassignevaluator1);
                    objDB.close();
                    address="/WEB-INF/AdAssignEvaluator.jsp";
                }
                else if(Option.equals("AssignEx2")){
                    String idEX2  = request.getParameter("assignEX2");
                    String queryassignevaluator2= "update evaluator set examiner2No='"+idEX2+"',flag_examiner2='N' where metricNo='"+metric+"'";
                    DB objDB= new DB();
                    objDB.connect();
                    objDB.query(queryassignevaluator2);
                    objDB.close();
                    address="/WEB-INF/AdAssignEvaluator.jsp";
                }
                
//            DB objDB = new DB();
//            objDB.connect();
//            String [] roomID = request.getParameterValues("roomID");
//            objDB.query("delete from project_evaluation");
//              for(int k=0;k<roomID.length;k++)
//                {
//                  
//                   
//                       for(int j=1;j<6;j++){
//                           for(int i=2;i<13;i++){
//                            String rStr = Integer.toString(j);
//                            String cStr = Integer.toString(i);
//                            String slot="tt"+Common.completeStr(rStr, 2)+ Common.completeStr(cStr, 2);
//                            String room = "_"+roomID[k];
//                            
//                            if(!(request.getParameter("s1_"+slot+room)==null) && !request.getParameter("s1_"+slot+room).equals("")){
//                             objDB.query("insert into project_evaluation (slot, roomID, metricNo, session, semester) values('"+slot+"','"
//                                                                                                                    +roomID[k]+"','"
//                                                                                                                    +request.getParameter("s1_"+slot+room)+"','1','"+Semester.getSemester()+"')");
//                                                                                                                    
//                            }
//                            if(!(request.getParameter("s2_"+slot+room)==null) && !request.getParameter("s2_"+slot+room).equals("")){
//                             objDB.query("insert into project_evaluation (slot, roomID, metricNo, session, semester) values('"+slot+"','"
//                                                                                                                    +roomID[k]+"','"
//                                                                                                                    +request.getParameter("s2_"+slot+room)+"','2','"+Semester.getSemester()+"')");
//                                                                                                                    
//                            }
//                        }
//                    }
//                }
//            
//           out.println("</body>");
//           out.println("</html>");
//           objDB.close();
//           address="/WEB-INF/AdAssignEvaluator.jsp";
          }
            else{
                address="/WEB-INF/Message.jsp?Message=Sorry. Your are not allowed to access this page without login.";
           }
           RequestDispatcher dispatcher = request.getRequestDispatcher(address);
           dispatcher.forward(request, response);  
        } 
        catch(Exception e){
            response.getWriter().println(e.getMessage());
        }
        finally {
        
            out.close();
        }
    } 
    
}
