<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consulta Cargo</title>
     <script src="../resources/js/jquery.js"></script>
     <script src="../resources/js/jquery.dataTables.js"></script>
     
     <script type="text/javascript">
           $(document).ready(function(){
               $('#tabela').dataTable();
               });
     </script>
</head>
  <body>
     <table id="tabela">
        <thead>
           <tr>
              <th>Codigo</th>
              <th>Cargo</th>   
           </tr>
        </thead>
           <tr>
             <td>Brasil</td>
           </tr>
           <tr>
             <td>Portugal</td>      
           </tr>
           <tr>
             <td>Italia</td>      
           </tr>
           <tr>
             <td>Espanha</td>      
           </tr>
        <tbody>
           
        </tbody>
     
     </table>
  </body>
</html>