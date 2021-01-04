<!DOCTYPE html>
<html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
	<title></title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="container-fluid">

     <div class="modal-body">
       <h3>Welcome to Excel Download Page</h3>
                      
       <c:if test="${not empty eudlist}">
			
			<div class="table-responsive col-md-12 col-sm-12 col-xs-12">
					
					<div class="col-md-12 col-sm-12 col-xs-12">

						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Sr.No.</th>
									<th>Id</th>
									<th>A</th>
									<th>B</th>
									<th>Date</th>
									<th>C</th>
									<th>D</th>
								</tr>
							</thead>
							<c:forEach var="list" items="${eudlist}" varStatus="counter">
								<tr>
									<td>${list.srNo}</td>
									<td>${list.id}</td> 
									<td>${list.aA}</td> 
									<td>${list.bB}</td> 
									<td>${list.date}</td> 
									<td>${list.cC}</td>
									<td>${list.dD}</td>
								</tr>
							</c:forEach>
						</table>
						<br> <br>
					</div>
					
					<div class="form-group">
				     <div class="col-md-2 col-sm-2 col-sx-2">
				      <input type="button" class="form-control btn btn-primary" id="downloadBtn" value="Download" style="margin-left: 530px;">
				     </div>
			        </div>
					
				</div>
			</c:if>
       
    </div>

</div>

<script>
	   
	   $("#downloadBtn").click(function(){
	    	console.log("inside download action");
	    	location.href="/downloadexcel";
		});

</script>  

</body>
</html>