<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.remark.RemarkBean"%>
<%@page import="com.dao.remark.RemarkDao"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Report</title>

  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath()%>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath()%>/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">
<%int sId=Integer.parseInt(request.getParameter("sid")); %>
${error }
  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Get Report</h1>
              </div>
			
			<% ArrayList<RemarkBean> al=(ArrayList<RemarkBean>)request.getAttribute("listbyid"); 
				RemarkBean rb= al.get(0); %>
      <form class="user" action="<%=request.getContextPath() %>/ReportController"> 
              		<input type="hidden" name="hiddenSid" value="<%=rb.getsId()%>">
					<input type="hidden" name="hiddenName" value="<%=rb.getsName() %>" %>
<div class="container">
	
  <hr class="my-4">

  	<div class="row mb-3">
    	<div class="col-sm-6 col-lg-8 themed-grid-col">
    		Name:-                  
    	</div>
    	<div class="col-6 col-lg-4 themed-grid-col">
    		<%=rb.getsName() %>	
    	</div>
  	</div>
 	<div class="row mb-3">
    	<div class="col-sm-6 col-lg-8 themed-grid-col">
    		Descipline:-                  
    	</div>
    	<div class="col-6 col-lg-4 themed-grid-col">
    		<%=rb.getrDescipline() %>	
    	</div>
  	</div>
  	<div class="row mb-3">
    	<div class="col-sm-6 col-lg-8 themed-grid-col">
    		Regularity:-                  
    	</div>
    	<div class="col-6 col-lg-4 themed-grid-col">
    		<%=rb.getrRegular() %>	
    	</div>
  	</div> <div class="row mb-3">
    	<div class="col-sm-6 col-lg-8 themed-grid-col">
    		Research:-                  
    	</div>
    	<div class="col-6 col-lg-4 themed-grid-col">
    		<%=rb.getrResearch() %>	
    	</div>
  	</div> <div class="row mb-3">
    	<div class="col-sm-6 col-lg-8 themed-grid-col">
    		Exam:-                  
    	</div>
    	<div class="col-6 col-lg-4 themed-grid-col">
    		<%=rb.getrExam() %>	
    	</div>
  	</div> <div class="row mb-3">
    	<div class="col-sm-6 col-lg-8 themed-grid-col">
    		Task:-                  
    	</div>
    	<div class="col-6 col-lg-4 themed-grid-col">
    		<%=rb.getrTask() %>	
    	</div>
  	</div> <div class="row mb-3">
    	<div class="col-sm-6 col-lg-8 themed-grid-col">
    		Grasping:-                  
    	</div>
    	<div class="col-6 col-lg-4 themed-grid-col">
    		<%=rb.getrGrasp() %>	
    	</div>
  	</div>  
</div>
         <hr>
                <input type="submit"  value="Generate Report" class="btn btn-primary btn-user btn-block">
               
              </form>
        
                    </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="<%=request.getContextPath()%>/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="<%=request.getContextPath()%>/js/sb-admin-2.min.js"></script>

</body>

</html>


