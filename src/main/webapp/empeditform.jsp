<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Employee</h1>  
       <form:form method="POST" action="/springJDBC/editsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="fname" /></td>  
         </tr>   
         <tr>    
          <td>Last Name : </td>   
          <td><form:input path="lname"  /></td>  
         </tr>
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    