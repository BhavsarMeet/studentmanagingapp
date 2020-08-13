<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="com.dao.faculty.FacultyDao"%>    
<%@page import= "com.bean.faculty.FacultyBean" %>
<%@page import= "com.dao.faculty.FacultyDao" %>
<%@page import= "java.util.ArrayList" %>
<%@page import="com.bean.student.StudentBean"%>
 

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Edit Student</title>

  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath() %>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath() %>/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
              </div>
             ${error} 
              <form class="user" action="<%=request.getContextPath() %>/StudentUpdateController?sid=${studentbean.sId}">
    			<input type="hidden" value="${studentbean.sId}" name="txtStudentId">
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" name="txtStudentName" id="exampleFirstName" value="${studentbean.sName}" placeholder="Enter Name....">
              	${name}
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" name="txtStudentAge" id="exampleLastName" value="${studentbean.sAge}" placeholder="Enter Your Age....">
                ${age}
                  </div>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" name="txtStudentEmail" id="exampleInputEmail" value="${studentbean.sEmail}" placeholder="Enter Email">
                ${email}
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" name="txtStudentMob" id="exampleInputPassword" value="${studentbean.sMob}" placeholder="Enter Mobile">
                ${mobile}
                  </div>
                <br>
                <br>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                 <select name="txtFacultyId">
							<option value="0">Select Faculty</option>
							<% ArrayList<FacultyBean> alf=new FacultyDao().facultyList();  
								
								for(int i=0;i<alf.size();i++)
								{	FacultyBean fb=alf.get(i);
								
							%> 
							<option value="<%=fb.getfId()%>"><%=fb.getfName()%></option>
							<%} %>
						</select>
						${faculty}
				 </div>
                 
                 </div>
              	<hr>  
              	<br>
           		<br>
           		<br>
           		<br>
           		<br>
                <input type="submit"  value="Register Account" class="btn btn-primary btn-user btn-block">
 
                </form>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="<%=request.getContextPath() %>/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="<%=request.getContextPath() %>/js/sb-admin-2.min.js"></script>

</body>

</html>

