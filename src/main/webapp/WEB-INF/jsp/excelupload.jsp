<!DOCTYPE html>
<html>
<head>
	<title></title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="container-fluid">
    
     <div class="modal-body">
        <h3>Welcome to Excel Upload Page</h3>
                      
       <form class="form-horizontal" method="post" id="euForm" action="/excelupload" enctype="multipart/form-data">
                      
        <div class="form-group">
           <div class="col-md-2 col-sm-2 col-sx-12">
            <label class="control-label important" for="ecode">Upload your excel file here</label>
		   </div>	
		   <div class="col-md-4 col-sm-4 col-sx-12">
			<input type="file" class="form-control" id="eufile" name="eufile" required>
			<p id="error" class="error" style="color:red;"></p>
		   </div>
		</div>              
						
		<div class="form-group">
		 <div class="col-md-6 col-sm-6 col-sx-12 text-center">
			<button type="button" id="uploadBtn" class="btn btn-default" style="background: blue; color: #fff;">Upload</button>
		 </div>
		</div>
      </form>
    </div>

</div>

<script>
$('input[type=file]').click(function(){
	$(".error").html("");
});

   $(document).ready(function(){
	   
	   $("#uploadBtn").click(function(){
			 var file = $("#eufile").val();
			 console.log(file);
			 
			 if(file != ""){
				 alert("File uploaded Successfully!");
				 $("#euForm").submit(); 
			 }else{
				 $("#error").html("Please choose a file");
			 }
	   });
	   
   });
</script>   

</body>
</html>