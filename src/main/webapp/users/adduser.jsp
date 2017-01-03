<%-- 
    Document   : adduser
    Created on : Jun 1, 2016, 11:34:39 AM
    Author     : Joseph George Davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
    </head>
    <body>
          <!-- /widget-header 
            <div class="widget-content">
                <div class="widget big-stats-container">
                    <div class="widget-content">
                        <h6 class="bigstats">.</h6>
                        <form action="<%=request.getContextPath()%>/user/add" method="post" >
                            <div class="span5">
                                <input type="text" value=""  placeholder="firstname" name="fn"/>
                            </div>
                            
                             <div class="span5">
                                <input type="text" value=""  placeholder="lastname" name="ln"/>
                            </div>
                             <div class="span5">
                                <input type="text" value=""  placeholder="username" name="un"/>
                            </div>
                            <div class="span5">
                                <input type="password" value=""  placeholder="password" name="password"/>
                            </div>
                           
                            <div class="span5">
                                <input type="text" value=""  placeholder="usercode " name="ac"/>
                            </div>
                           
                             <div class="span5">
                                <input type="text" value=""  placeholder="usertype" name="at"/>
                            </div>
                            
                              <div class="span5">
                                <input type="text" value=""  placeholder="organisation" name="org"/>
                            </div>
                          
                           
                            <div>
                                <input type="submit" class="btn btn-primary"  value="Add User" />
                            </div>
                             <input type="hidden" name="action" value="add" />
                        </form>
                    </div>

                    <!-- /widget-content --> 

               <!-- </div>
            </div>-->
               
     <div class="account-container register">
	
	<div class="content clearfix">
		
		<form action="<%=request.getContextPath()%>/user/add" method="post">
		
			<h1>Signup ICTC User</h1>			
			
			<div class="login-fields">
				
				<p>Enter User Details Below:</p>
				
				<div class="field">
					<label for="firstname">First Name:</label>
					<input type="text" id="fn" name="fn" value="" placeholder="First Name" class="login" />
				</div> <!-- /field -->
				
				<div class="field">
					<label for="lastname">Last Name:</label>	
					<input type="text" id="ln" name="ln" value="" placeholder="Last Name" class="login" />
				</div> <!-- /field -->
				
				
				<div class="field">
                                    <label for="organisation">Organisation:</label>
                                        <select id="org" name="org" class="login" >
                                            <option value="select">------Select Organisation------</option>
                                            <option value="GRAMEEN">GRAMEEN</option>
                                            <option value="ACDIVOCA">ACDIVOCA</option>
                                            <option value="MOFA">MOFA</option>
                                        </select>
				</div> <!-- /field -->
                                <div class="field">
					<label for="organisation">User type:</label>
					
                                        <select id="at" name="at" class="login" >
                                            <option value="select">------Select User Type--------</option>
                                            <option value="grameen_admin">Grameen admin</option>
                                            <option value="grameen_user">Grameen user</option>
                                            <option value="acdivoca_admin">ACDIVOCA admin</option>
                                             <option value="acdivoca_ob">ACDIVOCA OB</option>
                                            <option value="acdivoca_apo">ACDIVOCA APO</option>
                                            <option value="mofa_director">MOFA Director</option>
                                        </select>
				</div> <!-- /field -->
                                
                                <div class="field">
					<label for="username">Username:</label>	
                                        <input type="text" id="un" name="un" value="" placeholder="Username" class="login" required/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="password">Password:</label>
                                        <input type="password" id="password" name="password" value="" placeholder="Password" class="login" required/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="confirm_password">Confirm Password:</label>
                                        <input type="password" id="confirm_password" name="confirm_password" value="" placeholder="Confirm Password" class="login" required/>
				</div> <!-- /field -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
				
				<!--<span class="login-checkbox">
					<input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" />
					<label class="choice" for="Field">Agree with the Terms & Conditions.</label>
				</span>-->
									
				<button class="button btn btn-primary btn-large" >Register</button>
				
			</div> <!-- .actions -->
			 <input type="hidden" name="action" value="add" />
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<!-- Text Under Box -->
<div class="login-extra">
	Already have an account? <a href="login.html">Login to your account</a>
</div> <!-- /login-extra -->
   
    </body>
</html>
