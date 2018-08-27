
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript" src="/SpringMVCDemo1/js/jquery-1.7.2.min.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
   $(function(){
	   $("#btn").click(function(){
		  $.post("mvc/getPerson.do",{name:"wzp"},function(data){
			  alert(data);
		  });
	   });
	   
	   $("#btn2").click(function(){
		   $.post("json/user.do",null,function(data){
			   debugger;
			   alert(data.age);
		   })
	   });
	  
	   $("#btn3").click(function(){
		   var jsonDate=[{name:'wxp',id:9}];
		   JSONObject obj=new JSONObject();
		   $.post("integrate/save.do",jsonDate,function(data){
			  alert(data);
		   })
	   });
   });
</script>
<body>
    <input type="button" value="Button" id="btn">
    
    <form action="mvc/upload.do" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="submit">
    </form>
    
    <input type="button" value="JsonTest" id="btn2">
    <br>
    <br>
    <br>
    <br>
    <input type="button" value="整合测试" id="btn3">
</body>
</html>