<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Registration</title>
      <%@include file="includes/header.jsp" %>
   </head>

   <body>
      <div class="container-fluid">
         <section class="container">
            <div class="container-page">	
               <form method="POST" action="reg">
                  <h1>Registration</h1>

                  <div class="form-group col-lg-12">
                     <label>Email Address</label>
                     <input type="email" name="email" class="form-control" id="email" value="" autofocus required>
                  </div>

                  <div class="form-group col-lg-12">
                     <label>First name</label>
                     <input type="text" name="fname" class="form-control" id="fname" value="" required>
                  </div>

                  <div class="form-group col-lg-12">
                     <label>Last name</label>
                     <input type="text" name="lname" class="form-control" id="lname" value="" required>
                  </div>

                  <div class="form-group col-lg-6">
                     <label>Password</label>
                     <input type="password" name="password" class="form-control" id="password" value="" required>
                  </div>

                  <div class="form-group col-lg-6">
                     <label>Repeat Password</label>
                     <input type="password" name="rpassword" class="form-control" id="rpassword" value="" requires>
                  </div>

                  <a href="${pageContext.request.contextPath}"><button type="button" class="btn btn-default">Cancel</button></a>
                  <button type="submit" id="bRegister" class="btn btn-primary">Register</button>
               </form>
            </div>
         </section>
      </div>
   </body>
</html>
